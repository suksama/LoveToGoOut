package com.ltgo.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ltgo.model.ManagerPage;
import com.ltgo.service.ManagerService;
import com.ltgo.service.impl.ManagerServiceImpl;

@WebServlet("/ShowManagerServlet")
public class ShowManagerServlet extends HttpServlet {
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
		ManagerService service = new ManagerServiceImpl();
//		List<Manager> list=dao.getAllManagers();
//		request.setAttribute("info", list);
		String sCurrentPage=request.getParameter("currentPage");
		if(sCurrentPage==null){
			sCurrentPage="1";
		}
		ManagerPage page=service.getManagerByPage(Integer.parseInt(sCurrentPage), 10);
		request.setAttribute("page", page);
		request.getRequestDispatcher("/WEB-INF/views/admin/MemberSetting.jsp").forward(request, response);
	}

}
