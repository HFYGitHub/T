package com.iteima.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iteima.domain.Question;
import com.iteima.service.QuestionShow;

@WebServlet("/QuestionShowSevlet")
public class QuestionShowSevlet extends HttpServlet{

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String category="学术问题";
		System.out.println("正在加载问题..." );
		
		QuestionShow questionShow=new QuestionShow();
		 List<Question> allquestion=questionShow.Questionshow(category);
		  System.out.println(allquestion);
		 request.setAttribute("allquestion", allquestion);
		 request.setAttribute("category", category);
		 request.getRequestDispatcher("/release_question.jsp").forward(request, response);
		 return ;
	}
}
