package com.xiaojun.yb.service.VO;

import java.util.List;

public class TemplateConfigVO {

   private String d;
   private List L;
   private List ALLATORIxDEMO;


   public String getTempId() {
      return this.d;
   }

   public void setAuthIds(List a1) {
      this.L = a1;
   }

   public List getAuthIds() {
      return this.L;
   }

   public List getMenuIds() {
      return this.ALLATORIxDEMO;
   }

   public void setTempId(String a1) {
      this.d = a1;
   }

   public void setMenuIds(List a1) {
      this.ALLATORIxDEMO = a1;
   }
}
