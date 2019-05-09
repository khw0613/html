package kr.ddit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;



import java.util.ArrayList;

import kr.ddit.vo.Co_addrVO;

public class Co_addrDao {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "patagonia";
	String pw = "q1w2e3r4";

	public  ArrayList<Co_addrVO> select(String str) throws Exception {
		String query = " ";
		query += "select ";
		query += "		zipcode, ";
		query += "		city, ";
		query += "		gu, ";
		query += "		street, ";
		query += "		street_num ";
		query += "from ";
		query += "		co_addr ";
		query += "where ";
		query += "		street like '%"+str+"%'";
	
		
		
		
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, user, pw);
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
		System.out.println(query);
		ArrayList<Co_addrVO> relist = new ArrayList<Co_addrVO>();
		
		while (rs.next()) {
			Co_addrVO resultvo = new Co_addrVO();
			String zipcode = rs.getString(1);
			String city = rs.getString(2);
			String gu = rs.getString(3);
			String street = rs.getString(4);
			String street_num = rs.getString(5);
		
			
			resultvo.setZipcode(zipcode);
			resultvo.setCity(city);
			resultvo.setGu(gu);
			resultvo.setStreet(street);
			resultvo.setStreet_num(street_num);
		
			relist.add(resultvo);
		}

		rs.close();
		stmt.close();
		conn.close();

		return relist;
	}

	
	public static void main(String[] args) throws Exception {
		Co_addrDao dao = new Co_addrDao();
		Co_addrVO vo = new Co_addrVO();
		ArrayList<Co_addrVO> list = dao.select("대청") ;
		
		for(int i = 0 ; i < list.size(); i++){
			
			System.out.println(list.get(i).getStreet_num());
		}
	}
}
