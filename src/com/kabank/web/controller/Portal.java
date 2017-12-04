package com.kabank.web.controller;

import java.util.Scanner;

import com.kabank.web.bean.MemberBean;
import com.kabank.web.serviceImpl.AccountServiceImpl;
import com.kabank.web.serviceImpl.MemberServiceImpl;

public class Portal {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("회원수를 입력하세요.");
		MemberServiceImpl memberservice = new MemberServiceImpl(scanner.nextInt());
		MemberBean member = null;
		while(true) {
			System.out.println("[MENU] 0.종료 1.회원가입 2.계좌개설 3.총회원수 4.회원목록");
			switch(scanner.nextInt()) {
			case 0 : System.out.println("종료합니다.");
				return;
			case 1 :
				member = new MemberBean();
				System.out.println("이름");
				member.setName(scanner.next());
				System.out.println("주민번호");
				member.setSsn(scanner.next());
				member.setCustomNum(memberservice.createCustomNum());
				member.setGender(memberservice.findGender(member.getSsn()));
				member.setAge(memberservice.findAge(member.getSsn()));
				memberservice.addMember(member);
				
				System.out.println(
						 "[고객번호]" +member.getCustomNum()
						+"[이름]" +member.getName()
						+"[나이]" +member.getAge()
						+"[성별]" +member.getGender()
						);
					break;
			case 2 : 
				AccountServiceImpl accountService = new AccountServiceImpl();
				System.out.println("이름");
				String name = scanner.next();
				accountService.setAccountNum();
				System.out.println(
						"[이름]" +name
					   +"[계좌번호]" +accountService.getAccountNum() 
						);
					break;
			case 3 :
				System.out.println("총 회원수는 :" 
						+ memberservice.count());
					break;
			case 4 :
				MemberBean[] members = memberservice.list();
				for(int i =0; i < members.length; i++) {
					System.out.println(members[i].getName());
				}
					break;
			
			}
		}
	}
}
