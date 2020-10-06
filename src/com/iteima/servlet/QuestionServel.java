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
		System.out.println("初始化");
		
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		doPost(request, response);
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
			/**
		 * 1.获取请求
		 * 2.检查连接到数据库中
		 */
		request.setCharacterEncoding("utf-8");
		//处理乱码：2.doGet/doPost的response方向
		response.setContentType("text/html;charset=utf-8");
			
		//1.获取请求参数
		//种类
		String categroy=request.getParameter("categroy");
		//标题
		String title=request.getParameter("title");
		//问题内容
		String content=request.getParameter("content");
		//从登录时一直传递的参数，用户id，这是问题表里面的外键。
		String username=request.getParameter("username");
		UserService userservice=new UserService();
		User user=userservice.findUserByName(username);
		int id=user.getId();
		//发布时间
				java.util.Date date=new java.util.Date();
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
				String release_time=sdf.format(date);	
		//输出看是否获取参数正确		
		System.out.println("类别="+categroy+" 主题="+title+"内容="+content);
		
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

