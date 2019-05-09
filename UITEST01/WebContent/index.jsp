<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>patagonia</title>
<script src="jquery-1.12.4.js"></script>
<script type="text/javascript">
function init(){
	$.ajax({
		type : "get",
		url : "http://localhost/UITEST01/myselect01",
		dataType : "json",
		

		success : function(data) {
			renderCombo1(data);
		},

		error : function(xhr, status, error) {
			console.log("에러!: " + error);

		},

	});
}
function renderCombo1(data){
	var text = "";
	for(var i=0; i < data.length; i++){
	
		text += "<option value='"+data[i].maker_code+"'>"+data[i].maker_name+"</option>";
	}
	$("#my_select1").html(text);
	
}


function mychange01(data){
	var maker_code = $("#my_select1").val();
	if(maker_code == null){
		alert("기입 하셔야 합니다");
		return;
	}
	
	$.ajax({
		type : "get",
		url : "http://localhost/UITEST01/myselect02",
		data : { maker_code: maker_code },
		dataType : "json",
		

		success : function(data) {
			renderCombo2(data);
		},

		error : function(xhr, status, error) {
			console.log("에러!: " + error);

		},

	});
}

function renderCombo2(data){
	var text = "";
	for(var i=0; i < data.length; i++){
	
		text += "<option value='"+data[i].car_code+"'>"+data[i].car_name+"</option>";
	}
	$("#my_select2").html(text);
	
}

function mychange02(data){
	
	var maker_code = $("#my_select2").val();
	if(maker_code == null){
		alert("기입 하셔야 합니다");
		return;
	}
	
	$.ajax({
		type : "get",
		url : "http://localhost/UITEST01/myselect03",
		data : { maker_code: maker_code },
		dataType : "json",
		

		success : function(data) {
			rendertable(data);
		},

		error : function(xhr, status, error) {
			console.log("에러!: " + error);

		},

	});
	
}
function rendertable(data){
	var text = "";
	for(var i=0; i < data.length; i++){
		
		text += "<td value='"+data[i].car_code+"'>"+data[i].car_name+"</td>";
		text += "<td value='"+data[i].car_code+"'>"+data[i].maker_name+"</td>";
		text += "<td value='"+data[i].car_code+"'>"+data[i].fuel_type+"</td>";
		text += "<td value='"+data[i].car_code+"'>"+data[i].cc+"</td>";
		text += "<td value='"+data[i].car_code+"'>"+data[i].yunbi+"</td>";
		text += "<td value='"+data[i].car_code+"'>"+data[i].debut+"</td>";
	}
	$("#my_tbody").html(text);
	
}


</script>
</head>
<body onload="init()">


<select id="my_select1" onchange="mychange01()">
	<option value="">제조사 선택</option>
</select>

<select id="my_select2" onchange="mychange02()">
	<option value=""></option>
</select>
<br>

<table border="1">
	<tr>
		<td>차명</td>
		<td>제조사</td>
		<td>연료유형</td>
		<td>배기량(cc)</td>
		<td>연비</td>
		<td>출시일</td>
		
		
	</tr>
	<tbody id="my_tbody">
		
	</tbody>
	
	
</table>

</body>
</html>