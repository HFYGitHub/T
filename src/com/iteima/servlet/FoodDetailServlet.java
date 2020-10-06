package com.iteima.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iteima.domain.Food;
import com.iteima.domain.FoodTalk;
import com.iteima.domain.User;
import com.iteima.service.FoodService;
import com.iteima.service.UserService;

/**
 * Servlet implementation class FoodDetailServlet
 */
@WebServlet("/FoodDetailServlet")
public class FoodDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String content=request.getParameter("content");
		String th=null;
		th=request.getParameter("th");
		String food_img=request.getParameter("img");
		String username=request.getParameter("username");
		int id=Integer.parseInt(request.getParameter("food_id"));
		FoodService foodservice=new FoodService();
		if(content!=null) {
			
			
			
			foodservice.insertFoodTalk(username, content, id);
			
		}
		if(th!=null&&th.equals("删除")) {
			foodservice.deleteFood(id);
			 request.getRequestDispatcher("/FoodShareServlet?username="+username).forward(request, response);
			 return;
		}
	       
		
		
	
		String introduce=request.getParameter("introduce");
		String img=null;
		
		int num= Integer.parseInt(request.getParameter("num"));
		String theme=request.getParameter("theme");
		int fabulous=Integer.parseInt(request.getParameter("fabulous"));
		String publish_time=request.getParameter("publish_time").replace(".0","");
	
		 List<FoodTalk> allfoodtalk=foodservice.findFoodTalk(id);
		
		 UserService userservice=new UserService();
		 List<User> alluser=userservice.findFoodUserById(id);
		 List<User> us=new ArrayList<>();
		 String publish_name=null;
	     for(User s:alluser){
	    	 publish_name=s.getName();//得到发表的用户名
	    	 img=s.getImage();
	    	 
	     }
	     int total_num=0,flag=0;
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
	     request.setAttribute("food_img", food_img);
	     request.setAttribute("num", num);
	     request.setAttribute("fabulous", fabulous);
	     request.setAttribute("us", us);
		 request.getRequestDispatcher("/foodtalk.jsp").forward(request, response);
		
	}
		 
	

	

}
