package com.ltgo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ltgo.dao.ManagerDao;
import com.ltgo.model.Manager;
import com.ltgo.model.ManagerPage;
import com.ltgo.util.DBHelper;

public class ManagerDaoImpl implements ManagerDao{

	public List<Manager> getAllManagers() {
		List<Manager> list=new ArrayList<Manager>();
		Connection conn=null;
		conn = DBHelper.getConnection();
		Statement st=null;
		ResultSet rs=null;
		try {
			st=conn.createStatement();
			rs=st.executeQuery("select * from user");
			while(rs.next()){
				String account=rs.getString("u_Account");
				String password=rs.getString("u_password");
				String sex=rs.getString("u_Sex");
				String email=rs.getString("u_email");
				String time=rs.getString("u_time");
				Manager Manager=new Manager(account, password, sex, email, time);
				list.add(Manager);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBHelper.closeAll(conn, st, rs);
		}
		return list;
	}

	public boolean deleteManagerByAccount(String account) {
		Connection conn=null;
		conn = DBHelper.getConnection();
		PreparedStatement pst=null;
		try {
			pst=conn.prepareStatement("delete from user where u_Account=?");
			pst.setString(1, account);
			int count=pst.executeUpdate();
			if(count>0){
				return true;
			}else{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBHelper.closeAll(conn, pst, null);
		}
		return false;
	}

	public Manager getManagerByAccount(String account) {
		Connection conn=null;
		conn = DBHelper.getConnection();
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			pst=conn.prepareStatement("select * from user where u_Account=?");
			pst.setString(1, account);
			rs=pst.executeQuery();
			if(rs.next()){
				String password=rs.getString("u_password");
				String sex=rs.getString("u_Sex");
				String email=rs.getString("u_email");
				String time=rs.getString("u_time");
				Manager m=new Manager(account, password, sex, email, time);
				return m;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBHelper.closeAll(conn, pst, rs);
		}
		return null;
	}

	public boolean updateManager(Manager manager) {
		Connection conn=null;
		conn = DBHelper.getConnection();
		PreparedStatement pst=null;
		try {
			pst=conn.prepareStatement("update user set u_password=?,u_Sex=?,u_email=?,u_time=? where u_Account=?");
			pst.setString(1, manager.getPassword());
			pst.setString(2, manager.getSex());
			pst.setString(3, manager.getEmail());
			pst.setString(4, manager.getTime());
			pst.setString(5, manager.getAccount());
			int count=pst.executeUpdate();
			if(count>0){
				return true;
			}else{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBHelper.closeAll(conn, pst, null);
		}
		return false;
	}

	public int getPage(int pagesize){
		Connection conn=null;
		conn = DBHelper.getConnection();
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			pst=conn.prepareStatement("select count(*) from user");
			rs=pst.executeQuery();
			if(rs.next()){
				int total=rs.getInt(1);
				return (total+pagesize-1)/pagesize;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBHelper.closeAll(conn, pst, rs);
		}
		return 0;
	}
	
	public ManagerPage getManagerByPage(int currentPage,int pageSize){
		List<Manager> list=new ArrayList<Manager>();
		Connection conn=null;
		conn = DBHelper.getConnection();
		PreparedStatement pst=null;
		ResultSet rs=null;
		int totalPage=getPage(pageSize);
		int start=(currentPage-1)*pageSize;
		try {
			pst=conn.prepareStatement("select * from user limit ?,?");
			pst.setInt(1, start);
			pst.setInt(2, pageSize);
			rs=pst.executeQuery();
			while(rs.next()){
				String account=rs.getString("u_Account");
				String password=rs.getString("u_password");
				String sex=rs.getString("u_Sex");
				String email=rs.getString("u_email");
				String time=rs.getString("u_time");
				Manager m=new Manager(account, password, sex, email, time);
				list.add(m);
			}
			ManagerPage page=new ManagerPage(list, totalPage, currentPage);
			return page;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBHelper.closeAll(conn, pst, rs);
		}
		return null;
	}

	
	public boolean addManager(Manager manager) {
		Connection conn=null;
		conn = DBHelper.getConnection();
		PreparedStatement pst=null;
		try {
			pst=conn.prepareStatement("insert into user(u_Account,u_password,u_Sex,u_email,u_time) values(?,?,?,?,?)");
			pst.setString(1, manager.getAccount());
			pst.setString(2, manager.getPassword());
			pst.setString(3, manager.getSex());
			pst.setString(4, manager.getEmail());
			pst.setString(5, manager.getTime());
			int count=pst.executeUpdate();
			if(count>0){
				return true;
			}else{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBHelper.closeAll(conn, pst, null);
		}
		return false;
	}

}
