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
		System.out.println("���·�����ʼ��...");
		
	}
	
	private String tempPath;    // ��ʱ�ļ�Ŀ¼  
	 
    // ��ʼ��  
    public void init(ServletConfig config) throws ServletException  
    {  
        
 
       
      
        tempPath = "temp";  
 
        System.out.println("�ļ����Ŀ¼����ʱ�ļ�Ŀ¼׼����� ...");  
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
	            // threshold ���ޡ��ٽ�ֵ����Ӳ�̻��� 1M  
	            diskFactory.setSizeThreshold(4 * 1024);  
	            // repository �����ң�����ʱ�ļ�Ŀ¼  
	            diskFactory.setRepository(new File(tempPath));  
	          
	            ServletFileUpload upload = new ServletFileUpload(diskFactory);  
	            // ���������ϴ�������ļ���С 4M  
	            upload.setSizeMax(20 * 1024 * 1024);  
	            // ����HTTP������Ϣͷ  
	            List fileItems = upload.parseRequest(req);  
	            Iterator iter = fileItems.iterator();  
	            while(iter.hasNext())  
	            {  
	                FileItem item = (FileItem)iter.next();  
	                if(item.isFormField())  
	                {  
	                    System.out.println("��������� ...");  
	                    String fieldName = item.getFieldName();
	                    // �����ǰ������ֶ���Ϊusername
	                    if(fieldName.equals("cars")) {
	                    // ��ӡ��ǰ��������ݣ����û���username���������������
	                    	theme=item.getString("UTF-8");
	                   }
	                    if(fieldName.equals("content")) {
		                    // ��ӡ��ǰ��������ݣ����û���username���������������
	                    	content=item.getString("UTF-8");
		                   }
	                    if(fieldName.equals("comprname")) {
		                    // ��ӡ��ǰ��������ݣ����û���username���������������
	                    	comprname=item.getString("UTF-8");
		                   }
	                    processFormField(item, pw);  
	                }else{  
	                    System.out.println("�����ϴ����ļ� ...");  
	                    // ��ʱ���ļ���������������·������ע��ӹ�һ��  
	    		        String filename = item.getName();         
	    		        System.out.println("�������ļ�����" + filename);  
	    		        int index = filename.lastIndexOf("\\");  
	    		        filename = filename.substring(index + 1, filename.length());  
	    		        real_filename=filename;
	    		        long fileSize = item.getSize();  
	    		 
	    		        if("".equals(filename) && fileSize == 0)  
	    		        {             
	    		            System.out.println("�ļ���Ϊ�� ...");  
	    		            return;  
	    		        }  
	    		 
	    		        File uploadFile = new File(path + "/" + filename);  
	    		        System.out.println(uploadFile);
	    		         if(! uploadFile.exists()) {
	    		    	   item.write(uploadFile);  
	    			        
	    					
	    					//������Ƿ��ȡ������ȷ		
	    				
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
	            System.out.println("ʹ�� fileupload ��ʱ�����쳣 ...");  
	          //  req.getRequestDispatcher("/error.jsp").forward(req, res);
	        }// end try ... catch ...  
	    }// end doPost()  
	 
	 
	    // ���������  
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


