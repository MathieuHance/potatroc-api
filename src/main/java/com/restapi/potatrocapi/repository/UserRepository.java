package com.restapi.potatrocapi.repository;

import org.springframework.data.repository.CrudRepository;

import com.restapi.potatrocapi.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
}
