package com.xiaojun.yb.service.VO;

import java.io.Serializable;

public class RoleVO implements Serializable {

   private Integer seqNo;
   private String spaceId;
   private String id;
   private Integer type;
   private String name;
   private String deptId;
   private String deptName;
   private String remark;


   public String getName() {
      return this.name;
   }

   public String getDeptId() {
      return this.deptId;
   }

   public Integer getSeqNo() {
      return this.seqNo;
   }

   public void setId(String a1) {
      this.id = a1;
   }

   public String getId() {
      return this.id;
   }

   public String getRemark() {
      return this.remark;
   }

   public String getSpaceId() {
      return this.spaceId;
   }

   public void setDeptName(String a1) {
      this.deptName = a1;
   }

   public void setType(Integer a1) {
      this.type = a1;
   }

   public void setSeqNo(Integer a1) {
      this.seqNo = a1;
   }

   public String getDeptName() {
      return this.deptName;
   }

   public void setDeptId(String a1) {
      this.deptId = a1;
   }

   public Integer getType() {
      return this.type;
   }

   public void setSpaceId(String a1) {
      this.spaceId = a1;
   }

   public void setRemark(String a1) {
      this.remark = a1 == null?null:a1.trim();
   }

   public void setName(String a1) {
      this.name = a1 == null?null:a1.trim();
   }
}
