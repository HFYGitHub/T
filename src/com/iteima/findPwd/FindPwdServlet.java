package com.iteima.findPwd;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iteima.domain.User;
import com.iteima.service.UserService;
import com.iteima.utils.MailUtil;

/**
 * Servlet implementation class FindPwdServlet
 */
@SuppressWarnings("serial")
 @WebServlet(urlPatterns={"/FindPwdServlet"})

public class FindPwdServlet extends HttpServlet {
	private String email;  // 获取的收件人邮箱
	public FindPwdServlet() {
		// TODO Auto-generated constructor stub
		System.out.println("初始化");
		
	}
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		response.setContentType("text/html");
		//语言编码
		response.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
	    PrintWriter  out = response.getWriter();
	
		// 获取来自前端的参数
		 email = request.getParameter("email");
		
		String username = request.getParameter("username");
		UserService userservice=new UserService();
		User user=userservice.findUserByEmail(username,email); 
		if(username==null||email==null) {
			out.print(-1);
			
		}else if(user==null) {
			out.print(0);
		}else {
			
		
			 String reg="[1-9]\\d{7,10}@qq\\.com";//正则表达式，验证以新浪邮箱为例
			  if (email.matches(reg)) {
				  MailUtil sendEmail=new MailUtil();
				  
					//设置要发送的邮箱
					sendEmail.setReceiveMailAccount(email);
					//创建8位发验证码
					Random random=new Random();
					String str="";
					for(int i=0;i<8;i++) {
						int n=random.nextInt(10);
						str+=n;
					}
					
					//输出随机生成的验证码。
					System.out.print(str);
					System.out.print("\n");
					System.out.print("\n");
					
					sendEmail.setInfo(str);
					try {
						sendEmail.Send();
					} catch (Exception e) {
						e.printStackTrace();
					}
					 out.print(1);
					
					this.getServletContext().setAttribute("code", str);	
			  }else {
				  out.print(0);return;
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
