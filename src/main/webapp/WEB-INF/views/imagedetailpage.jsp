<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>${loginUser.userid } 님의 페이지 입니다</h1>
<img style="width:500px;height:500px;"src="${imagedetail.uploadimage }">

<p>좋아요 랑 싫어요 기능도 고민중</p>
<p>댓글 만들어볼까?</p>

<input type="button" value="메인으로 돌아가기" onclick="location.href='main'">

</body>
</html>