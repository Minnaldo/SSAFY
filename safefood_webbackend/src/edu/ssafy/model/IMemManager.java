package edu.ssafy.model;

import java.util.ArrayList;

public interface IMemManager {
	public void close();
	public boolean addMem(String id,String pw,String name,String addr,String email,String tel,String alinfo);
	public boolean isLogin(String id, String pw);
	public boolean updateMem(String id, String pw, String name, String addr, String email, String tel, String alinfo);
	public boolean delMem(String id);
	
	public ArrayList<MemVO> getList();
}