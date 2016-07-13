package com.webvue.ecom.repository;

import java.util.List;

import com.webvue.ecom.domain.Item;

public interface ItemRepository extends GenericRepository<Long, Item> {
   public List<Item> findByCategoryId(Long categoryId);
}
