package com.ltgo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ltgo.dao.impl.UserDaoImpl;
import com.ltgo.model.Place;
import com.ltgo.model.PlaceView;
import com.ltgo.util.Stringutil;
@WebServlet("/AlterServlet")
public class AlterServlet extends HttpServlet {
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
		req.setCharacterEncoding("utf-8");
		String id=req.getParameter("id");
		id=Stringutil.processNull(id);
		String p_Name=req.getParameter("p_Name");
		String p_Ename=req.getParameter("p_Ename");
		String p_Text=req.getParameter("p_Text");
		String p_Local=req.getParameter("p_Local");
		String c_Id=req.getParameter("c_Id");
		String c_Name=req.getParameter("c_Name");
		String c_Ename=req.getParameter("c_Ename");
		
		UserDaoImpl udi=new UserDaoImpl();
		PlaceView placeview =new PlaceView(Integer.parseInt(id), p_Name, p_Ename, p_Text, Double.parseDouble(p_Local),Integer.parseInt(c_Id) ,c_Name, c_Ename);
		System.out.println(placeview.toString());
		udi.alterTourist(placeview);
		req.getRequestDispatcher("/PageServlet").forward(req, resp);
	}
}
