package com.ltgo.json.servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.omg.CORBA.PRIVATE_MEMBER;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ltgo.dao.NoteListDao;
import com.ltgo.dao.UserDao;
import com.ltgo.dao.UserLikeDao;
import com.ltgo.dao.impl.NoteListDaoImpl;
import com.ltgo.dao.impl.UserDaoImpl;
import com.ltgo.dao.impl.UserLikeDaoImpl;
import com.ltgo.json.model.TravelNoteSingle;

/**
 * Servlet implementation class JsonNoteListServlet
 */
@WebServlet("/JsonNoteListServlet")
public class JsonNoteListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		List<Map<String, String>> list = g.fromJson(json, List.class);
		int nId = Integer.parseInt(list.get(0).get("nId"));
		int uId = Integer.parseInt(list.get(0).get("uId"));
		/*
		 * Type typeOfT = new TypeToken<List<TravelNote>>(){}.getType();
		 * List<TravelNote> data = g.fromJson(json, typeOfT); for(TravelNote tn
		 * : data){ System.out.println(tn.getLikeNum()+","+tn.getImageName()); }
		 */
		// 发送到手机
		List<String> listulike = null;
		if(uId != 0){
			UserLikeDao userDao = new UserLikeDaoImpl();
			listulike = userDao.getUserLike(uId);
		}
		NoteListDao dao = new NoteListDaoImpl();
		List<TravelNoteSingle> listdata = dao.getNoteList(nId);
		
		
		for (TravelNoteSingle travelNoteSingle : listdata) {
			if(listulike.contains(String.valueOf(travelNoteSingle.getId()))){
				travelNoteSingle.setUlikestate(1);
			}else {
				travelNoteSingle.setUlikestate(0);
			}
			
		}
		// 集合转成json
		String newsjson = g.toJson(listdata);
		response.getWriter().print(newsjson);

	}

}
