<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>사용자 아이디</th>
				<th>사용자 이름</th>
				<th>사용자 별명</th>
			</tr>
		</thead>
		<c:forEach items="${S_USERVO_LIST }" var="list">
			<tbody>
				<tr>
					<td>${list.userId }</td>
					<td>${list.userNm }</td>
					<td>${list.alias }</td>
				</tr>
			</tbody>
		</c:forEach>
	</table>
</body>
</html>