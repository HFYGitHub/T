package com.iteima.admin;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.iteima.dao.UserOp;
import com.iteima.domain.CompetitionNotice;
import com.iteima.domain.User;
import com.iteima.domain.UserReadComp;
import com.iteima.domain.compRead;
import com.iteima.service.FileService;
import com.iteima.service.ReleaseCompetitionService;
import com.iteima.service.UserService;
import com.iteima.utils.JdbcUtil;

/**
 * Servlet implementation class EditFileServlet
 */


@SuppressWarnings("serial")
@WebServlet(urlPatterns={"/EditFileServlet"})

public class EditFileServlet extends HttpServlet {
	public EditFileServlet() {
		// TODO Auto-generated constructor stub
		System.out.println("初始化");
		
	}
	 private String tempPath;    // 临时文件目录  
	 
	    // 初始化  
	    public void init(ServletConfig config) throws ServletException  
	    {  
	        
	 
	       
	      
	        tempPath = "temp";  
	 
	        System.out.println("文件存放目录、临时文件目录准备完毕 ...");  
	    }  
	      
	    // doPost  
	    public void doPost(HttpServletRequest req, HttpServletResponse res)  
	        throws IOException, ServletException  
	    {  
	    	 res.setContentType("text/plain;charset=gbk"); 
	    	req.setCharacterEncoding("utf-8");
	    	
	    	int file_id=Integer.parseInt(req.getParameter("file_id"));
	    	FileService fileservice=new FileService();
	    	com.iteima.domain.File f=fileservice.findFileByFile_id(file_id);
	    	String org_file=f.getFilename();
	    	String org_theme=f.getTheme();
	    	
	    
	    	String path=req.getSession().getServletContext().getRealPath("/download");
	        
	        PrintWriter pw = res.getWriter();  
	        try{  
	            DiskFileItemFactory diskFactory = new DiskFileItemFactory();  
	            // threshold 极限、临界值，即硬盘缓存 1M  
	            diskFactory.setSizeThreshold(4 * 1024);  
	            // repository 贮藏室，即临时文件目录  
	            diskFactory.setRepository(new File(tempPath));  
	          
	            ServletFileUpload upload = new ServletFileUpload(diskFactory);  
	            // 设置允许上传的最大文件大小 4M  
	            upload.setSizeMax(20 * 1024 * 1024);  
	            // 解析HTTP请求消息头  
	            List fileItems = upload.parseRequest(req);  
	            Iterator iter = fileItems.iterator();  
	            while(iter.hasNext())  
	            {  
	                FileItem item = (FileItem)iter.next();  
	                if(item.isFormField())  
	                {  
	                    System.out.println("处理表单内容 ...");  
	                    String fieldName = item.getFieldName();
	                    // 如果当前表单项的字段名为username
	                    
	                   
	                    processFormField(item, pw);  
	                }else{  
	                    System.out.println("处理上传的文件 ...");  
	                    // 此时的文件名包含了完整的路径，得注意加工一下  
	                    String filename = item.getName();    
	    		        filename = new String(filename.getBytes("gbk"),"utf-8");
	    		        System.out.println("完整的文件名：" + filename);  
	    		        int index = filename.lastIndexOf("\\");
	    		        filename = filename.substring(index + 1, filename.length());  
	    		 
	    		        long fileSize = item.getSize();  
	    		 
	    		        if("".equals(filename) && fileSize == 0)  
	    		        {             
	    		            System.out.println("文件名为空 ..."); 
	    		           
	    		            
	    		            
	    		            return;  
	    		        }  
	    		 
	    		       File uploadFile = new File(path + "/" + filename);  
	    		        System.out.println(uploadFile);
	    		       if(! uploadFile.exists()) {
	    		    	    item.write(uploadFile);  
	    			        pw.println(filename + " 文件保存完毕 ...");  
	    			        pw.println("文件大小为 ：" + fileSize + "\r\n");  
	    			       
	    			       
	    					
	    						 fileservice.updateFile(filename,org_theme,org_file);
	    					 
	    					 
	    				      
	    				      req.getRequestDispatcher("/SearchFileServlet?filename="+filename).forward(req, res);
	    				      return;
	    		       } else {
	    		    	   req.getRequestDispatcher("/edit_file.jsp").forward(req, res);
	    		    	   return;
	    		    	  // req.getRequestDispatcher("/error.jsp").forward(req, res);
	    		       }
	                }  
	            }// end while()  
	 
	            pw.close();  
	        }catch(Exception e){  
	            System.out.println("使用 fileupload 包时发生异常 ...");  
	          //  req.getRequestDispatcher("/error.jsp").forward(req, res);
	        }// end try ... catch ...  
	        
	        
	        
	    	
	        
	    }// end doPost()  
	 
	 
	    // 处理表单内容  
	    private void processFormField(FileItem item, PrintWriter pw)  
	        throws Exception  
	    {  
	        String name = item.getFieldName();  
	        String value = item.getString();          
	        pw.println(name + " : " + value + "\r\n");  
	    }  
	      
	  
	      
	    // doGet  
	    public void doGet(HttpServletRequest req, HttpServletResponse res)  
	        throws IOException, ServletException  
	    {  
	        doPost(req, res);  
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
