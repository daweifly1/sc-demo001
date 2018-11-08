package com.xiaojun.yb.service.VO;

import java.util.Date;

public class AccountVO {

   private Date b;
   private Integer d = Integer.valueOf(0);
   private String L;
   private String ALLATORIxDEMO;


   public void setLastLoginTime(Date a1) {
      this.b = a1;
   }

   public Integer getStatus() {
      return this.d;
   }

   public void setUserId(String a1) {
      this.ALLATORIxDEMO = a1;
   }

   public void setStatus(Integer a1) {
      this.d = a1;
   }

   public Date getLastLoginTime() {
      return this.b;
   }

   public String getLoginName() {
      return this.L;
   }

   public void setLoginName(String a1) {
      this.L = a1;
   }

   public String getUserId() {
      return this.ALLATORIxDEMO;
   }

}
