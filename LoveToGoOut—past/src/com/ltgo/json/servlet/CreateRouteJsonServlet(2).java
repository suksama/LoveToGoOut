package com.ltgo.json.servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ltgo.dao.impl.NotesJsonDaoImpl;
import com.ltgo.json.model.AddNoteJson;

/**
 * Servlet implementation class CreateRouteJsonServlet
 */
@WebServlet("/CreateRouteJsonServlet")
public class CreateRouteJsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateRouteJsonServlet() {
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
		
		InputStream is=request.getInputStream();
		byte[] b=new byte[1000];
		int len;
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
		while((len=is.read(b))>0){
			baos.write(b, 0, len);
		}
		String json=new String(baos.toByteArray(),"utf-8");
		Gson g=new Gson();
		AddNoteJson list=g.fromJson(json, AddNoteJson.class);
		int c_Id=list.getC_Id();
		List<Integer> idlist=list.getIdlist();
		List<String> datelist=list.getDatelist();
		NotesJsonDaoImpl njdi=new NotesJsonDaoImpl();
		for (int i = 0; i < idlist.size(); i++) {
			njdi.addRouteJson(1, c_Id, idlist.get(i), datelist.get(i));
		}
		
		
		
	}

}
