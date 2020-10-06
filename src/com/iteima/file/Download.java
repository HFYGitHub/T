package com.iteima.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
@WebServlet(value = "/download")
public class Download extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		OutputStream out=response.getOutputStream();
		//��ȡҪ���ص��ļ�����
		String fileName=request.getParameter("loadname");
		fileName=new String(fileName.getBytes("ISO-8859-1"),"UTF-8");
		//�õ������ļ���·��
		String storPath=getServletContext().getRealPath("WEB-INF/upload");
		//�õ�Դ�ļ�����
		String oldName=fileName.split("_")[1];
		//��һ������hashcode��ȷ����Ŀ¼
		String childPath=generateDir(storPath,fileName);
		//�ƶ�Ҫ���ص��ļ��Ƿ񻹴���
		File file=new File(storPath+File.separator+childPath+File.separator+fileName);
		if(!file.exists()){
			out.write("��Ҫ���ص���Դ���ܲ�����".getBytes());
		}else{
			//������ھͽ������ز���
			InputStream is=new FileInputStream(file);
			//ָ�����ص���Ӧͷ
			response.setHeader("Content-Disposition", 
					"attachment;filename="+URLEncoder.encode(oldName,"UTF-8"));
			IOUtils.copy(is, out);
			is.close();
		}
	}
	private String generateDir(String storePath, String fileName) {
		int hashcode=fileName.hashCode();
		int dir1=hashcode &  0xf;
		int dir2=(hashcode & 0xf0)>>4;
		String childPath=dir1+File.separator+dir2;
		File file=new File(storePath,childPath);
		if(!file.exists()){
			file.mkdirs();
		}
		return childPath;
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);

	}

}
