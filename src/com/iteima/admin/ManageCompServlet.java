package com.iteima.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iteima.domain.File;
import com.iteima.service.FileService;
import com.iteima.service.ReleaseCompetitionService;



@WebServlet("/ManageCompServlet")

public class ManageCompServlet extends HttpServlet {
	

		
		
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
 int notice_id = Integer.parseInt(request.getParameter("notice_id"));

 ReleaseCompetitionService fileservice=new ReleaseCompetitionService();
 fileservice.deleteComp(notice_id);
 
 
 request.getRequestDispatcher("/AllCompetition").forward(request, response);
}
}
