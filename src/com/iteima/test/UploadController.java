package com.iteima.test;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	@RequestMapping("/upload")
	@ResponseBody
	public EditorResult upload(MultipartFile upimg,HttpServletRequest request){
		//���������
		EditorResult er = new EditorResult();
		er.setErrno(1);
		//��ȡ�ļ���ַ
		String basepath = request.getServletContext().getRealPath("/uploadimg");
		String imgname = UUID.randomUUID().toString();
		//�ļ���׺��
		String suffix = upimg.getOriginalFilename().substring(upimg.getOriginalFilename().lastIndexOf("."));
		//�ļ�����
		try {
			upimg.transferTo(new File(basepath+"/"+imgname+suffix));
			//�ϴ��ɹ��޸�errno����״̬,����·��
			er.setErrno(0);
			er.setData(new String[]{"/uploadimg/"+imgname+suffix});
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//���������ǹ̶��ģ�������Ҫһ��������
		return er;
	}
}
