package com.patagonia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcTest01 {
	public static void main(String[] args) throws Exception {
		String driver	 	= "oracle.jdbc.driver.OracleDriver";
		String url		    = "jdbc:oracle:thin:@localhost:1521:xe";
		String user 		= "patagonia"; 
        String pw 			= "q1w2e3r4";
        
        Class.forName(driver);
        Connection  con = DriverManager.getConnection(url, user, pw);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select col1, col2, col3 from pata");
        //rs에서 가지고 올떄 1부터 시작 한다..driver
        while(rs.next()){
        	String col1 = rs.getString(1);
        	String col2 = rs.getString(2);
        	String col3 = rs.getString(3);
        	
        	System.out.println("col1:" + col1);
        	System.out.println("col2:" + col2);
        	System.out.println("col3:" + col3);
        }
        rs.close();
        stmt.close();
        con.close();

		
	/*	Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			String quary = "SELECT * FROM EMP";
			
			conn = DBConnection.getConnection();
			pstm = conn.prepareStatement(quary);
			rs = pstm.executeQuery();
			
			System.out.println("EMPNO ENAME JOB MGRF HIRDATE SAL COMM DEPTNO");
			System.out.println("============================================");
			
			while (rs.next()) {
				int empno = rs.getInt(1);
				String ename = rs.getString(2);
				String job = rs.getString(3);
				int mgr = rs.getInt(4);
				java.sql.Date hiredate = rs.getDate(5);
				int sal = rs.getInt(6);
				int comm = rs.getInt(7);
				int deptno = rs.getInt(8);
				
				String result = empno + " " + ename + " " + job + " " + mgr
							+ " " + hiredate + " " + sal + " " + comm + " " + deptno; 
				System.out.println(result);
				
			}
		} catch (SQLException sqle) {
			System.out.println("SELECT문에서 예외 발생");
			sqle.printStackTrace();
		}finally{
			try {
				if(rs != null) {rs.close();}
				if(pstm != null) {pstm.close();}
				if(conn != null) {conn.close();}
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}
}

class DBConnection{
	public static Connection dbConn;
	
	public static Connection getConnection(){
		Connection conn = null;
         try {
             String user = "patagonia"; 
             String pw = "q1w2e3r4";
             String url = "jdbc:oracle:thin:@localhost:1521:xe";
             
             Class.forName("oracle.jdbc.driver.OracleDriver");        
             conn = DriverManager.getConnection(url, user, pw);
             
             System.out.println("Database에 연결되었습니다.\n");
             
         } catch (ClassNotFoundException cnfe) {
             System.out.println("DB 드라이버 로딩 실패 :"+cnfe.toString());
         } catch (SQLException sqle) {
             System.out.println("DB 접속실패 : "+sqle.toString());
         } catch (Exception e) {
             System.out.println("Unkonwn error");
             e.printStackTrace();
         }
         return conn;   */  
     }
}


