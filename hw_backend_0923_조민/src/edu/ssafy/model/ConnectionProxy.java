/*package edu.ssafy.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectionProxy {
    
    public static Connection getConnection() throws SQLException { // �뜲�씠�꽣 踰좎씠�뒪瑜� 援먯껜�빐�빞 �븷 �븣 �뿬湲곕쭔 �닔�젙�븯硫� �맖!
        Connection conn = null;
        
        try {
            // 1. �뱶�씪�씠踰� 濡쒕뵫
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2. 而ㅻ꽖�뀡 �뿰寃�
            conn = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/ssafydb?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8", "ssafy",
                    "ssafy");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
        
    }
}*/