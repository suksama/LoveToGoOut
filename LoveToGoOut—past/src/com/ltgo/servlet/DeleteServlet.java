package com.ltgo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ltgo.dao.impl.UserDaoImpl;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	
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
		UserDaoImpl udi=new UserDaoImpl();
		
		String[] s=req.getParameterValues("checkbox");
		
		int num;
		for(int i=0;i<s.length;i++){
			num=Integer.parseInt(s[i]);
			udi.deleteTourist(num);
		}
		
	}
}
