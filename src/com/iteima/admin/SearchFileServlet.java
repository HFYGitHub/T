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

/**
 * Servlet implementation class SearchFileServlet
 */
@WebServlet("/SearchFileServlet")
public class SearchFileServlet extends HttpServlet {
	

	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * 1.��ȡ����
		 * 2.������ӵ����ݿ���
		 * 3.����û��������Ƿ�����ȷ
		 * 4.��½�ɹ�����ʾ�û���Ϣ
		 * 5.��½ʧ�ܸ�һ��������ʾ
		 */
		HttpSession session=request.getSession();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
	
	//1.��ȡ�������
	 String filename = request.getParameter("filename");
	 System.out.println(filename);
	 FileService fileservice=new FileService();
	 List<File> file=fileservice.findFileByName(filename);
	 if(file.isEmpty()) {
		 
	 }else {
		 int file_id=0;
		 for(File f:file) {
			 file_id=f.getFileid();
			 System.out.println(file_id);
		 }
		 request.getSession().setAttribute("file_id",file_id);
		 request.getSession().setAttribute("file",file);
		 request.getRequestDispatcher("/edit_file.jsp").forward(request, response);
	 }
	 
}



}