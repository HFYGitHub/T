package com.iteima.domain;

import java.sql.Date;
import java.util.List;

public class UserWithComment {
	private String content;
	private Integer answer_id;
	private Integer replay_id;
	private String username;
	private String image;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getAnswer_id() {
		return answer_id;
	}
	public void setAnswer_id(Integer answer_id) {
		this.answer_id = answer_id;
	}
	public Integer getReplay_id() {
		return replay_id;
	}
	public void setReplay_id(Integer replay_id) {
		this.replay_id = replay_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getimage() {
		return image;
	}
	public void setimage(String image) {
		this.image = image;
	}
	public String getReplay_username() {
		return replay_username;
	}
	public void setReplay_username(String replay_username) {
		this.replay_username = replay_username;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public Integer getFabulous() {
		return fabulous;
	}
	public void setFabulous(Integer fabulous) {
		this.fabulous = fabulous;
	}
	public Integer getRe_repaly_id() {
		return re_repaly_id;
	}
	public void setRe_repaly_id(Integer re_repaly_id) {
		this.re_repaly_id = re_repaly_id;
	}
	public List<ReplayUser> getDeptVos() {
		return deptVos;
	}
	public void setDeptVos(List<ReplayUser> deptVos) {
		this.deptVos = deptVos;
	}
	private String replay_username;
	private Date time;
	private Integer fabulous;
	private Integer re_repaly_id;
    private List<ReplayUser> deptVos;
}
