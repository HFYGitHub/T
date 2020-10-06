package com.iteima.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iteima.domain.Answer;
import com.iteima.domain.AnswerUser;
import com.iteima.domain.FoodTalk;
import com.iteima.domain.Question;
import com.iteima.domain.ReplayUser;
import com.iteima.domain.User;
import com.iteima.service.AnswerQuestionService;
import com.iteima.service.FoodService;
import com.iteima.service.QuestionService;
import com.iteima.service.UserService;
import com.iteima.test.BorrowSubOrderServiceImpl;


@SuppressWarnings("serial")
@WebServlet(urlPatterns={"/ManageQuesAnswer"})
public class ManageQuesAnswer extends HttpServlet {
	public ManageQuesAnswer() {
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
		int a_id=Integer.parseInt(request.getParameter("answer_id"));
		//1.��ȡ�������
		String username=request.getParameter("username");//��ǰ��½�û�
		
		int q_id=Integer.parseInt(request.getParameter("question_id"));
		String theme=request.getParameter("theme");
		int user_id=Integer.parseInt(request.getParameter("user_id"));//����������û���
		
		
		
		UserService userservice=new UserService();
		QuestionService ques=new QuestionService();
         ques.deleteAnswe(a_id);
		List<AnswerUser> userlist=new ArrayList<>();
		List<List<ReplayUser>> replay = new ArrayList<>();
		
		
		User user=userservice.findUserById(user_id);
		String user_name =user.getName();
		
		Question question=ques.findQuesById(q_id, user_id);
		List<Answer> answer=ques.findAnById(q_id);
		AnswerQuestionService answerques=new AnswerQuestionService();
		int num=0;
		for(Answer an:answer) {
			AnswerUser anuser=new AnswerUser();
			num++;
			List<ReplayUser> replay1=answerques.findAllFile(an.getAnswer_id());
		    
			User us=userservice.findUserById(an.getUser_id());
			anuser.setQuestion_id(an.getQuestion_id());
			anuser.setUser_id(an.getUser_id());
			anuser.setAnswer(an.getAnswer());
			anuser.setRelease_time(an.getRelease_time());
			anuser.setAnswer_id(an.getAnswer_id());
			anuser.setName(us.getName());
			userlist.add(anuser);
			replay.add( replay1);
			
		}
		
		request.setAttribute("user_name", user_name);//����������û���
		request.setAttribute("user_id", user_id);
		request.setAttribute("q_id", q_id);//����������û���
		request.setAttribute("category", question.getCategory());
		request.setAttribute("release_time", question.getRelease_time());
		request.setAttribute("title", question.getTitle());
		request.setAttribute("content", question.getContent());
		request.setAttribute("userlist", userlist);
		request.setAttribute("num", num);
		request.setAttribute("username", username);
		request.setAttribute("theme", theme);
		request.setAttribute("rep", replay);
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

