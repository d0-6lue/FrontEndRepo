<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ERROR PAGE</title>
</head>
<body>

	<h1>ERROR PAGE</h1>
	<hr>

	<% String errorMsg = (String)request.getAttribute("errorMsg"); %>

	<h3><%= errorMsg %></h3>

	<br>
	<a href="/app23">홈으로</a>

</body>
</html>