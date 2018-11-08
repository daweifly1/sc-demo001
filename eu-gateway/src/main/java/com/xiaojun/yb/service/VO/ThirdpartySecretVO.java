package com.xiaojun.yb.service.VO;

import java.util.Date;

public class ThirdpartySecretVO {

    private Date updateTime;
    private String c;
    private String appSecret;
    private String e;
    private Integer b;
    private Integer d;
    private String L;
    private String aesKey;


    public Date getUpdateTime() {
        return this.updateTime;
    }

    public String getAesKey() {
        return this.aesKey;
    }

    public void setAesKey(String a1) {
        this.aesKey = a1 == null ? null : a1.trim();
    }

    public void setUpdateTime(Date a1) {
        this.updateTime = a1;
    }

    public String getAppSecret() {
        return this.appSecret;
    }

    public void setSettingStatus(Integer a1) {
        this.b = a1;
    }

    public String getToken() {
        return this.c;
    }

    public void setToken(String a1) {
        this.c = a1 == null ? null : a1.trim();
    }

    public void setId(Integer a1) {
        this.d = a1;
    }

    public Integer getSettingStatus() {
        return this.b;
    }

    public void setWorkspaceId(String a1) {
        this.e = a1 == null ? null : a1.trim();
    }

    public String getWorkspaceId() {
        return this.e;
    }

    public String getAppId() {
        return this.L;
    }

    public void setAppId(String a1) {
        this.L = a1 == null ? null : a1.trim();
    }

    public Integer getId() {
        return this.d;
    }

    public void setAppSecret(String a1) {
        this.appSecret = a1 == null ? null : a1.trim();
    }
}
