package com.ltgo.json.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ltgo.dao.impl.NotesJsonDaoImpl;
import com.ltgo.json.model.NotesJson;

/**
 * Servlet implementation class NoteJsonByidServlet
 */
@WebServlet("/NoteJsonByidServlet")
public class NoteJsonByidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoteJsonByidServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json;charset=utf-8");
		String u_id = request.getParameter("loginid");
		NotesJsonDaoImpl njdi=new NotesJsonDaoImpl();
		List<NotesJson> notelist=njdi.getTravelNoteJsonByid(u_id);
		Gson g=new Gson();
		String newJson=g.toJson(notelist);
		PrintWriter out=response.getWriter();
		out.println(newJson);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
