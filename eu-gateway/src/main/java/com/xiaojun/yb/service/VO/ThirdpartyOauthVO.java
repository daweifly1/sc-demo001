package com.xiaojun.yb.service.VO;

import java.util.Date;

public class ThirdpartyOauthVO {

    private String m;
    private Integer B;
    private String I;
    private Date c;
    private String i;
    private Integer e;
    private String b;
    private String d;
    private Integer L;
    private Date ALLATORIxDEMO;


    public Date getBindTime() {
        return this.c;
    }

    public void setUserId(String a1) {
        this.b = a1 == null ? null : a1.trim();
    }

    public void setBindTime(Date a1) {
        this.c = a1;
    }

    public Integer getBindType() {
        return this.L;
    }

    public void setMetaData(String a1) {
        this.d = a1 == null ? null : a1.trim();
    }

    public void setId(Integer a1) {
        this.e = a1;
    }

    public Integer getId() {
        return this.e;
    }

    public String getRemark() {
        return this.m;
    }

    public void setRemark(String a1) {
        this.m = a1 == null ? null : a1.trim();
    }

    public void setAppId(String a1) {
        this.I = a1 == null ? null : a1.trim();
    }

    public void setBindType(Integer a1) {
        this.L = a1;
    }

    public Date getUpdateTime() {
        return this.ALLATORIxDEMO;
    }

    public Integer getBindStatus() {
        return this.B;
    }

    public String getUserId() {
        return this.b;
    }

    public String getAppId() {
        return this.I;
    }

    public String getThirdpartyId() {
        return this.i;
    }

    public void setBindStatus(Integer a1) {
        this.B = a1;
    }

    public String getMetaData() {
        return this.d;
    }

    public void setUpdateTime(Date a1) {
        this.ALLATORIxDEMO = a1;
    }

    public void setThirdpartyId(String a1) {
        this.i = a1 == null ? null : a1.trim();
    }
}
