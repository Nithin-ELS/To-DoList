package com.buddies.todo.Service.Impl;

import com.buddies.todo.Entity.User;
import com.buddies.todo.Repository.IUserRepository;
import com.buddies.todo.Service.IUserService;
import com.mongodb.DuplicateKeyException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {
	@Autowired
	private IUserRepository userRepository;

	@Autowired
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public User getUserById(final String userId) {
		logger.info("Getting {}...", userId);

		return userRepository.findById(new ObjectId(userId)).orElse(null);
	}

	@Override
	public User createUser(User user){
		
		User existingUser = userRepository.findByEmail(user.getEmail());
		if (existingUser != null) {
			return null;
		}
		logger.info(" Creating a new User");
		return userRepository.save(user);
	}
	
	@Override
	public User login(String email, String password) {
		
		
		Optional<User> s = Optional.of(userRepository.findByEmail(email));
		if (s.isPresent()) {
			User value = s.get();
		    if(password.equals(value.getPassword())){
			   return value;
		    }
		    else
		    {
		    	return null;
		    }
		}
		return null;
		    
	}
}
