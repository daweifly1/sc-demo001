package com.xiaojun.yb.service.VO;

import java.io.Serializable;

public class UserCacheVO implements Serializable {

    private static final long serialVersionUID = -9156808215937023240L;
    private String spaceId;
    private String areaCode;
    private String deptName;
    private String mobile;
    private String deptCode;
    private String openId;
    private String userId;
    private String name;
    private String deptId;


    public String getMobile() {
        return this.mobile;
    }

    public String getAreaCode() {
        return this.areaCode;
    }

    public void setOpenId(String a1) {
        this.openId = a1;
    }

    public void setDeptId(String a1) {
        this.deptId = a1;
    }

    public String getSpaceId() {
        return this.spaceId;
    }

    public void setUserId(String a1) {
        this.userId = a1;
    }

    public void setDeptCode(String a1) {
        this.deptCode = a1;
    }

    public String getDeptId() {
        return this.deptId;
    }

    public String getDeptName() {
        return this.deptName;
    }

    public void setAreaCode(String a1) {
        this.areaCode = a1;
    }

    public void setSpaceId(String a1) {
        this.spaceId = a1;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setName(String a1) {
        this.name = a1;
    }

    public String getDeptCode() {
        return this.deptCode;
    }

    public void setMobile(String a1) {
        this.mobile = a1;
    }

    public void setDeptName(String a1) {
        this.deptName = a1;
    }

    public String getOpenId() {
        return this.openId;
    }

    public String getName() {
        return this.name;
    }
}
