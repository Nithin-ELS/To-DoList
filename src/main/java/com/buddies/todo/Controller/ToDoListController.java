package com.buddies.todo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.buddies.todo.Entity.ToDoList;
import com.buddies.todo.Service.IToDoListService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/todo-lists")
public class ToDoListController {

    private final IToDoListService toDoListService;

    @Autowired
    public ToDoListController(IToDoListService toDoListService) {
        this.toDoListService = toDoListService;
    }

    @GetMapping
    public List<ToDoList> getAllToDoLists() {
        return toDoListService.getAllToDoLists();
    }

    @GetMapping("/{id}")
    public ToDoList getToDoListById(@PathVariable String id) {
        Optional<ToDoList> toDoList = toDoListService.getToDoListById(id);
        return toDoList.orElse(null); 
    }

    @PostMapping
    public ToDoList createToDoList(@RequestBody ToDoList toDoList,String userId) {
    	System.out.println(toDoList);
        return toDoListService.createToDoList(toDoList,userId);
    }

    @PutMapping("/{id}")
    public ToDoList updateToDoList(@PathVariable String id, @RequestBody ToDoList updatedToDoList) {
        return toDoListService.updateToDoList(id, updatedToDoList);
    }

    @DeleteMapping("/{id}")
    public void deleteToDoList(@PathVariable String id) {
        toDoListService.deleteToDoList(id);
    }
}
