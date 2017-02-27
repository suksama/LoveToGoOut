package com.ltgo.servlet;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.ltgo.dao.impl.TravelNoteDaoImpl;
import com.ltgo.model.TravelNote;

/**
 * Servlet implementation class UpdateTravelNoteServlet
 */
//@WebServlet(asyncSupported = true, urlPatterns = { "/UpdateTravelNoteServlet" })
@WebServlet("/UpdateTravelNoteServlet")
public class UpdateTravelNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		SmartUpload upload = new SmartUpload();
		upload.initialize(this.getServletConfig(), request, response);
		try {
			System.out.println("upload");
			upload.upload();
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		com.jspsmart.upload.File f1 = upload.getFiles().getFile(0);
		String filename = f1.getFileName();
		System.out.println(filename);
		ServletContext application = getServletContext();
		String path = application.getRealPath("/images");
		try {
			System.out.println("success");
			f1.saveAs(path+"\\"+filename);
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int nid = Integer.parseInt(upload.getRequest().getParameter("Nid"));
		String nwriter = upload.getRequest().getParameter("Nwriter");
		String nname = upload.getRequest().getParameter("Nname");
		int ntime = Integer.parseInt(upload.getRequest().getParameter("Ntime"));
		int nnumOfPoint = Integer.parseInt(upload.getRequest().getParameter("NnumOfPoint"));
		int nnumOfPic= Integer.parseInt(upload.getRequest().getParameter("NnumOfPic"));
		String nphoto;
		if(filename.length()==0){
			
			nphoto=upload.getRequest().getParameter("Nphoto");
		}else {
			nphoto = "images/"+filename;
		}
		int ncollect = Integer.parseInt(upload.getRequest().getParameter("Ncollect"));
		int nview = Integer.parseInt(upload.getRequest().getParameter("Nview"));
		SimpleDateFormat  sdf =new  SimpleDateFormat("yyyy-MM-dd"); 
		java.util.Date cDate;
		String ctime = upload.getRequest().getParameter("NcreateTime");
		String stime = upload.getRequest().getParameter("NstartTime");
		Date ncreateTime = null;
		Date nstartTime = null;
		try {
			cDate = sdf.parse(ctime);
			ncreateTime = new Date(cDate.getTime());
			System.out.println(ncreateTime);
			cDate = sdf.parse(stime);
			nstartTime = new Date(cDate.getTime());
			System.out.println(nstartTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TravelNote travelNote = new TravelNote(nid, nname, Integer.parseInt(nwriter), ncreateTime, nstartTime, ntime, nnumOfPoint, nnumOfPic, nphoto, ncollect, nview);
		TravelNoteDaoImpl dao = new TravelNoteDaoImpl();
		boolean flag = dao.updateTravelNote(travelNote);
		if(flag){
			response.getWriter().println("<script type=\"text/javascript\">alert(\"修改成功\");location.href = \"/LoveToGoOut/ShowTravelNoteServlet\";</script>");
		}else{
			response.getWriter().println("<script type=\"text/javascript\">alert(\"修改失败\");location.href = \"/LoveToGoOut/ShowTravelNoteServlet\";</script>");
		}
	
	
	}
	

}
