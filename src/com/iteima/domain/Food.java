package com.iteima.domain;

import java.util.Date;

public class Food {
   private int id;
   private int food_id;
   private int number;
   private String img_name;
   private Date release_time;
   private String introduce;
   private String text;
   private int fabulous;
public int getid() {
	return id;
}
public void setid(int id) {
	this.id = id;
}
public int getFood_id() {
	return food_id;
}
public void setFood_id(int food_id) {
	this.food_id = food_id;
}
public int getNumber() {
	return number;
}
public void setNumber(int number) {
	this.number = number;
}
public String getImg_name() {
	return img_name;
}
public void setImg_name(String img_name) {
	this.img_name = img_name;
}
public Date getrelease_time() {
	return release_time;
}
public void setrelease_time(Date release_time) {
	this.release_time = release_time;
}
public String getintroduce() {
	return introduce;
}
public void setintroduce(String introduce) {
	this.introduce = introduce;
}
public String gettext() {
	return text;
}
public void settext(String text) {
	this.text = text;
}
public int getFabulous() {
	return fabulous;
}
public void setFabulous(int fabulous) {
	this.fabulous = fabulous;
}
}
