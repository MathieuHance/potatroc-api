package com.restapi.potatrocapi.repository;

import com.restapi.potatrocapi.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
}
