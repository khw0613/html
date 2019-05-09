package kr.ddit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ddit.dao.CarDao;
import kr.ddit.vo.CarVO;


@WebServlet("/myselect03")
public class MySelect03 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		String car_codes = request.getParameter("maker_code");
		CarDao dao = new CarDao();
		try {
			ArrayList<CarVO> list = dao.selectList(car_codes);

			String text_pre = "[";
			String text = "";
			String text_post = "]";
			
			
			for(int i = 0; i < list.size(); i++){
				String car_name = list.get(i).getCar_name();
				String maker_name = list.get(i).getMaker_name();
				String fuel_type = list.get(i).getFuel_type();
				String cc = list.get(i).getCc();
				String yunbi = list.get(i).getYunbi();
				String debut = list.get(i).getDebut();
				
				
				text += "{ \"car_name\": \""+car_name+"\", \"maker_name\": \""+maker_name+"\","
						+ " \"fuel_type\": \""+fuel_type+"\", \"cc\": \""+cc+"\", \"yunbi\": \""+yunbi+"\","
								+ " \"debut\": \""+debut+"\"},";
				
				
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
