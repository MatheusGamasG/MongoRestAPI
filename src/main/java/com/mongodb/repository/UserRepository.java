package com.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mongodb.model.User;

public interface UserRepository extends MongoRepository<User, String> {

}
