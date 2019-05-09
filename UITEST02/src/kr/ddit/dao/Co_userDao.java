package kr.ddit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import kr.ddit.vo.Co_addrVO;
import kr.ddit.vo.Co_userVO;


public class Co_userDao {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "patagonia";
	String pw = "q1w2e3r4";
	
	public int select(String p_get_id) throws Exception{
		String query = "select * from co_user where co_id = '"+p_get_id+"'";
		
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, user, pw);
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		int cnt=0;
		
		while(rs.next()){
		cnt++;
		}
		
		rs.close();
		stmt.close();
		conn.close();
		
		return cnt;
	}
	public static void main(String[] args) throws Exception {
		Co_userDao dao = new Co_userDao();
		Co_userVO vo = new Co_userVO();
		System.out.println(dao.select("sys123"));
	}
	
}
