package com.raghul.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.raghul.task.dto.User;
import com.raghul.task.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    // get all users
    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // get user by id
    @GetMapping("/deails/{id}")
    public ResponseEntity<?> getUserById(@PathVariable String id) {
        User user = userService.getUserById(id);
        if(user != null) {
            return  ResponseEntity.ok(user);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User Not Found with Id:" + id);
        }
    }

    // add user
    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        User addedUser = userService.addUser(user);
        if (addedUser != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body("User created with ID: " + addedUser.getId());
        } 
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create user.");
        }
    }

    // update user
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateUser(@PathVariable String id, @RequestBody User user) {
        User updatedUser = userService.updateUser(id, user);
        if (updatedUser != null) {
            return ResponseEntity.ok("User updated with ID: " + id);
        } 
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found for update with ID: " + id);
        }
    }

    // delete user
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return "User Deleted with id: " + id;
    }

}
