package com.restapi.potatrocapi.Service;


import com.restapi.potatrocapi.model.User;
import com.restapi.potatrocapi.repository.UserRepository;
import com.restapi.potatrocapi.repository.VegetableRepository;
import com.restapi.potatrocapi.utils.tokenInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    VegetableRepository vegetableRepository;


    public Optional getUser(long id) {
        Optional<User> user  = userRepository.findById(id);
        return user;
    }

    public User findByAuthid(){
        String authid = new tokenInfo().getUserSub();
        User user = userRepository.findByAuthid(authid);
        return user;
    }


    public List<User> getAllUser() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public List<User> findAllUsersNative() {
        List<User> users = userRepository.findAllUsersNative();
        return users;
    }

    public double findDistance() {
        double location = userRepository.findDistance();
        return location;
    }

    public boolean checkAuth0Id() {
        boolean response = false;
        String authid = new tokenInfo().getUserSub();
        User user = userRepository.findByAuthid(authid);
        if (user != null ){
            response = true;
        }
        return response;
    }

    public ResponseEntity<String> addUser(User user) {
        User userWithSameAuthid = userRepository.findByAuthid(user.getAuthid());

        User _user = new User( user.getAuthid(), user.getEmail(), user.getPseudo(), user.getName(), user.getSurname(), user.getLocation() ,user.getAdmin());
        if (userWithSameAuthid == null ){
            userRepository.save(_user);
            return new ResponseEntity<>("user correctly  registered!", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("user already exists!", HttpStatus.NOT_FOUND);
        }

    }
    public ResponseEntity<User> updateUser(long id, User user) {
        Optional<User> userData = userRepository.findById(id);
        if ( userData.isPresent() ) {
            User _user = new User( user.getAuthid(), user.getEmail(), user.getPseudo(), user.getName(), user.getSurname(), user.getLocation() ,user.getAdmin());
            _user.setId(userData.get().getId());
            return new ResponseEntity<>(userRepository.save(_user), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
    public ResponseEntity<String> deleteUser(long id) {
        Optional<User> userData = userRepository.findById(id);
        if(userData.isPresent()) {
            userRepository.deleteById(id);
            return new ResponseEntity<>("User has been deleted!", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("User don't exist!",HttpStatus.NOT_FOUND);
        }
    }

}