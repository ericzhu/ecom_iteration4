package com.webvue.ecom.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User extends BaseEntity<Long> {

   private static final long serialVersionUID = 1L;

   private String            username;

   private String            password;

   private boolean           active;

   public User() {
      super();
   }

   public User(String username, String password, boolean active) {
      super();
      this.username = username;
      this.password = password;
      this.active = active;
   }

   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public boolean isActive() {
      return active;
   }

   public void setActive(boolean active) {
      this.active = active;
   }
}