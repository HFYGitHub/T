package com.iteima.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iteima.domain.File;
import com.iteima.domain.PageBean;
import com.iteima.domain.Question;
import com.iteima.domain.QuestionUser;
import com.iteima.domain.User;
import com.iteima.service.AnswerQuestionService;
import com.iteima.service.FileService;
import com.iteima.service.IPageBeanService;
import com.iteima.service.PageBeanService;
import com.iteima.service.QuestionService;
import com.iteima.service.UserService;

/**
 * Servlet implementation class ReplayAllQuestion
 */



@WebServlet("/ReplayAllQuestion")
public class ReplayAllQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IPageBeanService service = new PageBeanService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplayAllQuestion() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    
		HttpSession session=request.getSession();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//1.获取请求参数
		
		
			
			String username=request.getParameter("username");
			String theme=request.getParameter("theme");
		
		        try {
		            //获取“当前页”参数(第一次访问时当前页为null)
		            String currPage = request.getParameter("currentPage");
		            String key=null;
		            //判断   第一次是设置默认值
		            if(currPage == null || "".equals(currPage)){
		                currPage = "1";
		            }
		            
		            //转换   从jsp获取的都是字符串型的    需转换为整形才能保存到javaBean中
		            int currentPage = Integer.parseInt(currPage);
		            
		            PageBean<Question> pb = new PageBean<Question>();
		            pb.setCurrentPage(currentPage);
		            
		            //调用service层
		            service.getAllQuestion(pb, theme,key);
		            UserService userService=new UserService();
		            
		            QuestionService quesService=new QuestionService();
		            AnswerQuestionService an=new AnswerQuestionService();
		            List<Question> ques=quesService.getDetails(theme);
		            List<QuestionUser> quesUser=new ArrayList();
		            for(Question q:ques) {
		            	QuestionUser qu=new QuestionUser();
		            	User u=userService.findUserById(q.getUser_id());//获取发布问题的用户名
		            	qu.setPub_username(u.getName());
		            	qu.setQ_id(q.getQuestion_id());
		            	if(an.findLastAnswer(q.getQuestion_id())!=null) {
		            		User u1=userService.findUserById(an.findLastAnswer(q.getQuestion_id()).getUser_id());//获取最后回答的用户名
			            	qu.setLast_comment_username(u1.getName());
			            	qu.setLast_time(an.findLastAnswer(q.getQuestion_id()).getRelease_time());
			            	qu.setTotal_num(an.countAnswer(q.getQuestion_id()));
			            	
			            	
		            	}else {
		            		qu.setLast_comment_username("暂未回答");
			            	qu.setLast_time(q.getRelease_time());
			            	qu.setTotal_num(1);
		            	}
		            	quesUser.add(qu);
		            }
		            //保存域对象
		            request.setAttribute("pageBean", pb);
		            request.setAttribute("username", username);
		            request.setAttribute("theme", theme);
		            request.setAttribute("quesUser", quesUser);
		            request.getRequestDispatcher("release_question.jsp").forward(request, response);;
		        } catch (NumberFormatException e) {
		            e.printStackTrace();
		           
		        }
		        
		      }
	
	

}
