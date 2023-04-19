<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>100</title>
</head>
<body>

    <div class="wrap">

        <%@ include file="/WEB-INF/views/common/header.jsp" %>

        <main>
            <div>
                <ul class="chatroom-util">
                    <li><button class="chatroom-util-btn chatroom-main-reload">새로고침</button></li>
                    <li><button class="chatroom-util-btn">방만들기</button></li>
                </ul>
            </div>

            <div class="chatroom-list">
                
            </div>

        </main>

    </div>

</body>
</html>
<link rel="stylesheet" href="${root }/resource/css/chat/chatroom-home.css">
<script defer src="${root }/resource/js/chat/chathome.js"></script>
