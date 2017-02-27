package com.ltgo.json.servlet;

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

import sun.misc.BASE64Decoder;

/**
 * Servlet implementation class ChangePassword
 */
@WebServlet("/ChangePassword")
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePassword() {
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
		/*System.out.println("u_LoginID:"+u_LoginID);
		*/System.out.println("u_PassWord:"+u_PassWord);

		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement("update user set u_password=? where u_Account=?");
			pst.setString(1, u_PassWord);
			pst.setString(2, u_LoginID);
			pst.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//	public static boolean GenerateImage(String imgStr) { // 对字节数组字符串进行Base64解码并生成图片
//		if (imgStr == null) // 图像数据为空
//		return false;
//		BASE64Decoder decoder = new BASE64Decoder();
//		try {
//		// Base64解码
//		byte[] b = decoder.decodeBuffer(imgStr);
//		for (int i = 0; i < b.length; ++i) {
//		if (b[i] < 0) {// 调整异常数据
//		b[i] += 256;
//		}
//		}
//		// 生成jpeg图片
////		String fileName = UUID.randomUUID().toString();
//		String imgFilePath = "/Image/test22.png";// 新生成的图片
//		
//		
//		OutputStream out = new FileOutputStream(imgFilePath);
//		out.write(b);
//		out.flush();
//		out.close();
//		return true;
//		} catch (Exception e) {
//		return false;
//		}
//		}

}
