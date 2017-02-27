package com.ltgo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ltgo.dao.impl.PriceDaoImpl;
import com.ltgo.model.City;
import com.ltgo.model.PlacePrice;
@WebServlet("/ToUpdateCityServlet")
public class ToUpdateCityServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PriceDaoImpl pdi=new PriceDaoImpl();
		City city=pdi.toupdatecity(Integer.parseInt(req.getParameter("c_Id")));
		req.setAttribute("mana", city);
		req.getRequestDispatcher("/updatecity.jsp").forward(req, resp);
	}
}
