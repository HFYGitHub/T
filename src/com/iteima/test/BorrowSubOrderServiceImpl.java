package com.iteima.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.iteima.domain.Answer;
import com.iteima.domain.ReplayUser;
import com.iteima.utils.JdbcUtil;
 

public class BorrowSubOrderServiceImpl  {
	
	
	
	public List<Answer> findCompanyAndDepts(int question_id){
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
		String sql="select * from all_answer where question_id=?";
		 List<Answer>  companyVosList=null;
		 try {
			companyVosList=qr.query(sql, new BeanListHandler<Answer>(Answer.class),question_id);
	  		   
	  		  
	  	   }catch(SQLException e){
	  		   e.printStackTrace();
	  	   } 
		List<Answer> list=new ArrayList<Answer>();
	
		if(!companyVosList.isEmpty()){
			for(Answer companyVo:companyVosList){
				Answer companyVo2=new Answer();
				companyVo2.setAnswer_id(companyVo.getAnswer_id());
				companyVo2.setAnswer(companyVo.getAnswer());
				companyVo2.setQuestion_id(companyVo.getQuestion_id());
				companyVo2.setRelease_time(companyVo.getRelease_time());
				companyVo2.setReplayUser(companyVo.getReplayUser());
				companyVo2.setUser_id(companyVo.getUser_id());
				companyVo2.setReplayUser(getDepts(0,companyVo.getAnswer_id()));
				list.add(companyVo2);
			}
		}
		return list;
	}
	
	/**
	 * @descript:µÝ¹é»Ø¸´
	 * @param param
	 * @return
	 */
	public List<ReplayUser> getDepts(int fr,int an){ 
		List<ReplayUser> deptVosList=new ArrayList<ReplayUser>();
		List<ReplayUser> deptVos=null;
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
		String sql="select * from comment   where  re_repaly_id=? and answer_id=?  ";
		 try {
			 deptVos=qr.query(sql, new BeanListHandler<ReplayUser>(ReplayUser.class),fr,an);
			 }catch(SQLException e){
	  		   e.printStackTrace();
	  	   } 
		if(!deptVos.isEmpty()){ 
			for(ReplayUser deptVo:deptVos){
				ReplayUser deptVo2=new ReplayUser();
				deptVo2.setReplay_id(deptVo.getReplay_id());
				deptVo2.setContent(deptVo.getContent());
				deptVo2.setAnswer_id(deptVo.getAnswer_id());
				deptVo2.setFabulous(deptVo.getFabulous());
				deptVo2.setRe_repaly_id(deptVo.getRe_repaly_id());
				deptVo2.setReplay_username(deptVo.getReplay_username());
				deptVo2.setUsername(deptVo.getUsername());
				deptVo2.setTime(deptVo.getTime());
				deptVo2.setReplayUser(getDepts(deptVo.getReplay_id(),deptVo.getAnswer_id()));
				deptVosList.add(deptVo2);
			}
		}
		return deptVosList;
	}
	

}
