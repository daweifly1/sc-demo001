package com.xiaojun.yb.service.VO;


public class SessionDataVO {

   String d;
   Integer[] L;
   Object ALLATORIxDEMO;


   public Integer[] getCodes() {
      return this.L;
   }

   public void setUserId(String a1) {
      this.d = a1;
   }

   public String getUserId() {
      return this.d;
   }

   public Object getData() {
      return this.ALLATORIxDEMO;
   }

   public void setCodes(Integer[] a1) {
      this.L = a1;
   }

   public void setData(Object a1) {
      this.ALLATORIxDEMO = a1;
   }
}
