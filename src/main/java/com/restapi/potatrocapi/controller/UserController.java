package com.restapi.potatrocapi.controller;

import java.util.List;
import java.util.Optional;


import com.restapi.potatrocapi.Service.UserService;
import com.restapi.potatrocapi.model.User;
import com.restapi.potatrocapi.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin
@RestController
public class UserController {

    @Autowired
    UserRepository repository;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "api/user/{id}", method = RequestMethod.GET, produces = "application/json")
    public Optional getUser(@PathVariable("id") long id) {
        Optional<User> user = userService.getUser(id);
        return user;

    }

    @RequestMapping(value = "/api/user", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public User findByAuthid() {
        User user = userService.findByAuthid();
        return user;
    }

    @RequestMapping(value = "api/users", method = RequestMethod.GET, produces = "application/json")
    public List<User> getAllUsers() {
        List<User> users = userService.getAllUser();
        return users;
    }

    @RequestMapping(value = "/api/user/query", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<User> findAllUsersNative() {
        List<User> users = userService.findAllUsersNative();
        return users;

    }

    @RequestMapping(value = "/api/user/location", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public double findDistance() {
        double location = userService.findDistance();
        return location;

    }

    @RequestMapping(value = "/api/user/exist", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public boolean checkAuth0Id() {
        boolean response = userService.checkAuth0Id();
        return response;
    }

    @PostMapping("api/user")
    public ResponseEntity<String> postUser(@RequestBody User user) {
        ResponseEntity<String> _user = userService.addUser(user);
        return _user;
    }

    @PutMapping("api/user/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user) {
        ResponseEntity<User> _user = userService.updateUser(id, user);
        return _user;

    }
    @DeleteMapping("api/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") long id) {
        ResponseEntity<String> user = userService.deleteUser(id);
        return user;
    }



}
