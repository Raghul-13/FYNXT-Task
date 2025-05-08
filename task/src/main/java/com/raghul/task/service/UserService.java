package com.raghul.task.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raghul.task.dto.User;
import com.raghul.task.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    //get all user
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    //get user by id
    public User getUserById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    //add USer
    public User addUser(User user) {
        return userRepository.save(user);
    }

    //update User
    public User updateUser(String id, User user) {
        User existingUser = userRepository.findById(id).orElse(null);
        if(existingUser != null) {
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setMobile(user.getMobile());
        return userRepository.save(existingUser);    
    }
    else{
        return userRepository.save(user);
    }
    }

    //delete user
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}
