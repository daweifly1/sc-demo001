package com.xiaojun.yb.service.VO;


public class MenuVO {

   private String k;
   private String m;
   private Long B;
   private Integer I;
   private String c;
   private Long i;
   private Integer e;
   private boolean b;
   private boolean d;
   private String L;
   private String ALLATORIxDEMO;


   public Long getParentId() {
      return this.i;
   }

   public void setState(String a1) {
      this.ALLATORIxDEMO = a1;
   }

   public void setParentId(Long a1) {
      this.i = a1;
   }

   public void setShowFlag(boolean a1) {
      this.d = a1;
   }

   public void setId(Long a1) {
      this.B = a1;
   }

   public Integer getSeq() {
      return this.e;
   }

   public String getUrl() {
      return this.c;
   }

   public String getState() {
      return this.ALLATORIxDEMO;
   }

   public boolean isShowFlag() {
      return this.d;
   }

   public void setSeq(Integer a1) {
      this.e = a1;
   }

   public void setIcon(String a1) {
      this.L = a1;
   }

   public Long getId() {
      return this.B;
   }

   public void setChannel(Integer a1) {
      this.I = a1;
   }

   public Integer getChannel() {
      return this.I;
   }

   public boolean isLeaf() {
      return this.b;
   }

   public void setCode(String a1) {
      this.m = a1;
   }

   public String getName() {
      return this.k;
   }

   public String getCode() {
      return this.m;
   }

   public void setName(String a1) {
      this.k = a1;
   }

   public void setLeaf(boolean a1) {
      this.b = a1;
   }

   public String getIcon() {
      return this.L;
   }

   public void setUrl(String a1) {
      this.c = a1;
   }
}
