package com.myapp.fullstackbackend.controller;

import com.myapp.fullstackbackend.model.User;
import com.myapp.fullstackbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // Work
    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestBody User newUser) {
        User userFromDb = userRepository.findByUsername(newUser.getUsername());
        if (userFromDb != null) {
            if (userFromDb.getPassword().equals(newUser.getPassword())) {
                return new ResponseEntity<>(newUser, HttpStatus.CREATED);
            }
        }

        return new ResponseEntity<>(newUser, HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/registration")
    User registrationUser(@RequestBody User newUser) {
        return userRepository.save(newUser);
    }
}
