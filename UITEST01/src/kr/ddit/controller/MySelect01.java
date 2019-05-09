package kr.ddit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ddit.dao.MakerDao;
import kr.ddit.vo.MakerVO;


@WebServlet("/myselect01")
public class MySelect01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");

		PrintWriter out = response.getWriter();
		MakerDao dao = new MakerDao();
		try {
			ArrayList<MakerVO> list = dao.select(null);
			
			String text_pre = "[";
			String text = "";
			String text_post = "]";
			
			
			for(int i = 0; i < list.size(); i++){
				String maker_code = list.get(i).getMaker_code();
				String maker_name = list.get(i).getMaker_name();
				
				
				text += "{\"maker_code\": \""+maker_code+"\", \"maker_name\": \""+maker_name+"\"},";
				
			}
			if(list.size() > 0){
				text = text.substring(0, text.length()-1); 
			}
			
			out.print(text_pre);
			out.print(text);
			out.print(text_post);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}
	

}
