<%@page import="com.kh.app.board.vo.BoardVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	html, body {
		margin: 0;
		padding: 0;
	}
	.wrap {
		width: 80%;
		height: 100vh;
		margin: auto;
		background-color: lightblue;
	}
	h3 {
		margin: 0;
	}
	.title {
		height: 30px;
	}
	.nick-date {
		display: flex;
		justify-content: space-between;
		align-items: center;
	}
	.content {
		display: flex;
		justify-content: center;
	}
	textarea {
		width: 80%;
        height: 500px;
        resize: none;
	}
	.button {
		display: flex;
		justify-content: space-around;
	}
</style>
</head>
<body>

	<!-- 	EL ( Expression Language ) -->
	<!-- EL 연산자 검색 -->
	${ 10 }
	${ 10 + 20 }
	${ 'Hello, world' == boardVo.title }
	${ 'Hello, world' eq boardVo.title }
	${ 'Hello, world' != boardVo.title }
	${ 'Hello, world' ne boardVo.title }
	${ 10 < 20 }
	${ 10 lt 20 }
	${ 10 le 20 }
	${ 10 > 20 }
	${ 10 gt 20 }
	${ 10 ge 20 }
	${ 10 + 20 == 30 ? 123 : 321 }
	${ empty boardVo.writerNo } <!-- null, 빈문자열, 0 빈 배열 등등 -->
	
	<div class="wrap">
		<div class="title"><h3>제목 : ${boardVo.title}</h3></div>
		<h4><div class="nick-date">
			<span>작성자 : ${boardVo.writerNick }</span>
			<span>작성일 : ${boardVo.enrollDate }</span>
		</div></h4>
		<div class="content">
			<textarea> ${boardVo.content }</textarea>
		</div>
		
		<div class="button">
			<a href="/app23/board/list">뒤로</a>
			<a href="/app23">홈으로</a>
		</div>
		
	</div>

</body>
</html>