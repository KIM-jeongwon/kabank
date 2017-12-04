package com.kabank.web.service;

import com.kabank.web.bean.MemberBean;

public interface MemberService {
	public int createCustomNum();
	public String findGender(String ssn);
	public int findAge(String ssn);
	public void setChart(int chart);
	public int count();
	public void addMember(MemberBean member);
	public MemberBean[] list();
}
