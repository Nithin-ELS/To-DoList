package com.buddies.todo.Service.Impl;

import com.buddies.todo.Entity.User;
import com.buddies.todo.Repository.IUserRepository;
import com.buddies.todo.Service.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {
	
	private  IUserRepository userRepository;

	@Override
	public User getUserById(final String userId)
	{
//		log.info("Getting {}...", userId);

		return userRepository.findById(new ObjectId(userId)).orElse(null);
	}
}
