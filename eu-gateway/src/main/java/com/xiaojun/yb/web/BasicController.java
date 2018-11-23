package com.xiaojun.yb.web;

import com.xiaojun.auth.filter.JWTLoginFilter;
import com.xiaojun.auth.filter.TokenAuthenticationHandler;
import com.xiaojun.common.fastjson.FastJsonUtil;
import com.xiaojun.common.http.TockenUtil;
import com.xiaojun.infra.ActionResult;
import com.xiaojun.rbac.api.vo.SysUserDetail;
import com.xiaojun.yb.comm.enums.ErrorCode;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.http.HttpServletRequest;

public abstract class BasicController {

    public ActionResult actionResult(Object value) {
        ErrorCode a = ErrorCode.Success;
        return this.actionResult(a, value);
    }

    public ActionResult actionResult(ErrorCode code) {
        return this.actionResult(code, (Object) null);
    }

    public ActionResult actionResult(ErrorCode code, Object value) {
        return new ActionResult(code.getCode(), code.getDesc(), value);
    }

    public String getUserId(HttpServletRequest request) {
        return request.getHeader("x-user-id");
    }

    /**
     * 获取认证的用户信息
     *
     * @return
     */
    public SysUserDetail getSysUserDetail() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (null != authentication && null != authentication.getPrincipal()) {
            String p = authentication.getPrincipal().toString().replace(JWTLoginFilter.TOKEN_PREFIX, "");
            TokenAuthenticationHandler tokenAuthenticationHandler = new TokenAuthenticationHandler();
            String token = tokenAuthenticationHandler.getSubjectFromToken(p);
            SysUserDetail su = FastJsonUtil.parse(token, SysUserDetail.class);
            return su;
        }
        return null;
    }

    /**
     * 从cookie中获取用户信息
     *
     * @param req
     * @return
     */
    public static SysUserDetail getSysUserDetailFromRequest(HttpServletRequest req) {
        return TockenUtil.getSysUserDetailFromRequest(req);
    }
}
