package com.buddies.todo.Repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.buddies.todo.Entity.User;

public interface IUserRepository extends MongoRepository<User, ObjectId> {

}
