package com.webvue.ecom.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity<Long> {

   private static final long serialVersionUID = 1L;

   private String            roleName;

   public Role() {
      super();
   }

   public Role(String roleName) {
      super();
      this.roleName = roleName;
   }

   public String getRoleName() {
      return roleName;
   }

   public void setRoleName(String roleName) {
      this.roleName = roleName;
   }

}