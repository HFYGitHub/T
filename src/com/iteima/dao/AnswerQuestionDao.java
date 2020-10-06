package com.iteima.dao;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.iteima.domain.Answer;
import com.iteima.domain.ReplayUser;
import com.iteima.utils.JdbcUtil;

public class AnswerQuestionDao {
	
	public void insertAnswer(int question_id,int id,String answer,String release_time) {
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
		 String sql="insert into all_answer(question_id,user_id,answer,release_time) values(?,?,?,?)  ";
		 
			try {
			  qr.insert(sql,new ScalarHandler(), question_id,id,answer,release_time);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  	  
}
	public List<ReplayUser> findAllFile(int id) {
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
	     
  	   String sql="select * from comment where answer_id=? order by fabulous desc";
  	   List<ReplayUser> allfile=null;
  	   try {
  		   allfile=qr.query(sql, new BeanListHandler<ReplayUser>(ReplayUser.class),id);
  		   
  		   for(ReplayUser r:allfile) {
  			   System.out.println(r.getContent());
  		   }
  	   }catch(SQLException e){
  		   e.printStackTrace();
  	   }
  	   
  	   
  	   return allfile;
	}
	
	public List<Answer> findAll() {
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
	     
  	   String sql="select * from all_answer  order by release_time desc";
  	   List<Answer> allfile=null;
  	   try {
  		   allfile=qr.query(sql, new BeanListHandler<Answer>(Answer.class));
  		   
  		   
  	   }catch(SQLException e){
  		   e.printStackTrace();
  	   }
  	   
  	   
  	   return allfile;
	}
	public List<ReplayUser> findAllCom() {
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
	     
  	   String sql="select * from comment  order by time desc";
  	   List<ReplayUser> allfile=null;
  	   try {
  		   allfile=qr.query(sql, new BeanListHandler<ReplayUser>(ReplayUser.class));
  		   
  		   
  	   }catch(SQLException e){
  		   e.printStackTrace();
  	   }
  	   
  	   
  	   return allfile;
	}
	public List<ReplayUser> findByUserName(String username) {
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
	     
  	   String sql="select * from comment where username=? order by time desc";
  	   List<ReplayUser> allfile=null;
  	   try {
  		   allfile=qr.query(sql, new BeanListHandler<ReplayUser>(ReplayUser.class),username);
  		   
  		   for(ReplayUser r:allfile) {
  			   System.out.println(r.getContent());
  		   }
  	   }catch(SQLException e){
  		   e.printStackTrace();
  	   }
  	   
  	   
  	   return allfile;
	}
	
	
	public List<Answer> findByUserId(int id) {
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
	     
  	   String sql="select * from all_answer where user_id=? order by release_time desc";
  	   List<Answer> allfile=null;
  	   try {
  		   allfile=qr.query(sql, new BeanListHandler<Answer>(Answer.class),id);
  		   
  		   
  	   }catch(SQLException e){
  		   e.printStackTrace();
  	   }
  	   
  	   
  	   return allfile;
	}
	
	public int countAnswer(int id) {
		  String sql = "select count(*) from all_answer where question_id=? ";
		  QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
	        try {
	            Long count = qr.query(sql,id,new ScalarHandler<Long>());
	           
	            return count.intValue()+countComment(id);
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	        
	        
	}
	
	public int countComment(int id) {
		  
	        String sql1 = "select count(*) from comment where answer_id in(select answer_id from all_answer where question_id=?) ";
	        QueryRunner qr1=new QueryRunner(JdbcUtil.getDataSource());
	        try {
	            Long count1 = qr1.query(sql1,id,new ScalarHandler<Long>());
	           
	            return count1.intValue();
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	        
	}
	
	public Answer findLastAnswer(int id) {
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
	     
  	   String sql="select * from all_answer where question_id=? order by release_time desc";
  	   Answer allfile=null;
  	   try {
  		   allfile=qr.query(sql, new BeanHandler<Answer>(Answer.class),id);
  		 
  	   }catch(SQLException e){
  		   e.printStackTrace();
  	   }
  	   
  	   
  	   return allfile;
	}
	
	public void findReplay(int id) {
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
	     
		String sql="update comment set fabulous=fabulous+1 where replay_id=? ";
	  	  
  	   try {
  		 qr.update(sql, id);
  	   }catch(SQLException e){
  		   e.printStackTrace();
  	   }
  	 
	}
	public void deleteCom(int id) {
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
	      
  	    String sql="delete from comment  where answer_id in(select answer_id from all_answer where question_id=?)";
  	   
  	   try {
  		 qr.update(sql,id);
  	   }catch(SQLException e){
  		   e.printStackTrace();
  	   }
  	  
	}
	public void deleteAns(int id) {
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
	      
  	    String sql="delete from all_answer  where  question_id=?";
  	   
  	   try {
  		 qr.update(sql,id);
  	   }catch(SQLException e){
  		   e.printStackTrace();
  	   }
  	  
	}
	public void updateFabulous(int id) {
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
	     
  	   String sql="update comment set fabulous=fabulous+1  where replay_id=? ";
  	  
  	   try {
  		  qr.update(sql,id);
  		   
  	   }catch(SQLException e){
  		   e.printStackTrace();
  	   }
  	  
	}
	
	public void insertComment(String username,String replay_username,String content,int id,int answer_id) {
		java.util.Date date=new java.util.Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
		String time=sdf.format(date);
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
	     
  	   String sql="insert into comment(username,replay_username,content,time,re_repaly_id,fabulous,answer_id) values(?,?,?,?,?,?,?)  ";
  	 Object object=null;
		try {
		 object =  qr.insert(sql,new ScalarHandler(), username,replay_username,content,time,id,0,answer_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  	  
	}
	
	
	public void deleteComment(int id) {
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
	     
  	   String sql="delete from comment  where replay_id=? ";
  	   
  	   try {
  		 qr.update(sql,id);
  	   }catch(SQLException e){
  		   e.printStackTrace();
  	   }
  	  
	}
	public List< ReplayUser> getComment(int answer_id){
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
		String sql="select * from comment where answer_id=? and re_repaly_id=0 order by fabulous desc";//获取当前评论的第一条回复或者无回复的回复，oreder
		List<ReplayUser> allfile=new ArrayList<>();
	  	   try {
	  		   allfile=qr.query(sql, new BeanListHandler<ReplayUser>(ReplayUser.class),answer_id);
	  		   
	  		  
	  	   }catch(SQLException e){
	  		   e.printStackTrace();
	  	   } 
	  	 List<ReplayUser> allfile1=getCommentSon(answer_id);
	     for(ReplayUser r:allfile1) {
	    	 r.setContent("回复@"+r.getReplay_username()+":"+r.getContent());
	    	 allfile.add(r);
	     }
	    
	  	 
	  	 
	  	 return allfile;
	  	 }
	
	public List< ReplayUser> getCommentSon(int answer_id){
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
		String sql="select * from comment where answer_id=? and re_repaly_id!=0 order by fabulous desc";//获取当前评论的第一条回复或者无回复的回复，oreder
		List<ReplayUser> allfile=new ArrayList<>();
	  	   try {
	  		   allfile=qr.query(sql, new BeanListHandler<ReplayUser>(ReplayUser.class),answer_id);
	  		   
	  		  
	  	   }catch(SQLException e){
	  		   e.printStackTrace();
	  	   } 
	  	
	
	  	 
	  	 
	  	 
	  	 return allfile;
	  	 }
	
	


	
}
