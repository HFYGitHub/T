package com.iteima.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.iteima.dao.UserOp;
import com.iteima.domain.User;
import com.iteima.service.UserService;
import com.iteima.utils.JdbcUtil;
import com.iteima.utils.MailUtil;

/**
 * Servlet implementation class RegisterServel
 */
@SuppressWarnings("serial")
@WebServlet(urlPatterns={"/RegisterServel"})

public class RegisterServel extends HttpServlet {
	public RegisterServel() {
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
		 String username = request.getParameter("usr");
		  String pwd = request.getParameter("pwd");
		  String pwd2 = request.getParameter("repwd");
		  String email = request.getParameter("email");
		  String code = request.getParameter("code");
		System.out.println("name="+username+" pwd="+pwd  +"email="+email+"code="+code);
		
		//密码是否相等
		if(username==null||"".equals(username.trim())||pwd==null||"".equals(pwd.trim())||pwd2==null||"".equals(pwd2.trim())||!pwd.equals(pwd2)){
			 out.print(-1);
			
		  }else {
			  UserService userservice=new UserService();
		  
			  User user2=userservice.findUserName(username); 
		  
			User user1=userservice.findEmail(email); 
			if(user2!=null||user1!=null) {
				out.print(-4);
			}else {
			  String reg="[1-9]\\d{7,10}@qq\\.com";//正则表达式，验证以新浪邮箱为例
			  if (email.matches(reg)) {
				  String vc = (String) this.getServletContext().getAttribute("vc");
				  System.out.println(vc);
                   
				  if(code!=null&&vc!=null&&code.trim()!=""&&vc.equals(code)) {
					
					 
						//2.连接数据库
						//JdbcUtil.getDataSource();
						QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
					     
				   	   String sql="select * from users where name=? ";
						User user=null;
						try {
						 user=qr.query(sql, new BeanHandler<User>(User.class),username);
						 
						}catch(SQLException e) {
							e.printStackTrace();
						}
						
						//检查用户是否存在
						if(user != null) {
							 out.print(0);
										
							
							 
								
							
						}else {
							        UserOp userOp=new UserOp();
							        userOp.insertUser(username,pwd,email);
							 
								    System.out.println("注册成功，请登录！");
								   
								    out.print(1);
						}
						
						
						
					}
					else {
						 out.print(-2);
					}
		  }
			  else {
				  out.print(-3);
			  }
		
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
