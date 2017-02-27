package com.ltgo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ltgo.dao.PageDao;
import com.ltgo.dao.PriceDao;
import com.ltgo.model.City;
import com.ltgo.model.PlacePage;
import com.ltgo.model.PlacePrice;
import com.ltgo.util.DBHelper;

public class PriceDaoImpl implements PriceDao {

	public List<PlacePrice> showprice(String p_Name) {
		// TODO Auto-generated method stub
		String sql="select p_Id from place where p_Name=?";
		String sql1="select * from placeprice where p_Id=?";
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		List<PlacePrice> list=new ArrayList<PlacePrice>();
		try {
			conn=DBHelper.getConnection();
			pst=conn.prepareStatement(sql);
			pst.setString(1, p_Name);
			rs=pst.executeQuery();
			rs.next();
			int p_Id=rs.getInt("p_Id");
			pst=conn.prepareStatement(sql1);
			pst.setInt(1, p_Id);
			rs=pst.executeQuery();
			while(rs.next()){
				String pp_WebName=rs.getString("pp_WebName");
				double pp_Price=rs.getDouble("pp_Price");
				PlacePrice placeprice=new PlacePrice(pp_WebName,pp_Price);
				list.add(placeprice);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBHelper.close(conn, pst, rs);
		}
		return list;
	}

	public PlacePrice toupdate(String ppWebName) {
		// TODO Auto-generated method stub
		String sql="select * from placeprice where pp_WebName=?";
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			conn=DBHelper.getConnection();
			pst=conn.prepareStatement(sql);
			pst.setString(1, ppWebName);
			rs=pst.executeQuery();
			rs.next();
			PlacePrice placeprice=new PlacePrice(rs.getString("pp_WebName"), rs.getDouble("pp_Price"));
			return placeprice;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	public List<City> showcity(String c_Name) {
		// TODO Auto-generated method stub
	
		String sql="select * from city where c_Name=?";
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		List<City> list=new ArrayList<City>();
		try {
			conn=DBHelper.getConnection();
			pst=conn.prepareStatement(sql);
			pst.setString(1, c_Name);
			rs=pst.executeQuery();
			while(rs.next()){
				int c_Id=rs.getInt("c_Id");
				String c_Ename=rs.getString("c_Ename");
				String c_Photo=rs.getString("c_Photo");
				String c_Localtion=rs.getString("c_Localtion");
				City city=new City(c_Id, c_Name, c_Ename, c_Photo, c_Localtion);
				list.add(city);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBHelper.close(conn, pst, rs);
		}
		return list;
	}

	public City toupdatecity(int c_Id) {
		// TODO Auto-generated method stub
		String sql="select * from city where c_Id=?";
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			conn=DBHelper.getConnection();
			pst=conn.prepareStatement(sql);
			pst.setInt(1, c_Id);
			rs=pst.executeQuery();
			rs.next();
			City city=new City(rs.getInt("c_Id"), rs.getString("c_Name"), rs.getString("c_Ename"), rs.getString("c_Photo"), rs.getString("c_Localtion"));
			return city;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
