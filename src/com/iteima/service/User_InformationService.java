package com.iteima.service;

import java.util.List;

import com.iteima.dao.User_InformationDao;
import com.iteima.domain.User;


public class User_InformationService {

	public List<User> Show_Information(String username){
		User_InformationDao allinformation=new User_InformationDao();
   	    return allinformation.Show_Information(username);
	}
	public void UpdateImage(String image,String username) {
	 	User_InformationDao allinformation=new User_InformationDao();
   	   allinformation.UpdateImage(image, username);
   	  
	}
	public void UpdateUserInfo(String org_username,String username,String sex,String email,String nickname,String qq,String academy,String declaration,String wechat,String phone) {
		User_InformationDao allinformation=new User_InformationDao();
	   	   allinformation.UpdateUserInfo(org_username, username, sex, email, nickname, qq, academy, declaration, wechat, phone);
	}
}
