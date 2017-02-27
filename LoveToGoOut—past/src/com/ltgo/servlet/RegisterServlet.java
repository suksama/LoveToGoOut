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
import com.ltgo.model.User;
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	UserDaoImpl udi=new UserDaoImpl();
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
		try {
			
			req.setCharacterEncoding("utf-8");
			String account=req.getParameter("name");
			String password=req.getParameter("password");
			String sex=req.getParameter("sex");
			String email=req.getParameter("email");
			String random=req.getParameter("txtrad");
			HttpSession session=req.getSession();
			String radstr=(String) session.getAttribute("randomCode");
			User user=new User(account, password,sex,email);
			String message = "";
			if(random.equalsIgnoreCase(radstr)){
				int num=0;
				num=udi.save(user);
				
				if (num > 0) {
					message = "添加成功";

				} else {
					message = "添加失败";
				}
		 	
				}else{
					message="验证码错误";
				}
			resp.setContentType("text/html;charset=utf-8");
		 	PrintWriter out = resp.getWriter();
		 	out.println("<script>alert('"+ message +"');window.location.href='Register.jsp';</script>");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
