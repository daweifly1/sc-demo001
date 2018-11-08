package com.xiaojun.yb.service.VO;


public class UpdatePasswordVO {

   private String L;
   private String ALLATORIxDEMO;


   public void setOldPassword(String a1) {
      this.L = a1;
   }

   public String getOldPassword() {
      return this.L;
   }

   public String getNewPassword() {
      return this.ALLATORIxDEMO;
   }

   public void setNewPassword(String a1) {
      this.ALLATORIxDEMO = a1;
   }
}
