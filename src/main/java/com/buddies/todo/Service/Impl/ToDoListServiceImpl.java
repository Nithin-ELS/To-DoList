package com.buddies.todo.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buddies.todo.Entity.ToDoList;
import com.buddies.todo.Repository.IToDoListRepository;
import com.buddies.todo.Service.IToDoListService;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ToDoListServiceImpl implements IToDoListService {

	private final IToDoListRepository toDoListRepository;

	@Autowired
	public ToDoListServiceImpl(IToDoListRepository toDoListRepository) {
		this.toDoListRepository = toDoListRepository;
	}

	@Override
	public List<ToDoList> getAllToDoLists() {
//        return toDoListRepository.findAll();
		return toDoListRepository.findByIsDeletedFalse();
	}

	@Override
	public Optional<ToDoList> getToDoListById(String id) {
		return toDoListRepository.findById(id);
	}

	@Override
	public ToDoList createToDoList(ToDoList toDoList,String userId) {
		toDoList.setCreatedAt(new Date());
		toDoList.setCreatedBy(userId);
		return toDoListRepository.save(toDoList);
	}

	@Override
	public ToDoList updateToDoList(String id, ToDoList updatedToDoList) {
		Optional<ToDoList> existingToDoList = toDoListRepository.findById(id);
		if (existingToDoList.isPresent()) {
			ToDoList toDoList = existingToDoList.get();

			if (updatedToDoList.getToDoListName() != null) {
				toDoList.setToDoListName(updatedToDoList.getToDoListName());
			}

			// Update fields as needed
			toDoList.setToDoListName(updatedToDoList.getToDoListName());
			// Update other fields here
			return toDoListRepository.save(toDoList);
		} else {
			// Handle the case when the ToDoList with the given ID is not found
			System.out.println("ID Not found");
			return null;

		}
	}

	@Override
	public void deleteToDoList(String id) {
		toDoListRepository.deleteById(id);
	}
}
