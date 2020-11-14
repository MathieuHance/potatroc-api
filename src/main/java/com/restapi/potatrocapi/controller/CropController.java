package com.restapi.potatrocapi.controller;

import com.restapi.potatrocapi.Service.CropService;
import com.restapi.potatrocapi.model.Crop;

import com.restapi.potatrocapi.model.Vegetable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class CropController {

    @Autowired
    private CropService cropService;

    @RequestMapping(value = "api/crop/{id}", method = RequestMethod.GET, produces = "application/json")
    public Optional getCrop(@PathVariable("id") long id) {
        Optional<Crop> crop = cropService.getCrop(id);
        return crop;
    }

    @RequestMapping(value = "api/crops", method = RequestMethod.GET, produces = "application/json")
    public List<Crop> getAllCrops() {
        List<Crop> crops = cropService.getAllCropForUser();
        return crops;
    }

    @PostMapping("api/crop")
    public Crop postCrop(@RequestBody Crop crop) {
        Crop _crop = cropService.addCrop(crop);
        return _crop;

    }

    @PutMapping("api/crop/{id}")
    public ResponseEntity<Crop> updateCrop(@PathVariable("id") long id, @RequestBody Crop crop) {
        ResponseEntity<Crop> _crop = cropService.editCrop(id, crop);
        return _crop;
    }

    @DeleteMapping("api/crop/{id}")
    public ResponseEntity<String> deleteCrop(@PathVariable("id") long id) {
        ResponseEntity<String> crop = cropService.deleteCrop(id);
        return crop;
    }
}
