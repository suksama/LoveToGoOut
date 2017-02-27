package com.ltgo.json.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.catalina.core.ApplicationPart;

import com.ltgo.dao.impl.NotesJsonDaoImpl;

/**
 * Servlet implementation class WriteJsonServlet
 */
@WebServlet("/WriteJsonServlet")
@MultipartConfig
public class WriteJsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WriteJsonServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html,charset=UTF-8"); 
		ApplicationPart part=(ApplicationPart) request.getPart("file");
		String path=request.getServletContext().getRealPath("/upload");
		File dir=new File(path);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		String filesuf=part.getSubmittedFileName();
		String index=filesuf.substring(filesuf.indexOf("."));
		String fileName=UUID.randomUUID().toString();
		File file=new File(dir, fileName+""+index);
		part.write(file.getPath());
		String url=file.getAbsolutePath();
		
		String NS_Content=request.getParameter("content");
		String NS_Locate=request.getParameter("NS_Locate");
		String Id=request.getParameter("NS_Id");
		int NS_Id=Integer.valueOf(Id);
		String NS_Time=request.getParameter("NS_Time");
		String n_Name=request.getParameter("name");
		int u_Id=Integer.valueOf(request.getParameter("id"));
		NotesJsonDaoImpl njdi=new NotesJsonDaoImpl();
		PrintWriter out=response.getWriter();
		boolean isTrue=njdi.insertNoteRequest(url, NS_Content, NS_Locate,NS_Time,n_Name,u_Id);
		if (isTrue) {
			out.println("success");
		}else{
			out.println("fail");
		}
	}

}
