package com.buddies.todo.Controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.buddies.todo.Entity.User;
import com.buddies.todo.Service.IUserService;
import com.buddies.todo.Service.Impl.UserServiceImpl;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private final IUserService userService;
	
	@Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }
	
	@GetMapping()
    public String getUserById() {
        return userService.getUserById();
    }
	
}
