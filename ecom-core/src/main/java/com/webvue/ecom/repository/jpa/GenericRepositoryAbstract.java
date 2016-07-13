package com.webvue.ecom.repository.jpa;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.Validate;

import com.webvue.ecom.domain.BaseEntity;
import com.webvue.ecom.repository.GenericRepository;

public abstract class GenericRepositoryAbstract<ID extends Serializable, T extends BaseEntity<ID>> implements GenericRepository<ID, T> {

   protected Class<ID>     idClass;

   protected Class<T>      entityClass;

   @PersistenceContext
   protected EntityManager entityManager;

   @SuppressWarnings({ "unchecked", "rawtypes" })
   protected GenericRepositoryAbstract() {
      Type genericSuperclass = this.getClass().getGenericSuperclass();
      while (!(genericSuperclass instanceof ParameterizedType)) {
         if (!(genericSuperclass instanceof Class))
            throw new IllegalStateException("Unable to determine type " + "arguments because generic superclass neither " + "parameterized type nor class.");
         if (genericSuperclass == GenericRepositoryAbstract.class)
            throw new IllegalStateException("Unable to determine type " + "arguments because no parameterized generic superclass " + "found.");
         genericSuperclass = ((Class)genericSuperclass).getGenericSuperclass();
      }
      ParameterizedType type = (ParameterizedType)genericSuperclass;
      Type[] arguments = type.getActualTypeArguments();
      this.idClass = (Class<ID>)arguments[0];
      this.entityClass = (Class<T>)arguments[1];
   }

   @Override
   public T find(ID id) {
      if (id == null) {
         return null;
      }
      return entityManager.find(entityClass, id);
   }

   @Override
   public T persist(T entity) {
      entityManager.persist(entity);
      return entity;
   }

   @Override
   public T merge(T entity) {

      Validate.notNull(entity);

      entityManager.persist(entity);
      return entity;
   }

   @Override
   public void remove(T entity) {
      if (entity != null) {
         entityManager.remove(entity);
      }
   }

   @Override
   public void remove(ID entityId) {
      T entity = find(entityId);
      if (entity != null) {
         remove(entity);
      }
   }

   @Override
   public void refresh(T entity) {
      if (entity != null) {
         entityManager.refresh(entity);
      }
   }

   @Override
   public List<T> findAll() {

      CriteriaBuilder cb = entityManager.getCriteriaBuilder();

      CriteriaQuery<T> criteriaQuery = cb.createQuery(entityClass);
      Root<T> root = criteriaQuery.from(entityClass);
      criteriaQuery.select(root);
      return entityManager.createQuery(criteriaQuery).getResultList();
   }

   @Override
   public List<T> findByQuery(String jpql) {
      TypedQuery<T> query = entityManager.createQuery(jpql, entityClass);
      return query.getResultList();
   }
}
