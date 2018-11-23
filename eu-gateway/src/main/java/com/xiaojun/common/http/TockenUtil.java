package com.xiaojun.common.http;

import com.xiaojun.auth.filter.JWTLoginFilter;
import com.xiaojun.auth.filter.TokenAuthenticationHandler;
import com.xiaojun.common.fastjson.FastJsonUtil;
import com.xiaojun.rbac.api.vo.SysUserDetail;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;

@Slf4j
public class TockenUtil {

    /**
     * 从cookie中获取用户信息
     *
     * @param req
     * @return
     */
    public static SysUserDetail getSysUserDetailFromRequest(HttpServletRequest req) {
        String token = req.getHeader(JWTLoginFilter.HEADER_STRING);
        if (StringUtils.isBlank(token)) {
            token = (String) req.getSession().getAttribute(JWTLoginFilter.HEADER_STRING);
        }
        if (StringUtils.isBlank(token)) {
            token = (String) CookieUtil.getCookieValueByName(req, JWTLoginFilter.HEADER_STRING);
        }
        if (StringUtils.isNotBlank(token)) {
            SysUserDetail su = getSysUserDetail(token);
            return su;
        }
        return null;
    }

    public static SysUserDetail getSysUserDetail(String token) {
        if (StringUtils.isBlank(token)) {
            return null;
        }
        token = token.replace(JWTLoginFilter.TOKEN_PREFIX, "");
        TokenAuthenticationHandler tokenAuthenticationHandler = new TokenAuthenticationHandler();
        String token2 = tokenAuthenticationHandler.getSubjectFromToken(token);
        SysUserDetail su = FastJsonUtil.parse(token2, SysUserDetail.class);
        return su;
    }
}
