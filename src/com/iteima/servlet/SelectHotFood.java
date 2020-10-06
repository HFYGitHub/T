package com.iteima.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iteima.domain.File;
import com.iteima.domain.Food;
import com.iteima.service.FileService;
import com.iteima.service.FoodService;

/**
 * Servlet implementation class SelectHotFood
 */
@WebServlet("/SelectHotFood")
public class SelectHotFood extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	HttpSession session=request.getSession();
	response.setCharacterEncoding("UTF-8");
	response.setContentType("text/html;charset=UTF-8");
	//1.获取请求参数

	 FoodService foodservice=new FoodService();
	 List<Food> allfood=foodservice.findHotFood();
	 request.setAttribute("allfood", allfood);
	 request.getRequestDispatcher("/dataShare.jsp").forward(request, response);
		
		return ;
}
}