package com.xiaojun.yb.service.VO;


public class AuthInfoVO {

   private String L;
   private String ALLATORIxDEMO;


   public String getAuthId() {
      return this.ALLATORIxDEMO;
   }

   public String getVerifyCode() {
      return this.L;
   }

   public void setVerifyCode(String a1) {
      this.L = a1;
   }

   public void setAuthId(String a1) {
      this.ALLATORIxDEMO = a1;
   }
}
