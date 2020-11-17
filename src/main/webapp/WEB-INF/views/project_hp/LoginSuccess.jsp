<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/main.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<%@ include file='./header.jsp'%>
	<div id="con1">
		<div class="slideshow-container">
			<div class="mySlides fade">
				<img src="image/main_slide01.png" style="width: 100%">
				<div class="text" style="visibility: hidden;">Caption Text</div>

			</div>

			<div class="mySlides fade">
				<img src="image/main_slide02.png" style="width: 100%">
				<div class="text" style="visibility: hidden;">Caption Two</div>
			</div>

			<div class="mySlides fade">
				<img src="image/main_slide03.png" style="width: 100%">
				<div class="text" style="visibility: hidden;">Caption Three</div>
			</div>

			<div class="mySlides fade">
				<img src="image/main_slide04.png" style="width: 100%">
				<div class="text" style="visibility: hidden;">Caption Three</div>
			</div>

			<a class="prev" onclick="plusSlides(-1)">◁</a> <a class="next"
				onclick="plusSlides(1)">▷</a>

			<div style="text-align: center; margin-top: 200px;">
				<span class="dot" onclick="currentSlide(1)"></span> <span
					class="dot" onclick="currentSlide(2)"></span> <span class="dot"
					onclick="currentSlide(3)"></span> <span class="dot"
					onclick="currentSlide(4)"></span>
			</div>
		</div>
	</div>
	<div id="con2">
		<P style="font-size: 42PX; text-align: center;">NOT JUST PET, BUT
			ONLY FAMILY</P>
		<div class="con2pic">
			<div class="pic1">
				<a href='clinic.jsp'><img src="image/dog_sub01.jfif"></a>
			</div>
			<div class="pic2">
				<a href='booking.jsp'><img src="image/dog_sub02.jfif"></a>
			</div>
			<div class="pic3">
				<a href='vetboard.jsp'><img src="image/dog_sub05.jfif"></a>
			</div>
			<div class="pic4">
				<a href='selfinspection.jsp'><img src="image/dog_sub04.jfif"></a>
			</div>
		</div>
	</div>
	<div id="con3">
		<p style="font-size: 42PX; text-align: center;">ASK VETERINARIANS
			YOUR QUESTIONS!</p>
		<div id="con4">
			<table id="table">
				<tr class="btncon">
					<th class="btn" colspan="4"><input type="button" value="질문하기"
						id="writebtn" onclick="location.href='#'"></th>
				</tr>
				<tr class="tbtitle">
					<td style="width: 15%;">답변상태</td>
					<td style="width: 55%;">내용</td>
					<td style="width: 15%;">작성자</td>
					<td style="width: 15%;">작성일</td>
				</tr>
				<tr>
					<td style="width: 15%;">답변완료</td>
					<td style="width: 55%;">비밀글 입니다</td>
					<td style="width: 15%;">와꾸맨</td>
					<td style="width: 15%;">2020.06.16</td>
				</tr>
				<tr>
					<td style="width: 15%;">답변완료</td>
					<td style="width: 55%;">비밀글 입니다</td>
					<td style="width: 15%;">와꾸맨</td>
					<td style="width: 15%;">2020.06.16</td>
				</tr>
				<tr>
					<td style="width: 15%;">답변완료</td>
					<td style="width: 55%;">비밀글 입니다</td>
					<td style="width: 15%;">와꾸맨</td>
					<td style="width: 15%;">2020.06.16</td>
				</tr>
				<tr>
					<td style="width: 15%;">답변완료</td>
					<td style="width: 55%;">비밀글 입니다</td>
					<td style="width: 15%;">와꾸맨</td>
					<td style="width: 15%;">2020.06.16</td>
				</tr>
				<tr>
					<td style="width: 15%;">답변완료</td>
					<td style="width: 55%;">비밀글 입니다</td>
					<td style="width: 15%;">와꾸맨</td>
					<td style="width: 15%;">2020.06.16</td>
				</tr>
			</table>
			<div id="tableno">◁ ▷</div>
		</div>
	</div>
	<div id="con5">
		<div>
			<p>
				<img src="image/promise.png">4-PROMISES
			</p>
		</div>
		<div class="promise">
			<ul>
				<li><img src="image/lowerimg01.png"></li>
				<li><img src="image/lowerimg02.png"></li>
				<li><img src="image/lowerimg03.png"></li>
				<li><img src="image/lowerimg04.png"></li>
			</ul>
		</div>
	</div>
	<div id="footer"></div>

	<script src="./javascript/main.js">
		
	</script>
</body>
</html>