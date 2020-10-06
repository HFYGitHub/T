package com.iteima.test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

public class ImgController {
	@Autowired 
    private HttpServletRequest request; 
    @RequestMapping(value ="/upload",method=RequestMethod.POST)
    @ResponseBody
    public Object UpLoadImg(@RequestParam(value="myFileName")MultipartFile mf) {
        String realPath = request.getSession().getServletContext().getRealPath("upload");
         
    //��ȡԴ�ļ�
    String filename = mf.getOriginalFilename();
    String[] names=filename.split("\\.");//
    String tempNum=(int)(Math.random()*100000)+"";
    String uploadFileName=tempNum +System.currentTimeMillis()+"."+names[names.length-1];
    File targetFile = new File (realPath,uploadFileName);//Ŀ���ļ�
     
    //��ʼ��Դ�ļ�������Ŀ���ļ�
     
    //��ͼƬһ����λ
    try {
        mf.transferTo(targetFile);
    } catch (IllegalStateException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
     
    Map<String, String> map = new HashMap<String, String>();
    map.put("data","http://localhost:8080/SSM/upload/"+uploadFileName);//����Ӧ������Ŀ·��
    return map;//��ͼƬ��ַ����
    }
}
