<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>결과 페이지</h1>

	<%
		String x = (String)request.getAttribute("resultMsg"); 
	%>
	
	<h3>회원가입 <%= x %></h3>

</body>
</html>