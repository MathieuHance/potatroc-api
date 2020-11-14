package com.restapi.potatrocapi.Service;

    import java.util.Date;
    import java.util.List;
    import java.util.Optional;

    import com.restapi.potatrocapi.model.Crop;
    import com.restapi.potatrocapi.model.User;
    import com.restapi.potatrocapi.model.Vegetable;
    import com.restapi.potatrocapi.repository.CropRepository;
    import com.restapi.potatrocapi.repository.UserRepository;
    import com.restapi.potatrocapi.repository.VegetableRepository;
    import com.restapi.potatrocapi.tools.tokenInfo;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.stereotype.Service;


@Service
public class CropService {
    @Autowired
    CropRepository cropRepository;
    @Autowired
    VegetableRepository vegetableRepository;
    @Autowired
    private UserRepository userRepository;

    public Optional getCrop(long id) {
        String authid = new tokenInfo().getUserSub();
        User user= userRepository.findByAuthid(authid);
        Optional<Crop> crop  = cropRepository.findById(id);
        User crop_user= crop.get().getUser();
        if( user.getAdmin() || crop_user.getId() == user.getId() ){
            return crop;
        } else {
            return null;
        }
    }

    public List<Crop> getAllCropForUser() {
        String authid = new tokenInfo().getUserSub();
        User user= userRepository.findByAuthid(authid);
        List<Crop> crops = cropRepository.findByUser(user);
        return crops;
    }

    public Crop addCrop(Crop crop) {
        String authid = new tokenInfo().getUserSub();
        crop.setCreatedAt(new Date());
        crop.setUpdatedAt(new Date());
        User user = userRepository.findByAuthid(authid);
        Vegetable vegetable = crop.getVegetable();
        vegetable = vegetableRepository.findById(vegetable.getId()).get();
        crop.setvegetable(vegetable);
        crop.setUser(user);
        return cropRepository.save(crop);
    }

    public ResponseEntity<Crop> editCrop(long id, Crop crop) {
        Optional<Crop> cropData = cropRepository.findById(id);
        if(cropData.isPresent()) {
            String authid = new tokenInfo().getUserSub();

            User user = userRepository.findByAuthid(authid);
            Vegetable vegetable = crop.getVegetable();
            vegetable = vegetableRepository.findById(vegetable.getId()).get();

            Crop _crop = cropData.get();
            _crop.setUpdatedAt(new Date());
            _crop.setUser(user);
            _crop.setvegetable(vegetable);
            _crop.setQuantity(crop.getQuantity());
            return new ResponseEntity<>(cropRepository.save(_crop), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    public ResponseEntity<String> deleteCrop(long id) {
        Optional<Crop> cropData = cropRepository.findById(id);
        if(cropData.isPresent()) {
            cropRepository.deleteById(id);
            return new ResponseEntity<>("Crop has been deleted!", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Crop don't exist!",HttpStatus.NOT_FOUND);
        }
    }
}