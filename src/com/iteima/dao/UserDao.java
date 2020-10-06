package com.iteima.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.iteima.domain.User;
import com.iteima.utils.JdbcUtil;

public class UserDao {
	public List<User> findFoodUserById(int id) {
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
	     
  	   String sql="select * from users where id in(select id from food_data where food_id=?)";
  	   List<User> allfood=null;
  	   try {
  		 allfood=qr.query(sql, new BeanListHandler<User>(User.class),id);
  	   }catch(SQLException e){
  		   e.printStackTrace();
  	   }
  	   return allfood;
	}
	public List<User> findAll() {
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
	     
  	   String sql="select * from users ";
  	   List<User> allfood=null;
  	   try {
  		 allfood=qr.query(sql, new BeanListHandler<User>(User.class));
  	   }catch(SQLException e){
  		   e.printStackTrace();
  	   }
  	   return allfood;
	}
	
	public User findUserByEmail(String name,String email) {
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
	     
	   	   String sql="select * from users where name=? and email=?";
			User user=null;
			try {
			 user=qr.query(sql, new BeanHandler<User>(User.class),name,email);
			 
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
  	   return user;
	}
	public User findEmail(String email) {
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
	     
	   	   String sql="select * from users where  email=?";
			User user=null;
			try {
			 user=qr.query(sql, new BeanHandler<User>(User.class),email);
			 
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
  	   return user;
	}
	public User findUserName(String name) {
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
	     
	   	   String sql="select * from users where  name=?";
			User user=null;
			try {
			 user=qr.query(sql, new BeanHandler<User>(User.class),name);
			 
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
  	   return user;
	}
	public void updatePwd(String username,String email,String pwd,String new_pwd) {
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
	     
  	   String sql="update users set password=?  where name=? and password=? and email=?";
  	  
  	   try {
  		  qr.update(sql, new_pwd,username,pwd,email);
  		   
  	   }catch(SQLException e){
  		   e.printStackTrace();
  	   }
  	  
	}
	public User findUserByName(String name) {
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
	     
	   	   String sql="select * from users where name=? ";
			User user=null;
			try {
			 user=qr.query(sql, new BeanHandler<User>(User.class),name);
			 
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
  	   return user;
	}
	public User findUserById(int id) {
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
	     
	   	   String sql="select * from users where id=? ";
			User user=null;
			try {
			 user=qr.query(sql, new BeanHandler<User>(User.class),id);
			 
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
	   return user;
	}
}
