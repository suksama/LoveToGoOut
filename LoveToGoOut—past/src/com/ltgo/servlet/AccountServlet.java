package com.ltgo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ltgo.dao.UserDao;
import com.ltgo.dao.impl.UserDaoImpl;
import com.ltgo.model.Notes;
import com.ltgo.model.User;


@WebServlet("/AccountServlet")
public class AccountServlet extends HttpServlet {

	UserDaoImpl udi=new UserDaoImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub		
		login(req, resp);
	}

	private void login(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
	
		try {
			resp.setCharacterEncoding("utf-8"); 
			req.setCharacterEncoding("utf-8");
			String account=req.getParameter("username");
			String password=req.getParameter("psw");
			
			System.out.println(account);
			System.out.println(password);
			
			User user=new User(account, password);
			HttpSession session=req.getSession();
			
			boolean isSuccess=udi.isSccuess(user);
			PrintWriter out1=resp.getWriter();
			if (isSuccess) {
				session.setAttribute("user", user);
				try {
					resp.setContentType("text/html;charset=utf-8");
					req.getRequestDispatcher("/manager.jsp").forward(req, resp);
					
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else {
				out1.print("false");
			}
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	private void writenote(HttpServletRequest req, HttpServletResponse resp){
		try {
			req.setCharacterEncoding("utf-8");
			String title=req.getParameter("title");
			String content=req.getParameter("content");
			Notes note=new Notes(title, content);
			UserDaoImpl ud=new UserDaoImpl();
			int num=ud.savenotes(note);
			String message = "";
			if (num>0) {
				message = "添加成功";
			}else {
				message = "添加失败";
			}
			resp.setContentType("text/html;charset=utf-8");
		 	PrintWriter out = resp.getWriter();
		 	out.println("<script>alert('"+ message +"');window.location.href='index.jsp';</script>");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
