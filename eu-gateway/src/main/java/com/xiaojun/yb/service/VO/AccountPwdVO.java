package com.xiaojun.yb.service.VO;

public class AccountPwdVO extends AccountVO {

    private Integer L = Integer.valueOf(0);
    private String ALLATORIxDEMO;


    public void setType(Integer a1) {
        this.L = a1;
    }

    public String getPassword() {
        return this.ALLATORIxDEMO;
    }

    public void setPassword(String a1) {
        this.ALLATORIxDEMO = a1;
    }

    public Integer getType() {
        return this.L;
    }
}
