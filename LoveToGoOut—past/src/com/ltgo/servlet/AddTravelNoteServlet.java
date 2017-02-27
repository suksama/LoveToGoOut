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

import com.ltgo.dao.impl.TravelNoteDaoImpl;
import com.ltgo.model.TravelNote;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

/**
 * Servlet implementation class AddTravelNoteServlet
 */
@WebServlet("/AddTravelNoteServlet")
public class AddTravelNoteServlet extends HttpServlet {
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
		ServletContext application = getServletContext();
		String path = application.getRealPath("/images");
		System.out.println(path);
		if(filename.length()!=0){
		try {
			System.out.println("success");
			f1.saveAs(path+"\\"+filename);
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		int nid = Integer.parseInt(upload.getRequest().getParameter("nid"));
		String nwriter = upload.getRequest().getParameter("nwriter");
		String nname = upload.getRequest().getParameter("nname");
		int ntime = Integer.parseInt(upload.getRequest().getParameter("ntime"));
		int nnumOfPoint = Integer.parseInt(upload.getRequest().getParameter("nnumOfPoint"));
		int nnumOfPic= Integer.parseInt(upload.getRequest().getParameter("nnumOfPic"));
		String nphoto;
		if(filename.length()==0){
			
			nphoto=upload.getRequest().getParameter("nphoto");
		}else {
			nphoto = "images/"+filename;
		}
		int ncollect = Integer.parseInt(upload.getRequest().getParameter("ncollect"));
		int nview = Integer.parseInt(upload.getRequest().getParameter("nview"));
		SimpleDateFormat  sdf =new  SimpleDateFormat("yyyy-MM-dd"); 
		java.util.Date cDate;
		String ctime = upload.getRequest().getParameter("ncreateTime");
		String stime = upload.getRequest().getParameter("nstartTime");
		Date ncreateTime = null;
		Date nstartTime = null;
		try {
			cDate = sdf.parse(ctime);
			ncreateTime = new Date(cDate.getTime());
			cDate = sdf.parse(stime);
			nstartTime = new Date(cDate.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TravelNote travelNote = new TravelNote(nid, nname, Integer.parseInt(nwriter), ncreateTime, nstartTime, ntime, nnumOfPoint, nnumOfPic, nphoto, ncollect, nview);
		TravelNoteDaoImpl dao = new TravelNoteDaoImpl();
		boolean flag = dao.addTravelNote(travelNote);
		if(flag){
			response.getWriter().println("<script type=\"text/javascript\">alert(\"添加成功\");location.href = \"/Asd/ShowTravelNoteServlet\";</script>");
		}else{
			response.getWriter().println("<script type=\"text/javascript\">alert(\"添加失败\");location.href = \"/Asd/addTravelNote.jsp\";</script>");
		}
	}

}
