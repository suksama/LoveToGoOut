package com.ltgo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ltgo.dao.impl.PriceDaoImpl;
import com.ltgo.model.Manager;
import com.ltgo.model.PlacePrice;
import com.ltgo.service.ManagerService;
import com.ltgo.service.impl.ManagerServiceImpl;
@WebServlet("/ToUpatePriceServlet")
public class ToUpatePriceServlet extends HttpServlet {
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
		PlacePrice placeprice=pdi.toupdate(new String(req.getParameter("pp_WebName").getBytes("ISO-8859-1"),"utf-8"));
		System.out.println(new String(req.getParameter("pp_WebName").getBytes("ISO-8859-1"),"utf-8"));
		req.setAttribute("mana", placeprice);
		req.getRequestDispatcher("/updateprice.jsp").forward(req, resp);
	}
}
