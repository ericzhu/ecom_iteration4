package com.webvue.ecom.domain;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.Validate;

public class Cart implements Serializable {

   private static final long    serialVersionUID = 1L;

   private Map<Long, OrderLine> cartItems        = new HashMap<>();

   public void addItem(Item item, int quantity) {

      Validate.notNull(item);

      if (cartItems.containsKey(item.getId())) {
         OrderLine orderLine = cartItems.get(item.getId());
         orderLine.setQuantity(orderLine.getQuantity() + quantity);
      }
      else {
         cartItems.put(item.getId(), new OrderLine(item, quantity, item.getPrice()));
      }
   }
   
   public Collection<OrderLine> getItems() {
      return cartItems.values();
   }

}
