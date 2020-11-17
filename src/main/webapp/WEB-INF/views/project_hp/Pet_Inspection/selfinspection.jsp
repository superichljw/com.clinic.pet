<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/main.css">
<style>
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<title>Insert title here</title>
</head>
<body>
	<%@ include file='../header.jsp'%>
	<div id="self">
		<h1>자가진단 서비스</h1>
		<h2>나의 반려동물의 건강상태가 궁금하신가요?</h2>
		<p>
			<br>ALL THAT PET 에서 제공하는 자가진단 서비스를 통해 반려동물의 건강상태를 스스로 체크해보시고, <br>
			스스로 반려동물의 지킴이가 되어보세요.<br> <br> ※자가진단 서비스를 통해 확인한 결과는 참고용으로
			사용하시고, 자세한 결과는 전문의에게 상담받아보세요※
		</p>
	</div>
	<div id="selfpic">
		<ul>
			<li><label>for DOG</label>
				<div class="selfpic1">
					<img src="./image/selfInspec-dog.png"
						onclick='showPopupInspec();'>
				</div></li>
			<li><label>for CAT</label>
				<div class="selfpic1">
					<img src="./image/selfInspec-cat.png"
						onclick='showPopupInspec();'>
				</div></li>
		</ul>
	</div>
	<%@ include file='../footer.jsp'%>
	<script src="./javascript/main.js">
		
	</script>
</body>
</html>