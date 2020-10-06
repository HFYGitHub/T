package com.iteima.domain;

import java.sql.Date;

public class Competion {
	private String theme;
	private Integer notice_id;
	private Integer read_num;
	private String competition_name;
	public String getCompetition_name() {
		return competition_name;
	}
	public void setCompetition_name(String competition_name) {
		this.competition_name = competition_name;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public Integer getNotice_id() {
		return notice_id;
	}
	public void setNotice_id(Integer notice_id) {
		this.notice_id = notice_id;
	}
	public Integer getRead_num() {
		return read_num;
	}
	public void setRead_num(Integer read_num) {
		this.read_num = read_num;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getRelease_time() {
		return release_time;
	}
	public void setRelease_time(Date release_time) {
		this.release_time = release_time;
	}
	private String content;
	private Date release_time;
}
