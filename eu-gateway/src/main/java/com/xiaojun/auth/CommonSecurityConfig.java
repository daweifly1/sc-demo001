/**
 *
 */
package com.xiaojun.auth;

import com.xiaojun.auth.authorize.JWTAuthenticationFilter;
import com.xiaojun.auth.authorize.XgAuthorizeConfigManager;
import com.xiaojun.auth.config.CustomsSecurityProperties;
import com.xiaojun.auth.filter.JWTLoginFilter;
import com.xiaojun.common.fastjson.FastJsonUtil;
import com.xiaojun.infra.ActionResult;
import com.xiaojun.yb.comm.enums.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.session.InvalidSessionStrategy;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 * @author jy88
 */
@Configuration
public class CommonSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private CustomsSecurityProperties securityProperties;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private XgAuthorizeConfigManager authorizeConfigManager;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.formLogin()
//                .loginProcessingUrl("/auth/login").usernameParameter("loginName").passwordParameter("password")
//                .permitAll()
//                .and()
//                .authorizeRequests()
//                .antMatchers("/menu/authorized","/profile/getLogin","/auth/authInfo","/auth/kaptcha").permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()
//                //记住我配置，如果想在'记住我'登录时记录日志，可以注册一个InteractiveAuthenticationSuccessEvent事件的监听器
//                .rememberMe()
//                .tokenRepository(persistentTokenRepository())
//                .tokenValiditySeconds(60 * 60 * 24)
//                .userDetailsService(userDetailsService)
//                .and()
//                .sessionManagement()
//                .invalidSessionStrategy(invalidSessionStrategy())
//                .maximumSessions(5)
//                .maxSessionsPreventsLogin(true)
//                .expiredSessionStrategy(expiredSessionStrategy())
//                .and()
//                .and()
//                .logout()
//                .logoutUrl("/signOut")
//                .logoutSuccessHandler(logoutSuccessHandler)
//                .deleteCookies("JSESSIONID")
//                .and()
//                .csrf().disable();
//        authorizeConfigManager.config(http.authorizeRequests());

        http.csrf().disable().authorizeRequests()
                .antMatchers("/auth/login", "/menu/authorized", "/profile/getLogin", "/auth/authInfo", "/auth/kaptcha").permitAll()
                .anyRequest().authenticated()
                .and()
                //记住我配置，如果想在'记住我'登录时记录日志，可以注册一个InteractiveAuthenticationSuccessEvent事件的监听器
                .rememberMe()
                .tokenRepository(persistentTokenRepository())
                .tokenValiditySeconds(60 * 60 * 24)
                .userDetailsService(userDetailsService)
                .and()
                .sessionManagement()
                .invalidSessionStrategy(invalidSessionStrategy())
                .maximumSessions(5)
                .maxSessionsPreventsLogin(true)
                .expiredSessionStrategy(expiredSessionStrategy())
                .and()
                .and()
                .addFilterBefore(loginFilter(), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

        authorizeConfigManager.config(http.authorizeRequests());
    }


    @Bean
    public JWTLoginFilter loginFilter() throws Exception {
        JWTLoginFilter loginFilter = new JWTLoginFilter(authenticationManager());
        loginFilter.setSuccessHandler((request, response, exception) -> {
            ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
            HttpSession session = attr.getRequest().getSession(true);
            //可以考虑只写cookie
            session.setAttribute(JWTLoginFilter.HEADER_STRING, response.getHeader(JWTLoginFilter.HEADER_STRING));
            Cookie cookie = new Cookie(JWTLoginFilter.HEADER_STRING, response.getHeader(JWTLoginFilter.HEADER_STRING));//创建一个cookie，cookie的名字是lastAccessTime
            //将cookie对象添加到response对象中，这样服务器在输出response对象中的内容时就会把cookie也输出到客户端浏览器
            response.addCookie(cookie);
            response.setContentType("application/json");
            response.getWriter().write(FastJsonUtil.toJSONString(new ActionResult(ErrorCode.Success.getCode(), ErrorCode.Success.getDesc(), null)));
        });
        loginFilter.setAuthenticationFailureHandler((request, response, exception) -> {
            response.setContentType("application/json");
            response.getWriter().write(FastJsonUtil.toJSONString(new ActionResult(ErrorCode.CheckLoginFailure.getCode(), ErrorCode.CheckLoginFailure.getDesc(), null)));
        });
        return loginFilter;
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        authenticationProvider.setHideUserNotFoundExceptions(false);
        return authenticationProvider;
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
//		tokenRepository.setCreateTableOnStartup(true);
        return tokenRepository;
    }

    @Bean
    public InvalidSessionStrategy invalidSessionStrategy() {
        return new CommonSessionStrategy(securityProperties);
    }

    @Bean
    public SessionInformationExpiredStrategy expiredSessionStrategy() {
        return new CommonSessionStrategy(securityProperties);
    }
}
