package com.kabank.web.service;

import java.util.Vector;

import com.kabank.web.bean.MemberBean;

public interface MemberService {
	public int createCustomNum();
	public String findGender(String ssn);
	public int findAge(String ssn);
	public void setChart(int chart);
	public int count();
	public void addMember(MemberBean member);
	public Vector<MemberBean> list();
	public void deleteAll();
	public void delete(String id);
}
