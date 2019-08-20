<%@page import="kr.or.ddit.user.service.UserService"%>
<%@page import="kr.or.ddit.user.model.User"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.user.repository.UserDao"%>
<%@page import="kr.or.ddit.user.repository.IUserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%!UserService service = new UserService();
 List<User> list = service.getUserList();%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table{
		border-left :none;
		border-right : none;
		border-collapse: collapse;
		margin : 10px 10px 10px 800px;
		
	
	}
	
	td{
		border-left :none;
		border-right : none;
		width : 150px;
		height : 100px;
		text-align: center;
	}


	th{
		background : black;
		color : white;
	
	}
	
	span{
		color : red;
		font-weight : bold;
	
	}

</style>

</head>
<body>
	<%-- 1. userdao 선언 
		 2. getUserList()호출
		 3. 호출 결과 (List<UserVo>)를 for loop를 통해 tr태그를 반복 생성
	--%>
	<table border = 1>
	
		<tr>
			<th>이름</th>
		</tr>
	<%-- 	<% for(int i = 0; i<dao.getUserList().size(); i++){ %>
			<tr>
				<td>
				<%=i + "번째 유저이름 "%><br>
				<span><%=dao.getUserList().get(i).getUserName()%></span>
				</td>
			</tr>
		<%} %> --%>
		
		
		<%
							for(User user : list){
						%>
			<tr>
			 <td><span><%=user.getUserNm() %></span></td>
			</tr>
		<%} %> 
		
	</table>
</body>
</html>