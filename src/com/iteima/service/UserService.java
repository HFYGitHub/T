package com.iteima.service;

import java.util.List;

import com.iteima.dao.UserDao;
import com.iteima.domain.User;

public class UserService {
	UserDao user=new UserDao();
	public List<User> findFoodUserById(int id) {
		
   	 return user.findFoodUserById(id);
		
	}
	public void updatePwd(String username,String email,String pwd,String new_pwd) {
		
		user.updatePwd(username, email, pwd, new_pwd);
		
	}
	public List<User> findAll() {
		
	   	 return user.findAll();
	}
	public User findUserByEmail(String name,String email) {
		
			
	   	 return user.findUserByEmail(name,email);
			
		}
	
	public User findUserByName(String name) {
		
	   	 return user.findUserByName(name);
		
	}public User findUserById(int id) {
		
	   	 return user.findUserById(id);
		
	}
	public User findEmail(String email) {
		
	   	 return user.findEmail(email);
	}
	public User findUserName(String name) {
		
	   	 return user.findUserName(name);
	}
	}
	
