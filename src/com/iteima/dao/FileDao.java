package com.iteima.dao;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.apache.tools.ant.types.resources.selectors.Date;

import com.iteima.domain.File;
import com.iteima.domain.UserDownFile;
import com.iteima.utils.JdbcUtil;

public class FileDao {
	public List<File> findAllFile() {
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
	     
  	   String sql="select * from file_data order by downnum desc ";
  	   List<File> allfile=null;
  	   try {
  		   allfile=qr.query(sql, new BeanListHandler<File>(File.class));
  	   }catch(SQLException e){
  		   e.printStackTrace();
  	   }
  	   return allfile;
	}
	public List<File> findFileByName(String name) {
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
	     
  	   String sql="select * from file_data where filename=? ";
  	   List<File> allfile=null;
  	   try {
  		   allfile=qr.query(sql, new BeanListHandler<File>(File.class),name);
  	   }catch(SQLException e){
  		   e.printStackTrace();
  	   }
  	   return allfile;
	}
	public List<File> findFileByTheme(String theme) {
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
	     
  	   String sql="select * from file_data  where theme=? order by downnum desc";
  	   List<File> allfile=null;
  	   try {
  		   allfile=qr.query(sql, new BeanListHandler<File>(File.class),theme);
  	   }catch(SQLException e){
  		   e.printStackTrace();
  	   }
  	   return allfile;
	}
	
	
	public void updateDownNum(String filename) {
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
	     
  	   String sql="update file_data set downnum=downnum+1 where filename=? ";
  	   List<File> allfile=null;
  	   try {
  		  qr.update(sql, filename);
  		   
  	   }catch(SQLException e){
  		   e.printStackTrace();
  	   }
  	  
	}
	public void updateFile(String filename,String theme,String org_filename) {
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
	     
  	   String sql="update file_data set filename=? , theme=? where filename=? ";
  	  
  	   try {
  		  qr.update(sql, filename,theme,org_filename);
  		   
  	   }catch(SQLException e){
  		   e.printStackTrace();
  	   }
  	  
	}
	public void deleteFile(String filename) {
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
		String sql1="delete from user_downfile  where fileid in(select fileid from file_data where filename=?) ";
	  	   
	  	   try {
	  		 qr.update(sql1,filename);
	  	   }catch(SQLException e){
	  		   e.printStackTrace();
	  	   }
  	   String sql="delete from file_data  where filename=? ";
  	   
  	   try {
  		 qr.update(sql,filename);
  	   }catch(SQLException e){
  		   e.printStackTrace();
  	   }
  	  
	}

	public void insertFile(String filename,String path,String theme) {
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
	    
		String sql="select * from  file_data where filename=?  ";
		 List<File> allfile=null;
	  	   try {
	  		   allfile=qr.query(sql, new BeanListHandler<File>(File.class),filename);
	  	   }catch(SQLException e){
	  		   e.printStackTrace();
	  	   }
	  	   if(allfile.isEmpty()) {
	  		 java.util.Date date=new java.util.Date();
	 		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
	 		String time=sdf.format(date);
	 		 
	   	   String sql1="insert into file_data(filename,path,theme,time,id) values(?,?,?,?,?)  ";
	   	
	 		try {
	 		  qr.insert(sql1,new ScalarHandler(), filename,path,theme,time,"4");
	 		} catch (SQLException e) {
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
	 		}
	   	  
	  	   }else {
	  		   System.out.println("Ê§°Ü");
	  	   }
		
	}

	
	public void insertUserD(int fileid,String username) {
		java.util.Date date=new java.util.Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
		String time=sdf.format(date);
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
	     
  	   String sql="insert into user_downfile(fileid,username,down_time) values(?,?,?)  ";
  	 Object object=null;
		try {
		 object =  qr.insert(sql,new ScalarHandler(), fileid,username,time);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  	  
	}
	
	public File findFileByFile_id(int id) {
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
	     
  	   String sql="select * from file_data  where fileid=?";
  	   File allfile=null;
  	   try {
  		   allfile=qr.query(sql, new BeanHandler<File>(File.class),id);
  	   }catch(SQLException e){
  		   e.printStackTrace();
  	   }
  	   return allfile;
	}
	
	
	public List<UserDownFile> findFileByUser(String username) {
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
		
  	   String sql="select * from user_downfile  where username=?";
  	   List<UserDownFile> allfile=null;
  	   try {
  		   allfile=qr.query(sql, new BeanListHandler<UserDownFile>(UserDownFile.class),username);
  	   }catch(SQLException e){
  		   e.printStackTrace();
  	   }
  	 
  	   return allfile;
	}
	public List<UserDownFile> findFileByKey(String key) {
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
	
  	   String sql="select * from user_downfile  where username=?";
  	   List<UserDownFile> allfile=null;
  	   try {
  		   allfile=qr.query(sql, new BeanListHandler<UserDownFile>(UserDownFile.class),key);
  	   }catch(SQLException e){
  		   e.printStackTrace();
  	   }
  	  
  	   return allfile;
	}
	public int countFile(String theme) {
		  String sql = "select count(*) from file_data where theme=?";
		  QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
	        try {
	            Long count = qr.query(sql, new ScalarHandler<Long>(),theme);
	            
	            return count.intValue();
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	}
	public int countAllFile() {
		  String sql = "select count(*) from file_data ";
		  QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
	        try {
	            Long count = qr.query(sql, new ScalarHandler<Long>());
	            
	            return count.intValue();
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	}
	public int countUserDown(String username,int id) {
		  String sql = "select count(*) from user_downfile where username=? and fileid=?";
		  QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
	        try {
	            Long count = qr.query(sql, new ScalarHandler<Long>(),username,id);
	            
	            return count.intValue();
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	}
	public int countFile() {
		  String sql = "select count(*) from file_data ";
		  QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
	        try {
	            Long count = qr.query(sql, new ScalarHandler<Long>());
	            
	            return count.intValue();
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	}
}
