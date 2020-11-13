package com.restapi.potatrocapi.controller;

import com.restapi.potatrocapi.model.Vegetable;
import com.restapi.potatrocapi.repository.VegetableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;



@CrossOrigin
@RestController
public class VegetableController {

    @Autowired
    VegetableRepository repository;


    @RequestMapping(value = "api/vegetables", method = RequestMethod.GET, produces = "application/json")
    public List<Vegetable> getAllVegetables() {
        List<Vegetable> vegetables = new ArrayList<>();
        repository.findAll().forEach(vegetables::add);
        return vegetables;

    }
}