package kr.ddit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


import kr.ddit.vo.CarVO;

public class CarDao {

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "patagonia";
	String pw = "q1w2e3r4";
	
	public ArrayList<CarVO> select(String m_code) throws Exception{
		String query = "";
		query += "select ";
		query += "   car_code, ";
		query += "   car_name  ";
		query += "from ";
		query += "    car ";

		query += "where ";
		query += "    maker_code = '"+m_code+"'";
	    
		
		
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, user, pw);
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
		ArrayList<CarVO> relist = new ArrayList<CarVO>();

		while(rs.next()){
			String car_code = rs.getString(1);
			String car_name = rs.getString(2);
			
			
			CarVO reusultvo = new CarVO();
			reusultvo.setCar_code(car_code);
			reusultvo.setCar_name(car_name);
		
			
			relist.add(reusultvo);
		}
		
		rs.close();
		stmt.close();
		conn.close();
		
		return relist;
	}
	
	public ArrayList<CarVO> selectList(String car_codes) throws Exception{
		String query = "";
		query += "select ";
		query += "    c.car_code, ";
		query += "    c.car_name, ";
		query += "    m.maker_name, ";
		query += "    c.fuel_type, ";
		query += "    c.cc, ";
		query += "    c.yunbi, ";
		query += "    c.debut ";
	
		query += "from ";
		query += "    car c,";
		query += "    maker m ";
		query += "where ";
		query += "    c.maker_code = m.maker_code ";
		query += "and c.car_code = '"+car_codes+"'";
		
		
		
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, user, pw);
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
		ArrayList<CarVO> list = new ArrayList<CarVO>();
		while(rs.next()){
			String car_code = rs.getString(1);
			String car_name = rs.getString(2);
			String maker_name = rs.getString(3);
			String fuel_type = rs.getString(4);
			String cc = rs.getString(5);
			String yunbi = rs.getString(6);
			String debut = rs.getString(7);
		
			
			CarVO reusultvo = new CarVO();
			reusultvo.setCar_code(car_code);
			reusultvo.setCar_name(car_name);
			reusultvo.setMaker_name(maker_name);
			reusultvo.setFuel_type(fuel_type);
			reusultvo.setCc(cc);
			reusultvo.setYunbi(yunbi);
			reusultvo.setDebut(debut);
	
			
			list.add(reusultvo);
		}
		
		rs.close();
		stmt.close();
		conn.close();
		
		return list;
	}
	public static void main(String[] args) throws Exception {
//		CarDao dao = new CarDao();
		//CarVO vo = new CarVO();
//		vo.setCar_code("HD");
//		
//		CarVO rvo = dao.select(vo);
//		System.out.println(rvo.getCar_name());
		
//		//전체 Select문
//		CarDao dao = new CarDao();
//		
//		
//		
//		
//		ArrayList<CarVO> list = dao.select("SS");
//		
//		for(int i=0; i<list.size(); i++){
//			System.out.println(list.get(i).getCar_name());
//		}
	}
}
