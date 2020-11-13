package com.restapi.potatrocapi.Service;


import java.util.List;
import java.util.Optional;

import com.restapi.potatrocapi.model.Vegetable;
import com.restapi.potatrocapi.repository.CropRepository;
import com.restapi.potatrocapi.repository.UserRepository;
import com.restapi.potatrocapi.repository.VegetableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class VegetableService {
    @Autowired
    CropRepository cropRepository;
    @Autowired
    VegetableRepository vegetableRepository;

    @Autowired
    private UserRepository userRepository;

    public Optional getVegetable(long id) {
        Optional<Vegetable> vegetable  = vegetableRepository.findById(id);
        return vegetable;
    }

    public List <Vegetable> getAllVegetable() {
        List<Vegetable> vegetables = vegetableRepository.findAll();
        return vegetables;
    }

    public Vegetable addVegetable(Vegetable vegetable) {
        return vegetableRepository.save(vegetable);
    }

    public Vegetable editVegetable(Vegetable vegetable) {
        return vegetableRepository.save(vegetable);
    }

    public void deleteVegetable(long id) {
        vegetableRepository.deleteById(id);
    }
}