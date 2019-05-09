<%@page import="java.sql.ResultSet"%>
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
String driver = "oracle.jdbc.driver.OracleDriver";
String url = "jdbc:oracle:thin:@localhost:1521:xe";
String user = "patagonia";
String password = "q1w2e3r4";

Class.forName(driver);
Connection con = DriverManager.getConnection(url, user, password);
Statement stmt = con.createStatement(); //자바스크립트로 옮긴후 컨트롤 +스페이스로 하고 자바SQL로 바꿔줌
ResultSet rs = stmt.executeQuery("select * from pata"); //셀렉트는 query 나머지는 업데이트
%>
 <table border="1">
    <tr>
       <td>사번</td>
       <td>이름</td>
       <td>연봉</td>
    </tr>
<% 
while(rs.next()) {//비쥬얼베이직과 rs함수는 인덱스번호가 1부터 시작한다.
    String col1 = rs.getString(1);
    String col2 = rs.getString(2);
    String col3 = rs.getString(3);
%>
    <tr>
       <td><%=col1 %></td>
       <td><%=col2 %></td>
       <td><%=col3 %></td>
    </tr>
<%
            
            
         
}
rs.close();//1 매트리스개념 스택구조다.
stmt.close();//2 잘닫혓는지 확인해야한다. 각각 트라이캐치를 적용해줘야한다. 메모리가 남을 가능성이 있기때문에 계속 쌓여서 언젠간뒤짐
con.close();//3
%>



</table>
</body>
</html>