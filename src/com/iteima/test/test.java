package com.iteima.test;

import java.util.List;

import com.iteima.domain.Answer;
import com.iteima.domain.ReplayUser;

public class test {
	public static void main(String[] args)  { 
		 BorrowSubOrderServiceImpl ser=new BorrowSubOrderServiceImpl();
		 List<Answer> an=ser.findCompanyAndDepts(1);
		 for(Answer a:an) {
			 System.out.println("���Ǹ���"); System.out.println(a.getAnswer()); 
			 List<ReplayUser> re= a.getReplayUser();
			 for(int i=0;i<re.size();i++) {
				 
			 }
			 for(ReplayUser r:re) {
				 while(r.getReplayUser()!=null) {
					
				 }
				 System.out.println("���Ƕ���"); System.out.println(r.getContent());
				 for(ReplayUser r1:r.getReplayUser()) {
					 System.out.println("���Ƕ��ӵĶ���"); System.out.println(r1.getContent());
					 for(ReplayUser r2:r1.getReplayUser()) {
						 System.out.println("���Ƕ��ӵĶ��ӵĶ���"); System.out.println(r2.getContent());
					 }
				 }
			 }
		 }
	 }
}
