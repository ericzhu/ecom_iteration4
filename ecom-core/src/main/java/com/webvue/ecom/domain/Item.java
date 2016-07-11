package com.webvue.ecom.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "items")
public class Item extends BaseEntity<Long> {

   private static final long serialVersionUID = 1L;

   @NotEmpty
   @Size(min = 1, max = 20)
   private String            itemName;
   private String            itemDescription;
   private BigDecimal        price;
   private Integer           quantity;
   private boolean           selected;

   @ManyToOne
   @JoinColumn(name = "cat_id")
   private Category          category;

   public Item() {
      super();
   }

   public Item(String itemName, String itemDescription, BigDecimal price, Integer quantity, boolean selected, Category category) {
      super();
      this.itemName = itemName;
      this.itemDescription = itemDescription;
      this.price = price;
      this.quantity = quantity;
      this.selected = selected;
      this.category = category;
   }

   public String getItemName() {
      return itemName;
   }

   public void setItemName(String itemName) {
      this.itemName = itemName;
   }

   public String getItemDescription() {
      return itemDescription;
   }

   public void setItemDescription(String itemDescription) {
      this.itemDescription = itemDescription;
   }

   public BigDecimal getPrice() {
      return price;
   }

   public void setPrice(BigDecimal price) {
      this.price = price;
   }

   public Integer getQuantity() {
      return quantity;
   }

   public void setQuantity(Integer quantity) {
      this.quantity = quantity;
   }

   public boolean isSelected() {
      return selected;
   }

   public void setSelected(boolean selected) {
      this.selected = selected;
   }

   public Category getCategory() {
      return category;
   }

   public void setCategory(Category category) {
      this.category = category;
   }
}
