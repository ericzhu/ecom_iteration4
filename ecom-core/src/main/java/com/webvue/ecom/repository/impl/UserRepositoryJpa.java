package com.webvue.ecom.repository.impl;

import org.springframework.stereotype.Repository;

import com.webvue.ecom.domain.User;
import com.webvue.ecom.repository.UserRepository;
import com.webvue.ecom.repository.jpa.GenericRepositoryAbstract;

@Repository
public class UserRepositoryJpa extends GenericRepositoryAbstract<Long, User> implements UserRepository{

}
