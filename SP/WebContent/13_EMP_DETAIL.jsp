
<%@page import="com.patagonia.dao.EmpDao"%>
<%@page import="com.patagonia.model.EmpVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>patagonia</title>
</head>
<script type="text/javascript">
	function fn_delete() {
		var flag = confirm("삭제할 데이터는 복구할 수 없습니다. 진행하시겟습니까?");
		if (!flag) {
			return;
		}

		document.frm.submit();

	}

	function fn_update() {
		document.frm.action = "13_EMP_UPD.jsp";
		document.frm.submit();
	}
</script>

<body>

	상세화면
	<%
	String sawon_id = request.getParameter("sawon_id");

	EmpVO paramVO = new EmpVO();
	paramVO.setSawon_id(sawon_id);

	EmpDao dao = new EmpDao();
	EmpVO rVO = dao.ddong(paramVO);
%>
	<form id="frm" name="frm" method="POST" action="13_EMP_DEL_ACT.jsp">
		<table border="1">
			
			<input type="hidden" name="sawon_id" value="<%=rVO.getSawon_id()%>">
			<tr>
				<td>사번</td>
				<td><%=rVO.getSawon_id()%></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><%=rVO.getSawon_name()%></td>
			</tr>
			<tr>
				<td>휴대폰</td>
				<td><%=rVO.getMobile()%></td>
			</tr>
			<tr>
				<td colspan="2"><input type="button" onclick="fn_delete()"
					value="삭제"> <input type="button" onclick="fn_update()"
					value="수정"></td>
			</tr>



		</table>
	</form>

</body>
</html>