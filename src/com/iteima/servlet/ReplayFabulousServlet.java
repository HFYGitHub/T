package com.iteima.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iteima.service.AnswerQuestionService;

/**
 * Servlet implementation class ReplayFabulousServlet
 */
@WebServlet("/ReplayFabulousServlet")
public class ReplayFabulousServlet extends HttpServlet {
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//处理乱码：2.doGet/doPost的response方向
		response.setContentType("text/html;charset=utf-8");
			
		//1.获取请求参数
		String username=request.getParameter("username");//当前登陆用户
		int q_id=Integer.parseInt(request.getParameter("question_id"));
		String theme=request.getParameter("theme");
		int user_id=Integer.parseInt(request.getParameter("user_id"));//发布问题的用户名
		String th=request.getParameter("th");//当前登陆用户
		int replay_id=Integer.parseInt(request.getParameter("replay_id"));
		AnswerQuestionService answerques=new AnswerQuestionService();
		answerques.findReplay(replay_id);
		request.setAttribute("username", username);
		request.setAttribute("question_id", q_id);
		request.setAttribute("replay_id", replay_id);
		request.setAttribute("user_id", user_id);
		request.setAttribute("theme", theme);
		 request.getRequestDispatcher("/AllReplayShow").forward(request, response);
	}

}
