package kr.ddit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import kr.ddit.dao.Co_userDao;
import kr.ddit.vo.Co_userVO;

@WebServlet("/myserveltdupl")
public class MyServeltDupl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		String co_id = request.getParameter("p_id");
		PrintWriter out = response.getWriter();
		
		Co_userDao dao = new Co_userDao();
		int results = 0;
		
		try {
			results = dao.select(co_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		out.print("{\"checked\":\"" + results + "\"}");
	   
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
