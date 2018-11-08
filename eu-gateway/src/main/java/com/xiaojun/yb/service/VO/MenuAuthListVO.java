package com.xiaojun.yb.service.VO;

import java.util.List;

public class MenuAuthListVO {

   private List L;
   private Integer ALLATORIxDEMO;


   public void setMenuId(Integer a1) {
      this.ALLATORIxDEMO = a1;
   }

   public List getAuths() {
      return this.L;
   }

   public Integer getMenuId() {
      return this.ALLATORIxDEMO;
   }

   public void setAuths(List a1) {
      this.L = a1;
   }
}
