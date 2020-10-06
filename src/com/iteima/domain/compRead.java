package com.iteima.domain;

import java.sql.Date;

public class compRead {
	private Integer notice_id;
	private Integer user_id;
	private Integer look_num;
	private Integer down_num;
	private Date look_time;
	public Integer getNotice_id() {
		return notice_id;
	}
	public void setNotice_id(Integer notice_id) {
		this.notice_id = notice_id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getLook_num() {
		return look_num;
	}
	public void setLook_num(Integer look_num) {
		this.look_num = look_num;
	}
	public Integer getDown_num() {
		return down_num;
	}
	public void setDown_num(Integer down_num) {
		this.down_num = down_num;
	}
	public Date getLook_time() {
		return look_time;
	}
	public void setLook_time(Date look_time) {
		this.look_time = look_time;
	}
}
