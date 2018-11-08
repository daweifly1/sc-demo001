package com.xiaojun.yb.service.VO;

public class ConfigMenuVO {

   private Integer b;
   private String d;
   private MenuVO L;
   private Integer ALLATORIxDEMO;


   public void setSite(Integer a1) {
      this.ALLATORIxDEMO = a1;
   }

   public void setChannel(Integer a1) {
      this.b = a1;
   }

   public Integer getSite() {
      return this.ALLATORIxDEMO;
   }

   public Integer getChannel() {
      return this.b;
   }

   public MenuVO getMenuVO() {
      return this.L;
   }

   public String getTmpId() {
      return this.d;
   }

   public void setMenuVO(MenuVO a1) {
      this.L = a1;
   }

   public void setTmpId(String a1) {
      this.d = a1;
   }
}
