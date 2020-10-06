package com.iteima.domain;

import java.sql.Date;

public class CompetitionNotice {

	private Integer notice_id;
	private String theme;
	private String content;
	private Date release_time;
	private Integer read_num;
	private String competition_name;

	private String file;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public String getCompetition_name() {
		return competition_name;
	}
	public void setCompetition_name(String competition_name) {
		this.competition_name = competition_name;
	}
	public Integer getNotice_id() {
		return notice_id;
	}
	public void setNotice_id(Integer notice_id) {
		this.notice_id = notice_id;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public String getcontent() {
		return content;
	}
	public void setcontent(String content) {
		this.content = content;
	}
	public Date getRelease_time() {
		return release_time;
	}
	public void setRelease_time(Date release_time) {
		this.release_time = release_time;
	}
	public Integer getRead_num() {
		return read_num;
	}
	public void setRead_num(Integer read_num) {
		this.read_num = read_num;
	}
	@Override
	public String toString() {
		return "CompetitionNotice [notice_id=" + notice_id + ", theme=" + theme + ", content=" + content
				+ ", release_time=" + release_time + ", read_num=" + read_num + "]";
	}
	
	
}
