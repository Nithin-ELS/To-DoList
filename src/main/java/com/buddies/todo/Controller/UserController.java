package com.buddies.todo.Controller;

import com.buddies.todo.Entity.User;
import com.buddies.todo.Service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
	
	@Autowired
	private  IUserService userService;

	@GetMapping(value = "/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id) {
        return Optional.ofNullable(userService.getUserById(id)).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
	
	@PostMapping(value="/createUser")
	public ResponseEntity<User> createUser(@RequestBody User user){
        return Optional.ofNullable(userService.createUser(user)).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
	
	@GetMapping("/login")
	public ResponseEntity<User> login(@RequestParam("email") String email, @RequestParam("pass") String pass) {
	  User register = userService.login(email, pass);
	  if(register!=null) {
		  return new ResponseEntity<User>(register,HttpStatus.OK);
	  }
	  else
	  {
		  return new ResponseEntity<User>(register,HttpStatus.PARTIAL_CONTENT);
	  }
	}
}
