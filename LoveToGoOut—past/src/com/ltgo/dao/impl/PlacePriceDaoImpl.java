package com.ltgo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ltgo.dao.PlacePriceDao;
import com.ltgo.model.PlacePrice;
import com.ltgo.util.DBHelper;

public class PlacePriceDaoImpl implements PlacePriceDao{

	@Override
	public int addprice(PlacePrice placeprice) {
		// TODO Auto-generated method stub
		String sql="insert into placeprice(p_Id,pp_WebName,pp_Price) values(?,?,?)";
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			conn=DBHelper.getConnection();
			pst=conn.prepareStatement(sql);
			pst.setInt(1, placeprice.getP_Id());
			pst.setString(2, placeprice.getPp_WebName());
			pst.setDouble(3, placeprice.getPp_Price());
			return pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteprice(PlacePrice placeprice) {
		// TODO Auto-generated method stub
		String sql="delete";
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		try {
			conn=DBHelper.getConnection();
			pst=conn.prepareStatement(sql);
			return pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
}
