package com.webvue.ecom.repository;

import java.io.Serializable;
import java.util.List;

import com.webvue.ecom.domain.BaseEntity;

public interface GenericRepository<ID extends Serializable, T extends BaseEntity<ID>> {

   public T find(ID id);

   public T persist(T entity);

   public T merge(T entity);

   public void remove(T entity);

   public void remove(ID entityId);

   public void refresh(T entity);

   public List<T> findAll();
   
   public List<T> findByQuery(String jpql);
}
