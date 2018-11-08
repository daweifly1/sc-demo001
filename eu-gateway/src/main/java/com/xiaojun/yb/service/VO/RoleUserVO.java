package com.xiaojun.yb.service.VO;

import java.util.List;

public class RoleUserVO {

   private List L;
   private String ALLATORIxDEMO;


   public List getUserIds() {
      return this.L;
   }

   public void setUserIds(List a1) {
      this.L = a1;
   }

   public String getRoleId() {
      return this.ALLATORIxDEMO;
   }

   public void setRoleId(String a1) {
      this.ALLATORIxDEMO = a1;
   }
}
