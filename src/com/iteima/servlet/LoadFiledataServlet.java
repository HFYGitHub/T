package com.iteima.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.iteima.domain.File;
import com.iteima.domain.User;
import com.iteima.service.FileService;
import com.iteima.utils.JdbcUtil;


@WebServlet("/LoadFiledataServlet")
public class LoadFiledataServlet extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 1.��ȡ����
		 * 2.������ӵ����ݿ���
		 * 3.����û��������Ƿ�����ȷ
		 * 4.��½�ɹ�����ʾ�û���Ϣ
		 * 5.��½ʧ�ܸ�һ��������ʾ
		 */
	
	 FileService fileservice=new FileService();
	 List<File> allfile=fileservice.findAllFile();
	  System.out.println(allfile);
	 request.setAttribute("allfile", allfile);
	 request.getRequestDispatcher("/dataShare.jsp").forward(request, response);
	 return ;
	}

}
