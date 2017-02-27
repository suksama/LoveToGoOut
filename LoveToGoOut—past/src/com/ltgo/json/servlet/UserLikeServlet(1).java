package com.ltgo.json.servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ltgo.dao.ULikeListDao;
import com.ltgo.dao.UserLikeDao;
import com.ltgo.dao.impl.ULikeListDaoImpl;
import com.ltgo.dao.impl.UserLikeDaoImpl;

/**
 * Servlet implementation class UserLikeServlet
 */
@WebServlet("/UserLikeServlet")
public class UserLikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
		response.setContentType("application/json;charset=utf-8");
		// 通过流的方式
		InputStream is = request.getInputStream();
		byte b[] = new byte[1000];
		int len;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		while ((len = is.read(b)) > 0) {
			baos.write(b, 0, len);
		}
		// List<News>集合
		String json = new String(baos.toByteArray(), "utf-8");
		Gson g = new Gson();
		Type classOfT = new TypeToken<List<String>>(){}.getType();
		List<String> likelist = g.fromJson(json, classOfT);
		
		/*
		 * Type typeOfT = new TypeToken<List<TravelNote>>(){}.getType();
		 * List<TravelNote> data = g.fromJson(json, typeOfT); for(TravelNote tn
		 * : data){ System.out.println(tn.getLikeNum()+","+tn.getImageName()); }
		 */
		// 发送到手机
		
		ULikeListDao dao = new ULikeListDaoImpl();
		dao.setULikeList(likelist);
//
//		// 集合转成json
//		String newsjson = g.toJson(listdata);
//		response.getWriter().print(newsjson);
	}

}
