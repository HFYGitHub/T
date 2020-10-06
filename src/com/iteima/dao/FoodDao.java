package com.iteima.dao;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.iteima.domain.File;
import com.iteima.domain.Food;
import com.iteima.domain.FoodTalk;
import com.iteima.domain.User;
import com.iteima.service.UserService;
import com.iteima.utils.JdbcUtil;

public class FoodDao {
	public List<Food> findFileByTheme(String theme) {
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
	     
  	   String sql="select * from food_data";
  	   List<Food> allfood=null;
  	   try {
  		 allfood=qr.query(sql, new BeanListHandler<Food>(Food.class));
  	   }catch(SQLException e){
  		   e.printStackTrace();
  	   }
  	   return allfood;
	}
	public void updateFood(int id) {
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
	     
  	   String sql="update food_data set fabulous=fabulous+1 where food_id=? ";
  	  System.out.println("okll");
  	   try {
  		  qr.update(sql, id);
  		   
  	   }catch(SQLException e){
  		   e.printStackTrace();
  	   }
  	  
	}
	
	public void updateFoodTalk(int id,String time,String username) {
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
	     
  	   String sql="update food_talk set like_num=like_num+1 where food_id=? and username=? and time=? ";
  	  System.out.println("okll");
  	   try {
  		  qr.update(sql, id,username,time);
  		   
  	   }catch(SQLException e){
  		   e.printStackTrace();
  	   }
  	  
	}
	public List<Food> findAllFood() {
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
	     
  	   String sql="select * from food_data order by fabulous desc";
  	   List<Food> allfood=null;
  	   try {
  		 allfood=qr.query(sql, new BeanListHandler<Food>(Food.class));
  	   }catch(SQLException e){
  		   e.printStackTrace();
  	   }
  	   return allfood;
	}
	public List<Food> findAllFoodByName(int id) {
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
	     
  	   String sql="select * from food_data where id=? order by fabulous desc";
  	   List<Food> allfood=null;
  	   try {
  		 allfood=qr.query(sql, new BeanListHandler<Food>(Food.class),id);
  	   }catch(SQLException e){
  		   e.printStackTrace();
  	   }
  	   return allfood;
	}
	public List<Food> findFoodById(int id) {
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
	     
  	   String sql="select * from food_data where food_id=? order by fabulous desc";
  	   List<Food> allfood=null;
  	   try {
  		 allfood=qr.query(sql, new BeanListHandler<Food>(Food.class),id);
  	   }catch(SQLException e){
  		   e.printStackTrace();
  	   }
  	   return allfood;
	}
	
	public Food findFood(int id) {
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
	     
	  	   String sql="select * from food_data where food_id=? ";
	  	   Food allfood=null;
	  	   try {
	  		 allfood=qr.query(sql, new BeanHandler<Food>(Food.class),id);
	  	   }catch(SQLException e){
	  		   e.printStackTrace();
	  	   }
	  	   return allfood;
		
	}
	
	public List<FoodTalk> findFoodTalkByName(String  name) {
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
	     
	  	   String sql="select * from food_talk where username=? ";
	  	 List<FoodTalk> allfood=null;
	  	   try {
	  		 allfood=qr.query(sql, new BeanListHandler<FoodTalk>(FoodTalk.class),name);
	  	   }catch(SQLException e){
	  		   e.printStackTrace();
	  	   }
	  	   return allfood;
		
	}
	//按照分类显示图片
	public List<Food> findFileByTheme(String numflag,String theme,String dateflag) {
		System.out.println(theme+" "+numflag+" "+dateflag);
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
		String sql=null;
		 List<Food> allfood=null;
		
		
				 sql="select * from food_data   order by fabulous  desc  ";
		
			   try {
					 allfood=qr.query(sql, new BeanListHandler<Food>(Food.class));
				   }catch(SQLException e){
					   e.printStackTrace();
				   }
		
		
		
  	   
  	  
	   return allfood;
	}
	public List<Food> findFoodByKey(String key) {
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
	     
		String sql = "select * from food_data where text like '%"+key+"%' or introduce like '%"+key+"%' order by fabulous desc";
		 List<Food> allfood=null;
		   try {
			 allfood=qr.query(sql, new BeanListHandler<Food>(Food.class));
		   }catch(SQLException e){
			   e.printStackTrace();
		   }
		   return allfood;
	}
	public List<Food> findHotFood() {
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
		
		String sql = "SELECT DISTINCT * FROM food_data WHERE food_id IN(SELECT food_id AS NUM  FROM food_talk GROUP BY food_id ORDER BY NUM DESC)  LIMIT 0,5";
		 List<Food> allfood=null;
		   try {
			 allfood=qr.query(sql, new BeanListHandler<Food>(Food.class));
		   }catch(SQLException e){
			   e.printStackTrace();
		   }
		   return allfood;
	}
	
	public List<FoodTalk> findFoodTalk(int id) {
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
	     System.out.println(id);
  	   String sql="select * from food_talk where food_id=? order by like_num desc";
  	   List<FoodTalk> allfoodtalk=null;
  	   try {
  		 allfoodtalk=qr.query(sql, new BeanListHandler<FoodTalk>(FoodTalk.class),id);
  	   }catch(SQLException e){
  		   e.printStackTrace();
  	   }
  	   for(FoodTalk f:allfoodtalk) {
  		   System.out.println(f.getContent());
  	   }
  	   return allfoodtalk;
	}
	
	public void insertFoodTalk(String username,String content,int food_id) {
		java.util.Date date=new java.util.Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
		String time=sdf.format(date);
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
	     
  	   String sql="insert into food_talk(food_id,username,time,content) values(?,?,?,?)  ";
  	   Object object=null;
		try {
		 object =  qr.insert(sql,new ScalarHandler(), food_id,username,time,content);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  	  
	}
	
	
	public void insertFood(String username,String content,String image,String  text) {
		java.util.Date date=new java.util.Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
		String time=sdf.format(date);
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
	     UserService user=new UserService();
	     User u=user.findUserByName(username);
  	   String sql="insert into food_data(id,text,release_time,img_name,introduce) values(?,?,?,?,?)  ";
  	   Object object=null;
		try {
		 object =  qr.insert(sql,new ScalarHandler(), u.getId(),text,time,image,content);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  	  
	}
	public void deleteFood(int id) {
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
		String sql1="delete from food_talk  where food_id=? ";
	  	   
	  	   try {
	  		 qr.update(sql1,id);
	  	   }catch(SQLException e){
	  		   e.printStackTrace();
	  	   }
  	   String sql="delete from food_data  where food_id=? ";
  	   
  	   try {
  		 qr.update(sql,id);
  	   }catch(SQLException e){
  		   e.printStackTrace();
  	   }
  	  
	}
	public void deleteFoodtalk(int id,String time,String username) {
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
	     
  	   String sql="delete from food_talk  where food_id=? and username=? and time=?";
  	   
  	   try {
  		 qr.update(sql,id,username,time);
  	   }catch(SQLException e){
  		   e.printStackTrace();
  	   }
  	  
	}
	public int countFood() {
		
		
		 String sql = "select count(*) from food_data ";
		  QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
	        try {
	            Long count = qr.query(sql, new ScalarHandler<Long>());
	            
	            return count.intValue();
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	}
}
