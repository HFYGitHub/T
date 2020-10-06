package com.iteima.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iteima.service.FileService;
import com.iteima.service.FoodService;

/**
 * Servlet implementation class FoodCommentServlet
 */
@WebServlet("/FoodCommentServlet")
public class FoodCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//1.获取请求参数
		String username=request.getParameter("username");
		String content=request.getParameter("content");
		int food_id=Integer.parseInt(request.getParameter("food_id"));
		
		FoodService foodservice=new FoodService();
		foodservice.insertFoodTalk(username, content, food_id);
	
		 request.getRequestDispatcher("/foodshare.jsp").forward(request, response);
		 return ;
	}


}
