package com.restapi.potatrocapi.controller;

import com.restapi.potatrocapi.Service.UnitService;
import com.restapi.potatrocapi.model.Unit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class UnitController {

    @Autowired
    private UnitService unitService;

    @RequestMapping(value = "api/unit/{id}", method = RequestMethod.GET, produces = "application/json")
    public Optional getUnit(@PathVariable("id") long id) {
        Optional<Unit> unit = unitService.getUnit(id);
        return unit;
    }

    @RequestMapping(value = "api/units", method = RequestMethod.GET, produces = "application/json")
    public List<Unit> getAllUnits() {
        List<Unit> units = unitService.getAllUnit();
        return units;

    }

    @PostMapping("api/unit")
    public ResponseEntity<Unit> postUnit(@RequestBody Unit unit) {
        ResponseEntity<Unit> _unit = unitService.addUnit(unit);
        return _unit;
    }
    @PutMapping("api/unit/{id}")
    public ResponseEntity<Unit> updateUnit(@PathVariable("id") long id, @RequestBody Unit unit) {
        ResponseEntity<Unit> _unit = unitService.editUnit(id, unit);
        return _unit;
    }

    @DeleteMapping("api/unit/{id}")
    public ResponseEntity<String> deleteUnit(@PathVariable("id") long id) {
        ResponseEntity<String> unit = unitService.deleteUnit(id);
        return unit;
    }
}
