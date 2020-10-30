package com.restapi.potatrocapi.controller;

import com.restapi.potatrocapi.model.Location;
import com.restapi.potatrocapi.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class LocationController {

    @Autowired
    LocationRepository repository;


    @RequestMapping(value = "api/locations", method = RequestMethod.GET, produces = "application/json")
    public List<Location> getAllLocations() {

        List<Location> locations = new ArrayList<>();
        repository.findAll().forEach(locations::add);

        return locations;

    }
}



