package com.webvue.ecom.repository.impl;

import org.springframework.stereotype.Repository;

import com.webvue.ecom.domain.Category;
import com.webvue.ecom.repository.CategoryRepository;
import com.webvue.ecom.repository.jpa.GenericRepositoryAbstract;

@Repository
public class CategoryRepositoryJpa extends GenericRepositoryAbstract<Long, Category> implements CategoryRepository{

}
