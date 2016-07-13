package com.webvue.ecom.service.spring;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webvue.ecom.domain.Cart;
import com.webvue.ecom.domain.Category;
import com.webvue.ecom.domain.Customer;
import com.webvue.ecom.domain.Item;
import com.webvue.ecom.domain.Order;
import com.webvue.ecom.domain.OrderLine;
import com.webvue.ecom.domain.Role;
import com.webvue.ecom.domain.User;
import com.webvue.ecom.repository.CategoryRepository;
import com.webvue.ecom.repository.CustomerRepository;
import com.webvue.ecom.repository.ItemRepository;
import com.webvue.ecom.repository.OrderLineRepository;
import com.webvue.ecom.repository.OrderRepository;
import com.webvue.ecom.repository.UserRepository;
import com.webvue.ecom.service.StoreService;

@Service
@Transactional
public class StoreServiceImpl implements StoreService {

   @Autowired
   private CategoryRepository  categoryRepository;

   @Autowired
   private ItemRepository      itemRepository;

   @Autowired
   private UserRepository      userRepository;

   @Autowired
   private CustomerRepository  customerRepository;

   @Autowired
   private OrderRepository     orderRepository;

   @Autowired
   private OrderLineRepository orderLineRepository;

   @Override
   public Category addCategory(Category category) {
      categoryRepository.persist(category);
      return category;
   }

   @Override
   @Transactional(readOnly = true)
   public List<Category> listCategories() {
      return categoryRepository.findAll();
   }

   @Override
   @Transactional(readOnly = true)
   public Category getCategory(Long categoryId) {
      return categoryRepository.find(categoryId);
   }

   @Override
   public void deleteCategory(Long categoryId) {
      categoryRepository.remove(categoryId);
   }

   @Override
   public Category updateCategory(Category category) {
      return categoryRepository.merge(category);
   }

   @Override
   public void addItem(Item item, Long categoryId) {
      Category category = categoryRepository.find(categoryId);
      item.setCategory(category);
      itemRepository.persist(item);
   }

   @Override
   @Transactional(readOnly = true)
   public List<Item> listItems() {
      return itemRepository.findAll();
   }

   @Override
   @Transactional(readOnly = true)
   public List<Item> searchItemByKeyword(String keyword) {
      String jpql = "select i from Item i where i.itemName like '%" + keyword + "%' or i.itemDescription like '%" + keyword + "%'";
      return itemRepository.findByQuery(jpql);
   }

   @Override
   @Transactional(readOnly = true)
   public List<Item> getItemByCategories(Long categoryId) {
      return itemRepository.findByCategoryId(categoryId);
   }

   @Override
   @Transactional(readOnly = true)
   public List<Item> getSelectedItems() {
      String jpql = "select i from Item i where i.selected = true";
      return itemRepository.findByQuery(jpql);
   }

   @Override
   @Transactional(readOnly = true)
   public Item getItemById(Long id) {
      return itemRepository.find(id);
   }

   @Override
   public Item updateItem(Item item) {
      return itemRepository.merge(item);
   }

   @Override
   public User addUser(User user) {
      return userRepository.persist(user);

   }

   @Override
   public void assignRole(Role role, Long userId) {

   }

   @Override
   public Order registerOrder(Cart cart, Customer customer) {

      Collection<OrderLine> cartItems = cart.getItems();
      if (CollectionUtils.isNotEmpty(cartItems)) {
         return null;
      }
      customerRepository.persist(customer);
      
      Order order = new Order();
      order.setCustomer(customer);
      order.setOrderDate(new Date());
      orderRepository.persist(order);

      for (OrderLine orderLine : cartItems) {
         orderLine.setOrder(order);
         orderLineRepository.persist(orderLine);
      }      
      order.setOrderLines(cartItems);
      return order;
   }
}
