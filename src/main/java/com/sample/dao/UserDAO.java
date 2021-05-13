package com.sample.dao;

import org.springframework.data.repository.CrudRepository;

import com.sample.model.Users;

public interface UserDAO extends CrudRepository<Users, Integer>{
	Users findByUsername(String username);
}
