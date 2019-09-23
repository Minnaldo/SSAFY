package edu.ssafy.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemManagerImpl implements IMemManager{

	private ArrayList<MemVo> list = new ArrayList<>();
	private static MemManagerImpl man = new MemManagerImpl();

	public MemManagerImpl() {	}
	
	private Connection conn;
	private PreparedStatement st;
	private ResultSet rs;

	public static MemManagerImpl getInstance()
	{
		
		return man;
	}

	public boolean addMem(String id, String name, String pw, int age, String addr, String tel)
	{
		String str = "insert into memberweb(id, name, pw, age, addr, tel) values(?, ?, ?, ?, ?, ?)";
		boolean res = false;
		try {
			conn = ConnectionProxy.getConnection();
			
			st = conn.prepareStatement(str);
			st.setString(1, id);
			st.setString(2, name);
			st.setString(3, pw);
			st.setInt(4, age);
			st.setString(5, addr);
			st.setString(6, tel);
			res = st.execute();
			res = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			res = false;
			e.printStackTrace();
		} finally {
			close();
		}
		return res;
	}
	
	public boolean delMem(String id)
	{
		String str = "delete from memberweb where id = ?";
		boolean res = false;
		try {
			conn = ConnectionProxy.getConnection();
			st = conn.prepareStatement(str);
			st.setString(1, id);
			st.execute();
			res = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			res = false;
		} finally {
			close();
		}
		return res;
	}
	
	public boolean updateMem(String id, String name, String pw, int age, String addr, String tel)
	{
		String str = "update memberweb set name = ?, pw = ?, addr = ?, age = ?, tel = ? where id = ?";
		boolean res = false;
		try {
			conn = ConnectionProxy.getConnection();
			st = conn.prepareStatement(str);
			st.setString(1, name);
			st.setString(2, pw);
			st.setString(3, addr);
			st.setInt(4, age);
			st.setString(5, tel);
			st.setString(6, id);
			st.execute();
			res = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			res = false;
		}finally {
			close();
		}
		return res;
	}
	
	public ArrayList<MemVo> getList()
	{
		String q = "select * from memberweb";
		ArrayList<MemVo> list = null;
		try {
			conn = ConnectionProxy.getConnection();
			st = conn.prepareStatement(q);
			rs = st.executeQuery();
			list = new ArrayList<>();
			while(rs.next()) {
				MemVo vo = new MemVo();
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setPw(rs.getString("pw"));
				vo.setAge(rs.getInt("age"));
				vo.setAddr(rs.getString("addr"));
				vo.setTel(rs.getString("tel"));
				list.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}
	
	public MemVo memInfo(String id)
	{
		String q = "select * from memberweb where id = ?";
		MemVo vo = null;
		try {
			conn = ConnectionProxy.getConnection();
			st = conn.prepareStatement(q);
			st.setString(1, id);
			rs = st.executeQuery();
			if(rs.next()) {
				vo = new MemVo();
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setPw(rs.getString("pw"));
				vo.setAge(rs.getInt("age"));
				vo.setAddr(rs.getString("addr"));
				vo.setTel(rs.getString("tel"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}
	
	public boolean loginmem(String id, String pw) {
		// TODO Auto-generated method stub
		String q = "select * from memberweb where id = ? and pw = ?";
		try {
			conn = ConnectionProxy.getConnection();
			st = conn.prepareStatement(q);
			st.setString(1, id);
			st.setString(2, pw);
			rs = st.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public ArrayList<MemVo> nameFind(String keyword) {
		// TODO Auto-generated method stub
		String q = "select * from memberweb";
		ArrayList<MemVo> list = null;
		try {
			conn = ConnectionProxy.getConnection();
			st = conn.prepareStatement(q);
			rs = st.executeQuery();
			list = new ArrayList<>();
			while(rs.next()) {
				if(rs.getString("name").contains(keyword) || rs.getString("name") == "") {
					MemVo vo = new MemVo();
					vo.setId(rs.getString("id"));
					vo.setName(rs.getString("name"));
					vo.setAge(rs.getInt("age"));
					vo.setAddr(rs.getString("addr"));
					vo.setTel(rs.getString("tel"));
					list.add(vo);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	
	public void close() {
		try {
			if(rs != null) rs.close();
			if(st != null) st.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
