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

    public Crop editCrop(Crop crop) {
        return cropRepository.save(crop);
    }

    public void deleteCrop(long id) {
        cropRepository.deleteById(id);
    }
}