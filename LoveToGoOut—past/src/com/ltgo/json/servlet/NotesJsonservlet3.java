package com.ltgo.json.servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ltgo.dao.impl.NotesJsonDaoImpl;
import com.ltgo.json.model.NotePage;
import com.ltgo.json.model.NotesJson;

/**
 * Servlet implementation class NotesJsonservlet
 */
@WebServlet("/NotesJsonservlet3")
public class NotesJsonservlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NotesJsonservlet3() {
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
		response.setContentType("application/json;charset=utf-8");
		NotesJsonDaoImpl njdi=new NotesJsonDaoImpl();
		String loginid = request.getParameter("loginid");
		System.out.println("获取的ID为"+loginid);
		
		InputStream is=request.getInputStream();
		byte[] b=new byte[1000];
		int len;
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
		while((len=is.read(b))>0){
			baos.write(b, 0, len);
		}
		String json=new String(baos.toByteArray(),"utf-8");
		Gson g=new Gson();
		List<Map<String, String>> list=g.fromJson(json, List.class);
		int currentPage=Integer.parseInt(list.get(0).get("currentPage"));
		
		NotePage notePage=njdi.getPlaceBypage(currentPage, 3);
		List<NotesJson> notelist=notePage.getData();
		String newJson=g.toJson(notelist);
		PrintWriter out=response.getWriter();
		out.println(newJson);
		System.out.println(newJson);
	}

}
