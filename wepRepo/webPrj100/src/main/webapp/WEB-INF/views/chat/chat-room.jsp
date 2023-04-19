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

            <div class="chat-area">

                <div class="others-chat-box"><span class="others-name">아무개</span><span class="chat others-chat">테스트 ㅇㅁㅇ</span></div>
                <div class="my-chat-box"><span class="chat my-chat">테스트 ㅇㅅㅇ</span><span class="i-my-me-mine">나</span></div>

                
            </div>
            <div class="chat-input">
                <input type="text" name="chatContent"> <button class="send">보내기</button>
            </div>

        </main>

    </div>

</body>
</html>
<link rel="stylesheet" href="${root }/resource/css/chat/chat-room.css">
<script src="${root}/resource/js/chat/chat-room.js"></script>