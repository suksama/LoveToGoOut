package com.ltgo.json.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.google.gson.Gson;
import com.ltgo.model.User;
import com.ltgo.util.DBHelper;
import com.ltgo.util.Stringutil;

/**
 * Servlet implementation class checkUser
 */
@WebServlet("/checkUser")
public class checkUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public checkUser() {
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
		response.setContentType("application/json;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		String loginid = request.getParameter("loginid");
		loginid = Stringutil.processNull(loginid);
		String password = request.getParameter("password");
		password = Stringutil.processNull(password);
//		System.out.println("输入的账号为" + loginid);
//		System.out.println("输入的密码为" + password);

		Gson g = new Gson();
		String json = g.toJson(searchUser(loginid, password));
		out.println(json);
		System.out.println(json);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public User searchUser(String loginid, String password) {
		boolean flag = true;
		String overflag = "type0";
		Connection conn = DBHelper.getConnection();
		Statement st = null;
		ResultSet rs = null;
		User user = null;
		user = new User(loginid, password, null, overflag);
//		System.out.println("point");
		try {
			st = conn.createStatement();
			rs = st.executeQuery("select * from user where u_Account =" + "'" + loginid + "'");
			// SELECT * FROM Persons WHERE City='Beijing'
			flag = rs.next();
//			System.out.println("表示为"+flag);
			if (flag) {
				String pp = rs.getString("u_password");
//				System.out.println(pp);
				if (pp.equals(password)) {
					overflag = "type2";
					String nickname = rs.getString("u_Name");
					user = new User(loginid, password, nickname, overflag);
				} else {
					overflag = "type1";
					user = new User(loginid, password, null, overflag);
				}
			}
//			System.out.println("flag=" + flag);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println(overflag);
		return user;

	}
}
