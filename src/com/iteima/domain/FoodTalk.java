package com.iteima.domain;

import java.util.Date;

public class FoodTalk {
private String username;
private String content;
private int user_id;
private int like_num;
private int food_id;
public int getFood_id() {
	return food_id;
}
public void setFood_id(int food_id) {
	this.food_id = food_id;
}
public int getLike_num() {
	return like_num;
}
public void setLike_num(int like_num) {
	this.like_num = like_num;
}
private Date time;
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public int getUser_id() {
	return user_id;
}
public void setUser_id(int user_id) {
	this.user_id = user_id;
}
public Date getTime() {
	return time;
}
public void setTime(Date time) {
	this.time = time;
} 
}
