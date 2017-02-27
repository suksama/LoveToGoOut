package com.ltgo.json.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ltgo.model.User;
import com.ltgo.util.DBHelper;
import com.ltgo.util.Stringutil;


/**
 * Servlet implementation class registUser
 */
@WebServlet("/registUser")
public class registUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		Connection conn = DBHelper.getConnection();
		String u_LoginID = request.getParameter("loginid");
		String u_PassWord = request.getParameter("password");
		String u_NickName = request.getParameter("nickname");	
		
		u_LoginID = Stringutil.processNull(u_LoginID);
		u_PassWord = Stringutil.processNull(u_PassWord);
		u_NickName = Stringutil.processNull(u_NickName);	
		
		
//		System.out.println("u_LoginID:"+u_LoginID);
//		System.out.println("u_PassWord:"+u_PassWord);
//		System.out.println("u_NickName:"+u_NickName);
		
		User user = new User(u_LoginID, u_PassWord, u_NickName, null);
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement("insert into user (u_Account,u_Name,u_password) values(?,?,?)");
			pst.setString(1, user.getU_LoginID());
			pst.setString(2, user.getU_NickName());
			pst.setString(3, user.getU_PassWord());
			pst.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
