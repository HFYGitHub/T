package com.iteima.user;

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

	@SuppressWarnings("serial")
	@WebServlet(urlPatterns={"/Edit"})
	public class Edit extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public Edit() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doPost(request,response);
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			    
			
				response.setContentType("text/html");
			    //语言编码
				response.setCharacterEncoding("utf-8");
				response.setCharacterEncoding("utf-8");
				PrintWriter  out = response.getWriter();
			    String email = request.getParameter("email");
			    String org_pwd = request.getParameter("org_pwd");

			    String new_pwd = request.getParameter("new_pwd");
				String username = request.getParameter("username");
				String code = request.getParameter("code");
				UserService userservice=new UserService();
				
				
				  String vc = (String) this.getServletContext().getAttribute("vc");
					 
					System.out.print(vc+"ooo");
					 if(vc==null) {
						out.print(0);//未发送验证码
					 }else if(!vc.equals(code)){
						 out.print(-1);//验证码输入错误
					 }else {
						 User user=userservice.findUserName(username); 
						 String pwd=user.getPassword();
						 User user1=userservice.findUserByEmail(username,email); 
						 if(user1!=null&&pwd.equals(user.getPassword())) {
							 userservice.updatePwd(username, email, org_pwd, new_pwd);
							 out.print(1);
						 }else {
							 out.print(-2);//用户信息错误
						 }
						
					 }
				
				
				out.flush();
				out.close();
		}
		
		

	}
