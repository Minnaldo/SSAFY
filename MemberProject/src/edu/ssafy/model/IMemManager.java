package edu.ssafy.model;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IMemManager {
		
	public boolean addMem(String id, String name, String pw, int age, String addr, String tel);
	
	public boolean delMem(String id);
	
	public boolean updateMem(String id, String name, String pw, int age, String addr, String tel);
	
	public ArrayList<MemVo> getList();
	
	public MemVo memInfo(String id);
	
	public boolean loginmem(String id, String pw);
	
	public ArrayList<MemVo> nameFind(String keyword);
	
	
	public void close();
}
