
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>patagonia</title>
</head>
<body>
<%

String col1 = request.getParameter("col1");//파라메타
String col2 = request.getParameter("col2");
String col3 = request.getParameter("col3");


String driver	 	= "oracle.jdbc.driver.OracleDriver";
String url		    = "jdbc:oracle:thin:@localhost:1521:xe";
String user 		= "patagonia"; 
String pw 			= "q1w2e3r4";
String query		= "insert into pata (col1, col2, col3) values('"+col1+"', '"+col2+"', '"+col3+"')";
																//파라메타 값 넣을때
Class.forName(driver);
Connection  con = DriverManager.getConnection(url, user, pw);
Statement stmt = con.createStatement();
int cnt = stmt.executeUpdate(query);

if(cnt == 1){
%>
정상적으로 입력되었습니다.
<%
}

stmt.close();
con.close();

%>

</body>
</html>