package com.iteima.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.iteima.service.AnswerQuestionService;


/**
 * Servlet implementation class TTT
 */


@SuppressWarnings("serial")
@WebServlet(urlPatterns={"/TTT"})
public class TTT extends HttpServlet {
	public TTT() {
		// TODO Auto-generated constructor stub
		System.out.println("��ʼ��");
		
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		doPost(request, response);
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		request.setCharacterEncoding("utf-8");
		//�������룺2.doGet/doPost��response����
		response.setContentType("text/html;charset=utf-8");
		
		//1.��ȡ�������
		
		String username=request.getParameter("username");
		String content=request.getParameter("content");
		String replay_username=request.getParameter("replay_username");//��ǰ��½�û�
		int q_id=Integer.parseInt(request.getParameter("question_id"));
		String theme=request.getParameter("theme");
		int user_id=Integer.parseInt(request.getParameter("user_id"));//����������û���
		int answer_id=Integer.parseInt(request.getParameter("answer_id"));
		 AnswerQuestionService answerques=new AnswerQuestionService();
		int re_replay_id=Integer.parseInt(request.getParameter("re_replay_id"));
		
		answerques.insertComment(username, replay_username, content, re_replay_id,answer_id);
		
		request.setAttribute("user_id", user_id);
		request.setAttribute("question_id", q_id);
		request.setAttribute("username", username);
		request.setAttribute("theme", theme);
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
