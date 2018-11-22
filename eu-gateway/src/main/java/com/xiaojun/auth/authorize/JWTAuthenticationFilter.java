package com.xiaojun.auth.authorize;

import com.xiaojun.auth.filter.JWTAuthenticationToken;
import com.xiaojun.auth.filter.TokenAuthenticationHandler;
import com.xiaojun.common.http.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Slf4j
public class JWTAuthenticationFilter extends GenericFilterBean {

    static final String HEADER_STRING = "Authorization";
    static final String TOKEN_PREFIX = "Bearer";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;

        String token = req.getHeader(HEADER_STRING);
        if (StringUtils.isBlank(token)) {
            token = (String) req.getSession().getAttribute(HEADER_STRING);
        }
        if (StringUtils.isBlank(token)) {
            token = (String) CookieUtil.getCookieValueByName(req, HEADER_STRING);
        }
        if (StringUtils.isNotBlank(token) && token.startsWith(TOKEN_PREFIX)) {
            TokenAuthenticationHandler tokenAuthenticationHandler = new TokenAuthenticationHandler();
            String subject = tokenAuthenticationHandler.getSubjectFromToken(token.replace(TOKEN_PREFIX, ""));
            if (StringUtils.isNotBlank(subject)) {
                SecurityContextHolder.getContext().setAuthentication(new JWTAuthenticationToken(subject));
            }
        }
        filterChain.doFilter(request, response);
    }

}