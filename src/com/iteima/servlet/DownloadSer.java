package com.iteima.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iteima.service.FileService;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import Decoder.BASE64Encoder;

/**
 * Servlet implementation class DownloadSer
 */
@WebServlet("/DownloadSer")
public class DownloadSer extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  doPost(request, response);  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("filename");
		String page=request.getParameter("currentpage");
		String theme=request.getParameter("theme");
		//name=new String(name.getBytes("ISO8859-1"),"UTF-8");
		//按照文件名来获取mine
		SmartUpload su = new SmartUpload();//创建对象
        su.initialize(getServletConfig(), request, response);//初始化
        try {
            su.downloadFile("/download/"+name);//路径加文件名
            //su.setContentDisposition();
        } catch (SmartUploadException e) {
            e.printStackTrace();
        }
	    FileService fileservice=new FileService();
	    fileservice.updateDownNum(name);
	  
	   String uri = "/T/IndexServlet?currentPage="+page;
	   request.getRequestDispatcher(uri).forward(request, response);
	

}
	
}
