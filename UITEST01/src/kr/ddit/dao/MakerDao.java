package kr.ddit.dao;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import kr.ddit.vo.CarVO;
import kr.ddit.vo.MakerVO;

public class MakerDao {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "patagonia";
	String pw = "q1w2e3r4";
	
	public ArrayList<MakerVO> select(MakerVO vo) throws Exception{
		String query = "";
		query += "select ";
		query += "    maker_code, ";
		query += "    maker_name, ";
		query += "    maker_code, ";
		query += "    in_date, ";
		query += "    in_user, ";
		query += "    up_date, ";
		query += "    up_user ";
	
		query += "from ";
		query += "    maker ";
	
		
		
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, user, pw);
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
		ArrayList<MakerVO> relist = new ArrayList<MakerVO>();
		MakerVO reusultvo = null;
		while(rs.next()){
			String maker_code = rs.getString(1);
			String maker_name = rs.getString(2);
			String in_date = rs.getString(3);
			String in_user = rs.getString(4);
			String up_date = rs.getString(5);
			String up_user = rs.getString(6);
		
			reusultvo = new MakerVO();
			reusultvo.setMaker_code(maker_code);
			reusultvo.setMaker_name(maker_name);
			reusultvo.setIn_date(in_date);
			reusultvo.setIn_user(in_user);
			reusultvo.setUp_date(up_date);
			reusultvo.setUp_user(up_user);
			
			relist.add(reusultvo);
		}
		rs.close();
		stmt.close();
		conn.close();
		
		return relist;
	}
	
	public ArrayList<MakerVO> selectList(MakerVO vo) throws Exception{
		String query = "";
		query += "select ";
		query += "    m.maker_code, ";
		query += "    m.maker_name, ";
		query += "    m.maker_code, ";
		query += "    m.in_date, ";
		query += "    m.in_user, ";
		query += "    m.up_date, ";
		query += "    m.up_user ";
	
		query += "from ";
		query += "    car c,  ";
		query += "    maker m ";

		
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, user, pw);
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
		ArrayList<MakerVO> list = new ArrayList<MakerVO>();
		while(rs.next()){
			String maker_code = rs.getString(1);
			String maker_name = rs.getString(2);
			String in_date = rs.getString(3);
			String in_user = rs.getString(4);
			String up_date = rs.getString(5);
			String up_user = rs.getString(6);
		
			
			MakerVO reusultvo = new MakerVO();
			reusultvo.setMaker_code(maker_code);
			reusultvo.setMaker_name(maker_name);
			reusultvo.setIn_date(in_date);
			reusultvo.setIn_user(in_user);
			reusultvo.setUp_date(up_date);
			reusultvo.setUp_user(up_user);
			
			list.add(reusultvo);
		}
		
		rs.close();
		stmt.close();
		conn.close();
		
		return list;
		
		
}
	public static void main(String[] args) throws Exception {
//		MakerDao dao = new MakerDao();
//		MakerVO vo = new MakerVO();
//		vo.setMaker_code("HD");
//		
//		MakerVO rvo = dao.select(vo);
//		System.out.println(rvo.getMaker_name());
		
//		//전체 Select문
//		MakerDao dao = new MakerDao();
//		
//		ArrayList<MakerVO> list = dao.select(null);
//		
//		for(int i=0; i<list.size(); i++){
//			System.out.println(list.get(i).getMaker_code() + " " + list.get(i).getMaker_name() + " "
//							   + list.get(i).getIn_date() + " " + list.get(i).getIn_user() + " "
//							   + list.get(i).getUp_date() + " " + list.get(i).getUp_user() + " ");
//		}
	}
	
}
