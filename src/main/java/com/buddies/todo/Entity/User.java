package com.buddies.todo.Entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Users")
 public class User {
 
	@Id
	private ObjectId id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	
}
