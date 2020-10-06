package com.iteima.domain;

import java.sql.Date;
import java.util.List;

public class AnswerUser {
	private String name;
	private Integer answer_id;
	private Integer question_id;
	private Integer user_id;
	private String answer;

	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	private String image;
	private Date release_time;
    private List<ReplayUser> deptVos;
	
	public List<ReplayUser> getReplayUser() {
		return deptVos;
	}
	public void setReplayUser(List<ReplayUser> deptVos) {
		this.deptVos = deptVos;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAnswer_id() {
		return answer_id;
	}
	public void setAnswer_id(Integer answer_id) {
		this.answer_id = answer_id;
	}
	public Integer getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(Integer question_id) {
		this.question_id = question_id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Date getRelease_time() {
		return release_time;
	}
	public void setRelease_time(Date release_time) {
		this.release_time = release_time;
	}
}
