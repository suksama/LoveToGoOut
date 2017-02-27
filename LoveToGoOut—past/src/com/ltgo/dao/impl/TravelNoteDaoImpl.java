package com.ltgo.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ltgo.dao.TravelNoteDao;
import com.ltgo.model.TravelNote;
import com.ltgo.model.TravelNotePage;
import com.ltgo.util.DBHelper;


public class TravelNoteDaoImpl implements TravelNoteDao {
	
	public int getPage(int pageSize,String searchContent) {
		Connection conn=null;
		conn = DBHelper.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			if(searchContent ==null){
				pst = conn.prepareStatement("select count(*) from travel_note");
			}else{
				pst = conn.prepareStatement("select count(*) from travel_note WHERE CONCAT(N_Name,N_Writer) LIKE ?");
				pst.setString(1, "%"+searchContent+"%");
			}
//			
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
	
	public TravelNotePage getTravelNoteByPage(int CurrentPage, int pageSize, String searchContent) {
		List<TravelNote> list = new ArrayList<TravelNote>();
		Connection conn=null;
		conn = DBHelper.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		int totalPage = getPage(pageSize,searchContent);
		System.out.println("total="+totalPage);
		String sql = "select * from note limit ?,?";
		String sql1 = "select * from note WHERE CONCAT(n_Name,u_Id) LIKE ? limit ?,?";
		try {
			int start = (CurrentPage-1) * pageSize;
			if(searchContent ==null){
				pst = conn.prepareStatement(sql);
				pst.setInt(1, start);
				pst.setInt(2, pageSize);
			}else{
				pst = conn.prepareStatement(sql1);
				pst.setString(1,"%"+searchContent+"%");
				pst.setInt(2, start);
				pst.setInt(3, pageSize);
			}
			rs = pst.executeQuery();
			while(rs.next()){
				int Nid = rs.getInt("n_Id");
				String Nname = rs.getString("n_Name");
				int Nwriter = rs.getInt("u_Id");
				Date NcreateTime = rs.getDate("n_CreateTime");
				Date NstartTime = rs.getDate("n_StartTime");
				int Ntime = rs.getInt("n_Day");
				int NumOfPoint = rs.getInt("n_NumOfPoint");
				int NnumOfPic = rs.getInt("n_NumOfPic");
				String Nphoto = rs.getString("n_Photo");
				int Ncollect = rs.getInt("n_NumCollect");
				int Nview = rs.getInt("n_NumView");
				TravelNote tNote = new TravelNote(Nid, Nname, Nwriter, NcreateTime, NstartTime, Ntime, NumOfPoint, NnumOfPic, Nphoto, Ncollect, Nview);
				list.add(tNote);
			}
			TravelNotePage page = new TravelNotePage(list, totalPage, CurrentPage);
			return page;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBHelper.close(conn, pst, rs);
		}
		return null;
		
	}
	public boolean deleteTravelNote(int nid) {
		Connection conn=null;
		conn = DBHelper.getConnection();
		PreparedStatement pst = null;
		String sql = "delete from note where n_Id = ?";
		String sql1="delete from notebar where n_Id=?";
		String sql2="delete from discuss where nb_Id";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1,nid);
			int count = pst.executeUpdate();
			if(count>0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	public TravelNote getTravelNoteByNid(int nid) {
		Connection conn=null;
		conn = DBHelper.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "select * from note where n_Id =?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, nid);
			rs = pst.executeQuery();
			if(rs.next()){
				String Nname = rs.getString("n_Name");
				int Nwriter = rs.getInt("u_Id");
				Date NcreateTime = rs.getDate("n_CreateTime");
				Date NstartTime = rs.getDate("n_StartTime");
				int Ntime = rs.getInt("n_Day");
				int NumOfPoint = rs.getInt("n_NumOfPoint");
				int NnumOfPic = rs.getInt("n_NumOfPic");
				String Nphoto = rs.getString("n_Photo");
				int Ncollect = rs.getInt("n_NumCollect");
				int Nview = rs.getInt("n_NumView");
				TravelNote travelNote = new TravelNote(nid, Nname, Nwriter, NcreateTime, NstartTime, Ntime, NumOfPoint, NnumOfPic, Nphoto, Ncollect, Nview);
				return travelNote;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public boolean updateTravelNote(TravelNote travelNote) {
		Connection conn=null;
		conn = DBHelper.getConnection();
		PreparedStatement pst = null;
		String sql = "update note set n_Name=?,u_Id=?,n_CreateTime=?,n_StartTime=?,n_Day=?,n_NumOfPoint=?,n_NumOfPic=?,n_Photo=?,n_NumCollect=?,n_NumView=? where N_Id=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, travelNote.getNname());
			pst.setInt(2, travelNote.getNwriter());
			pst.setDate(3, (java.sql.Date) travelNote.getNcreateTime());
			pst.setDate(4, (java.sql.Date) travelNote.getNstartTime());
			pst.setInt(5, travelNote.getNtime());
			pst.setInt(6, travelNote.getNnumOfPoint());
			pst.setInt(7, travelNote.getNnumOfPic());
			pst.setString(8, travelNote.getNphoto());
			pst.setInt(9, travelNote.getNcollect());
			pst.setInt(10, travelNote.getNview());
			pst.setInt(11, travelNote.getNid());
			int count = pst.executeUpdate();
			if(count>0){
				return true;
			}else{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean addTravelNote(TravelNote travelNote) {
		Connection conn=null;
		conn = DBHelper.getConnection();
		PreparedStatement pst = null;
		String sql = "insert into note values(?,?,?,?,?,?,?,?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, travelNote.getNid());
			pst.setString(2, travelNote.getNname());
			pst.setInt(3, travelNote.getNwriter());
			pst.setDate(4, (java.sql.Date) travelNote.getNcreateTime());
			pst.setDate(5, (java.sql.Date) travelNote.getNstartTime());
			pst.setInt(6, travelNote.getNtime());
			pst.setInt(7, travelNote.getNnumOfPoint());
			pst.setInt(8, travelNote.getNnumOfPic());
			pst.setString(9, travelNote.getNphoto());
			pst.setInt(10, travelNote.getNcollect());
			pst.setInt(11, travelNote.getNview());
			int count = pst.executeUpdate();
			if(count>0){
				return true;
			}else{
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
