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
import com.ltgo.json.model.CommentBean;
import com.ltgo.json.model.DestinationDetailsJson;
import com.ltgo.json.model.NewNote;
import com.ltgo.json.model.NoteBarJson;
import com.ltgo.json.model.NotePage;
import com.ltgo.json.model.NotesJson;
import com.ltgo.json.model.PDJSon;
import com.ltgo.json.model.PublishCommit;
import com.ltgo.json.model.ReplyBean;
import com.ltgo.json.model.ReviseNote;
import com.ltgo.json.model.presonNoteJson;
import com.ltgo.model.TravelNote;
import com.ltgo.util.DBHelper;

public class NotesJsonDaoImpl {
	@SuppressWarnings("resource")
	public List<NotesJson> getTravelNoteJson(int ispublish) {
		List<NotesJson> list = new ArrayList<NotesJson>();
		Connection conn = null;
		conn = DBHelper.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		String sql = "select * from note where ispublish=?";

		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, ispublish);
			rs = pst.executeQuery();
			
			while (rs.next()) {
				int Nid = rs.getInt("n_Id");
				String Nname = rs.getString("n_Name");
				String NstartTime = rs.getString("n_StartTime");
				String Nphoto = rs.getString("n_Photo");
				int Nwriter = rs.getInt("u_Id");
				String sql1 = "select * from user where u_Id=?";
				pst = conn.prepareStatement(sql1);
				pst.setInt(1, Nwriter);
				rs1 = pst.executeQuery();
				String nj_icon = null;
				while (rs1.next()) {
					nj_icon = rs1.getString("u_HeadPortrait");
					
				}
				NotesJson notesJson = new NotesJson(Nid, Nname, NstartTime, Nphoto, nj_icon);
				list.add(notesJson);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelper.close(conn, pst, rs);
		}
		return null;

	}

	public List<AddressJson> getAddressJson1() {
		List<AddressJson> aj_list = new ArrayList<AddressJson>();
		Connection conn = null;
		conn = DBHelper.getConnection();
		String localtion = "国内";
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "select * from city where c_Localtion=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, localtion);
			rs = pst.executeQuery();
			while (rs.next()) {
				int c_id = rs.getInt("c_Id");
				String aj_Name = rs.getString("c_Name");
				String aj_Ename = rs.getString("c_Ename");
				String aj_imgUrl = rs.getString("c_Photo");
				AddressJson addressjson = new AddressJson(c_id, aj_Name, aj_Ename, aj_imgUrl, 121);
				aj_list.add(addressjson);
			}
			return aj_list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelper.close(conn, pst, rs);
		}

		return null;

	}

	public List<AddressJson> getAddressJson2() {
		List<AddressJson> aj_list = new ArrayList<AddressJson>();
		Connection conn = null;
		conn = DBHelper.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String localtion = "国外";
		String sql = "select * from city where c_Localtion=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, localtion);
			rs = pst.executeQuery();
			while (rs.next()) {
				int c_id = rs.getInt("c_Id");
				String aj_Name = rs.getString("c_Name");
				String aj_Ename = rs.getString("c_Ename");
				String aj_imgUrl = rs.getString("c_Photo");
				AddressJson addressjson = new AddressJson(c_id, aj_Name, aj_Ename, aj_imgUrl, 121);
				aj_list.add(addressjson);
			}
			return aj_list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelper.close(conn, pst, rs);
		}
		return null;
	}

	public List<DestinationDetailsJson> getDestinationDetailsJson(int aj_Id) {
		List<DestinationDetailsJson> ddj_list = new ArrayList<DestinationDetailsJson>();
		Connection conn = null;
		conn = DBHelper.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "select * from place where c_Id=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, aj_Id);
			rs = pst.executeQuery();
			while (rs.next()) {
				String ddj_Name = rs.getString("p_Name");
				String ddj_imgUrl = rs.getString("p_photo");
				int ddj_Id = rs.getInt("p_Id");
				DestinationDetailsJson addressStrategyJson = new DestinationDetailsJson(ddj_Name, ddj_imgUrl, ddj_Id);
				ddj_list.add(addressStrategyJson);
			}
			return ddj_list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelper.close(conn, pst, rs);
		}
		return null;

	}

	public List<NoteBarJson> getNoteBarJson(int n_Id) {
		List<NoteBarJson> nbj_list = new ArrayList<NoteBarJson>();
		Connection conn = null;
		conn = DBHelper.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		String sql = "select * from notebar where n_Id=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, n_Id);
			rs = pst.executeQuery();
			while (rs.next()) {
				int nbj_Id = rs.getInt("nb_Id");
				int nj_Id = rs.getInt("n_Id");
				String nbj_Text = rs.getString("nb_text");
				String nbj_imgUrl = rs.getString("nb_photo");
				String nbj_Time = rs.getDate("nb_data").toString();
				int p_Id = rs.getInt("p_Id");
				String sql1 = "select * from place where p_Id=?";
				pst = conn.prepareStatement(sql1);
				pst.setInt(1, p_Id);
				rs1 = pst.executeQuery();
				String nbj_placename = null;
				while (rs1.next()) {
					nbj_placename = rs1.getString("p_Name");
				}
				NoteBarJson noteBarJson = new NoteBarJson(nbj_Id, nj_Id, nbj_Text, nbj_imgUrl, nbj_Time, p_Id,
						nbj_placename);
				nbj_list.add(noteBarJson);
			}
			return nbj_list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public List<presonNoteJson> getRouteJson(int u_id) {
		List<presonNoteJson> pnj_list = new ArrayList<presonNoteJson>();
		Connection conn = null;
		conn = DBHelper.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "select * from route where u_Id=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, u_id);
			rs = pst.executeQuery();
			while (rs.next()) {
				int pnj_Day = rs.getInt("r_Day");
				String pnj_Name = rs.getString("r_name");
				String pnj_CreateTime = rs.getDate("r_CreateTime").toString();
				presonNoteJson pnj = new presonNoteJson(pnj_Day, pnj_CreateTime, pnj_Name);
				pnj_list.add(pnj);
			}
			return pnj_list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public void addRouteJson(int u_Id, List<String> list) {
		Connection conn = null;
		conn = DBHelper.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		int p_Id = Integer.valueOf(list.get(0));
		String sql1 = "select * from place where p_Id=?";
		String sql = "insert into route(r_name,u_Id,r_CreateTime,r_StartTime,r_Day,r_photo)values(?,?,?,?,?,?)";
		try {
			pst = conn.prepareStatement(sql1);
			pst.setInt(1, p_Id);
			rs = pst.executeQuery();
			while (rs.next()) {
				String r_Name = rs.getString("p_Name");
				String r_imageUrl = rs.getString("p_photo");
				pst = conn.prepareStatement(sql);
				pst.setString(1, r_Name);
				pst.setInt(2, u_Id);
				Date dt = new Date();
				SimpleDateFormat matter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				pst.setDate(3, (java.sql.Date) dt);
				pst.setDate(4, (java.sql.Date) matter1.parse(list.get(list.size() - 1) + "00:00:00"));
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

	public List<PDJSon> getPDJRequest(int id) {
		List<PDJSon> pdj_list = new ArrayList<PDJSon>();
		Connection conn = null;
		conn = DBHelper.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		ResultSet rs2=null;
		String sql = "select * from routelist where r_Id=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while (rs.next()) {
				int rl_id = rs.getInt("rl_Id");
//				System.out.println(rl_id);
				String pdj_date = rs.getString("rl_date");
//				System.out.println(pdj_date);
				int pdj_id = rs.getInt("c_Id");
				String sql1 = "select * from routebar where rl_Id=?";
				pst = conn.prepareStatement(sql1);
				pst.setInt(1, rl_id);
				rs1 = pst.executeQuery();
				rs1.next();
				int p_Id = rs1.getInt("p_Id");
				String sql2="select * from place where p_Id=?";
//				System.out.println(p_Id);
				pst=conn.prepareStatement(sql2);
				pst.setInt(1, p_Id);
				rs2=pst.executeQuery();
				rs2.next();
				String pdj_end_address=rs2.getString("p_Name");
//				System.out.println(pdj_end_address);
				PDJSon pdjSon = new PDJSon(rl_id, pdj_date, pdj_end_address);
				pdj_list.add(pdjSon);
			}
			return pdj_list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	public void addRouteJson(int r_Id, int p_Id, String rl_date) {
		Connection conn = null;
		conn = DBHelper.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "insert into routelist(r_Id,rl_date,c_Id)values(?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, r_Id);
			pst.setString(2, rl_date);
			pst.setInt(3, p_Id);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<NotesJson> getTravelNoteJsonByid(String u_id) {
		List<NotesJson> list = new ArrayList<NotesJson>();
		Connection conn = null;
		conn = DBHelper.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		String sql = "select * from note where u_Id=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, u_id);
			rs = pst.executeQuery();
			while (rs.next()) {
				int Nid = rs.getInt("n_Id");
				String Nname = rs.getString("n_Name");
				Date NstartTime = rs.getDate("n_StartTime");
				String Nphoto = rs.getString("n_Photo");
				int Nwriter = rs.getInt("u_Id");
				String sql1 = "select * from user where u_Id=?";
				pst = conn.prepareStatement(sql1);
				pst.setInt(1, Nwriter);
//				System.out.println(Nwriter);
				rs1 = pst.executeQuery();
				String nj_icon = null;
				while (rs1.next()) {
					nj_icon = rs1.getString("u_Account");
				}
				NotesJson notesJson = new NotesJson(Nid, Nname, NstartTime.toString(), Nphoto, nj_icon);
				list.add(notesJson);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelper.close(conn, pst, rs);
		}
		return null;

	}

	public List<CommentBean> commRequset(int NS_Id, int ch_status) {
		List<CommentBean> list = new ArrayList<CommentBean>();
		Connection conn = null;
		conn = DBHelper.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		String sql = "select * from chat where NS_Id=? and ch_status=?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, NS_Id);
			pst.setInt(2, ch_status);
			rs = pst.executeQuery();
			while (rs.next()) {
				int ch_Id = rs.getInt(1);
				String ch_Text = rs.getString(2);
				String ch_SendTime = rs.getString(3);
				int u_Id = rs.getInt(4);
				String sql1 = "select * from user where u_Id=?";
				pst = conn.prepareStatement(sql1);
				pst.setInt(1, u_Id);
				rs1 = pst.executeQuery();
				rs1.next();
				String u_Name = rs1.getString("u_Name");
				CommentBean commentbean = new CommentBean(ch_Id,u_Id, u_Name, ch_SendTime, ch_Text);
				list.add(commentbean);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	
	public boolean publishCommit(PublishCommit publishCommit){
		Connection conn=null;
		conn = DBHelper.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "insert into chat(ch_Text,ch_SendTime,u_Id,ch_status,NS_Id)values(?,?,?,?,?)";
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, publishCommit.getCh_Text());
			pst.setString(2, publishCommit.getCh_SendTime());
			pst.setInt(3, publishCommit.getU_id());
			pst.setInt(4, publishCommit.getCh_status());
			pst.setInt(5, publishCommit.getNS_Id());
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	
	public List<ReplyBean> replyRequest(int NS_Id,int ch_status){
		List<ReplyBean> list=new ArrayList<ReplyBean>();
		Connection conn=null;
		conn = DBHelper.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		ResultSet rs1=null;
		String sql = "select * from chat where NS_Id=? and ch_status=?";
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, NS_Id);
			pst.setInt(2, ch_status);
			rs=pst.executeQuery();
			while(rs.next()){
				int ch_Id=rs.getInt(1);
				String ch_Text=rs.getString(2);
				String ch_SendTime=rs.getString(3);
				int u_Id=rs.getInt(4);
				String sql1="select * from user where u_Id=?";
				pst=conn.prepareStatement(sql1);
				pst.setInt(1, u_Id);
				rs1=pst.executeQuery();
				rs1.next();
				String u_Name=rs1.getString("u_Name");
				ReplyBean replyBean=new ReplyBean( 2, u_Name, 1, "123", ch_Text);
				list.add(replyBean);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	public boolean insertNoteRequest(String NS_imageName,String NS_Content,String NS_Locate,String NS_Time,String n_Name,int u_Id){
		Connection conn=null;
		conn = DBHelper.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		ResultSet rs1=null;
		String sql1="select * from note where u_Id=? and n_Name=?";
		String sql = "insert into travel_note_single(NS_imageName,NS_Content,NS_Locate,n_Id,NS_Time)values(?,?,?,?,?)";
		try {
			pst=conn.prepareStatement(sql1);
			pst.setInt(1, u_Id);
			pst.setString(2, n_Name);
			rs1=pst.executeQuery();
			rs1.next();
			int n_Id=rs1.getInt(1);
			pst=conn.prepareStatement(sql);
			pst.setString(1, NS_imageName);
			pst.setString(2, NS_Content);
			pst.setString(3, NS_Locate);
			pst.setInt(4, n_Id);
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			Date date1 = null;
			try {
				date1 = sdf.parse(NS_Time);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			java.sql.Date date2= new java.sql.Date(date1.getTime());
			pst.setString(5, NS_Time);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return true;
		
	}

	public void addRouteJson(int r_Id,int c_id,int p_Id,String rl_date){
		Connection conn=null;
		conn = DBHelper.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		ResultSet rs1=null;
		String sql = "insert into routelist(r_Id,rl_date,c_Id)values(?,?,?)";
		String sql1="select * from routelist where r_Id=? and rl_date=? and c_Id=?";
		String sql2="insert into routebar(rl_Id,p_Id) values(?,?) ";
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, r_Id);
			pst.setString(2, rl_date);
			pst.setInt(3, c_id);
			pst.executeUpdate();
			pst=conn.prepareStatement(sql1);
			pst.setInt(1, r_Id);
			pst.setString(2, rl_date);
			pst.setInt(3, c_id);
			rs1=pst.executeQuery();
			rs1.next();
			int rl_Id=rs1.getInt(1);
			
			pst=conn.prepareStatement(sql2);
			pst.setInt(1, rl_Id);
			pst.setInt(2,p_Id );
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	public boolean createnoteRequest(NewNote newNote){
		Connection conn=null;
		conn = DBHelper.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		ResultSet rs1=null;
		String sql = "insert into note(n_Name,u_Id,n_CreateTime,ispublish)values(?,?,?,?)";
		try {
			pst=conn.prepareStatement(sql);
			pst.setString(1, newNote.getNn_Name());
			pst.setInt(2, newNote.getU_Id());
			pst.setString(3, newNote.getNn_CreateTime());
			pst.setInt(4, 0);
			pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
		
	}
	
	public int getPage(int pageSize) {
		// TODO Auto-generated method stub
		Connection conn=null;
		conn = DBHelper.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = conn.prepareStatement("select count(*) from place");
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

	@SuppressWarnings("null")
	public NotePage getPlaceBypage(int currentPage, int pageSize) {
		// TODO Auto-generated method stub
		List<NotesJson> list = new ArrayList<NotesJson>();
		Connection conn=null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		Connection exe=null;
		ResultSet rs1=null;
		PreparedStatement pst1=null;
		int totalPage = getPage(pageSize);
		try {
			conn=DBHelper.getConnection();
			int start = (currentPage - 1) * pageSize;
			pst = conn.prepareStatement("select * from note where ispublish=?  limit ?,? ");
			pst.setInt(1, 1);
			pst.setInt(2, start);
			pst.setInt(3, pageSize);
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
				rs1=pst.executeQuery();
				String nj_icon = null;
				while(rs1.next()){
					nj_icon=rs1.getString("u_HeadPortrait");
				}
				NotesJson notesJson = new NotesJson(Nid,Nname, NstartTime.toString(), Nphoto, nj_icon);
				list.add(notesJson);
			}
			NotePage page = new NotePage(list, totalPage, currentPage);
			return page;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBHelper.close(exe, pst, rs);
			DBHelper.close(exe, pst1, rs1);
		}
		return null;
	}


	public List<ReviseNote> alterNoteRequest(int id){
		List<ReviseNote> list=new ArrayList<ReviseNote>();
		Connection conn=null;
		conn = DBHelper.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		String sql = "select * from travel_note_single where n_Id=?";
		try {
			pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
			rs=pst.executeQuery();
			while(rs.next()){
				int rn_Id=rs.getInt("NS_Id");
				String rn_ImageUrl=rs.getString("NS_imageName");
				String rn_Location=rs.getString("NS_Locate");
				String rn_content=rs.getString("NS_Content");
				ReviseNote reviseNote=new ReviseNote(rn_Id, rn_ImageUrl, rn_content, rn_Location);
				list.add(reviseNote);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}


	
}
