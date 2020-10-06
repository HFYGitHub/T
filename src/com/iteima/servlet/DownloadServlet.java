package com.iteima.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iteima.service.FileService;
import com.iteima.utils.DownLoadUtils;

import Decoder.BASE64Encoder;



@SuppressWarnings("serial")
@WebServlet(urlPatterns={"/DownloadServlet"})

	public class DownloadServlet extends HttpServlet {
		public DownloadServlet() {
			// TODO Auto-generated constructor stub
			System.out.println("初始化");
			
		}
		@Override
		protected  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
			doPost(request, response);
			
		}
		@Override
		protected  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
			
			service(request,response);
	}
		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String name=request.getParameter("filename");
			String page=request.getParameter("currentpage");
			String theme=request.getParameter("theme");
			//name=new String(name.getBytes("ISO8859-1"),"UTF-8");
			//按照文件名来获取mine
			String mimeType=this.getServletContext().getMimeType(name);
			response.setContentType(mimeType);
			 response.setCharacterEncoding("UTF-8");
			String agent=request.getHeader("User-Agent").toUpperCase();;
			String filenameEncode="";
			if(agent.contains("MSIE")) {
				filenameEncode=URLEncoder.encode(name,"utf-8");
				filenameEncode=filenameEncode.replace("+", " ");
			}else if(agent.contains("Firefox")) {
				BASE64Encoder base64Encoder=new BASE64Encoder();
				filenameEncode="=?utf-8?B?"+base64Encoder.encode(name.getBytes("utf-8"))+"?=";
			}else {
				filenameEncode=URLEncoder.encode(name,"utf-8");
			}
			
			
			//拼接文件的路径
		     String path=	this.getServletContext().getRealPath("download/"+name);
			FileInputStream in=new FileInputStream(path);
			File file = new File(path);
			//获取响应的输出
			ServletOutputStream out=response.getOutputStream();
			response.reset();
		   
		    response.setContentType("application/force-download");// 设置强制下载不打开
		    response.addHeader("Content-Disposition", "attachment;filename=" + filenameEncode);
		    response.setHeader("Content-Length", String.valueOf(file.length()));
	          System.out.println("aaa");
	          byte[] b = new byte[1024];
		    int len;
		    while ((len = in.read(b)) != -1) {
		        response.getOutputStream().write(b, 0, len);
		    }
		    response.flushBuffer();
		    in.close();
		    FileService fileservice=new FileService();
		    fileservice.updateDownNum(name);
		   out.close();
		   
		}
		@Override
		public void destroy() {
			// TODO Auto-generated method stub
			super.destroy();
		}

		@Override
		public void init() throws ServletException {
			// TODO Auto-generated method stub
			super.init();
		}
		
	}
