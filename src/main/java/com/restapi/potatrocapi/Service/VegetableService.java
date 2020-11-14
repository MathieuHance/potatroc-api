package com.restapi.potatrocapi.Service;


import java.util.List;
import java.util.Optional;

import com.restapi.potatrocapi.model.Unit;
import com.restapi.potatrocapi.model.Vegetable;
import com.restapi.potatrocapi.repository.UnitRepository;
import com.restapi.potatrocapi.repository.VegetableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class VegetableService {
    @Autowired
    UnitRepository unitRepository;
    @Autowired
    VegetableRepository vegetableRepository;


    public Optional getVegetable(long id) {
        Optional<Vegetable> vegetable  = vegetableRepository.findById(id);
        return vegetable;
    }

    public List <Vegetable> getAllVegetable() {
        List<Vegetable> vegetables = vegetableRepository.findAll();
        return vegetables;
    }

    public ResponseEntity<Vegetable> addVegetable(Vegetable vegetable) {
        Unit unit = vegetable.getUnit();
        unit = unitRepository.findById(unit.getId()).get();
        vegetable.setUnit(unit);
        return new ResponseEntity<>(vegetableRepository.save(vegetable), HttpStatus.OK);
    }

    public ResponseEntity<Vegetable> editVegetable(long id, Vegetable vegetable) {
        Optional<Vegetable> vegetableData = vegetableRepository.findById(id);
        if(vegetableData.isPresent()) {
            Unit unit = vegetable.getUnit();
            unit = unitRepository.findById(unit.getId()).get();
            Vegetable _vegetable = vegetableData.get();
            _vegetable.setName(vegetable.getName());
            _vegetable.setPrice(vegetable.getPrice());
            _vegetable.setUnit(unit);
            return new ResponseEntity<>(vegetableRepository.save(_vegetable), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<String> deleteVegetable(long id) {
        Optional<Vegetable> vegetableData = vegetableRepository.findById(id);
        if(vegetableData.isPresent()) {
            vegetableRepository.deleteById(id);
            return new ResponseEntity<>("Vegetable has been deleted!", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Vegetable don't exist!",HttpStatus.NOT_FOUND);
        }
    }
}