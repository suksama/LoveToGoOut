package com.ltgo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ltgo.dao.impl.TravelNoteDaoImpl;
import com.ltgo.model.TravelNotePage;

@WebServlet("/ShowTravelNoteServlet")
public class ShowTravelNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TravelNoteDaoImpl dao = new TravelNoteDaoImpl();
		String tCurrentPage = request.getParameter("currentPage");
		if(tCurrentPage==null){
			tCurrentPage = "1";
		}
		String searchContent =request.getParameter("searchContent");
		TravelNotePage page = dao.getTravelNoteByPage(Integer.parseInt(tCurrentPage), 6,searchContent);
		request.setAttribute("tpage", page);
		if(searchContent==null){
			searchContent="";
		}
			request.setAttribute("searchContent", searchContent);
			request.getRequestDispatcher("/Notes.jsp").forward(request, response);

		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
