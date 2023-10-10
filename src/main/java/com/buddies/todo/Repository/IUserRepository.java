package com.buddies.todo.Repository;

import com.buddies.todo.Entity.User;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IUserRepository extends MongoRepository<User, ObjectId> {
	User findByEmail(String email);
}
