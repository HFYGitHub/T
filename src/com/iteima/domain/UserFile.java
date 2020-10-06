package com.iteima.domain;

import java.util.Date;

public class UserFile {
	private Integer file_id;
	private String username;
	private Date down_time;
	private String filename;
	private String theme;
	private Integer down_num;
	public Integer getFile_id() {
		return file_id;
	}
	public void setFile_id(Integer file_id) {
		this.file_id = file_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getDown_time() {
		return down_time;
	}
	public void setDown_time(Date down_time) {
		this.down_time = down_time;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public Integer getDown_num() {
		return down_num;
	}
	public void setDown_num(Integer down_num) {
		this.down_num = down_num;
	}
}
