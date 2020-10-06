package com.iteima.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iteima.domain.Answer;
import com.iteima.domain.AnswerUser;
import com.iteima.domain.Competion;
import com.iteima.domain.CompetitionNotice;
import com.iteima.domain.File;
import com.iteima.domain.ReplayUser;
import com.iteima.domain.User;
import com.iteima.domain.UserReadComp;
import com.iteima.domain.compRead;
import com.iteima.service.FileService;
import com.iteima.service.ReleaseCompetitionService;
import com.iteima.service.UserService;

/**
 * Servlet implementation class EditCompServlet
 */
@WebServlet("/EditCompServlet")
public class EditCompServlet extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 1.获取请求
		 * 2.检查连接到数据库中
		 * 3.检查用户名密码是否在正确
		 * 4.登陆成功，显示用户信息
		 * 5.登陆失败给一个错误提示
		 */
		HttpSession session=request.getSession();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
	
	//1.获取请求参数
		 int id = Integer.parseInt(request.getParameter("id"));
		 
		 ReleaseCompetitionService readservice=new ReleaseCompetitionService();
		 UserService userservice=new UserService();
 	      List<CompetitionNotice> comp=readservice.findCopmById(id);
	      List<compRead> comread=readservice.findRead(id);
	      List<UserReadComp> userlist=new ArrayList<>();
	      int num=0;
	      for(compRead an:comread) {
	    	  UserReadComp anuser=new UserReadComp();
				num++;
				
				User us=userservice.findUserById(an.getUser_id());
				
				anuser.setDown_num(an.getDown_num());
				anuser.setLook_num(an.getLook_num());
				anuser.setLook_time(an.getLook_time());
				anuser.setName(us.getName());
				anuser.setNotice_id(an.getNotice_id());
				anuser.setUser_id(an.getUser_id());
				userlist.add(anuser);
			}
	      request.getSession().setAttribute("num",num);
		 request.getSession().setAttribute("comp",comp);
		 request.getSession().setAttribute("id",id);
		 request.getSession().setAttribute("userlist",userlist);
		 request.getRequestDispatcher("/edit_comp.jsp").forward(request, response);
	}
	}