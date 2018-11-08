package com.xiaojun.yb.service.VO;


public class MenuBase {

   private Short k;
   private Long m;
   private Integer B;
   private String I;
   private Integer c;
   private String i;
   private String e;
   private Integer b;
   private String d;
   private String L;
   private Short ALLATORIxDEMO;


   public void setUrl(String a1) {
      this.L = a1;
   }

   public Short getShowFlag() {
      return this.k;
   }

   public Integer getId() {
      return this.B;
   }

   public Integer getSeq() {
      return this.b;
   }

   public String getState() {
      return this.i;
   }

   public void setIcon(String a1) {
      this.d = a1;
   }

   public void setCode(String a1) {
      this.I = a1;
   }

   public int hashCode() {
      int var1 = this.B.hashCode();
      return 31 * var1 + this.I.hashCode();
   }

   public void setName(String a1) {
      this.e = a1;
   }

   public Integer getChannel() {
      return this.c;
   }

   public void setShowFlag(Short a1) {
      this.k = a1;
   }

   public String getCode() {
      return this.I;
   }

   public void setLeaf(Short a1) {
      this.ALLATORIxDEMO = a1;
   }

   public Long getParentId() {
      return this.m;
   }

   public boolean equals(Object a1) {
      if(this == a1) {
         return true;
      } else if(a1 != null && this.getClass() == a1.getClass()) {
         MenuBase a2 = (MenuBase)a1;
         return !this.B.equals(a2.B)?false:this.I.equals(a2.I);
      } else {
         return false;
      }
   }

   public void setParentId(Long a1) {
      this.m = a1;
   }

   public void setId(Integer a1) {
      this.B = a1;
   }

   public void setState(String a1) {
      this.i = a1;
   }

   public Short getLeaf() {
      return this.ALLATORIxDEMO;
   }

   public void setSeq(Integer a1) {
      this.b = a1;
   }

   public String getIcon() {
      return this.d;
   }

   public String getName() {
      return this.e;
   }

   public String getUrl() {
      return this.L;
   }

   public void setChannel(Integer a1) {
      this.c = a1;
   }
}
