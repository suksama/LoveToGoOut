package com.ltgo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ltgo.dao.impl.PageDaoImpl;
import com.ltgo.model.PlacePage;
@WebServlet("/PageServlet")
public class PageServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		PageDaoImpl pdi=new PageDaoImpl();
		//获得页码的参数
	//	resp.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		String sCurrentPage = req.getParameter("currentPage");
		String searchcontent=req.getParameter("searchcontent");
		String searchcontent1=null;
		if(searchcontent!=null){
			searchcontent1=new String(searchcontent.getBytes("ISO-8859-1"),"utf-8");
		}
		if(sCurrentPage == null){
			sCurrentPage = "1";
		}
		
		PlacePage page = pdi.getPlaceBypage(Integer.parseInt(sCurrentPage), 10,searchcontent1);
		req.setAttribute("page", page);//servlet==>jsp
		
		req.getRequestDispatcher("/Notestable.jsp").forward(req, resp);
	}
}
