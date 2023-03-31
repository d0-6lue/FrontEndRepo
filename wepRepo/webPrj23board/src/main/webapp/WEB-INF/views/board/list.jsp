<%@page import="com.kh.app.board.vo.BoardVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	html, body{
        margin: 0;
        padding: 0;
    }
    .wrap{
        width: 80%;
        height: 100vh;
        margin: auto;
        background-color: lightblue;
    }
    .align {
    	padding: 0;
    	margin: 0;
        display: flex;
        justify-content: center;
        align-items: center;
    }
    table {
    	border-collapse: collapse;
    	height: 500px;
    }
</style>
</head>
<body>

	<% List<BoardVo> boardVoList = (List)request.getAttribute("boardVoList"); %>
	
	<div class="wrap">
		<h1 class="align">글 목록</h1>
		<hr>
		<div class="list align">
			<table border="1">
				<thead>
		            <tr>
		                <th>글번호</th>
		                <th>내용</th>
		                <th>작성자</th>
		                <th>작성일자</th>
		            </tr>
	            </thead>
	            <tbody>
	            	<% for(int i = 0; i < boardVoList.size(); i++) { %>
			            <tr>
			                <td><%= boardVoList.get(i).getNo() %></td>
			                <td>
			                	<a href="/app23/board/detail?no=<%= boardVoList.get(i).getNo() %>">
			                		<%= boardVoList.get(i).getTitle() %>
			                	</a>
			                </td>
			                <td><%= boardVoList.get(i).getWriterNick() %></td>
			                <td><%= boardVoList.get(i).getEnrollDate() %></td>
			            </tr>
		            <% } %>
	            </tbody>
	        </table>
		</div>
		<br>
        <a href="/app23" class="align">홈으로</a>
	</div>
	

</body>
</html>