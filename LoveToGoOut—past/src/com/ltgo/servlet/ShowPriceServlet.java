package com.ltgo.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ltgo.dao.PriceDao;
import com.ltgo.dao.impl.PageDaoImpl;
import com.ltgo.dao.impl.PriceDaoImpl;
import com.ltgo.model.PlacePrice;
@WebServlet("/ShowPriceServlet")
public class ShowPriceServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
//		PageDaoImpl pdi=new PageDaoImpl();
//		List<PlacePrice> data=pdi.showprice();
//		System.out.println(data.get(0).getPp_WebName());
//		req.setAttribute("data1", data);
		PriceDaoImpl pdi=new PriceDaoImpl();
		List<PlacePrice> data=pdi.showprice(new String(req.getParameter("name").getBytes("ISO-8859-1"),"utf-8")
);
		req.setAttribute("data1", data);
		req.getRequestDispatcher("/Price.jsp").forward(req, resp);
	}
}
