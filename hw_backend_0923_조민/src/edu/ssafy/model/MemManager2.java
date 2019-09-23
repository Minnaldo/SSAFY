package edu.ssafy.model;

import java.util.ArrayList;

public class MemManager2 {

	private ArrayList<MemVo> list = new ArrayList<>();
	private static MemManager2 man = new MemManager2();

	private MemManager2() {	}

	public static MemManager2 getInstance()
	{
		return man;
	}

	public boolean addMem(String id, String name, String pw, String addr, int age, String tel)
	{
		list.add(new MemVo(id, name, pw, addr, age, tel));
		return true;
	}
	
	public boolean delMem(String id)
	{
		for(int i = 0; i < list.size(); i++)
		{
			if(list.get(i).getId().equals(id)) {
				list.remove(i);
			}
		}
		return true;
	}
	
	public boolean updateMem(String id, String name, String pw, String addr, int age, String tel)
	{
		for(int i = 0; i < list.size(); i++)
		{
			if(list.get(i).getId().equals(id))
			{
				list.get(i).setName(name);
                list.get(i).setPw(pw);
                list.get(i).setAddr(addr);
                list.get(i).setAge(age);
                list.get(i).setTel(tel);
			}
		}
		
		return true;
	}
	
	public ArrayList<MemVo> getList()
	{
		
		return list;
	}
	
	public MemVo meminfo(String id)
	{
		for (MemVo memVo : list) {
			if(memVo.getId().equals(id))
			{
				return memVo;
			}
		}
		return null;
	}
	
}
