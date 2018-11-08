package com.xiaojun.yb.service.VO;


public class AuthVO {

   private Integer b;
   private String d;
   private String L;
   private Integer ALLATORIxDEMO;


   public void setParentId(Integer a1) {
      this.b = a1;
   }

   public Integer getAuthId() {
      return this.ALLATORIxDEMO;
   }

   public Integer getParentId() {
      return this.b;
   }

   public String getAuthName() {
      return this.d;
   }

   public void setAuthId(Integer a1) {
      this.ALLATORIxDEMO = a1;
   }

   public String getAuthDesc() {
      return this.L;
   }

   public void setAuthName(String a1) {
      this.d = a1;
   }

   public void setAuthDesc(String a1) {
      this.L = a1;
   }
}
