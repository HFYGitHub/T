package com.iteima.servlet;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iteima.domain.File;
import com.iteima.service.FileService;

public class OrderFileservlet extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	HttpSession session=request.getSession();
	response.setCharacterEncoding("UTF-8");
	response.setContentType("text/html;charset=UTF-8");
	//1.获取请求参数
	String order=request.getParameter("order");
	System.out.println(order);
	
	
	 request.getRequestDispatcher("/dataShare.jsp").forward(request, response);
	 return ;
	 
}
}
