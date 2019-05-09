package kr.ddit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ddit.dao.Co_addrDao;
import kr.ddit.vo.Co_addrVO;

@WebServlet("/myserveltserach")
public class MyServeltSerach extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
	
		
		String addr = request.getParameter("p_addr");
		Co_addrDao dao = new Co_addrDao();
		try {
			ArrayList<Co_addrVO> list = dao.select(addr);

			String text_pre = "[";
			String text = "";
			String text_post = "]";
			
			
			for(int i = 0; i < list.size(); i++){
				String zipcode = list.get(i).getZipcode();
				String city = list.get(i).getCity();
				String gu = list.get(i).getGu();
				String street = list.get(i).getStreet();
				String street_num = list.get(i).getStreet_num();
				
				
				text += "{ \"zipcode\": \""+zipcode+"\", \"city\": \""+city+"\","
						+ " \"gu\": \""+gu+"\", \"street\": \""+street+"\", \"street_num\": \""+street_num+"\"},";
				
				
			}
			if(list.size() > 0){
				text = text.substring(0, text.length()-1); //
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
