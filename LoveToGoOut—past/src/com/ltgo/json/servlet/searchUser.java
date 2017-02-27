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

import com.ltgo.util.DBHelper;
import com.ltgo.util.Stringutil;
import com.sun.xml.internal.bind.v2.model.core.ID;

/**
 * Servlet implementation class searchUser
 */
@WebServlet("/searchUser")
public class searchUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stud
		doPost(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String loginid = request.getParameter("loginid");		
		loginid = Stringutil.processNull(loginid);
//		System.out.println(loginid);
		boolean f = searchUser(loginid);
		out.println(f);
	}

	public boolean searchUser(String loginid){
		boolean flag = true;
		Connection conn = DBHelper.getConnection();
		Statement st = null;
		ResultSet rs = null;
//		System.out.println("point");
		try {
			st = conn.createStatement();
			rs = st.executeQuery("select * from user where u_Account ="+"'"+loginid+"'");		
//			System.out.println(rs);
//			System.out.println(rs.next());
			flag = rs.next();
//			System.out.println("flag="+flag);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;	
	}
}
