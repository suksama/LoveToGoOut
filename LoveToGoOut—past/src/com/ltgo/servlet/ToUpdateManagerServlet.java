package com.ltgo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ltgo.model.Manager;
import com.ltgo.service.ManagerService;
import com.ltgo.service.impl.ManagerServiceImpl;
@WebServlet("/ToUpdateManagerServlet")
public class ToUpdateManagerServlet extends HttpServlet{
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
		String account=req.getParameter("account");
		ManagerService service=new ManagerServiceImpl();
		Manager manager=service.getManagerByAccount(account);
		req.setAttribute("mana", manager);
		req.getRequestDispatcher("/updateManager.jsp").forward(req, resp);
	}
}
