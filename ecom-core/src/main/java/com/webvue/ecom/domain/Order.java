package com.webvue.ecom.domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order extends BaseEntity<Long> {

   private static final long     serialVersionUID = 1L;

   private Date                  orderDate;

   @OneToMany(mappedBy = "order")
   private Collection<OrderLine> orderLines;

   @ManyToOne(optional = false)
   @JoinColumn(name = "customer_id")
   private Customer              customer;

   public Order() {
      super();
   }

   public Order(Customer customer) {
      super();
      this.customer = customer;
   }

   public Date getOrderDate() {
      return orderDate;
   }

   public void setOrderDate(Date orderDate) {
      this.orderDate = orderDate;
   }

   public Collection<OrderLine> getOrderLines() {
      return orderLines;
   }

   public void setOrderLines(Collection<OrderLine> orderLines) {
      this.orderLines = orderLines;
   }

   public Customer getCustomer() {
      return customer;
   }

   public void setCustomer(Customer customer) {
      this.customer = customer;
   }
}
