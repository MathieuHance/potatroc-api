package com.restapi.potatrocapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.restapi.potatrocapi.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
