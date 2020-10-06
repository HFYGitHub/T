package com.iteima.user;

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
import com.iteima.domain.Question;
import com.iteima.domain.User;
import com.iteima.service.FoodService;
import com.iteima.service.QuestionService;
import com.iteima.service.UserService;

/**
 * Servlet implementation class EditFoodService
 */

@SuppressWarnings("serial")
@WebServlet(urlPatterns={"/EditFoodService"})
public class EditFoodService extends HttpServlet {
	public EditFoodService() {
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
		 List<User> alluser1 = new ArrayList<>();
		//1.获取请求参数
		String th=request.getParameter("th");
		if(th.equals("点赞")) {
			int food_id=Integer.parseInt(request.getParameter("food_id"));
			FoodService foodse=new FoodService();
			foodse.updateFood(food_id);
			String username=request.getParameter("username");
			
			UserService userserivce=new UserService();
			User user=userserivce.findUserByName(username);
			FoodService foodservice=new FoodService();
			List<Food> food=foodservice.findAllFoodByName(user.getId());
			QuestionService quesservice=new QuestionService();
			List<Question> ques=quesservice.findQuesByUserId(user.getId());
			 request.setAttribute("food", food);
			 request.setAttribute("ques", ques);
             
			 request.setAttribute("image", user.getImage());
			 request.setAttribute("username", username);
		
		}else if(th.equals("插入评论")) {
			String username=request.getParameter("username");
			int food_id=Integer.parseInt(request.getParameter("food_id"));
			String content=request.getParameter("content");
			FoodService foodservice1=new FoodService();
			foodservice1.insertFoodTalk(username, content, food_id);
			Food food=foodservice1.findFood(food_id);
			
			String introduce=food.getintroduce();
			String img=food.getImg_name();
			String user_img=request.getParameter("us_image");
			int num= food.getNumber();
			String theme=food.gettext();
			int fabulous=food.getFabulous();
			String publish_time=food.getrelease_time().toString();
			FoodService foodservice=new FoodService();
			 List<FoodTalk> allfoodtalk=foodservice.findFoodTalk(food_id);
			
			 
			 UserService userservice=new UserService();
			 List<User> alluser=userservice.findFoodUserById(food_id);
			 String publish_name=null;
			 String us_image=null;
		     for(User s:alluser){
		    	 publish_name=s.getName();//得到发表的用户名
		    	 us_image=s.getImage();
		     }
		     int total_num=0;
		     for(FoodTalk f:allfoodtalk) {
		    	  User u=userservice.findUserByName(f.getUsername());
			  		 alluser1.add(u);
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
		     request.setAttribute("food_id", food_id);
		     request.setAttribute("num", num);
		     request.setAttribute("fabulous", fabulous);
		     request.setAttribute("us_image", us_image);

		     request.setAttribute("image", user_img);

		     request.setAttribute("alluser1", alluser1);
		}else if(th.equals("删除")) {

			String user_img=request.getParameter("us_image");
			int food_id= Integer.parseInt(request.getParameter("food_id"));
			String foodtalk_time=request.getParameter("foodtalk_time");
			
			String username=request.getParameter("username");//当前用户名
			FoodService foodservice1=new FoodService();
			Food food=foodservice1.findFood(food_id);
			
			String introduce=food.getintroduce();
			String img=food.getImg_name();
			int num= food.getNumber();
			String theme=food.gettext();
			int fabulous=food.getFabulous();
			String publish_time=food.getrelease_time().toString();
			FoodService foodservice=new FoodService();
			foodservice.deleteFoodtalk(food_id, foodtalk_time, username);
			 List<FoodTalk> allfoodtalk=foodservice.findFoodTalk(food_id);
			 UserService userservice=new UserService();
			 List<User> alluser=userservice.findFoodUserById(food_id);
			 String publish_name=null;
			 String us_image=null;
		     for(User s:alluser){
		    	 publish_name=s.getName();//得到发表的用户名
		    	 us_image=s.getImage();
		     }
		     int total_num=0;
		     for(FoodTalk f:allfoodtalk) {
		    	  User u=userservice.findUserByName(f.getUsername());
			  		alluser1.add(u);
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
		     request.setAttribute("food_id", food_id);
		     request.setAttribute("num", num);
		     request.setAttribute("fabulous", fabulous);
		     request.setAttribute("image", user_img);
		     request.setAttribute("us_image", us_image);
		     request.setAttribute("alluser1", alluser1);
		}else if(th.equals("点赞评论")) {
			String user_img=request.getParameter("us_image");
			int food_id= Integer.parseInt(request.getParameter("food_id"));
			
			String username=request.getParameter("username");//当前用户名
			String foodtalk_time=request.getParameter("foodtalk_time");
			FoodService foodservice1=new FoodService();
			Food food=foodservice1.findFood(food_id);
			String food_username=request.getParameter("food_username");
			String introduce=food.getintroduce();
			String img=food.getImg_name();
			int num= food.getNumber();
			String theme=food.gettext();
			int fabulous=food.getFabulous();
			String publish_time=food.getrelease_time().toString();
			FoodService foodservice=new FoodService();
			foodservice.updateFoodTalk(food_id, foodtalk_time, food_username);
			 List<FoodTalk> allfoodtalk=foodservice.findFoodTalk(food_id);
			 UserService userservice=new UserService();
			 List<User> alluser=userservice.findFoodUserById(food_id);
			 String publish_name=null;
			 String us_image=null;
		     for(User s:alluser){
		    	 publish_name=s.getName();//得到发表的用户名
		    	 us_image=s.getImage();
		     }
		     int total_num=0;
		     for(FoodTalk f:allfoodtalk) {
		    	  User u=userservice.findUserByName(f.getUsername());
			  		 alluser1.add(u);
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
		     request.setAttribute("food_id", food_id);
		     request.setAttribute("num", num);
		     request.setAttribute("fabulous", fabulous);
		     request.setAttribute("image", user_img);
		     request.setAttribute("us_image", us_image);

		     request.setAttribute("alluser1", alluser1);
		}else if(th.equals("动态点赞")) {
			String user_img=request.getParameter("us_image");
			int food_id= Integer.parseInt(request.getParameter("food_id"));
			
			String username=request.getParameter("username");//当前用户名
			FoodService foodservice1=new FoodService();
			foodservice1.updateFood(food_id);
			Food food=foodservice1.findFood(food_id);
			String introduce=food.getintroduce();
			String img=food.getImg_name();
			int num= food.getNumber();
			String theme=food.gettext();
			int fabulous=food.getFabulous();
			String publish_time=food.getrelease_time().toString();
			FoodService foodservice=new FoodService();
			 List<FoodTalk> allfoodtalk=foodservice.findFoodTalk(food_id);
			 UserService userservice=new UserService();
			 List<User> alluser=userservice.findFoodUserById(food_id);
			 String publish_name=null;
			 String us_image=null;
		     for(User s:alluser){
		    	 publish_name=s.getName();//得到发表的用户名
		    	 us_image=s.getImage();
		     }
		     int total_num=0;
		     for(FoodTalk f:allfoodtalk) {
		    	  User u=userservice.findUserByName(f.getUsername());
			  		 alluser1.add(u);
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
		     request.setAttribute("food_id", food_id);
		     request.setAttribute("num", num);
		     request.setAttribute("fabulous", fabulous);
		     request.setAttribute("image", user_img);
		     request.setAttribute("us_image", us_image);

		     request.setAttribute("alluser1", alluser1);
		}
		
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