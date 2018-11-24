package com.xiaojun.auth.filter;

import com.xiaojun.common.http.CookieUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenAuthenticationHandler implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final String CLAIM_KEY_CREATED = "created";
    private static final String CLAIM_KEY_SUBJECT = "subject";

    private static final String DEFAULT_SECRET = "eboot@secret";
    public static final Long DEFAULT_EXPIRATION = 2*60L;

    private String secret = DEFAULT_SECRET;
    private Long EXPIRATION = DEFAULT_EXPIRATION;

    public TokenAuthenticationHandler() {

    }

    public String getSubjectFromToken(String token) {
        String subject;
        try {
            final Claims claims = getClaimsFromToken(token);
            subject = claims.get(CLAIM_KEY_SUBJECT).toString();
        } catch (Exception e) {
            subject = null;
        }
        return subject;
    }


    private Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + EXPIRATION * 1000);
    }

    public String generateToken(String subject) {
        Map<String, Object> claims = new HashMap<String, Object>();
        claims.put(CLAIM_KEY_CREATED, new Date());
        claims.put(CLAIM_KEY_SUBJECT, subject);
        return generateToken(claims);
    }

    /**
     * 判断令牌是否过期
     *
     * @param token 令牌
     * @return 是否过期
     */
    public Boolean isTokenExpired(String token) {
        try {
            Claims claims = getClaimsFromToken(token);
            Date expiration = claims.getExpiration();
            return expiration.before(new Date());
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 刷新令牌
     *
     * @param token 原令牌
     * @return 新令牌
     */
    public String refreshToken(String token) {
        String refreshedToken;
        try {
            Claims claims = getClaimsFromToken(token);
            claims.put("created", new Date());
            refreshedToken = generateToken(claims);
        } catch (Exception e) {
            refreshedToken = null;
        }
        return refreshedToken;
    }

    String generateToken(Map<String, Object> claims) {
        return Jwts.builder().setClaims(claims).setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, secret).compact();
    }

    public void doRefreshToken(HttpServletResponse resp, String token) {
        Claims claims = getClaimsFromToken(token);
        if (null != claims) {
            String subject = claims.get(CLAIM_KEY_SUBJECT).toString();
            if (StringUtils.isNotBlank(subject)) {
                SecurityContextHolder.getContext().setAuthentication(new JWTAuthenticationToken(subject));
            }
            Date expiration = claims.getExpiration();
            Date date = new Date(System.currentTimeMillis() + EXPIRATION * 1000 >> 1);
            //距离过期时间还有一半时候刷新token
            if (expiration.before(date)) {
                token = refreshToken(token);
                CookieUtil.setCookie(resp, JWTLoginFilter.HEADER_STRING, JWTLoginFilter.TOKEN_PREFIX + " " + token, TokenAuthenticationHandler.DEFAULT_EXPIRATION);
            }
            resp.addHeader(JWTLoginFilter.HEADER_STRING, JWTLoginFilter.TOKEN_PREFIX + " " + token);
        }
    }
}