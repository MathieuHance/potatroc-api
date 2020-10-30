package com.restapi.potatrocapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.restapi.potatrocapi.model.User;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByAuthid(@Param("authid") String authid);
}
