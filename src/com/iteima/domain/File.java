package com.iteima.domain;

import java.util.Date;
import java.util.List;

public class File {
private int fileid;
private String filename;
private String path;
private String theme;
private Date time;
private int downnum;

private int user_id;

public int getFileid() {
	return fileid;
}

public void setFileid(int fileid) {
	this.fileid = fileid;
}

public String getFilename() {
	return filename;
}

public void setFilename(String filename) {
	this.filename = filename;
}

public String getPath() {
	return path;
}

public void setPath(String path) {
	this.path = path;
}

public String getTheme() {
	return theme;
}

public void setTheme(String theme) {
	this.theme = theme;
}

public Date getTime() {
	return time;
}

public void setTime(Date time) {
	this.time = time;
}

public int getDownnum() {
	return downnum;
}

public void setDownnum(int downnum) {
	this.downnum = downnum;
}

public int getUser_id() {
	return user_id;
}

public void setUser_id(int user_id) {
	this.user_id = user_id;
}



}
