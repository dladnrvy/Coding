<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script>
		$(document).ready(function () {
			$.ajax({
				url: 'seat.jsp',
				type: 'GET',
				data : {
					name: $('.time').val(this)
				},
				success: function(data){
					if(data == '1'){
						alert("1번시간");
					}else{
						alert("2번시간");
					}
				}
			});
		});
	</script>
<body>
	<input type="button" class="time" id="1" value="첫번째시간">
	<input type="button" class="time" id="2" value="두번째시간">
	
</body>
</html>