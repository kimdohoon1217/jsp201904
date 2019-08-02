<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action = "<%=request.getContextPath() %>/jsp/mul.jsp" method = "get">
		number1 : <input type ="text" name ="number1"/><br>
		number2 : <input type ="text" name ="number2"/><br>
		<input type = "submit" value = "넘버넘기기"/>			
	</form>

</body>
</html>