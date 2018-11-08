package com.xiaojun.yb.service.VO;

public class RegMemberVO extends ProfileVO {

   private Integer e;
   private static final long b = 1L;
   private Integer d;
   private String L;
   private String ALLATORIxDEMO;


   public void setWorkSpaceName(String a1) {
      this.L = a1;
   }

   public Integer getMemberType() {
      return this.d;
   }

   public void setMemberType(Integer a1) {
      this.d = a1;
   }

   public void setWorkSpaceId(String a1) {
      this.ALLATORIxDEMO = a1;
   }

   public void setSite(Integer a1) {
      this.e = a1;
   }

   public String getWorkSpaceId() {
      return this.ALLATORIxDEMO;
   }

   public Integer getSite() {
      return this.e;
   }

   public String getWorkSpaceName() {
      return this.L;
   }
}
