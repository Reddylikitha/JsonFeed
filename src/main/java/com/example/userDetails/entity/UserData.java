package com.example.userDetails.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class UserData {
	
	@Id
	private int userId;
	private int it;
	private String title;
	private String body;
	
	public UserData(){
		
	}
	
	
	public UserData(int userId,int it,String title,String body) {
		
		this.setUserId(userId);
		this.setIt(it);
		this.setTitle(title);
		this.setBody(body);
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getIt() {
		return it;
	}
	public void setIt(int it) {
		this.it = it;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}

}
