package com.iteima.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.iteima.domain.Competion;
import com.iteima.domain.CompetitionNotice;
import com.iteima.domain.File;
import com.iteima.domain.User;
import com.iteima.domain.compRead;
import com.iteima.utils.JdbcUtil;

public class ReleaseCompetitionDao {
	
	public void insertCompetition(String theme,String content,String release_time,String file,String competition_name) {
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
		 String sql="insert into all_competitionnotice(theme,content,release_time,file,competition_name) values(?,?,?,?,?)  ";
		 
			try {
			 qr.insert(sql,new ScalarHandler(), theme,content,release_time,file,competition_name);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  	  
}
	public int countCompetion(String theme) {

		 String sql = "select count(*) from all_competitionnotice ";
		  QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
	        try {
	            Long count = qr.query(sql, new ScalarHandler<Long>());
	            
	            return count.intValue();
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	}
	public void insertCompetitionFile(int notice_id,String filename,String path) {
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
		 String sql="insert into competion_file(notice_id,filename,path) values(?,?,?)  ";
		 
			try {
			 qr.insert(sql,new ScalarHandler(), notice_id,filename,path);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  	  
}
	public List<CompetitionNotice> findCopmById(int id) {
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
	     
	   	   String sql="select * from all_competitionnotice where notice_id=? ";
	   	List<CompetitionNotice> user=null;
			try {
			 user=qr.query(sql, new BeanListHandler<CompetitionNotice>(CompetitionNotice.class),id);
			 
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
  	   return user;
	}
	public CompetitionNotice findById(int id) {
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
	     
  	   String sql="select * from all_competitionnotice  where notice_id=? ";
  	 CompetitionNotice allfile=null;
  	   try {
  		   allfile=qr.query(sql, new BeanHandler<CompetitionNotice>(CompetitionNotice.class),id);
  	   }catch(SQLException e){
  		   e.printStackTrace();
  	   }
  	   return allfile;
	}
	
	public List<compRead> findRead(int id) {
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
	     
  	   String sql="select * from competion_read  where notice_id=? order by look_num desc";
  	   List<compRead> allfile=null;
  	   try {
  		   allfile=qr.query(sql, new BeanListHandler<compRead>(compRead.class),id);
  	   }catch(SQLException e){
  		   e.printStackTrace();
  	   }
  	   return allfile;
	}
	public void updateFile(String content,String theme,int id) {
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
	     
  	   String sql="update all_competitionnotice set content=? , file=? where notice_id=? ";
  	  
  	   try {
  		  qr.update(sql, content,theme,id);
  		   
  	   }catch(SQLException e){
  		   e.printStackTrace();
  	   }
  	  
	}
	public void deleteComp(int id) {
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
		  String sql1="delete from competion_read  where notice_id=? ";
		  try {
		  		 qr.update(sql1,id);
		  	   }catch(SQLException e){
		  		   e.printStackTrace();
		  	   }
  	   String sql="delete from all_competitionnotice  where notice_id=? ";
  	   
  	   try {
  		 qr.update(sql,id);
  	   }catch(SQLException e){
  		   e.printStackTrace();
  	   }
  	  
	}
}
