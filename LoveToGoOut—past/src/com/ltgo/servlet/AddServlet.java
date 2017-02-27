package com.ltgo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ltgo.dao.impl.UserDaoImpl;
@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {

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
		
		String p_Name=new String(req.getParameter("p_Name").getBytes("ISO-8859-1"),"utf-8");
		System.out.println(p_Name);
		String p_Ename=new String(req.getParameter("p_Ename").getBytes("ISO-8859-1"),"utf-8");
		String p_Text=new String(req.getParameter("p_Text").getBytes("ISO-8859-1"),"utf-8");
		String c_Name=new String(req.getParameter("c_Name").getBytes("ISO-8859-1"),"utf-8");
		UserDaoImpl udi=new UserDaoImpl();
		udi.addplace(p_Name, p_Ename, p_Text, c_Name);
		req.getRequestDispatcher("/PageServlet").forward(req, resp);
	}
}
