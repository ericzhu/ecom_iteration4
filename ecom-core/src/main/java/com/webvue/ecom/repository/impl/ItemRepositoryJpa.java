package com.webvue.ecom.repository.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.webvue.ecom.domain.Item;
import com.webvue.ecom.repository.ItemRepository;
import com.webvue.ecom.repository.jpa.GenericRepositoryAbstract;

@Repository
public class ItemRepositoryJpa extends GenericRepositoryAbstract<Long, Item> implements ItemRepository {

   @Override
   public List<Item> findByCategoryId(Long categoryId) {
      String jpql = "select i from Item i where i.category.id = :categoryId";
      TypedQuery<Item> query = entityManager.createQuery(jpql, entityClass);
      query.setParameter("categoryId", categoryId);
      return query.getResultList();
   }
}
