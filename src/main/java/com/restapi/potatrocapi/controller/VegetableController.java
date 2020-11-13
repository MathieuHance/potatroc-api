package com.restapi.potatrocapi.controller;

import com.restapi.potatrocapi.Service.VegetableService;
import com.restapi.potatrocapi.model.Crop;
import com.restapi.potatrocapi.model.User;
import com.restapi.potatrocapi.model.Vegetable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin
@RestController
public class VegetableController {

    @Autowired
    private VegetableService vegetableService;

    @RequestMapping(value = "api/vegetable/{id}", method = RequestMethod.GET, produces = "application/json")
    public Optional getVegetable(@PathVariable("id") long id) {
        Optional<Vegetable> vegetable = vegetableService.getVegetable(id);
        return vegetable;
    }

    @RequestMapping(value = "api/vegetables", method = RequestMethod.GET, produces = "application/json")
    public List<Vegetable> getAllVegetables() {
        List<Vegetable> vegetables = vegetableService.getAllVegetable();
        return vegetables;

    }

    @PostMapping("api/vegetable")
    public ResponseEntity<Vegetable> postVegetable(@RequestBody Vegetable vegetable) {
        ResponseEntity<Vegetable> _vegetable = vegetableService.addVegetable(vegetable);
        return _vegetable;
    }
    @PutMapping("api/vegetable/{id}")
    public ResponseEntity<Vegetable> updateUser(@PathVariable("id") long id, @RequestBody Vegetable vegetable) {
        ResponseEntity<Vegetable> _vegetable = vegetableService.editVegetable(id, vegetable);
        return _vegetable;
    }

    @DeleteMapping("api/vegetable/{id}")
    public ResponseEntity<String> deleteVegetable(@PathVariable("id") long id) {
        ResponseEntity<String> vegetable = vegetableService.deleteVegetable(id);
        return vegetable;
    }
}

