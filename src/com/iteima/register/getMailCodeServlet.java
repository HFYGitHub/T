package com.iteima.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iteima.domain.User;
import com.iteima.service.UserService;
import com.iteima.utils.MailUtil;

/**
 * Servlet implementation class getMailCodeServlet
 */
@SuppressWarnings("serial")
@WebServlet(urlPatterns={"/getMailCodeServlet"})

public class getMailCodeServlet extends HttpServlet {
	private String email;  // ��ȡ���ռ�������
	private PrintWriter out;  // �����
	private MailUtil emailUtil ;
	public getMailCodeServlet() {
		// TODO Auto-generated constructor stub
		System.out.println("��ʼ��");
		
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
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
		String username=request.getParameter("usr");
		UserService userservice=new UserService();
		User user=userservice.findUserName(username); 
		User user1=userservice.findEmail(email); 
		if(username==null||email==null) {
			out.print(-1);
			
		}else if(user!=null) {
			out.print(-2);
		}else if(user1!=null){
			out.print(-3);
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
					
					this.getServletContext().setAttribute("vc", str);	
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
