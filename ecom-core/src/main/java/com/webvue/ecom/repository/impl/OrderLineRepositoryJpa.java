package com.webvue.ecom.repository.impl;

import org.springframework.stereotype.Repository;

import com.webvue.ecom.domain.OrderLine;
import com.webvue.ecom.repository.OrderLineRepository;
import com.webvue.ecom.repository.jpa.GenericRepositoryAbstract;

@Repository
public class OrderLineRepositoryJpa extends GenericRepositoryAbstract<Long, OrderLine> implements OrderLineRepository{

}
