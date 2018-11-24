package com.xiaojun.auth.authorize;

import com.xiaojun.auth.filter.JWTLoginFilter;
import com.xiaojun.auth.filter.TokenAuthenticationHandler;
import com.xiaojun.common.http.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Slf4j
public class JWTAuthenticationFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;

        HttpServletResponse resp = (HttpServletResponse) response;

        String token = req.getHeader(JWTLoginFilter.HEADER_STRING);
//        if (StringUtils.isBlank(token)) {
//            token = (String) req.getSession().getAttribute(HEADER_STRING);
//        }
        if (StringUtils.isBlank(token)) {
            token = (String) CookieUtil.getCookieValueByName(req, JWTLoginFilter.HEADER_STRING);
        }
        if (StringUtils.isNotBlank(token) && token.startsWith(JWTLoginFilter.TOKEN_PREFIX)) {
            TokenAuthenticationHandler tokenAuthenticationHandler = new TokenAuthenticationHandler();
            tokenAuthenticationHandler.doRefreshToken(resp, token.replace(JWTLoginFilter.TOKEN_PREFIX, ""));
        }
        filterChain.doFilter(request, response);
    }

}