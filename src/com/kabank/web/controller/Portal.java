package com.kabank.web.controller;

import java.util.Scanner;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.kabank.web.bean.MemberBean;
import com.kabank.web.serviceImpl.AccountServiceImpl;
import com.kabank.web.serviceImpl.MemberServiceImpl;

public class Portal {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		MemberServiceImpl memberservice = new MemberServiceImpl();
		MemberBean member = null;
		while(true) {
			
			switch(JOptionPane.showInputDialog("[MENU] 0.종료 1.회원가입 2.계좌개설 3.총회원수 4.회원목록 5.로그인"
					+ " 6. 회원삭제" 
					+ " 9.회원전체삭제")) {
			case "0" : JOptionPane.showMessageDialog(null, "종료합니다.");
				return;
			case "1" :
				String spec = JOptionPane.showInputDialog("이름/주민번호/ID/PASS");
				String[] dummy = {
						"홍길동/800101-123456/hong/1",
						"김유신/900203-134567/kim/1",
						"이이/920304-189456/lee/1",
						"유관순/850910-223456/you/1",
						"신사임당/950101-273456/shin/1"
				};
				for(int i = 0; i < dummy.length;i++) {
					String[] arr = dummy[i].split("/");
					member = new MemberBean();
					member.setName(arr[0]);
					member.setSsn(arr[1]);
					member.setId(arr[2]);
					member.setPass(arr[3]);
					member.setCustomNum(memberservice.createCustomNum());
					member.setGender(memberservice.findGender(member.getSsn()));
					member.setAge(memberservice.findAge(member.getSsn()));
					memberservice.addMember(member);
				}
					break;
			case "2" : 
				member = new MemberBean();
				AccountServiceImpl accountService = new AccountServiceImpl();
				JOptionPane.showInputDialog("이름");
				String name = scanner.next();
				accountService.setAccountNum();
				JOptionPane.showMessageDialog(null, "[이름]" +name
					   +"[계좌번호]" +accountService.getAccountNum());
					break;
			case "3" :
				JOptionPane.showMessageDialog(null, "총 회원수는 :" 
						+ memberservice.count());
					break;
			case "4" :
				JOptionPane.showMessageDialog(null, memberservice.list());
					break;
			case "5" :
				//get(indexOf("hong".equals(obj.get(i).getId()))
					//					     = arr[i]
					break;
			case "6" :
				
				JOptionPane.showInputDialog("삭제할 이름");
					break;
			case "9" :
				memberservice.deleteAll();
				JOptionPane.showMessageDialog(null, "전체삭제되었습니다.");
				break;
			
			}
		}
	}
}
