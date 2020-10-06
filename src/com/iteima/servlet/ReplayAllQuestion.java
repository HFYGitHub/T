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
		//1.��ȡ�������
		
		
			
			String username=request.getParameter("username");
			String theme=request.getParameter("theme");
		
		        try {
		            //��ȡ����ǰҳ������(��һ�η���ʱ��ǰҳΪnull)
		            String currPage = request.getParameter("currentPage");
		            String key=null;
		            //�ж�   ��һ��������Ĭ��ֵ
		            if(currPage == null || "".equals(currPage)){
		                currPage = "1";
		            }
		            
		            //ת��   ��jsp��ȡ�Ķ����ַ����͵�    ��ת��Ϊ���β��ܱ��浽javaBean��
		            int currentPage = Integer.parseInt(currPage);
		            
		            PageBean<Question> pb = new PageBean<Question>();
		            pb.setCurrentPage(currentPage);
		            
		            //����service��
		            service.getAllQuestion(pb, theme,key);
		            UserService userService=new UserService();
		            
		            QuestionService quesService=new QuestionService();
		            AnswerQuestionService an=new AnswerQuestionService();
		            List<Question> ques=quesService.getDetails(theme);
		            List<QuestionUser> quesUser=new ArrayList();
		            for(Question q:ques) {
		            	QuestionUser qu=new QuestionUser();
		            	User u=userService.findUserById(q.getUser_id());//��ȡ����������û���
		            	qu.setPub_username(u.getName());
		            	qu.setQ_id(q.getQuestion_id());
		            	if(an.findLastAnswer(q.getQuestion_id())!=null) {
		            		User u1=userService.findUserById(an.findLastAnswer(q.getQuestion_id()).getUser_id());//��ȡ���ش���û���
			            	qu.setLast_comment_username(u1.getName());
			            	qu.setLast_time(an.findLastAnswer(q.getQuestion_id()).getRelease_time());
			            	qu.setTotal_num(an.countAnswer(q.getQuestion_id()));
			            	
			            	
		            	}else {
		            		qu.setLast_comment_username("��δ�ش�");
			            	qu.setLast_time(q.getRelease_time());
			            	qu.setTotal_num(1);
		            	}
		            	quesUser.add(qu);
		            }
		            //���������
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
