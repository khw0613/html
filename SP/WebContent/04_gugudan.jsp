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
	int dan = Integer.parseInt(request.getParameter("dan"));
	
// 	for(int i = 1; i <= 9; i++){
// 		out.println(dan + " * " + i + " = " + i*2 + "<br/>");
// 	 } 
%>
<%for(int i = 1; i <= 9; i++){ %>
<%= dan + " * " + i + " = " + (i*2) + "<br/>" %>
<%} %>

</body>
</html>