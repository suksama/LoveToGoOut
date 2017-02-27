package com.ltgo.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ltgo.dao.impl.UserDaoImpl;
import com.ltgo.model.Place;
import com.ltgo.model.PlaceView;
@WebServlet("/GetServlet")
public class GetServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, resp);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserDaoImpl udi=new UserDaoImpl();
		List<PlaceView> list=udi.getplace();
		request.setAttribute("data",list );
		request.getRequestDispatcher("/Notestable.jsp").forward(request, resp);
	}
}
