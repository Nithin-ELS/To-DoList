package com.buddies.todo.Repository;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.buddies.todo.Entity.ToDoList;

public interface IToDoListRepository extends MongoRepository<ToDoList, String> {
	List<ToDoList> findByIsDeletedFalse();
}
