<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%-- <c:url value="/" var="root" /> --%>

<c:set var="root" value="${pageContext.request.contextPath}"></c:set>

<link rel="stylesheet" href="${root}/resource/css/common/header.css">
<header>
    <div class="logo">
        <a href="${root}/home">
            <img class="logo-img" src="${root}/resource/img/logo.png" alt="로고 이미지">
        </a>
    </div>
    <nav>
        <ul class="nav-list">
            <li class="nav-list-elem"><a href="">공지사항</a></li>
            <li class="nav-list-elem"><a href="">자유게시판</a></li>
            <li class="nav-list-elem"><a href="">갤러리</a></li>
            <li class="nav-list-elem"><a href="">문의게시판</a></li>
            <li class="nav-list-elem"><a href="${root }/chat/home">채팅방</a></li>
        </ul>
        <div class="nav-util">
            <button class="login-btn">로그인</button>
            <div class="join-find">
                <div class="join"><a href="${root }/member/join">회원가입</a></div>
                <div class="find"><a href="">아이디/비밀번호 찾기</a></div>
            </div>
        </div>
    </nav>
</header>