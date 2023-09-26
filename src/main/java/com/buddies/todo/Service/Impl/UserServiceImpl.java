package com.buddies.todo.Service.Impl;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buddies.todo.Entity.User;
import com.buddies.todo.Repository.IUserRepository;
import com.buddies.todo.Service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	
	private final IUserRepository userRepository;

    @Autowired
    public UserServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
	@Override
	public String getUserById()
	{
		return "working";
	}
}
