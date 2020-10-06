package com.iteima.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iteima.domain.Food;
import com.iteima.domain.User;
import com.iteima.service.FoodService;
import com.iteima.service.UserService;

/**
 * Servlet implementation class FoodShareServlet
 */
@WebServlet("/FoodShareServlet")
public class FoodShareServlet extends HttpServlet {
	    
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//1.获取请求参数
		String theme=null;
		String numflag=null;
		String dateflag=null;
		String username=request.getParameter("username");
		String key=request.getParameter("key");
		FoodService foodservice=new FoodService();
		List<Food> allfood=null;
		List<Food> allfood_right=new ArrayList<>();
		List<Food> allfood_left=new ArrayList<>();
		
		if(key==null) {
			
			
			
			
			 allfood=foodservice.findFileByTheme(numflag, theme, dateflag);
			
			
		}
		else {
			 allfood=foodservice.findFoodByKey(key);
			
		}
		UserService userservice=new UserService();
		List<User> user=new ArrayList<>();
		int sum=1;
		for(Food f:allfood) {
			if(sum%2==0) {
				allfood_left.add(f);
			}else {
				allfood_right.add(f);
			}
			sum++;
			User us=userservice.findUserById(f.getid());
			int flag=0;
			for(User test:user) {
				
				if(us.getName().equals(test.getName())) {
					flag=1;
				}
			}
			
			if(flag==0) {
				user.add(us);
			}
			
			
			
			
		}
		
		
		List<Food> hotfood=foodservice.findHotFood();
		 request.setAttribute("hotfood", hotfood);
		 request.setAttribute("allfood_left", allfood_left);
		 request.setAttribute("allfood_right", allfood_right);
		 
		 request.setAttribute("user", user);
		 request.setAttribute("theme", theme);
		 request.setAttribute("date", dateflag);
		 request.setAttribute("num", numflag);
		 request.setAttribute("username", username);
		 request.getRequestDispatcher("/foodshare.jsp").forward(request, response);
		 return ;
	}

	

}
