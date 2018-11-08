package com.xiaojun.yb.service.VO;


public class MenuConditionVO {

   private Integer d;
   private Integer L;
   private Integer ALLATORIxDEMO;


   public Integer getParentId() {
      return this.d;
   }

   public void setParentId(Integer a1) {
      this.d = a1;
   }

   public Integer getLeaf() {
      return this.L;
   }

   public void setLeaf(Integer a1) {
      this.L = a1;
   }

   public void setSite(Integer a1) {
      this.ALLATORIxDEMO = a1;
   }

   public Integer getSite() {
      return this.ALLATORIxDEMO;
   }
}
