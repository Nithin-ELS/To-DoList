package com.buddies.todo.Service;

import java.util.List;
import java.util.Optional;

import com.buddies.todo.Entity.ToDoList;

public interface IToDoListService {
	List<ToDoList> getAllToDoLists();

    Optional<ToDoList> getToDoListById(String id);

    ToDoList createToDoList(ToDoList toDoList,String userId);

    ToDoList updateToDoList(String id, ToDoList updatedToDoList);

    void deleteToDoList(String id);
}
