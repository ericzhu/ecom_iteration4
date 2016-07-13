package com.webvue.ecom.repository.impl;

import org.springframework.stereotype.Repository;

import com.webvue.ecom.domain.Order;
import com.webvue.ecom.repository.OrderRepository;
import com.webvue.ecom.repository.jpa.GenericRepositoryAbstract;

@Repository
public class OrderRepositoryJpa extends GenericRepositoryAbstract<Long, Order> implements OrderRepository{

}
