package com.iteima.login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.iteima.domain.User;
import com.iteima.utils.JdbcUtil;


@WebServlet("/LoginServel")
public class LoginServel extends HttpServlet {
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 1.��ȡ����
		 * 2.������ӵ����ݿ���
		 * 3.����û��������Ƿ�����ȷ
		 * 4.��½�ɹ�����ʾ�û���Ϣ
		 * 5.��½ʧ�ܸ�һ��������ʾ
		 */
		HttpSession session=request.getSession();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//1.��ȡ�������
		String name=request.getParameter("username");
		String pwd=request.getParameter("pwd");
		System.out.println("name="+name+" pwd="+pwd);
		
		//2.�������ݿ�
		//JdbcUtil.getDataSource();
		QueryRunner qr=new QueryRunner(JdbcUtil.getDataSource());
	     
   	   String sql="select * from users where name=? and password=?";
		User user=null;
		try {
		 user=qr.query(sql, new BeanHandler<User>(User.class),name,pwd);
		 
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		//����û��������Ƿ���ȷ
		if(user != null) {
			
			//���û�user�������session��
			session.setAttribute("user", user);
			session.setAttribute("username", name);
			int permission=user.getPermission();
			if(permission==0) {
				request.getRequestDispatcher("/ShowQuestionAtMain?username=username").forward(request, response);
			}else {
				request.getRequestDispatcher("/admin.jsp?username=username").forward(request, response);
			}
			
			  
		}else {
			
			request.getSession().setAttribute("err", "�û������������");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
				
			
		}
	}

}
