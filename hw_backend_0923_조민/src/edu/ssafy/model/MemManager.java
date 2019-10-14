package edu.ssafy.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.ssafy.controller.DBCPConnection;

public class MemManager {

	private ArrayList<MemVo> list = new ArrayList<>();
	private static MemManager man = new MemManager();

	private MemManager() {	}
	
	private Connection conn;
	private PreparedStatement st;
	private ResultSet rs;

	public static MemManager getInstance()
	{
		return man;
	}

	public boolean addMem(String id, String name, String quantity, int price)
	{
		String str = "insert into productdb(id, name, quantity, price) values(?, ?, ?, ?)";
		boolean res = false;
		try {
			conn = DBCPConnection.getConnection();
			
			st = conn.prepareStatement(str);
			st.setString(1, id);
			st.setString(2, name);
			st.setString(3, quantity);
			st.setInt(4, price);
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
		String str = "delete from productdb where id = ?";
		boolean res = false;
		try {
			conn = DBCPConnection.getConnection();
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
	
	public boolean updateMem(String id, String name, String quantity, int price)
	{
		String str = "update productdb set name = ?, pw = ?, quantity = ?, price = ? where id = ?";
		boolean res = false;
		try {
			conn = DBCPConnection.getConnection();
			st = conn.prepareStatement(str);
			st.setString(1, id);
			st.setString(2, name);
			st.setString(3, quantity);
			st.setInt(4, price);
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
		String q = "select * from productdb";
		ArrayList<MemVo> list = null;
		try {
			conn = DBCPConnection.getConnection();
			st = conn.prepareStatement(q);
			rs = st.executeQuery();
			list = new ArrayList<>();
			while(rs.next()) {
				MemVo vo = new MemVo();
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setQuantity(rs.getString("quantity"));
				vo.setPrice(rs.getInt("price"));
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
		String q = "select * from productdb where id = ?";
		MemVo vo = null;
		try {
			conn = DBCPConnection.getConnection();
			st = conn.prepareStatement(q);
			st.setString(1, id);
			rs = st.executeQuery();
			if(rs.next()) {
				vo = new MemVo();
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setQuantity(rs.getString("quantity"));
				vo.setPrice(rs.getInt("price"));
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
			conn = DBCPConnection.getConnection();
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
		String q = "select * from productdb";
		ArrayList<MemVo> list = null;
		try {
			conn = DBCPConnection.getConnection();
			st = conn.prepareStatement(q);
			rs = st.executeQuery();
			list = new ArrayList<>();
			while(rs.next()) {
				if(rs.getString("id").contains(keyword) || rs.getString("id") == "") {
					MemVo vo = new MemVo();
					vo.setId(rs.getString("id"));
					vo.setName(rs.getString("name"));
					vo.setQuantity(rs.getString("quantity"));
					vo.setPrice(rs.getInt("price"));
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
		DBCPConnection.close(conn, st, rs);
	}
	
}
