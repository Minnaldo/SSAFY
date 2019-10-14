package edu.ssafy.controller;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class DBCPConnection {
	private static DataSource env;
	
	static {
		try {
			InitialContext initialContext = new InitialContext();
			env = (DataSource) initialContext.lookup("java:comp/env/ssafy/mysql");
			System.out.println("Lookup success");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			System.out.println("Lookup Failed");
		}
		
	}
	
	public static Connection getConnection() throws SQLException {
        Connection conn = null;
        if(env != null) {
            conn = env.getConnection();
            if(conn != null) {
                System.out.println("Connection Success");
            }else {
                System.out.println("Connection Fail");
            }
            return conn;
        }else {
            System.out.println("Connection Fail");
            return env.getConnection();
        }
    }
	
	public static void close(Connection conn, Statement st, ResultSet rs) {
        if(rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if(st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
