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
import com.ltgo.json.model.AddressJson;

/**
 * Servlet implementation class AddressJsonServlet
 */
@WebServlet("/AddressJsonServlet")
public class AddressJsonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddressJsonServlet() {
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
		List<AddressJson> aj_list=njdi.getAddressJson1();
		Gson g=new Gson();
		String newJson=g.toJson(aj_list);
		PrintWriter out=response.getWriter();
		out.println(newJson);
		System.out.println(newJson);
	}

}
