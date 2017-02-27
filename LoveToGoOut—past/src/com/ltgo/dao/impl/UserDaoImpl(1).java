package com.ltgo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ltgo.dao.UserDao;
import com.ltgo.model.Notes;
import com.ltgo.model.Place;
import com.ltgo.model.PlaceView;
import com.ltgo.model.User;
import com.ltgo.util.DBHelper;

public class UserDaoImpl implements UserDao {

	DBHelper conn=new DBHelper();
	PreparedStatement pst=null;
	ResultSet rs=null;
	Statement st =null;
	
	
	
	public List<PlaceView> getplace() {
		// TODO Auto-generated method stub
		String sql="select * from place ";
		String sql1="select * from city where c_Id=?";
		String sql2="select * from placeprice where p_Id=?";
		List<PlaceView> list=new ArrayList<PlaceView>();
		PreparedStatement pst=null;
		ResultSet rs1=null;
		PreparedStatement pst1=null;
		Connection exe=null;
		try {
			exe=conn.getConnection();
			pst=exe.prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()){
				int p_Id=rs.getInt("p_Id");
				String p_Name=rs.getString("p_Name");
				String p_Ename=rs.getString("p_Ename");
				int c_Id=rs.getInt("c_Id");
				String p_photo=rs.getString("p_photo");
				String p_Text=rs.getString("p_Text");
				double p_local=rs.getDouble("p_local");
				
				pst1=exe.prepareStatement(sql1);
				pst1.setInt(1, c_Id);
				rs1=pst1.executeQuery();
				String c_Name=null;
				String c_Ename=null;
				rs1.next();
				c_Name=rs1.getString(2);
				c_Ename=rs1.getString(3);
				
				
				
				PlaceView placeview=new PlaceView(p_Id, p_Name, p_Ename, p_Text, 0, c_Id,c_Name, c_Ename);
				list.add(placeview);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			conn.close(exe, pst, rs);
			conn.close(exe, pst1, rs1);
		}
		
		return null;
	}
	
	public List<PlaceView> showplace(int id) {
		// TODO Auto-generated method stub
		String sql="select * from place where p_id="+id;
		String sql1="select * from city where c_Id=?";
		String sql2="select * from placeprice where p_Id=?";
		List<PlaceView> list=new ArrayList<PlaceView>();
		PreparedStatement pst=null;
		ResultSet rs1=null;
		PreparedStatement pst1=null;
		Connection exe=null;
		try {
			exe=conn.getConnection();
			pst=exe.prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()){
				int p_Id=rs.getInt("p_Id");
				String p_Name=rs.getString("p_Name");
				String p_Ename=rs.getString("p_Ename");
				int c_Id=rs.getInt("c_Id");
				String p_photo=rs.getString("p_photo");
				String p_Text=rs.getString("p_Text");
				double p_local=rs.getDouble("p_local");
				
				pst1=exe.prepareStatement(sql1);
				pst1.setInt(1, c_Id);
				rs1=pst1.executeQuery();
				String c_Name=null;
				String c_Ename=null;
				rs1.next();
				c_Name=rs1.getString(2);
				c_Ename=rs1.getString(3);
				
				
				
				PlaceView placeview=new PlaceView(p_Id, p_Name, p_Ename, p_Text, 0,c_Id, c_Name, c_Ename);
				list.add(placeview);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			conn.close(exe, pst, rs);
			conn.close(exe, pst1, rs1);
		}
		
		return null;
	}
	public int deleteTourist(int id) {
		// TODO Auto-generated method stub
		String sql="Delete from place where p_Id="+id;
		String sql1="delete from placeprice where p_Id="+id;
		
		Connection exe=null;
		try {
			exe = conn.getConnection();
			st=exe.createStatement();
			st.executeUpdate(sql1);
			return st.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			conn.close(exe, null, rs);
			if(st!=null){
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return 0;
	}
	public int alterTourist(PlaceView placeView){
		String sql="update place set p_Name=?,p_Ename=?,p_Text=?,p_local=?,c_Id=? where p_id=?";
		String sql1="";
		Connection conn=null;
		try {
			conn=DBHelper.getConnection();
			pst=conn.prepareStatement(sql);
			pst.setString(1, placeView.getP_Name());
			pst.setString(2, placeView.getP_Ename());
			pst.setString(3,placeView.getP_Text());
			pst.setDouble(4, placeView.getP_Local());
			pst.setInt(5, placeView.getC_Id());
			pst.setInt(6,placeView.getP_Id() );
			return pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBHelper.close(conn, pst, null);
		}
		
		return 0;
		
	}
	public void page(){
		UserDaoImpl udi=new UserDaoImpl();
		//udi.gettourist().size();
	}
	public int addplace(String pName, String pEname, String pText,
			String cName) {
		// TODO Auto-generated method stub
		String sql1="select c_Id from city where c_Name=?";
		String sql="insert into place(p_Name,p_Ename,c_Id,p_photo,p_Text,p_local) values(?,?,?,?,?,?) ";
		String sql2="insert into placeprice(p_Id,pp_WebName,pp_Price) values(?,?,?)";
		Connection conn=null;
		PreparedStatement pst1=null;
		try {
			conn=DBHelper.getConnection();
			pst=conn.prepareStatement(sql1);
			pst.setString(1, cName);
			rs=pst.executeQuery();
			rs.next();
			int cityId=rs.getInt("c_Id");
//			System.out.println(cityId);
			pst1=conn.prepareStatement(sql);
			pst1.setString(1, pName);
			pst1.setString(2, pEname);
			pst1.setInt(3, cityId);
			pst1.setString(4, "null");
			pst1.setString(5, pText);
			pst1.setDouble(6, 0);
			return pst1.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBHelper.close(conn, pst1, rs);
			DBHelper.close(null, pst, null);
		}
		return 0;
	}

	@Override
	public int save(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isSccuess(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int savenotes(Notes note) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
