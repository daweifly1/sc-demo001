package com.xiaojun.yb.service.VO;

import java.util.List;

public class RoleMenuVO {

    private List b;
    private Integer d;
    private List L;
    private String ALLATORIxDEMO;


    public List getAuthIds() {
        return this.L;
    }

    public void setChannel(Integer a1) {
        this.d = a1;
    }

    public Integer getChannel() {
        return this.d;
    }

    public String getRoleId() {
        return this.ALLATORIxDEMO;
    }

    public void setMenuIds(List a1) {
        this.b = a1;
    }

    public void setAuthIds(List a1) {
        this.L = a1;
    }

    public void setRoleId(String a1) {
        this.ALLATORIxDEMO = a1;
    }

    public List getMenuIds() {
        return this.b;
    }
}
