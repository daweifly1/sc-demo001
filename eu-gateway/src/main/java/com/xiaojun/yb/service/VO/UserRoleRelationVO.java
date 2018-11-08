package com.xiaojun.yb.service.VO;


public class UserRoleRelationVO {

   private String L;
   private String ALLATORIxDEMO;


   public String getRoleId() {
      return this.ALLATORIxDEMO;
   }

   public void setRoleId(String a1) {
      this.ALLATORIxDEMO = a1;
   }

   public void setUserId(String a1) {
      this.L = a1;
   }

   public String getUserId() {
      return this.L;
   }
}
