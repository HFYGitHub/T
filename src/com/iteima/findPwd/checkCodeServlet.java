package com.iteima.findPwd;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.iteima.domain.User;
import com.iteima.service.UserService;

/**
 * Servlet implementation class checkCodeServlet
 */
@SuppressWarnings("serial")
@WebServlet(urlPatterns={"/checkCodeServlet"})

public class checkCodeServlet extends HttpServlet {
	public checkCodeServlet() {
		// TODO Auto-generated constructor stub
		System.out.println("初始化");
		
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		doPost(request, response);
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		/**
		 * 1.获取请求
		 * 2.检查连接到数据库中
		 * 3.检查用户名密码是否在正确
		 * 4.登陆成功，显示用户信息
		 * 5.登陆失败给一个错误提示
		 */
		request.setCharacterEncoding("utf-8");
		//处理乱码：2.doGet/doPost的response方向
		response.setContentType("text/html;charset=utf-8");
		 PrintWriter  out = response.getWriter();
		//1.获取请求参数
		 String username = request.getParameter("username");
		  String email = request.getParameter("email");
		  String code = request.getParameter("code");
	
		System.out.println(username);
		//用户是否正确
		if(username==null||"".equals(username.trim())){
			 out.print(-1);//用户名输入为空
			
		  }else {
			  String reg="[1-9]\\d{7,10}@qq\\.com";//正则表达式，验证以新浪邮箱为例
			  if (email.matches(reg)) {
				  String vc = (String) this.getServletContext().getAttribute("code");
				  System.out.println(vc);
				  UserService userservice=new UserService();
					User user=userservice.findUserByEmail(username,email); 
					if(user != null) {
				  if(vc!=null&&code!=null&&vc.equals(code)) {
					
					 
					   
							out.print(1);
							request.setAttribute("pwd", user.getPassword());		
							System.out.println(user.getPassword());
							 
								
							
						}else {
							 out.print(-2);//验证码错误
							       
						}
						
						
						
					}
					else {
						out.print(0);//用户不存在
					}
		  }
			  else {
				  out.print(-3);//邮箱错误
			  }
		
	
	}
		out.flush();
		out.close();
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
