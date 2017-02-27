package com.ltgo.json.servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ltgo.dao.NoteListDao;
import com.ltgo.dao.impl.NoteListDaoImpl;
import com.ltgo.json.model.TravelNoteSingle;

/**
 * Servlet implementation class JsonNoteListServlet
 */
@WebServlet("/JsonNoteListServlet")
public class JsonNoteListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		/*// 通过流的方式
		InputStream is = request.getInputStream();
		byte b[] = new byte[1000];
		int len;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		while ((len = is.read(b)) > 0) {
			baos.write(b, 0, len);
		}*/
		//List<News>集合
//		String json = new String(baos.toByteArray(), "utf-8");
		Gson g = new Gson();
		/*Type typeOfT = new TypeToken<List<TravelNote>>(){}.getType();
		List<TravelNote> data = g.fromJson(json, typeOfT);
		for(TravelNote tn : data){
			System.out.println(tn.getLikeNum()+","+tn.getImageName());
		}*/
		//发送到手机
		NoteListDao dao = new NoteListDaoImpl();
		List<TravelNoteSingle> listdata = dao.getNoteList();
		
		//集合转成json
		String newsjson = g.toJson(listdata);
		response.getWriter().print(newsjson);
	
	}

}
