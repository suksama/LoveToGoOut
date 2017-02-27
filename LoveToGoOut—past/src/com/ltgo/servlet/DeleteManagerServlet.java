package com.ltgo.servlet;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ltgo.service.ManagerService;
import com.ltgo.service.impl.ManagerServiceImpl;
@WebServlet("/DeleteManagerServlet")
public class DeleteManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String chkvalues[]=request.getParameterValues("checkbox");
		String chkvalue=Arrays.toString(chkvalues);
		StringBuilder sb=new StringBuilder(chkvalue);
		sb.deleteCharAt(0);
		sb.deleteCharAt(0);
		sb.deleteCharAt(sb.length()-1);
		chkvalue=sb.toString();
		String[] ids=chkvalue.split(",");
		if(ids.length>0){
			for (String account : ids) {
				ManagerService service = new ManagerServiceImpl();
			    service.deleteManagerByAccount(account);
			}
			//ɾ��ɹ�
//			request.getRequestDispatcher("/ShowManagerServlet").forward(request, response);
			response.getWriter().println("<script type=\"text/javascript\">alert(\"删除成功\");location.href=\"/LoveToGoOut/ShowManagerServlet\";</script>");
		}else{
			//ɾ��ʧ��
			response.getWriter().println("<script type=\"text/javascript\">alert(\"删除失败\");location.href=\"/LoveToGoOut/ShowManagerServlet\";</script>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
