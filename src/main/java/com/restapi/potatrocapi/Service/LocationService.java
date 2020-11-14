package com.restapi.potatrocapi.Service;


import com.restapi.potatrocapi.model.Location;
import com.restapi.potatrocapi.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LocationService {
    @Autowired
    LocationRepository locationRepository;

    public List<Location> getAllLocation() {
        List<Location> locations = locationRepository.findAll();
        return locations;
    }

}