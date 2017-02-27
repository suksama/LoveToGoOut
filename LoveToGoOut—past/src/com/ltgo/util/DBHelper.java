package com.ltgo.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBHelper {
	public static Connection getConnection(){
		Connection conn=null;
		Statement smt = null;
		try {
//			InputStream is=DBHelper.class.getResourceAsStream("/db.properties");
//			Properties prop=new Properties();
//			prop.load(is);
			String drivername="com.mysql.jdbc.Driver";
			String url="jdbc:mysql://localhost:3306/project";
			String name="root";
			String pass="123456";
			Class.forName(drivername);
			conn=DriverManager.getConnection(url, name, pass);
			return conn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return null;
		
	}
	
	public static void closeAll(Connection con,Statement sta,ResultSet res){
		if(res!=null){
			try {
				res.close();
				res=null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(sta!=null){
			try {
				sta.close();
				sta=null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(con!=null){
			try {
				con.close();
				con=null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void close(Connection conn,PreparedStatement pst,ResultSet rs){
		if (conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if (pst!=null) {
			try {
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if (rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
