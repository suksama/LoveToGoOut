package com.ltgo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ltgo.dao.impl.PlacePriceDaoImpl;
import com.ltgo.model.Manager;
import com.ltgo.model.Place;
import com.ltgo.model.PlacePrice;
import com.ltgo.service.ManagerService;
import com.ltgo.service.impl.ManagerServiceImpl;
import com.ltgo.util.Stringutil;
@WebServlet("/AddPriceServlet")
public class AddPriceServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		String p_Id = req.getParameter("p_Id");
		p_Id = Stringutil.processNull(p_Id);
		String pp_WebName = req.getParameter("pp_WebName");
		pp_WebName = Stringutil.processNull(pp_WebName);
		String pp_Price = req.getParameter("pp_Price");
		pp_Price = Stringutil.processNull(pp_Price);
		PlacePrice placeprice=new PlacePrice(Integer.parseInt(p_Id), pp_WebName, Double.parseDouble(pp_Price));
		PlacePriceDaoImpl ppdi=new PlacePriceDaoImpl();
		 int i=ppdi.addprice(placeprice);
		if(i>0){
			resp.getWriter().println("<script type=\"text/javascript\">alert(\"添加成功\");location.href=\"/LoveToGoOut/PageServlet\";</script>");
		}else{
			req.getRequestDispatcher("/LoveToGoOut/PageServlet").forward(req, resp);
		}
//		
	}
}
