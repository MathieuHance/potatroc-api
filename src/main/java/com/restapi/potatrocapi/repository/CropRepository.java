package com.restapi.potatrocapi.repository;

import com.restapi.potatrocapi.model.Crop;
import com.restapi.potatrocapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CropRepository extends JpaRepository<Crop, Long> {
    List<Crop> findByUser(@Param("user") User user);

}
