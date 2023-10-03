package com.buddies.todo.Controller;

import com.buddies.todo.Entity.User;
import com.buddies.todo.Service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
	
	@Autowired
	private final IUserService userService;

	@GetMapping(value = "/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id) {
        return Optional.ofNullable(userService.getUserById(id)).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
	
}
