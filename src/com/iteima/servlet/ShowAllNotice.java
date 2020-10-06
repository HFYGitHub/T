package com.iteima.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.iteima.domain.CompetitionNotice;
import com.iteima.domain.PageBean;

import com.iteima.service.IPageBeanService;
import com.iteima.service.PageBeanService;

@WebServlet("/ShowAllNotice")
public class ShowAllNotice extends HttpServlet {
	 private IPageBeanService service = new PageBeanService();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//1.��ȡ�������
		
		
		    String key=request.getParameter("key");
			String username=request.getParameter("username");
			String theme=request.getParameter("theme");
		    System.out.println(username);
		    System.out.println(theme);
		        try {
		            //��ȡ����ǰҳ������(��һ�η���ʱ��ǰҳΪnull)
		            String currPage = request.getParameter("currentPage");
		            
		            //�ж�   ��һ��������Ĭ��ֵ
		            if(currPage == null || "".equals(currPage)){
		                currPage = "1";
		            }
		            
		            //ת��   ��jsp��ȡ�Ķ����ַ����͵�    ��ת��Ϊ���β��ܱ��浽javaBean��
		            int currentPage = Integer.parseInt(currPage);
		            
		            PageBean<CompetitionNotice> pb = new PageBean<CompetitionNotice>();
		            pb.setCurrentPage(currentPage);
		            
		            //����service��
		            service.getAllCompNotice(pb, theme,key);
		            
		            //���������
		            request.setAttribute("pageBean", pb);
		            request.setAttribute("username", username);
		            request.setAttribute("theme", theme);
		        } catch (NumberFormatException e) {
		            e.printStackTrace();
		           
		        }
		        
		        //��ת
		        request.getRequestDispatcher("/competition.jsp").forward(request, response);
	}

}
