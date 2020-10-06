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
		System.out.println("��ʼ��");
		
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		doPost(request, response);
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		/**
		 * 1.��ȡ����
		 * 2.������ӵ����ݿ���
		 * 3.����û��������Ƿ�����ȷ
		 * 4.��½�ɹ�����ʾ�û���Ϣ
		 * 5.��½ʧ�ܸ�һ��������ʾ
		 */
		request.setCharacterEncoding("utf-8");
		//�������룺2.doGet/doPost��response����
		response.setContentType("text/html;charset=utf-8");
		 PrintWriter  out = response.getWriter();
		//1.��ȡ�������
		 String username = request.getParameter("username");
		  String email = request.getParameter("email");
		  String code = request.getParameter("code");
	
		System.out.println(username);
		//�û��Ƿ���ȷ
		if(username==null||"".equals(username.trim())){
			 out.print(-1);//�û�������Ϊ��
			
		  }else {
			  String reg="[1-9]\\d{7,10}@qq\\.com";//������ʽ����֤����������Ϊ��
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
							 out.print(-2);//��֤�����
							       
						}
						
						
						
					}
					else {
						out.print(0);//�û�������
					}
		  }
			  else {
				  out.print(-3);//�������
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
