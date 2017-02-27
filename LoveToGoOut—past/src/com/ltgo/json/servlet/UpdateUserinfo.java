package com.ltgo.json.servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ltgo.util.DBHelper;
import com.ltgo.util.Stringutil;

import sun.misc.BASE64Decoder;

/**
 * Servlet implementation class registUser
 */
@WebServlet("/UpdateUserinfo")
public class UpdateUserinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateUserinfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		Connection conn = DBHelper.getConnection();
		String u_LoginID = request.getParameter("loginid");
		String u_NickName = request.getParameter("nickname");
		String u_introduce = request.getParameter("userinturdance");

		u_LoginID = Stringutil.processNull(u_LoginID);
		u_NickName = Stringutil.processNull(u_NickName);
		u_introduce = Stringutil.processNull(u_introduce);

//		System.out.println("u_LoginID:" + u_LoginID);
//		System.out.println("u_NickName" + u_NickName);
//		System.out.println("u_introduce" + u_introduce);
		
		

		// User user = new User(u_LoginID, u_PassWord, u_NickName, null);
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement("update user set u_Name=?,u_introduce=? where u_Account=?");
			pst.setString(1, u_NickName);
			pst.setString(2, u_introduce);
			pst.setString(3, u_LoginID);
			pst.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
