package com.ltgo.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ltgo.dao.impl.PriceDaoImpl;
import com.ltgo.model.City;
import com.ltgo.model.PlacePrice;
@WebServlet("/ShowCityServlet")
public class ShowCityServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		PriceDaoImpl pdi=new PriceDaoImpl();
		List<City> data=pdi.showcity(new String(req.getParameter("cityname").getBytes("ISO-8859-1"),"utf-8")
);
		req.setAttribute("data2", data);
		req.getRequestDispatcher("/City.jsp").forward(req, resp);
	}
}
