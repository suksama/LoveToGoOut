package com.ltgo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ltgo.dao.PageDao;
import com.ltgo.model.PlacePage;
import com.ltgo.model.PlacePrice;
import com.ltgo.model.PlaceView;
import com.ltgo.util.DBHelper;

public class PageDaoImpl implements PageDao {

	public int getPage(int pageSize,String searchcontent) {
		// TODO Auto-generated method stub
		Connection conn=null;
		conn = DBHelper.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			if(searchcontent == null){
				pst = conn.prepareStatement("select count(*) from place");
			}else{
				pst = conn.prepareStatement("select count(*) from place where p_Name like ?");
				pst.setString(1, "%"+searchcontent+"%");
			}
			rs = pst.executeQuery();
			if(rs.next()){
				int total = rs.getInt(1);
				//total=9  pageSize=3
				return (total + pageSize - 1) / pageSize;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBHelper.close(conn, pst, rs);
		}
		return 0;
	}

	public PlacePage getPlaceBypage(int currentPage, int pageSize,String searchcontent) {
		// TODO Auto-generated method stub
		List<PlaceView> list = new ArrayList<PlaceView>();
		PreparedStatement pst = null;
		ResultSet rs = null;
		Connection exe=null;
		ResultSet rs1=null;
		PreparedStatement pst1=null;
		int totalPage = getPage(pageSize,searchcontent);
		try {
			exe=DBHelper.getConnection();
			int start = (currentPage - 1) * pageSize;
			if(searchcontent==null){
				pst = exe.prepareStatement("select * from place   limit ?,?");
				pst.setInt(1, start);
				pst.setInt(2, pageSize);
			}else{
				pst=exe.prepareStatement("select * from place where p_Name=? limit ?,?");
				pst.setString(1,searchcontent);
				pst.setInt(2, start);
				pst.setInt(3, pageSize);
			}
			
			rs = pst.executeQuery();
			
			while(rs.next()){
				int p_Id=rs.getInt("p_Id");
				String p_Name=rs.getString("p_Name");
				String p_Ename=rs.getString("p_Ename");
				int c_Id=rs.getInt("c_Id");
				String p_photo=rs.getString("p_photo");
				String p_Text=rs.getString("p_Text");
				double p_local=rs.getDouble("p_local");
				String sql1="select * from city where c_Id=?";	
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
			PlacePage page = new PlacePage(list, totalPage, currentPage);
			return page;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBHelper.close(exe, pst, rs);
			DBHelper.close(exe, pst1, rs1);
		}
		return null;
	}

	public List<PlacePrice> showprice() {
		// TODO Auto-generated method stub
		String sql="select p_Id from place where p_Name=?";
		Connection conn=null;
		PreparedStatement pst=null;
		ResultSet rs=null;
		List<PlacePrice> list=new ArrayList<PlacePrice>();
		try {
			conn=DBHelper.getConnection();
//			pst=conn.prepareStatement(sql);
//			pst.setString(1, p_Name);
//			rs=pst.executeQuery();
//			rs.next();
//			int p_Id=rs.getInt("p_Id");
			String sql1="select * from placeprice";
			pst=conn.prepareStatement(sql1);
	//		pst.setInt(1, p_Id);
			rs=pst.executeQuery();
			while(rs.next()){
				String pp_WebName=rs.getString("pp_WebName");
				double pp_Price=rs.getDouble("pp_Price");
				PlacePrice placePrice=new PlacePrice(pp_WebName,pp_Price);
				list.add(placePrice);
				
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

}
