package com.iteima.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iteima.domain.FoodTalk;
import com.iteima.domain.User;
import com.iteima.service.FoodService;
import com.iteima.service.UserService;

/**
 * Servlet implementation class ShowFoodTalk
 */


@WebServlet("/ShowFoodTalk")
public class ShowFoodTalk extends HttpServlet {
	public ShowFoodTalk() {
		// TODO Auto-generated constructor stub
		System.out.println("初始化");
		
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		doPost(request, response);
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		request.setCharacterEncoding("utf-8");
		//处理乱码：2.doGet/doPost的response方向
		response.setContentType("text/html;charset=utf-8");
		
		//1.获取请求参数
		
	
		
			int id= Integer.parseInt(request.getParameter("food_id"));
			String introduce=request.getParameter("introduce");
			String img=request.getParameter("food_img");
			String user_img=request.getParameter("image");
			int num= Integer.parseInt(request.getParameter("num"));
			String theme=request.getParameter("theme");
			int fabulous=Integer.parseInt(request.getParameter("food_fabulous"));
			String publish_time=request.getParameter("publish_time").replace(".0","");
			String username=request.getParameter("username");//当前用户名
			FoodService foodservice=new FoodService();
			 List<FoodTalk> allfoodtalk=foodservice.findFoodTalk(id);
			
			 
			 UserService userservice=new UserService();
			 List<User> alluser1 = new ArrayList<>();
			 List<User> alluser=userservice.findFoodUserById(id);
			 String publish_name=null;
			 String us_image=null;
		     for(User s:alluser){
		    	 publish_name=s.getName();//得到发表的用户名
		    	 us_image=s.getImage();
		     }
		     int total_num=0;
		     for(FoodTalk f:allfoodtalk) {
		  		  User u=userservice.findUserByName(f.getUsername());
		  		  
		  		 int flag=0;
				 for(User uss:alluser1) {
					 if(uss.getName().equals(u.getName())) {
						 
						 flag=1;
					 }
				 }
				 if(flag==0) {
					 alluser1.add(u);
					 
					 
					
				 }
		  		 
		  		 total_num++;
		  	   }
		     request.setAttribute("allfoodtalk", allfoodtalk);
		     request.setAttribute("total_num", total_num);
		     request.setAttribute("publish_name", publish_name);
		     request.setAttribute("introduce", introduce);
		     request.setAttribute("img", img);
		     request.setAttribute("time", publish_time);
		     request.setAttribute("theme", theme);
		     request.setAttribute("username", username);
		     request.setAttribute("food_id", id);
		     request.setAttribute("num", num);
		     request.setAttribute("fabulous", fabulous);
		     request.setAttribute("us_image", us_image);
		     request.setAttribute("alluser1", alluser1);
		     request.setAttribute("image", user_img);
		     request.getRequestDispatcher("/user_foodcomm.jsp").forward(request, response);
		}

		@Override
		public void destroy() {
			// TODO Auto-generated method stub
			super.destroy();
		}

		@Override
		public void init() throws ServletException {
			// TODO Auto-generated method stub
			super.init();
		}
		

	}