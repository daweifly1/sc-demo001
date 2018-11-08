package com.xiaojun.yb.service.VO;

import java.io.Serializable;
import java.util.List;

public class UserVO extends ProfileVO implements Serializable {

    private static final long serialVersionUID = 7776519781356022660L;
    private List roleIds;
    private String roleName;
    private List roleVOs;
    private String openId;
    private String deptName;


    public String getDeptName() {
        return this.deptName;
    }

    public void setRoleVOs(List a1) {
        this.roleVOs = a1;
    }

    public void setOpenId(String a1) {
        this.openId = a1;
    }

    public void setDeptName(String a1) {
        this.deptName = a1;
    }

    public String getRoleNames() {
        return this.roleName;
    }

    public void setRoleNames(String a1) {
        this.roleName = a1;
    }

    public List getRoleVOs() {
        return this.roleVOs;
    }

    public String getOpenId() {
        return this.openId;
    }

    public void setRoleIds(List a1) {
        this.roleIds = a1;
    }

    public List getRoleIds() {
        return this.roleIds;
    }
}
