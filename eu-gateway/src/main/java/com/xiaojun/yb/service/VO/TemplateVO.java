package com.xiaojun.yb.service.VO;


public class TemplateVO {

    private Integer site;
    private String remark;
    private String id;
    private String name;


    public String getName() {
        return this.name;
    }

    public String getRemark() {
        return this.remark;
    }

    public String getId() {
        return this.id;
    }

    public void setSite(Integer a1) {
        this.site = a1;
    }

    public void setId(String a1) {
        this.id = a1;
    }

    public void setName(String a1) {
        this.name = a1;
    }

    public Integer getSite() {
        return this.site;
    }

    public void setRemark(String a1) {
        this.remark = a1;
    }

}
