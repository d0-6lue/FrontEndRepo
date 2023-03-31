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
		background-color: lightblue;
		margin: auto;
	}
	.wrap * {
		display: flex;
		justify-content: center;
		align-items: center;
	}
	header{
		border-bottom: 1px solid black;
	}

    #wrap {
        margin-top: 10px;
        background-color: khaki;
        width: 400px;
        height: 400px;

        border: 1px solid black;
        box-sizing: border-box;

        display: grid;
        grid-template-columns: 1fr 3fr;
        grid-template-rows: 1fr 6fr 1fr;
    }

    #wrap > div {
        display: flex;
        justify-content: center;
        align-items: center;
    }

    input[name='title'] {
        width: 250px;
    }

    textarea[name='content'] {
        width: 250px;
        height: 300px;
        resize: none;
    }

    #wrap > div:last-child {
        grid-column: 1/3;
    }

</style>
</head>
<body>

    <div class="wrap">
        <header>
            <h1>게시글 작성</h1>
        </header>

        <form action="/app23/board/write" method="post">
            <div id="wrap">
                <div>
                    제목
                </div>
                <div>
                    <input type="text" name="title">
                </div>
                <div>
                    내용
                </div>
                <div>
                    <textarea name="content"></textarea>
                </div>
                <div>
                    <input type="submit" value="작성하기">
                </div>
            </div>
        </form>

    </div>
    
</body>
</html>