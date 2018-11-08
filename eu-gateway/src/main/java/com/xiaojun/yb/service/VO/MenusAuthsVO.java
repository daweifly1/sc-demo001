package com.xiaojun.yb.service.VO;

import java.util.List;

public class MenusAuthsVO {

   private List L;
   private List ALLATORIxDEMO;


   public List getAuths() {
      return this.L;
   }

   public List getMenus() {
      return this.ALLATORIxDEMO;
   }

   public void setMenus(List a1) {
      this.ALLATORIxDEMO = a1;
   }

   public void setAuths(List a1) {
      this.L = a1;
   }
}
