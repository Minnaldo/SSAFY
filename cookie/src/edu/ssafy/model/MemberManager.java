package edu.ssafy.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberManager {
	
	private ArrayList<MemberVO> list = new ArrayList<>();
	private static MemberManager man = new MemberManager();
	
	public MemberManager() { }
	
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;
	
	
	public boolean addMember(MemberVO memberVO) {
		String sql = "INSERT INTO members VALUES (?, ?, ?, ? , ?, ?)";
		
		int result = 0;
		try {
			conn = ConnectionProxy.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, memberVO.getName());
			pst.setString(2, memberVO.getUserid());
			pst.setString(3, memberVO.getPwd());
			pst.setString(4, memberVO.getEmail());
			pst.setString(5, memberVO.getPhone());
			pst.setInt(6, memberVO.getAdmin());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			//close
		}
		return result > 0? true:false;
	}
	
	public MemberVO getMember(String userid) {
		String sql = "SELECT * FROM members WHERE userid = ?";
		pst = null;
		MemberVO memberVO = null;
		try {
			conn = ConnectionProxy.getConnection();
			pst = conn.prepareStatement(sql);
			pst.setString(1, userid);
			
			//rs라는 화살표가 맨 위에 있음.
			rs = pst.executeQuery();	//DDL은 execute  DML은 executeUpdate  DQL 은 executeQuery
			
			//rs 화살표가 한 칸 내려가고, 내려갈 수 있으면 true 없으면 false
			if(rs.next()) {
				memberVO = new MemberVO();
				memberVO.setName( rs.getString("name"));
				memberVO.setUserid( rs.getString("userid"));
				memberVO.setPwd( rs.getString("pwd"));
				memberVO.setEmail( rs.getString("email"));
				memberVO.setPhone( rs.getString("phone"));
				memberVO.setAdmin( rs.getInt("admin"));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			
		}

		return memberVO;
	}
	
	public List<MemberVO> getMemberList() {
		String sql = "SELECT * FROM members";
		ArrayList<MemberVO> memberlist = new ArrayList<>();
		MemberVO memberVO = null;
		try {
			conn = ConnectionProxy.getConnection();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while( rs.next() ) {
				memberVO = new MemberVO();
				memberVO.setName( rs.getString("name"));
				memberVO.setUserid( rs.getString("userid"));
				memberVO.setPwd( rs.getString("pwd"));
				memberVO.setEmail( rs.getString("email"));
				memberVO.setPhone( rs.getString("phone"));
				memberVO.setAdmin( rs.getInt("admin"));
				memberlist.add(memberVO);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return memberlist;
	}
	
	
}
