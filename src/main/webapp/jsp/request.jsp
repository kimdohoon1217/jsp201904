<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--jsp에서는 request를 사용할수 있다 --%>
	<%
		//jsp에 내장되어있는 기본 객체가 존재 request, response
		//
		
	
	
	%>
	resquest.getLocalAddr() local ip = <%= request.getLocalAddr() %><br>
	resquest.getRemoteAddr() 클라이언트 ip = <%= request.getRemoteAddr()%><br>
	resquest.getContentLength() 요청정보 길이 = <%= request.getContentLength()%><br>
	resquest.getCharacterEncoding() 요청정보 인코딩 = <%= request.getCharacterEncoding()%><br>
	resquest.getContentType() 요청정보 컨텐트 타입 = <%= request.getContentType() %><br>
	resquest.getProtocol() 요청 프로토콜 = <%= request.getProtocol()%><br>
	resquest.getMethod() 요청 메서드= <%= request.getMethod()%><br>
	resquest.getRequestURI() 요청 URI = <%= request.getRequestURI()%><br>
	resquest.getContextPath() context path= <%= request.getContextPath()%><br>
	resquest.getServerName() 서버이름  = <%= request.getServerName()%><br>
	resquest.getServerPort() 서버포트번호 = <%= request.getServerPort() %><br>
	
	
</body>
</html>