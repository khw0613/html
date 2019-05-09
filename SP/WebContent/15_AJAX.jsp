<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>patagonia</title>
<script src="jquery-1.12.4.js"></script>
<script type="text/javascript">

	function fn_ajax(){
		$.ajax({
			type : "get",
			url : "MyAjax",
			data : {
				param1: 'merryChrismax'
			},
			dataType : "json",

			success : function(data) {
				console.log(data.message);
				$("#mydiv").html(data.message);
			},

			error : function(xhr, status, error) {
				console.log("에러!: " + error);

			},

		});
	}
</script>
</head>
<body>
<a href="javascript:fn_ajax()">flickering X</a>

<div id="mydiv">Hello</div>

</body>
</html>