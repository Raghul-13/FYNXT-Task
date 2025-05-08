package com.raghul.task.repository;

import com.raghul.task.dto.User;

// import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
// import org.springframework.stereotype.Repository;

// @Repository
public interface UserRepository extends MongoRepository<User, String>{
    // List<User>
}
