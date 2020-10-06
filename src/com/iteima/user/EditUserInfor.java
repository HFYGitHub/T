package com.iteima.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iteima.domain.User;
import com.iteima.service.UserService;
import com.iteima.service.User_InformationService;
import com.iteima.utils.MailUtil;

/**
 * Servlet implementation class EditUserInfor
 */

@SuppressWarnings("serial")
@WebServlet(urlPatterns={"/EditUserInfor"})

public class EditUserInfor extends HttpServlet {
	private String email;  // 获取的收件人邮箱
	private PrintWriter out;  // 输出流
	private MailUtil emailUtil ;
	public EditUserInfor() {
		// TODO Auto-generated constructor stub
		System.out.println("初始化");
		
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		doPost(request, response);
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		response.setContentType("text/html");
		//语言编码
		response.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String org_username=request.getParameter("org_username");
		String username=request.getParameter("username");
		String email=request.getParameter("email");
		String nickname=request.getParameter("nickname");
		String qq=request.getParameter("qq");
		String sex=request.getParameter("sex");
		String academy=request.getParameter("academy");
		String declaration=request.getParameter("declaration");
		String wechat=request.getParameter("wechat");
		String phone=request.getParameter("phone");
		User_InformationService user=new User_InformationService();
		user.UpdateUserInfo(org_username, username, sex, email, nickname, qq, academy, declaration, wechat, phone);
		User_InformationService user_InformationService=new User_InformationService();
		 List<User> allinformation=user_InformationService.Show_Information(username);
		  System.out.println(allinformation);
		 request.setAttribute("allinformation", allinformation);
		 request.setAttribute("username", username);
		 request.getRequestDispatcher("/user_information.jsp").forward(request, response);
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
