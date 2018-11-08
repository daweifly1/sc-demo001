package com.xiaojun.yb.service.VO;

public class UserLoginVO {

    private String authId;
    private String password;
    private String code;
    private String loginName;


    public void setLoginName(String a1) {
        this.loginName = a1;
    }

    public void setAuthId(String a1) {
        this.authId = a1;
    }

    public String getPassword() {
        return this.password;
    }


    public String getLoginName() {
        return this.loginName;
    }

    public void setPassword(String a1) {
        this.password = a1;
    }

    public void setCode(String a1) {
        this.code = a1;
    }

    public String getAuthId() {
        return this.authId;
    }

    public String getCode() {
        return this.code;
    }
}
