package com.fhsu.redtrade.controller;

import com.fhsu.redtrade.entity.User;
import com.fhsu.redtrade.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/users")
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUsers () {
        logger.info("Getting all users");

        return ResponseEntity.ok(userService.findAllUsers());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById (@PathVariable(required = false) String userId) {
        logger.info("Getting a user by id = {}", userId);

        return ResponseEntity.ok(userService.findById(userId));
    }

    @PostMapping("/")
    public ResponseEntity<User> createUser (@RequestBody User user) {
        logger.info("Creating a user = {}", user);

        return ResponseEntity.ok(userService.createUser(user));
    }

    @PutMapping("/")
    public ResponseEntity<User> updateUser (@RequestBody User user) {
        logger.info("Updating userId = {}", user.getId());

        return ResponseEntity.ok(userService.createUser(user));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUserById (@PathVariable(required = false) String userId) {
        logger.info("Deleting userId = {}", userId);

        userService.deleteUser(userId);

        return ResponseEntity.ok("Successfully deleted !");
    }
}