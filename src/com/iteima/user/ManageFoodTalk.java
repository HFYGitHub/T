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
 * Servlet implementation class ManageFoodTalk
 */
@WebServlet("/ManageFoodTalk")
public class ManageFoodTalk extends HttpServlet {
private static final long serialVersionUID = 1L;
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
	       
		
		
		int id= Integer.parseInt(request.getParameter("food_id"));
		String introduce=request.getParameter("introduce");
		String img=request.getParameter("img");
		int num= Integer.parseInt(request.getParameter("num"));
		String theme=request.getParameter("theme");
		int fabulous=Integer.parseInt(request.getParameter("fabulous"));
		String publish_time=request.getParameter("publish_time").replace(".0","");
		String time=request.getParameter("time").replace(".0","");
		String username=request.getParameter("username");//当前用户名
		FoodService foodservice=new FoodService();
		String food_img=request.getParameter("img");
		foodservice.deleteFoodtalk(id, time, username);
		 List<FoodTalk> allfoodtalk=foodservice.findFoodTalk(id);
		 UserService userservice=new UserService();
		 List<User> alluser=userservice.findFoodUserById(id);
		 String publish_name=null;
	     for(User s:alluser){
	    	 publish_name=s.getName();//得到发表的用户名
	     }
	     List<User> us=new ArrayList<>();
	     int total_num=0;
	     for(FoodTalk f:allfoodtalk) {
	  		   System.out.println(f.getContent());
	  		 total_num++;
	  		 int num1=0;
		  		User u=userservice.findUserByName(f.getUsername());
		  		 for(User u_test:us) {
		  			 System.out.println(u_test.getName()+" "+u.getName());
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
