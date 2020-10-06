package com.iteima.servlet;

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


@WebServlet("/FoodFabulousServlet")
public class FoodFabulousServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flag=request.getParameter("flag");
		int id= Integer.parseInt(request.getParameter("food_id"));
		String introduce=request.getParameter("introduce");
		String img=request.getParameter("img");
		String food_img=request.getParameter("food_img");
		int num= Integer.parseInt(request.getParameter("num"));
		String theme=request.getParameter("theme");
		int fabulous=Integer.parseInt(request.getParameter("fabulous"));
		String publish_time=request.getParameter("publish_time");
		String username=request.getParameter("username");//当前用户名
		FoodService foodservice=new FoodService();
		 UserService userservice=new UserService();
		 String publish_name=null;
		    int total_num=0;
		    List<FoodTalk> allfoodtalk=null;
		if(flag.equals("美食")) {
			
			
			 allfoodtalk=foodservice.findFoodTalk(id);
			
			 foodservice.updateFood(id);
			  fabulous=fabulous+1;
			
		    
		}else if(flag.equals("讨论")) {
			String username1=request.getParameter("foodtalk.username");
			String time=request.getParameter("foodtalk.time");
			
			  foodservice.updateFoodTalk(id, time, username1);
			  allfoodtalk=foodservice.findFoodTalk(id);
		
			 
			
		}
		 List<User> alluser=userservice.findFoodUserById(id);
		
		 List<User> us=new ArrayList<>();
	     for(User s:alluser){
	    	 publish_name=s.getName();//得到发表的用户名
	     }
	     for(FoodTalk f:allfoodtalk) {
	  		 
	  		 total_num++;
	  		  int num1=0;
	  		User u=userservice.findUserByName(f.getUsername());
	  		 for(User u_test:us) {
	  			
	  			 if(u_test.getName().equals(u.getName())) {
	  				 
	  				num1=1;
	  			 }
	  		 }
	  		 if(num1==0) {
	  			 
	  			us.add(u);
	  	
	  		 }
	  		 
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

	     request.setAttribute("us", us);
	     request.setAttribute("fabulous", fabulous);
	     
	     request.setAttribute("food_img", food_img);
		 request.getRequestDispatcher("/foodtalk.jsp").forward(request, response);
		 return ;
	}
		 
	

	

}
