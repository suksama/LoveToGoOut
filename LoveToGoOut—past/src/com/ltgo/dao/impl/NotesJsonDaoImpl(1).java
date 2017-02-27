package com.ltgo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ltgo.json.model.AddressJson;
import com.ltgo.json.model.DestinationDetailsJson;
import com.ltgo.json.model.NoteBarJson;
import com.ltgo.json.model.NotesJson;
import com.ltgo.json.model.presonNoteJson;
import com.ltgo.model.TravelNote;
import com.ltgo.util.DBHelper;

public class NotesJsonDaoImpl {
	@SuppressWarnings("resource")
	public List<NotesJson> getTravelNoteJson() {
		List<NotesJson> list = new ArrayList<NotesJson>();
		Connection conn=null;
		conn = DBHelper.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		String sql = "select * from note";
		
		try {
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				int Nid=rs.getInt("n_Id");
				String Nname = rs.getString("n_Name");
				Date NstartTime = rs.getDate("n_StartTime");
				String Nphoto = rs.getString("n_Photo");
				int Nwriter = rs.getInt("u_Id");
				String sql1="select * from user where u_Id=?";
				pst=conn.prepareStatement(sql1);
				pst.setInt(1, Nwriter);
				System.out.println(Nwriter);
				rs1=pst.executeQuery();
				String nj_icon = null;
				while(rs1.next()){
					nj_icon=rs1.getString("u_Account");
				}
				NotesJson notesJson = new NotesJson(Nid,Nname, NstartTime.toString(), Nphoto, nj_icon);
				list.add(notesJson);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBHelper.close(conn, pst, rs);
		}
		return null;
		
	}
	public List<AddressJson> getAddressJson1(){
		List<AddressJson> aj_list=new ArrayList<AddressJson>();
		Connection conn=null;
		conn = DBHelper.getConnection();
		String localtion="国内";
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "select * from city where c_Localtion=?";
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, localtion);
			rs=pst.executeQuery();
			while (rs.next()) {
				int c_id=rs.getInt("c_Id");
				String aj_Name=rs.getString("c_Name");
				String aj_Ename=rs.getString("c_Ename");
				String aj_imgUrl=rs.getString("c_Photo");
				AddressJson addressjson=new AddressJson(c_id,aj_Name, aj_Ename, aj_imgUrl, 121);
				aj_list.add(addressjson);
			}
			return aj_list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBHelper.close(conn, pst, rs);
		}
		
		return null;
		
	}
	public List<AddressJson> getAddressJson2(){
		List<AddressJson> aj_list=new ArrayList<AddressJson>();
		Connection conn=null;
		conn = DBHelper.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String localtion="国外";
		String sql = "select * from city where c_Localtion=?";
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, localtion);
			rs=pst.executeQuery();
			while (rs.next()) {
				int c_id=rs.getInt("c_Id");
				String aj_Name=rs.getString("c_Name");
				String aj_Ename=rs.getString("c_Ename");
				String aj_imgUrl=rs.getString("c_Photo");
				AddressJson addressjson=new AddressJson(c_id,aj_Name, aj_Ename, aj_imgUrl, 121);
				aj_list.add(addressjson);
			}
			return aj_list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBHelper.close(conn, pst, rs);
		}
		return null;
	}
	public List<DestinationDetailsJson> getDestinationDetailsJson(int aj_Id){
		List<DestinationDetailsJson> ddj_list=new ArrayList<DestinationDetailsJson>();
		Connection conn=null;
		conn = DBHelper.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "select * from place where c_Id=?";
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, aj_Id);
			rs=pst.executeQuery();
			while(rs.next()){
				String ddj_Name=rs.getString("p_Name");
				String ddj_imgUrl=rs.getString("p_photo");
				int ddj_Id=rs.getInt("p_Id");
				DestinationDetailsJson addressStrategyJson=new DestinationDetailsJson(ddj_Name, ddj_imgUrl, ddj_Id);
				ddj_list.add(addressStrategyJson);
			}
			return ddj_list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBHelper.close(conn, pst, rs);
		}
		return null;
		
	}
	public List<NoteBarJson> getNoteBarJson(int n_Id){
		List<NoteBarJson> nbj_list=new ArrayList<NoteBarJson>();
		Connection conn=null;
		conn = DBHelper.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		ResultSet rs1=null;
		String sql = "select * from notebar where n_Id=?";
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, n_Id);
			rs=pst.executeQuery();
			while(rs.next()){
				int nbj_Id=rs.getInt("nb_Id");
				int nj_Id=rs.getInt("n_Id");
				String nbj_Text=rs.getString("nb_text");
				String nbj_imgUrl=rs.getString("nb_photo");
				String nbj_Time=rs.getDate("nb_data").toString();
				int p_Id=rs.getInt("p_Id");
				String sql1="select * from place where p_Id=?";
				pst=conn.prepareStatement(sql1);
				pst.setInt(1,p_Id);
				rs1=pst.executeQuery();
				String nbj_placename=null;
				while(rs1.next()){
					nbj_placename=rs1.getString("p_Name");
				}
				NoteBarJson noteBarJson=new NoteBarJson(nbj_Id, nj_Id, nbj_Text, nbj_imgUrl, nbj_Time, p_Id, nbj_placename);
				nbj_list.add(noteBarJson);
			}
			return nbj_list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	public List<presonNoteJson> getRouteJson(int u_id){
		List<presonNoteJson> pnj_list=new ArrayList<presonNoteJson>();
		Connection conn=null;
		conn = DBHelper.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "select * from route where u_Id=?";
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, u_id);
			rs=pst.executeQuery();
			while(rs.next()){
				int pnj_Day=rs.getInt("r_Day");
				String pnj_Name=rs.getString("r_name");
				String pnj_CreateTime=rs.getDate("r_CreateTime").toString();
				presonNoteJson pnj=new presonNoteJson(pnj_Day, pnj_CreateTime, pnj_Name);
				pnj_list.add(pnj);
			}
			return pnj_list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	public void addRouteJson(int u_Id,List<String> list){
		Connection conn=null;
		conn = DBHelper.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		int p_Id=Integer.valueOf(list.get(0));
		String sql1="select * from place where p_Id=?";
		String sql = "insert into route(r_name,u_Id,r_CreateTime,r_StartTime,r_Day,r_photo)values(?,?,?,?,?,?)";
		try {
			pst=conn.prepareStatement(sql1);
			pst.setInt(1, p_Id);
			rs=pst.executeQuery();
			while(rs.next()){
				String r_Name=rs.getString("p_Name");
				String r_imageUrl=rs.getString("p_photo");
				pst=conn.prepareStatement(sql);
				pst.setString(1, r_Name);
				pst.setInt(2, u_Id);
				Date dt=new Date();
			    SimpleDateFormat matter1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			    pst.setDate(3, (java.sql.Date) dt);
				pst.setDate(4,(java.sql.Date) matter1.parse(list.get(list.size()-1)+"00:00:00") );
				pst.setInt(5, 3);
				pst.setString(6, r_imageUrl);
				pst.executeQuery();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
}
