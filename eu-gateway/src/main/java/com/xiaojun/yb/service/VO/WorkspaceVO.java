package com.xiaojun.yb.service.VO;


public class WorkspaceVO {

    private String id;
    private Integer site;
    private String account;
    private String remark;
    private String type;
    private String status;
    private String tempId;
    private String password;
    private String name;


    public void setPassword(String a1) {
        this.password = a1;
    }

    public String getType() {
        return this.type;
    }

    public void setStatus(String a1) {
        this.status = a1;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String a1) {
        this.id = a1;
    }

    public String getStatus() {
        return this.status;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setType(String a1) {
        this.type = a1;
    }

    public void setSite(Integer a1) {
        this.site = a1;
    }

    public void setTempId(String a1) {
        this.tempId = a1;
    }

    public void setName(String a1) {
        this.name = a1;
    }

    public Integer getSite() {
        return this.site;
    }

    public String getPassword() {
        return this.password;
    }

    public String getAccount() {
        return this.account;
    }

    public void setAccount(String a1) {
        this.account = a1;
    }

    public String getName() {
        return this.name;
    }

    public void setRemark(String a1) {
        this.remark = a1;
    }

    public String getTempId() {
        return this.tempId;
    }
}
