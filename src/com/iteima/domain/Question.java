package com.iteima.domain;

import java.sql.Date;

public class Question {
	private Integer question_id;
	private Integer user_id;
	private String category;
	private Date release_time;
	private String title;
	private String content;
	@Override
	public String toString() {
		return "Question [user_id=" + user_id + ", category=" + category + ", release_time=" + release_time + ", title="
				+ title + ", content=" + content + "]";
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Date getRelease_time() {
		return release_time;
	}
	public void setRelease_time(Date release_time) {
		this.release_time = release_time;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(Integer question_id) {
		this.question_id = question_id;
	}
	
	
	
}
