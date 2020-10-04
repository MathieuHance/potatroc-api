package com.restapi.potatrocapi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import com.restapi.potatrocapi.model.User;
import com.restapi.potatrocapi.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")

public class UserController {

    @Autowired
    UserRepository repository;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        repository.findAll().forEach(users::add);
        return users;
    }

    @PostMapping("/user")
    public User postUser(@RequestBody User user) {
        User _user = repository.save(new User(user.getName()));
        return _user;
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") long id) {
        repository.deleteById(id);
        return new ResponseEntity<>("User has been deleted!", HttpStatus.OK);
    }


    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user) {
        Optional<User> userData = repository.findById(id);

        if (userData.isPresent()) {
            User _user = userData.get();
            _user.setName(user.getName());
            return new ResponseEntity<>(repository.save(_user), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
