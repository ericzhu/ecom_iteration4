package com.webvue.ecom.repository.impl;

import com.webvue.ecom.domain.Customer;
import com.webvue.ecom.repository.CustomerRepository;
import com.webvue.ecom.repository.jpa.GenericRepositoryAbstract;

public class CustomerRepositoryJpa extends GenericRepositoryAbstract<Long, Customer> implements CustomerRepository{

}
