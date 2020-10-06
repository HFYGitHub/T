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
	            //获取“当前页”参数(第一次访问时当前页为null)
	            String currPage = req.getParameter("currentPage");
	            String key = req.getParameter("key");
	            //判断   第一次是设置默认值
	            if(currPage == null || "".equals(currPage)){
	                currPage = "1";
	            }
	            
	            //转换   从jsp获取的都是字符串型的    需转换为整形才能保存到javaBean中
	            int currentPage = Integer.parseInt(currPage);
	            
	            PageBean<File> pb = new PageBean<File>();
	            pb.setCurrentPage(currentPage);
	            //调用service层
	            service.getAllFile(pb,key);
	            
	            //保存域对象
	            req.setAttribute("pageBean", pb);
	            req.setAttribute("key", key);
	            uri = "/admin_datafiel.jsp";
	        } catch (NumberFormatException e) {
	            e.printStackTrace();
	           
	        }
	        
	        //跳转
	        req.getRequestDispatcher(uri).forward(req, resp);
	    }

	    @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	            throws ServletException, IOException {
	        doGet(req, resp);
	    }   
	}