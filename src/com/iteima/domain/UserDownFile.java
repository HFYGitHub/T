package com.iteima.domain;

import java.util.Date;

public class UserDownFile {
	private Integer fileid;
	private String username;
	private Date down_time;
	public Integer getfileid() {
		return fileid;
	}
	public void setfileid(Integer fileid) {
		this.fileid = fileid;
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
}
