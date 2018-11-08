package com.xiaojun.yb.service.VO;

import java.util.List;

public class TmpAuthsVO {

   private List L;
   private String ALLATORIxDEMO;


   public String getTemplateId() {
      return this.ALLATORIxDEMO;
   }

   public void setTemplateId(String a1) {
      this.ALLATORIxDEMO = a1;
   }

   public void setAuthIds(List a1) {
      this.L = a1;
   }

   public List getAuthIds() {
      return this.L;
   }
}
