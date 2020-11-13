package com.restapi.potatrocapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.restapi.potatrocapi.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByAuthid(@Param("authid") String authid);

    @Query(
            value = "Select u.* from potatroc.user u ",
            nativeQuery = true)
    List<User> findAllUsersNative();

    @Query(
            value = "select st_distance_sphere(st_makepoint(3.450078945154793, 50.56683384660144),st_makepoint(3.381802, 50.6052712))from potatroc.location",
            nativeQuery = true)
    double findDistance();

}
