package com.ltgo.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ltgo.dao.impl.UserDaoImpl;
import com.ltgo.model.PlaceView;
@WebServlet("/ShowServlet")
public class ShowServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("id");
		UserDaoImpl udi=new UserDaoImpl();
		List<PlaceView> list =udi.showplace(Integer.parseInt(id));
		request.setAttribute("list", list);
		request.getRequestDispatcher("/altertable.jsp").forward(request, resp);
	}
}
