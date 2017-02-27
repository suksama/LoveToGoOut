package com.ltgo.servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ltgo.dao.impl.ManagerDaoImpl;
import com.ltgo.dao.impl.UserDaoImpl;
import com.ltgo.model.User;

/**
 * Servlet implementation class LoginSerlvet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		InputStream is=request.getInputStream();
		byte[] b=new byte[1000];
		int len;
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
		while((len=is.read(b))>0){
			baos.write(b, 0, len);
		}
		String json=new String(baos.toByteArray(),"utf-8");
		Gson g=new Gson();
		User user=g.fromJson(json, User.class);
		System.out.println(json);
		UserDaoImpl udi=new UserDaoImpl();
		PrintWriter out=response.getWriter();
		String newsjson=g.toJson(user);
		if(udi.isSccuess(user)){
			out.print(newsjson);
			System.out.println("........");
		}else{
			out.println("false");
			System.out.println("yyyyyyyy");
		}
		
	}

}
