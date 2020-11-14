package com.restapi.potatrocapi.Service;


import com.restapi.potatrocapi.model.Unit;
import com.restapi.potatrocapi.repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UnitService {
    @Autowired
    UnitRepository unitRepository;


    public Optional getUnit(long id) {
        Optional<Unit> unit  = unitRepository.findById(id);
        return unit;
    }

    public List<Unit> getAllUnit() {
        List<Unit> unit = unitRepository.findAll();
        return unit;
    }

    public ResponseEntity<Unit> addUnit(Unit unit) { ;
        return new ResponseEntity<>(unitRepository.save(unit), HttpStatus.OK);
    }

    public ResponseEntity<Unit> editUnit(long id, Unit unit) {
        Optional<Unit> unitData = unitRepository.findById(id);
        if(unitData.isPresent()) {
            Unit _unit = unitData.get();
            _unit.setName(unit.getName());
            _unit.setSymbol(unit.getSymbol());
            return new ResponseEntity<>(unitRepository.save(_unit), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<String> deleteUnit(long id) {
        Optional<Unit> unitData = unitRepository.findById(id);
        if(unitData.isPresent()) {
            unitRepository.deleteById(id);
            return new ResponseEntity<>("Unit has been deleted!", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Unit don't exist!",HttpStatus.NOT_FOUND);
        }
    }
}