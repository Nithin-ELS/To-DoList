package com.buddies.todo.Service;

import com.buddies.todo.Entity.UpdatePasswordDTO;
import com.buddies.todo.Entity.User;

public interface IUserService{
	User getUserById(String userId);
	User createUser(User user);
	User login(String email, String pass);
	String updatePassword(UpdatePasswordDTO updatePasswordDTO);
}
