<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("select[name=locale]").on('change', function(){
			$("#frm").submit();			
		});
		
		$("select[name=locale]").val('${locale}');
	});

</script>
</head>
<body>
	<form id="frm" action="${cp }/selectLocale" method="get">
		<select id="sel" name="locale">
			<option class="op" value="ko">한국어</option>
			<option class="op" value="en">english</option>
			<option class="op" value="zh">中国话</option>
		</select>
	</form>
	
	
	
	<fmt:setLocale value="${locale }"/>
	<input type="hidden" id="input" value="${locale }" />
	<fmt:setBundle basename="kr.or.ddit.config.msg.message" var="msg"/>
	<fmt:message key="GREETING" bundle="${msg }"/> <br>
	
</body>
</html>