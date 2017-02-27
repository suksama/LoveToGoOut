package com.ltgo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ltgo.dao.impl.TravelNoteDaoImpl;
@WebServlet("/DeleteTravelNoteServlet")
public class DeleteTravelNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		int Nid = Integer.parseInt(request.getParameter("Nid"));
		TravelNoteDaoImpl dao = new TravelNoteDaoImpl();
		boolean flag = dao.deleteTravelNote(Nid);
		if(flag){
			request.getRequestDispatcher("/ShowTravelNoteServlet").forward(request, response);
		}else{
			response.getWriter().println("<script type=\"text/javascript\">alert(\"删除失败\");</script>");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
