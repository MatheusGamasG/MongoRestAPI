package com.mongodb.repository;

import com.mongodb.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import java.util.Objects;

@Repository
public class UserRepositoryRaiz {

    MongoOperations mongoOperations;
    @Autowired
    public UserRepositoryRaiz(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    public User saveUser(User user) {
        if(Objects.nonNull(user)) {
            return mongoOperations
                    .insert(user);
        }
        throw new RuntimeException("Não foi possível salvar o usuário.");
    }

}
