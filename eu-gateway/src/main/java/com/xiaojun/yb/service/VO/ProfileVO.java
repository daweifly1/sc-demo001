package com.xiaojun.yb.service.VO;

import java.io.Serializable;
import java.util.List;

public class ProfileVO extends AccountPwdVO implements Serializable {

    private static final long serialVersionUID = -1473888104096068912L;
    private String areaCode;
    private Integer locked;
    private String mobile;
    private String email;
    private String spaceId;
    private String telephone;
    private List authIds;
    private String icon;

    private String deptCode;
    private Integer sex;
    private String idNumber;
    private List roleIds;
    private String deptId;
    private String name;
    private String nickname;
    private String myself;


    public void setName(String a1) {
        this.name = a1;
    }

    public void setMyself(String a1) {
        this.myself = a1;
    }

    public String getMobile() {
        return this.mobile;
    }

    public String getIcon() {
        return this.icon;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public void setNickname(String a1) {
        this.nickname = a1;
    }

    public String getMyself() {
        return this.myself;
    }

    public void setTelephone(String a1) {
        this.telephone = a1;
    }

    public void setRoleIds(List a1) {
        this.roleIds = a1;
    }

    public List getAuthIds() {
        return this.authIds;
    }

    public Integer getSex() {
        return this.sex;
    }

    public void setIdNumber(String a1) {
        this.idNumber = a1;
    }

    public String getDeptCode() {
        return this.deptCode;
    }

    public List getRoleIds() {
        return this.roleIds;
    }

    public void setDeptId(String a1) {
        this.deptId = a1;
    }

    public void setIcon(String a1) {
        this.icon = a1;
    }

    public void setMobile(String a1) {
        this.mobile = a1;
    }

    public String getDeptId() {
        return this.deptId;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setAreaCode(String a1) {
        this.areaCode = a1;
    }

    public Integer getLocked() {
        return this.locked;
    }

    public String getName() {
        return this.name;
    }

    public void setLocked(Integer a1) {
        this.locked = a1;
    }

    public String getEmail() {
        return this.email;
    }

    public String getAreaCode() {
        return this.areaCode;
    }

    public void setSpaceId(String a1) {
        this.spaceId = a1;
    }

    public void setSex(Integer a1) {
        this.sex = a1;
    }

    public void setDeptCode(String a1) {
        this.deptCode = a1;
    }

    public void setEmail(String a1) {
        this.email = a1;
    }

    public String getIdNumber() {
        return this.idNumber;
    }

    public String getSpaceId() {
        return this.spaceId;
    }

    public void setAuthIds(List a1) {
        this.authIds = a1;
    }
}
