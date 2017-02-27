package com.ltgo.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ltgo.model.Manager;
import com.ltgo.service.ManagerService;
import com.ltgo.service.impl.ManagerServiceImpl;


/**
 * Servlet implementation class ActionController
 */
//@WebServlet("*.do")
public class ActionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path=request.getServletPath();
		int end=path.indexOf(".");
		int start=path.indexOf("/");
		String pathInfo=path.substring(start+1, end);
		if("ShowManagerServlet".equals(pathInfo)){
			request.getRequestDispatcher("/ShowManagerServlet").forward(request, response);
		}else if("ToUpdateManagerServlet".equals(pathInfo)){
			String account=request.getParameter("account");
			ManagerService service=new ManagerServiceImpl();
			Manager manager=service.getManagerByAccount(account);
			request.setAttribute("mana", manager);
			request.getRequestDispatcher("/WEB-INF/views/admin/updateManager.jsp").forward(request, response);
		}else if("UpdateManagerServlet".equals(pathInfo)){
			request.getRequestDispatcher("/UpdateManagerServlet").forward(request, response);
		}else if("DeleteManagerServlet".equals(pathInfo)){
			request.getRequestDispatcher("/DeleteManagerServlet").forward(request, response);
		}else if("ToAddManagerServlet".equals(pathInfo)){
			request.getRequestDispatcher("/WEB-INF/views/admin/addManager.jsp").forward(request, response);
		}else if("AddManagerServlet".equals(pathInfo)){
			request.getRequestDispatcher("/AddManagerServlet").forward(request, response);
		}
	}

}
