package com.iteima.domain;

import java.sql.Date;

public class QuestionUser {

	private Date last_time;
	private Integer q_id;
	public Integer getQ_id() {
		return q_id;
	}
	public void setQ_id(Integer q_id) {
		this.q_id = q_id;
	}
	private String pub_username;
	private Integer total_num;
	private String last_comment_username;
	
	public Date getLast_time() {
		return last_time;
	}
	public void setLast_time(Date last_time) {
		this.last_time = last_time;
	}
	public String getPub_username() {
		return pub_username;
	}
	public void setPub_username(String pub_username) {
		this.pub_username = pub_username;
	}
	public Integer getTotal_num() {
		return total_num;
	}
	public void setTotal_num(Integer total_num) {
		this.total_num = total_num;
	}
	public String getLast_comment_username() {
		return last_comment_username;
	}
	public void setLast_comment_username(String last_comment_username) {
		this.last_comment_username = last_comment_username;
	}
}
