package com.kabank.web.serviceImpl;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import com.kabank.web.bean.MemberBean;
import com.kabank.web.service.MemberService;

public class MemberServiceImpl implements MemberService {
	private MemberBean[] members;
	private int count;
	
	
	public MemberServiceImpl(int count) {
		members = new MemberBean[count];
		this.count=0;
	}
	@Override
	public int count() {
		return this.count;
	}
	
	@Override
	public int createCustomNum() {
		int foo = 0;
		for (int i = 1; i >= 101; i++) {
			if (i >= 101) {
				foo = i;
			} else {

			}
		}
		return foo;
	}

	@Override
	public String findGender(String ssn) {
		String foo = "";
		char ch = ssn.charAt(7);
		switch (ch) {
		case '1':
		case '3':
			foo = "남자";
			break;
		case '2':
		case '4':
			foo = "여자";
			break;
		case '5':
		case '6':
			foo = "외국인";
			break;
		}
		return foo;
	}

	@Override
	public int findAge(String ssn) {
		Calendar cal = Calendar.getInstance();
		int year = 0, foo = 0, res = 0, c2 =0;
		String year2 = "";
		year = cal.get(Calendar.YEAR);
		year2 = ssn.charAt(0)+ ""+ssn.charAt(1);
		int now = cal.get(cal.YEAR);
		int year3 =Integer.parseInt(year2);
		int gap = now - year3;
		if(gap >= 2000) {
			res = Integer.parseInt("20"+year2);
		}else {
			res = Integer.parseInt("19"+year2);
		}
		foo = now - res + 1;
		return foo;
	}
	@Override
	public void addMember(MemberBean member) {
		// TODO Auto-generated method stub
		members[count] = member;
		count++;
	}
	@Override
	public MemberBean[] list() {
		return members;
	}
	@Override
	public void setChart(int chart) {
		// TODO Auto-generated method stub
		/*
		 * switch
		 * case
		 * default
		 *                    true !=  false
		 *                    loop     return; break;
 		 * if = switch
		 * else if = case
		 * else. = default
		 * */
	}
}
