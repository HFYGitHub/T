package com.iteima.test;
import java.io.Serializable;
import java.util.List;
 
public class CompanyVos  implements Serializable{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 5617344073236043292L;
	private Integer answer_id;
	private String answer;
	private List<DeptVos> deptVos;
	
	
	public List<DeptVos> getDeptVos() {
		return deptVos;
	}
	public void setDeptVos(List<DeptVos> deptVos) {
		this.deptVos = deptVos;
	}
	
	public String toString() {
		return "CompanyVos [companyId=" + answer_id + ", companyName=" + answer +", deptVos="+"]";
	}
	public Integer getAnswer_id() {
		return answer_id;
	}
	public void setAnswer_id(Integer answer_id) {
		this.answer_id = answer_id;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
	
	
