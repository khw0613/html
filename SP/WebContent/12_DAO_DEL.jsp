
<%@page import="com.patagonia.model.PataVO"%>
<%@page import="com.patagonia.dao.OracleDao"%>
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
String col1 = request.getParameter("col1");

OracleDao dao = new OracleDao();
PataVO vo = new PataVO();

vo.setCol1(col1);

int cnt = dao.delPata(vo);
%>
<%=cnt %>개가 삭제 되었습니다.

</body>
</html>