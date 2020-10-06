package com.iteima.test;
import java.io.Serializable;
import java.util.List;
 
public class DeptVos  implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 7648136453963080696L;
	private Integer answer_id;
	private Integer re_replay_id;
	private Integer replay_id;
	private String content;
	private List<DeptVos> subDeptVos;
	
	
	
	public List<DeptVos> getSubDeptVos() {
		return subDeptVos;
	}
	public void setSubDeptVos(List<DeptVos> subDeptVos) {
		this.subDeptVos = subDeptVos;
	}
	
	public String toString() {
		return "DeptVos [deptId=" + replay_id + ", deptName=" + re_replay_id
				+ ", subDeptVos=" + subDeptVos + "]";
	}
	public Integer getAnswer_id() {
		return answer_id;
	}
	public void setAnswer_id(Integer answer_id) {
		this.answer_id = answer_id;
	}
	public Integer getRe_replay_id() {
		return re_replay_id;
	}
	public void setRe_replay_id(Integer re_replay_id) {
		this.re_replay_id = re_replay_id;
	}
	public Integer getReplay_id() {
		return replay_id;
	}
	public void setReplay_id(Integer replay_id) {
		this.replay_id = replay_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	
	
}
