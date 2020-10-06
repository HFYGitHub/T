package com.iteima.admin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.iteima.domain.File;
import com.iteima.domain.Food;
import com.iteima.domain.User;
import com.iteima.service.FileService;
import com.iteima.service.FoodService;
import com.iteima.utils.JdbcUtil;

/**
 * Servlet implementation class ManageFileServlet
 */

@WebServlet("/ManageFileServlet")

public class ManageFileServlet extends HttpServlet {
	

		
		
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
		 String filename = request.getParameter("filename");
		 System.out.println(filename);
		 FileService fileservice=new FileService();
		 fileservice.deleteFile(filename);
		 
		 List<File> allfile= fileservice.findAllFile();
		
		 request.getSession().setAttribute("allfile", allfile);	
		 request.getRequestDispatcher("/FileIndexServlet").forward(request, response);
	}

	

}