package com.ltgo.json.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ltgo.util.DBHelper;
import com.ltgo.util.SaveUtil;
import com.ltgo.util.Stringutil;

import sun.misc.BASE64Decoder;

/**
 * Servlet implementation class UploadImageServlet
 */
@WebServlet("/UploadUserPortServlet")
public class UploadUserPortServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadUserPortServlet() {
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
		String photo = request.getParameter("photo");
		String u_LoginID = request.getParameter("loginid");
		photo = Stringutil.processNull(photo);
		u_LoginID = Stringutil.processNull(u_LoginID);
//		System.out.println("photo:" + photo);
		
		SaveUtil saveUtil =new SaveUtil();
		String local = saveUtil.SaveImage(getServletContext(), photo);
//		System.out.println(local);
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement("update user set u_HeadPortrait=? where u_Account=?");
			pst.setString(1, local);
			pst.setString(2, u_LoginID);
			pst.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
