package edu.ssafy.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemManagerImpl implements IMemManager{

	private Connection conn;
	private PreparedStatement st;
	private ResultSet rs;

	@Override
	public boolean addMem(String id, String pw, String name, String addr, String email, String tel, String alinfo) {
		String str = "insert into memtb(id, pw, name, addr, email, tel, alinfo) values(?, ?, ?, ?, ?, ?, ?)";
		boolean res = false;
		try {
			conn = ConnectionProxy.getConnection();
			st = conn.prepareStatement(str);
			st.setString(1, id);
			st.setString(2, pw);
			st.setString(3, name);
			st.setString(4, addr);
			st.setString(5, email);
			st.setString(6, tel);
			st.setString(7, alinfo);
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

	@Override
	public boolean isLogin(String id, String pw) {
        // TODO Auto-generated method stub
        String sql = "select * from memtb where id=? and pw=?";
        boolean res = false;
        try {
            conn = ConnectionProxy.getConnection();
            
            st = conn.prepareStatement(sql);
            st.setString(1, id);
            st.setString(2, pw);
            rs = st.executeQuery();
			return true;
            /*rs.last();
            int cnt=rs.getRow();
            if(cnt==1) {
                res=true;
            }*/
        } catch (SQLException e) {
            // TODO Auto-generated catch block
        	res = false;
            e.printStackTrace();
        } finally {
            close();
        }
        
        return res;
    }


	@Override
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

	@Override
	public ArrayList<MemVO> getList() {
		String q = "select * from memtb";
		ArrayList<MemVO> list = null;
		try {
			conn = ConnectionProxy.getConnection();
			st = conn.prepareStatement(q);
			rs = st.executeQuery();
			list = new ArrayList<>();
			while(rs.next()) {

				//(String id, String pw, String name, String addr, String email, String tel, String alinfo)
				MemVO vo = new MemVO();
				vo.setId(rs.getString("pid"));
				vo.setPw(rs.getString("ppw"));
				vo.setName(rs.getString("pname"));
				vo.setAddr(rs.getString("paddr"));
				vo.setEmail(rs.getString("pemail"));
				vo.setTel(rs.getString("ptel"));
				vo.setAlinfo(rs.getString("palinfo"));
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

	@Override
	public boolean updateMem(String id, String pw, String name, String addr, String email, String tel, String alinfo) {
		String str="update memtb set pw=?,name=?,addr=?,email=?,tel=?,alinfo=? where id=?";
		boolean res=true;
		try {
			conn=ConnectionProxy.getConnection();
			st=conn.prepareStatement(str);
			st.setString(1, pw);
			st.setString(2, name);
			st.setString(3, addr);
			st.setString(4, email);
			st.setString(5, tel);
			st.setString(6, alinfo);
			st.setString(7, id);
			st.execute();
			res = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			res=false;
		}finally {
			close();
		}
		return res;
	}

	@Override
	//아이디로 회원 삭제
	public boolean delMem(String id) {
		String str = "delete from memtb where id = ?";
		boolean res = false;
		try {
			conn=ConnectionProxy.getConnection();
			st = conn.prepareStatement(str);
			st.setString(1, id);
			st.execute();
			res=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return res;
	}

}
