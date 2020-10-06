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
		//工具类对象
		EditorResult er = new EditorResult();
		er.setErrno(1);
		//获取文件地址
		String basepath = request.getServletContext().getRealPath("/uploadimg");
		String imgname = UUID.randomUUID().toString();
		//文件后缀名
		String suffix = upimg.getOriginalFilename().substring(upimg.getOriginalFilename().lastIndexOf("."));
		//文件保存
		try {
			upimg.transferTo(new File(basepath+"/"+imgname+suffix));
			//上传成功修改errno错误状态,返回路径
			er.setErrno(0);
			er.setData(new String[]{"/uploadimg/"+imgname+suffix});
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//返回类型是固定的，这里需要一个工具类
		return er;
	}
}
