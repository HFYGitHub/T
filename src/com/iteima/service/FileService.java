package com.iteima.service;

import java.util.List;

import com.iteima.dao.FileDao;
import com.iteima.domain.File;
import com.iteima.domain.UserDownFile;

public class FileService {
     public List<File> findAllFile(){
    	 FileDao file=new FileDao();
    	 return file.findAllFile();
     }
     
     public List<File> findFileByTheme(String theme){
    	 FileDao file=new FileDao();
    	 return file.findFileByTheme(theme);
     }
     public int countAllFile() {
    	 FileDao file=new FileDao();
    	 return file.countAllFile();
     }
     public List<File> findFileByName(String name) {
    	 FileDao file=new FileDao();
    	 return file.findFileByName(name);
     }
     
     public void updateDownNum(String filename) {
    	 FileDao file=new FileDao();
    	 file.updateDownNum(filename);
    	 
     }
     public int countFile(String theme) {
    	 FileDao file=new FileDao();
    	return  file.countFile(theme);
     }
     public int countFile() {
    	 FileDao file=new FileDao();
    	return  file.countFile();
     }
     public void deleteFile(String filename) {
    	 FileDao file=new FileDao();
    	 file.deleteFile(filename);
     }
 	public void insertFile(String filename,String path,String theme) {
 		FileDao file=new FileDao();
    	 file.insertFile(filename,path,theme);
 	}
 	public void updateFile(String filename,String theme,String org_filename) {
 		FileDao file=new FileDao();
   	 file.updateFile(filename,theme,org_filename);
 	}
 	public void insertUserD(int file_id,String username) {
 		FileDao file=new FileDao();
 	   	 file.insertUserD(file_id,username);
 	}
 	
		public File findFileByFile_id(int id) {
			FileDao file=new FileDao();
	 		return file.findFileByFile_id(id);
		}
	public List<UserDownFile> findFileByUser(String username) {
		FileDao file=new FileDao();
 		return file.findFileByUser(username);
	}
	public int countUserDown(String username,int id) {
		FileDao file=new FileDao();
 		return file.countUserDown(username, id);
	}
 	}

