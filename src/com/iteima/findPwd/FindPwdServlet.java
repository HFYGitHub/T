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
	private String email;  // ��ȡ���ռ�������
	public FindPwdServlet() {
		// TODO Auto-generated constructor stub
		System.out.println("��ʼ��");
		
	}
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		response.setContentType("text/html");
		//���Ա���
		response.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
	    PrintWriter  out = response.getWriter();
	
		// ��ȡ����ǰ�˵Ĳ���
		 email = request.getParameter("email");
		
		String username = request.getParameter("username");
		UserService userservice=new UserService();
		User user=userservice.findUserByEmail(username,email); 
		if(username==null||email==null) {
			out.print(-1);
			
		}else if(user==null) {
			out.print(0);
		}else {
			
		
			 String reg="[1-9]\\d{7,10}@qq\\.com";//������ʽ����֤����������Ϊ��
			  if (email.matches(reg)) {
				  MailUtil sendEmail=new MailUtil();
				  
					//����Ҫ���͵�����
					sendEmail.setReceiveMailAccount(email);
					//����8λ����֤��
					Random random=new Random();
					String str="";
					for(int i=0;i<8;i++) {
						int n=random.nextInt(10);
						str+=n;
					}
					
					//���������ɵ���֤�롣
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
