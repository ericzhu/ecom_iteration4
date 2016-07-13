package com.webvue.ecom.repository.jpa;

import org.springframework.stereotype.Repository;

import com.webvue.ecom.domain.Category;
import com.webvue.ecom.repository.CategoryRepository;

@Repository
public class CategoryRepositoryJpa extends GenericRepositoryAbstract<Long, Category> implements CategoryRepository {

}
