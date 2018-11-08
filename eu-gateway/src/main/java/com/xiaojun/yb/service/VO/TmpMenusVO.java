package com.xiaojun.yb.service.VO;

import java.util.List;

public class TmpMenusVO {

   private String L;
   private List ALLATORIxDEMO;


   public void setTemplateId(String a1) {
      this.L = a1;
   }

   public String getTemplateId() {
      return this.L;
   }

   public List getMenuIds() {
      return this.ALLATORIxDEMO;
   }

   public void setMenuIds(List a1) {
      this.ALLATORIxDEMO = a1;
   }
}
