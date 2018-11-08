package com.xiaojun.yb.service.VO;

import java.util.List;

public class MenuDisplayVO extends MenuBase {

    private List auths;
    private String url;
    private List children;
    private String state;


    public void setAuths(List a1) {
        this.auths = a1;
    }

    public String getUrl() {
        return this.url;
    }

    public List getAuths() {
        return this.auths;
    }

    public void setUrl(String a1) {
        this.url = a1;
    }

    public List getChildren() {
        return this.children;
    }

    public void setChildren(List a1) {
        this.children = a1;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String a1) {
        this.state = a1;
    }
}
