package com.xiaojun.yb.web;

import com.xiaojun.infra.ActionResult;
import com.xiaojun.yb.comm.enums.ErrorCode;

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
}
