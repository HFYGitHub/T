package com.iteima.service;

import java.util.List;

import com.iteima.dao.FileDao;
import com.iteima.dao.FoodDao;
import com.iteima.domain.Food;
import com.iteima.domain.FoodTalk;

public class FoodService {
	public List<Food> findFileByTheme(String theme){
		 FoodDao food=new FoodDao();
    	 return food.findFileByTheme(theme);
	}
	public List<Food> findAllFood(){
		 FoodDao food=new FoodDao();
   	 return food.findAllFood();
	}
	public List<FoodTalk> findFoodTalkByName(String  name) {
		 FoodDao food=new FoodDao();
	   	 return food.findFoodTalkByName(name);
	}
	public void deleteFood(int id) {
		 FoodDao food=new FoodDao();
	   	 food.deleteFood(id);
	}
	public List<Food> findAllFoodByName(int id) {
		 FoodDao food=new FoodDao();
	   	 return food.findAllFoodByName(id);
	}
	public void insertFood(String username,String content,String image,String  text) {
		FoodDao food=new FoodDao();
	   	 food.insertFood(username, content, image, text);
	}
	public List<Food> findFoodById(int id) {
		 FoodDao food=new FoodDao();
	   	 return food.findFoodById(id);
	}public List<Food> findFoodByKey(String key) {
		 FoodDao food=new FoodDao();
	   	 return food.findFoodByKey(key);
	}
	public List<Food> findFileByTheme(String numflag,String theme,String dateflag) {
		FoodDao food=new FoodDao();
    	 return food.findFileByTheme(numflag,theme,dateflag);
	}
	public List<FoodTalk> findFoodTalk(int id) {
		FoodDao food=new FoodDao();
   	 return food.findFoodTalk(id);
	}
	public void insertFoodTalk(String username,String content,int food_id) {
		FoodDao food=new FoodDao();
	   	food.insertFoodTalk(username,content,food_id);
		}
	
	public void updateFood(int id) {
		FoodDao food=new FoodDao();
	   	food.updateFood(id);
	}
	public void updateFoodTalk(int id,String time,String username) {
		FoodDao food=new FoodDao();
	   	food.updateFoodTalk(id,time,username);
	}
	public Food findFood(int id)
	{
		FoodDao food=new FoodDao();
	   	return food.findFood(id);
}
	public void deleteFoodtalk(int id,String time,String username) {
		FoodDao food=new FoodDao();
	   	food.deleteFoodtalk(id,time,username);
	}
public int countFood() {
	FoodDao food=new FoodDao();
	return  food.countFood();
}
public List<Food> findHotFood() {
	FoodDao food=new FoodDao();
	 return  food.findHotFood();
}
}