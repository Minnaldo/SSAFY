package edu.ssafy.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface IMemManager {

	public boolean addMem(String id, String name, String quantity, int price);
	
	public boolean delMem(String id);
	
	public boolean updateMem(String id, String name, String quantity, int price);
	
	public ArrayList<MemVo> getList();
	
	public MemVo memInfo(String id);
	
	public boolean loginmem(String id, String pw);
	
	public ArrayList<MemVo> nameFind(String keyword);
	
	
	public void close();
	
}
