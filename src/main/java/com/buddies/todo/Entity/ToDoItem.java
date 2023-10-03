package com.buddies.todo.Entity;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ToDoItem {

	@Id
	private ObjectId id;
	private String item;

	@CreatedBy
	private String createdBy;

	@CreatedDate
	private Date createdAt;

	@LastModifiedBy
	private String lastModifiedBy;

	@LastModifiedDate
	private Date lastModifiedDate;
	
	private Boolean isDeleted;
	private Boolean isDisabled;

}
