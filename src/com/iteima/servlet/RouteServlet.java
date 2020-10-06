package com.iteima.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RouteServlet
 */
@WebServlet("/RouteServlet")
public class RouteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
/*/
 * 分页查询
 */

	protected void pageQuery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1接收参数
		String currentPageStr=request.getParameter("currentPage");
		String pageSizeStr=request.getParameter("pageSizeStr");
		String cidStr=request.getParameter("cidStr");
		
		//2处理参数
		int cid=0;
		if(cidStr!=null&&cidStr.length()>0) {
			cid=Integer.parseInt(cidStr);
		}
		//当前页码
		int currentpage=0;
		if(currentPageStr!=null&&currentPageStr.length()>0) {
			currentpage=Integer.parseInt(currentPageStr);
		}else {
			currentpage=1;
		}
		//每页显示条数
		int pagesize=0;
		if(pageSizeStr!=null&&pageSizeStr.length()>0) {
			pagesize=Integer.parseInt(pageSizeStr);
		}else {
			pagesize=5;
		}
		
		//3.调用service
	}

	

}
