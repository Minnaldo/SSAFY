package edu.ssafy.model;

import java.util.ArrayList;

public class Manager {
	private static Manager man = new Manager();
	private ArrayList<Member> list = new ArrayList<>();
	
	private Manager() {
		
	}
	
	public static Manager getInstance()
	{
		return man;
	}
	
	public boolean addMember(String name, String id, String passwd)
	{
		list.add(new Member(name, id, passwd));
		return true;
	}
	
	public boolean find_Id(String id, String passwd)
	{
		for(Member member : list)
		{
			if(member.getId().equals("ssafy") && member.getPasswd().equals("1111"))
			{
				return true;
			}
		}
		return false;
	}
}
