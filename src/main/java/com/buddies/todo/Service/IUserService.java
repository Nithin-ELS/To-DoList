package com.buddies.todo.Service;

import com.buddies.todo.Entity.User;

public interface IUserService{
	User getUserById(String userId);
	User createUser(User user);
}
