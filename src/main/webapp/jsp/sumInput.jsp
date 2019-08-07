<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action = "<%=request.getContextPath() %>/sumCalculation" method = "post">
		start : <input type ="text" name ="start" required/><br>
		end : <input type ="text" name ="end" required/><br>
		<input type = "submit" value = "try"/>			
	</form>

</body>
</html>