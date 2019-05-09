package com.patagonia.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.patagonia.model.PataVO;

public class OracleDao {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "patagonia";
	String pw = "q1w2e3r4";
	
	public ArrayList<PataVO> getPata() throws Exception {

		ArrayList<PataVO> list = new ArrayList<PataVO>();

		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, user, pw);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select col1, col2, col3 from pata");
		// rs에서 가지고 올떄 1부터 시작 한다..driver
		while (rs.next()) {
			String col1 = rs.getString(1);
			String col2 = rs.getString(2);
			String col3 = rs.getString(3);

			PataVO vo = new PataVO();
			vo.setCol1(col1);
			vo.setCol2(col2);
			vo.setCol3(col3);
			list.add(vo);

		}
		rs.close();
		stmt.close();
		con.close();

		return list;
	}

	public int insPata(PataVO vo) throws Exception {
		String query = "insert into pata (col1, col2, col3) = '" + vo.getCol1()
				+ "',col3='" + vo.getCol2() + "' where col1= '" + vo.getCol3()
				+ "'";
		// 파라메타 값 넣을때
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, user, pw);
		Statement stmt = con.createStatement();
		int cnt = stmt.executeUpdate(query);

		stmt.close();
		con.close();

		return cnt;
	}

	public int updPata(PataVO vo) throws Exception {
		String query = "update pata set col2='" + vo.getCol2() + "',col3='"
				+ vo.getCol3() + "' where col1= '" + vo.getCol1() + "'";
		// 파라메타 값 넣을때
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, user, pw);
		Statement stmt = con.createStatement();
		int cnt = stmt.executeUpdate(query);

		stmt.close();
		con.close();

		return cnt;

	}
	public int delPata(PataVO vo) throws Exception{
        String query		= "delete from pata where col1='" + vo.getCol1() + "'";
        
        Class.forName(driver);
        Connection  con = DriverManager.getConnection(url, user, pw);
        Statement stmt = con.createStatement();
        int cnt = stmt.executeUpdate(query);
        
        System.out.println("cnt : " + cnt);
     
        stmt.close();
        con.close();
        
        return cnt;
        
	}
	

	public static void main(String[] args) throws Exception {
		OracleDao dao = new OracleDao();
//		ArrayList<PataVO> list = dao.getPata();
//		for (int i = 0; i < list.size(); i++) {
//			String col1 = list.get(i).getCol1();
//			String col2 = list.get(i).getCol2();
//			String col3 = list.get(i).getCol3();
//
//			System.out.println(col1 + "\t");
//			System.out.println(col2 + "\t");
//			System.out.println(col3 + "\t");
//		}
//		PataVO vo = new PataVO();
//		vo.setCol1("1001");
//		vo.setCol2("홍길동");
//		vo.setCol3("1억");
//		
//		int cnt = dao.insPata(vo);
//		System.out.println(cnt+"개 적용 되었습니다.");
		
//		PataVO vo = new PataVO();
//		vo.setCol1("3");
//		vo.setCol2("홍길남");
//		vo.setCol3("5억");
//		
//		int cnt = dao.updPata(vo);
//		System.out.println(cnt+"개 적용 되었습니다.");
		
		PataVO vo = new PataVO();
		vo.setCol1("id");
		
		int cnt = dao.delPata(vo);
		System.out.println(cnt+"개 삭제 되었습니다.");
	}
}
