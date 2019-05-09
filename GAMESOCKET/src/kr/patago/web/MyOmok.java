package kr.patago.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/myomok")
public class MyOmok extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		
		String historys = request.getParameter("historys");
		String winner = request.getParameter("winner");
		System.out.println("his"+historys);
		System.out.println("win"+winner);
		
		String param1 = request.getParameter("param1");
		System.out.println(param1);
		PrintWriter out = response.getWriter();
		out.print("{\"message\":\"ok\"}");
		//out.flush();
		
		
		System.out.println("doget");
	}

}
