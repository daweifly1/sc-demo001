package com.xiaojun.yb.service.VO;

import java.util.List;

public class MenuConfigVO extends MenuBase {

   private List ALLATORIxDEMO;


   public void setChildren(List a1) {
      this.ALLATORIxDEMO = a1;
   }

   public List getChildren() {
      return this.ALLATORIxDEMO;
   }

}
