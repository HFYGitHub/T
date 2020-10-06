package com.iteima.servlet;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.iteima.service.FileService;
import com.iteima.service.ReleaseCompetitionService;

@WebServlet("/ReleaseCompetitionServlet")
public class ReleaseCompetitionServlet extends HttpServlet{
	
	public ReleaseCompetitionServlet() {
		// TODO Auto-generated constructor stub
		System.out.println("赛事发布初始化...");
		
	}
	
	private String tempPath;    // 临时文件目录  
	 
    // 初始化  
    public void init(ServletConfig config) throws ServletException  
    {  
        
 
       
      
        tempPath = "temp";  
 
        System.out.println("文件存放目录、临时文件目录准备完毕 ...");  
    } 
    
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
		 res.setContentType("text/plain;charset=gbk"); 
	    	req.setCharacterEncoding("utf-8");
	    	
	    	String content=null;
	    	String theme=null;
	    	String comprname=null;
	    	String real_filename=null;
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
	                    if(fieldName.equals("cars")) {
	                    // 打印当前表单项的内容，即用户在username表单项中输入的内容
	                    	theme=item.getString("UTF-8");
	                   }
	                    if(fieldName.equals("content")) {
		                    // 打印当前表单项的内容，即用户在username表单项中输入的内容
	                    	content=item.getString("UTF-8");
		                   }
	                    if(fieldName.equals("comprname")) {
		                    // 打印当前表单项的内容，即用户在username表单项中输入的内容
	                    	comprname=item.getString("UTF-8");
		                   }
	                    processFormField(item, pw);  
	                }else{  
	                    System.out.println("处理上传的文件 ...");  
	                    // 此时的文件名包含了完整的路径，得注意加工一下  
	    		        String filename = item.getName();         
	    		        System.out.println("完整的文件名：" + filename);  
	    		        int index = filename.lastIndexOf("\\");  
	    		        filename = filename.substring(index + 1, filename.length());  
	    		        real_filename=filename;
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
	    			        
	    					
	    					//输出看是否获取参数正确		
	    				
	    		    	   if(theme!=null&&content!=null&&comprname!=null&&real_filename!=null) {
	  	                	 java.util.Date date=new java.util.Date();
	  	 					SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
	  	 					String release_time=sdf.format(date);	
	  	 	            	ReleaseCompetitionService releaseCompetitionService=new ReleaseCompetitionService();
	  	 					releaseCompetitionService.insertCompetition(theme, content, release_time,real_filename,comprname);
	  	                    
	  	 					
	  	 					
	  	 					
	  	 					 req.getRequestDispatcher("/AllCompetition").forward(req, res);
	  	                        return;
	  	                }
	    				
	    					
	    		       } else {
	    		    	   req.getRequestDispatcher("/AllCompetition").forward(req, res);
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


