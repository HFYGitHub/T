package com.iteima.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iteima.domain.PageBean;
import com.iteima.domain.Question;
import com.iteima.service.IPageBeanService;
import com.iteima.service.PageBeanService;
import com.iteima.service.QuestionService;
@WebServlet("/ShowQuestionAtMain")
public class ShowQuestionAtMain extends HttpServlet{
 private IPageBeanService service = new PageBeanService();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//1.获取请求参数
		
		
			
			String username=request.getParameter("username");
			String theme=request.getParameter("theme");
			System.out.println(theme);
			if(theme==null) {
				theme="本周";
			}
			QuestionService qustionService=new QuestionService();
			List<Question> ques=qustionService.findAnByTh(theme);
		       
		            
		            request.setAttribute("ques", ques);
		       
		        
		        //跳转
		        request.getRequestDispatcher("/main.jsp").forward(request, response);
	}

}

