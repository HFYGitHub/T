package com.iteima.dao;

import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import com.iteima.domain.User;
import com.iteima.utils.JdbcUtil;

public class User_InformationDao {
	
	public List<User> Show_Information(String username) {
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
	     
  	   String sql="select * from users where name=? ";
  	   List<User> allinformation=null;
  	   try {
  		 allinformation=qr.query(sql, new BeanListHandler<User>(User.class),username);
  	   }catch(SQLException e){
  		   e.printStackTrace();
  	   }
  	   return allinformation;
	}

	//更改个人图片
	public void UpdateImage(String image,String username) {
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
	     
	  	   String sql="update users set image=? where name=? ";
	  	  System.out.println("okll");
	  	   try {
	  		  qr.update(sql, image,username);
	  		   
	  	   }catch(SQLException e){
	  		   e.printStackTrace();
	  	   }
		
	}
	public void UpdateUserInfo(String org_username,String username,String sex,String email,String nickname,String qq,String academy,String declaration,String wechat,String phone) {
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
		
	  	   String sql="update users set  sex=? , email=? , nickname=? , qq=? , academy=? , declaration=? , wechat=? , phone=?  where name=? ";
	  	  System.out.println("okll");
	  	   try {
	  		  qr.update(sql, sex,email,nickname,qq,academy,declaration,wechat,phone,org_username);
	  		   
	  	   }catch(SQLException e){
	  		   e.printStackTrace();
	  	   }
		
	}
}
