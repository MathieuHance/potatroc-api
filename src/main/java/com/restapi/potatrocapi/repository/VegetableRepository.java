package com.restapi.potatrocapi.repository;

import com.restapi.potatrocapi.model.Vegetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VegetableRepository extends JpaRepository<Vegetable, Long> {
}
