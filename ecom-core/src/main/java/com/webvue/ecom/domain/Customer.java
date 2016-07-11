package com.webvue.ecom.domain;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "customers")
public class Customer extends BaseEntity<Long> {

   private static final long serialVersionUID = 1L;

   @NotEmpty
   private String            name;
   @NotEmpty
   private String            email;
   @NotEmpty
   private String            phone;
   @NotEmpty
   private String            address;

   @OneToMany(mappedBy = "customer")
   private Collection<Order> orders;

   public Customer() {
      super();
   }

   public Customer(String name, String email, String phone, String address) {
      super();
      this.name = name;
      this.email = email;
      this.phone = phone;
      this.address = address;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getPhone() {
      return phone;
   }

   public void setPhone(String phone) {
      this.phone = phone;
   }

   public String getAddress() {
      return address;
   }

   public void setAddress(String address) {
      this.address = address;
   }

   public Collection<Order> getOrders() {
      return orders;
   }

   public void setOrders(Collection<Order> orders) {
      this.orders = orders;
   }

}
