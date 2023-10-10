package com.buddies.todo.Entity;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

import lombok.NoArgsConstructor;


@Document(collection = "todo_lists")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ToDoList {
	@Id
	private String id;
	private String toDoListName;
	private List<ToDoItem> items;
	
	@CreatedDate
	private Date createdAt;
	
	@LastModifiedDate
	private Date lastModifiedAt;
	
	@CreatedBy
	private String createdBy;
	
	@LastModifiedBy
	private String lastModifiedBy;
	
	private boolean isDeleted;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<ToDoItem> getItems() {
		return items;
	}

	public void setItems(List<ToDoItem> items) {
		this.items = items;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getLastModifiedAt() {
		return lastModifiedAt;
	}

	public void setLastModifiedAt(Date lastModifiedAt) {
		this.lastModifiedAt = lastModifiedAt;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Object getToDoListName() {

		return toDoListName;
	}

	public void setToDoListName(Object object) {
		this.toDoListName = (String) object;
	}

}
