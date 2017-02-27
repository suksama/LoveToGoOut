package com.ltgo.model;

import java.sql.Blob;
import java.sql.Date;





public class TravelNote {
	private int Nid;
	private String Nname;
	private int Nwriter;
	private Date NcreateTime;
	private Date NstartTime;
	private int Ntime;
	private int NnumOfPoint;
	private int NnumOfPic;
	private String Nphoto;
	private int Ncollect;
	private int Nview;
	public TravelNote(int nid, String nname, int nwriter, Date ncreateTime, Date nstartTime, int ntime,
			int nnumOfPoint, int nnumOfPic, String nphoto, int ncollect, int nview) {
		super();
		Nid = nid;
		Nname = nname;
		Nwriter = nwriter;
		NcreateTime = ncreateTime;
		NstartTime = nstartTime;
		Ntime = ntime;
		NnumOfPoint = nnumOfPoint;
		NnumOfPic = nnumOfPic;
		Nphoto = nphoto;
		Ncollect = ncollect;
		Nview = nview;
	}
	public int getNid() {
		return Nid;
	}
	public void setNid(int nid) {
		Nid = nid;
	}
	public String getNname() {
		return Nname;
	}
	public void setNname(String nname) {
		Nname = nname;
	}
	public int getNwriter() {
		return Nwriter;
	}
	public void setNwriter(int nwriter) {
		Nwriter = nwriter;
	}
	public Date getNcreateTime() {
		return NcreateTime;
	}
	public void setNcreateTime(Date ncreateTime) {
		NcreateTime = ncreateTime;
	}
	public Date getNstartTime() {
		return NstartTime;
	}
	public void setNstartTime(Date nstartTime) {
		NstartTime = nstartTime;
	}
	public int getNtime() {
		return Ntime;
	}
	public void setNtime(int ntime) {
		Ntime = ntime;
	}
	public int getNnumOfPoint() {
		return NnumOfPoint;
	}
	public void setNnumOfPoint(int nnumOfPoint) {
		NnumOfPoint = nnumOfPoint;
	}
	public int getNnumOfPic() {
		return NnumOfPic;
	}
	public void setNnumOfPic(int nnumOfPic) {
		NnumOfPic = nnumOfPic;
	}
	public String getNphoto() {
		return Nphoto;
	}
	public void setNphoto(String nphoto) {
		Nphoto = nphoto;
	}
	public int getNcollect() {
		return Ncollect;
	}
	public void setNcollect(int ncollect) {
		Ncollect = ncollect;
	}
	public int getNview() {
		return Nview;
	}
	public void setNview(int nview) {
		Nview = nview;
	}
	
	
	
}
