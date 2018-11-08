package com.xiaojun.infra;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ActionResult<T> {
    protected int code;
    protected String message;
    protected T value;

    public ActionResult() {
        this.code = 0;
        this.message = "成功";
    }

    public ActionResult(int code, String message, T value) {
        this.code = code;
        this.message = message;
        this.value = value;
    }

    public ActionResult(int code, String message) {
        this.code = code;
        this.message = message;
        this.value = null;
    }
}
