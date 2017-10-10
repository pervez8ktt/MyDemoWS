package com.pervez.ws.model;

import java.util.List;

public class MyResponse {
	
	Boolean status;
	List<User> object;
	String message;
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public List<User> getObject() {
		return object;
	}
	public void setObject(List<User> object) {
		this.object = object;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
