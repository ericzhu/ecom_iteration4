package com.webvue.ecom.service;

import java.util.List;

import com.webvue.ecom.domain.Cart;
import com.webvue.ecom.domain.Category;
import com.webvue.ecom.domain.Customer;
import com.webvue.ecom.domain.Item;
import com.webvue.ecom.domain.Order;
import com.webvue.ecom.domain.Role;
import com.webvue.ecom.domain.User;

public interface StoreService {

   public Category addCategory(Category category);

   public List<Category> listCategories();

   public Category getCategory(Long categoryId);

   public void deleteCategory(Long categoryId);

   public Category updateCategory(Category category);

   public void addItem(Item item, Long categoryId);

   public List<Item> listItems();

   public List<Item> searchItemByKeyword(String keyword);

   public List<Item> getItemByCategories(Long categoryId);

   public List<Item> getSelectedItems();

   public Item getItemById(Long id);

   public Item updateItem(Item item);

   public User addUser(User user);

   public void assignRole(Role role, Long userId);

   public Order registerOrder(Cart cart, Customer customer);
}
