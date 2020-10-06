package com.iteima.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iteima.domain.File;
import com.iteima.domain.PageBean;
import com.iteima.service.IPageBeanService;
import com.iteima.service.PageBeanService;

/**
 * Servlet implementation class FileIndexServlet
 */
@WebServlet("/FileIndexServlet")
public class FileIndexServlet extends HttpServlet {
	 private IPageBeanService service = new PageBeanService();
	    private String uri;
	    @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException {
	      
	        try {
	            //��ȡ����ǰҳ������(��һ�η���ʱ��ǰҳΪnull)
	            String currPage = req.getParameter("currentPage");
	            String key = req.getParameter("key");
	            //�ж�   ��һ��������Ĭ��ֵ
	            if(currPage == null || "".equals(currPage)){
	                currPage = "1";
	            }
	            
	            //ת��   ��jsp��ȡ�Ķ����ַ����͵�    ��ת��Ϊ���β��ܱ��浽javaBean��
	            int currentPage = Integer.parseInt(currPage);
	            
	            PageBean<File> pb = new PageBean<File>();
	            pb.setCurrentPage(currentPage);
	            //����service��
	            service.getAllFile(pb,key);
	            
	            //���������
	            req.setAttribute("pageBean", pb);
	            req.setAttribute("key", key);
	            uri = "/admin_datafiel.jsp";
	        } catch (NumberFormatException e) {
	            e.printStackTrace();
	           
	        }
	        
	        //��ת
	        req.getRequestDispatcher(uri).forward(req, resp);
	    }

	    @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException {
	        doGet(req, resp);
	    }   
	}