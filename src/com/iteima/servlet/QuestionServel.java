package com.iteima.servlet;


import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.iteima.domain.Food;
import com.iteima.domain.Question;
import com.iteima.domain.User;
import com.iteima.service.FoodService;
import com.iteima.service.QuestionService;
import com.iteima.service.UserService;
import com.iteima.utils.JdbcUtil;


@SuppressWarnings("serial")
@WebServlet(urlPatterns={"/QuestionServel"})

public class QuestionServel extends HttpServlet {
	public QuestionServel() {
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
		 */
		request.setCharacterEncoding("utf-8");
		//�������룺2.doGet/doPost��response����
		response.setContentType("text/html;charset=utf-8");
			
		//1.��ȡ�������
		//����
		String categroy=request.getParameter("categroy");
		//����
		String title=request.getParameter("title");
		//��������
		String content=request.getParameter("content");
		//�ӵ�¼ʱһֱ���ݵĲ������û�id���������������������
		String username=request.getParameter("username");
		UserService userservice=new UserService();
		User user=userservice.findUserByName(username);
		int id=user.getId();
		//����ʱ��
				java.util.Date date=new java.util.Date();
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
				String release_time=sdf.format(date);	
		//������Ƿ��ȡ������ȷ		
		System.out.println("���="+categroy+" ����="+title+"����="+content);
		
		QuestionService quesservice=new QuestionService();
		quesservice.insertQues( id,categroy, title, content, release_time);
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

