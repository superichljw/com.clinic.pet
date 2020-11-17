<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="./css/main.css">

<style>
</style>
<script>
	function go_apply() {

		alert("적용되었습니다");
		location.reload();

	}
</script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<%@ include file='./header.jsp'%>
	<div id="con1">
		<div class="slideshow-container">

			<%-- <c:forEach items="${slidedList }" var="slidedList">
			<div class="mySlides fade">
				<img src="/image/upload/${ slidedList.pic}"
					style="width: 100%">
				<div class="text" style="visibility: hidden;">Caption Text</div>

			</div>
			
		</c:forEach> --%>
			<div class="mySlides fade">
				<img src="./image/main_slide01.png"
					style="width: 100%">
				<div class="text" style="visibility: hidden;">Caption Text</div>

			</div>

			<div class="mySlides fade">
				<img src="./image/main_slide02.png"
					style="width: 100%">
				<div class="text" style="visibility: hidden;">Caption Two</div>
			</div>

			<div class="mySlides fade">
				<img src="./image/main_slide03.png"
					style="width: 100%">
				<div class="text" style="visibility: hidden;">Caption Three</div>
			</div>

			<div class="mySlides fade">
				<img src="./image/main_slide04.png"
					style="width: 100%">
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
		<%-- <c:choose>
			<c:when test="${loginUser.usertype eq 'oper' }">
				<P style="font-size: 42PX; text-align: center;">
					NOT JUST PET, BUT ONLY FAMILY<input type="button"
						onclick="showPopupSlideChange()" value="슬라이드 사진변경"> <input
						type="button" onclick="go_apply();" value="사진적용">
				</P>
			</c:when>
			<c:otherwise>
				<P style="font-size: 42PX; text-align: center;">NOT JUST PET,
					BUT ONLY FAMILY</P>
			</c:otherwise>
		</c:choose> --%>
		<P style="font-size: 42PX; text-align: center;">NOT JUST PET, BUT
			ONLY FAMILY</P>
		<div class="con2pic">
			<div class="pic1">
				<a href='./search_list'><img
					src="./image/dog_sub01.jfif"></a>
			</div>
			<div class="pic2">
				<a href='./board_list'><img
					src="./image/dog_sub02.jfif"></a>
			</div>
			<div class="pic3">
				<a href='./selfinspection'><img
					src="./image/dog_sub05.jfif"></a>
			</div>
			<div class="pic4">
				<a href='./notice_list'><img
					src="./image/dog_sub04.jfif"></a>
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
						id="writebtn"
						onclick="location.href='./board_list'">
					</th>
				</tr>
				<c:choose>
					<c:when test="${empty boardList }">
						<tr class="tbtitle">
							<td style="width: 15%;">글번호</td>
							<td style="width: 55%;">제목</td>
							<td style="width: 15%;">작성자</td>
							<td style="width: 15%;">작성일</td>
						</tr>
						<tr>
							<td colspan="4">첫번째 질문을 올려보세요!</td>
						</tr>
					</c:when>
					<c:otherwise>
						<tr class="tbtitle">
							<td style="width: 15%;">글번호</td>
							<td style="width: 55%;">제목</td>
							<td style="width: 15%;">작성자</td>
							<td style="width: 15%;">작성일</td>
						</tr>
						<c:forEach items="${boardList }" var="boardList">
							<tr>
								<td style="width: 15%;">${boardList.num }</td>
								<td style="width: 55%;">${boardList.title }</td>
								<td style="width: 15%;">${boardList.name }</td>
								<td style="width: 15%;"><fmt:formatDate
										value="${boardList.writedate }" /></td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>

			</table>

		</div>
	</div>
	<div id="con5">
		<div>
			<p>
				<img src="./image/promise.png">4-PROMISES
			</p>
		</div>
		<div class="promise">
			<ul>
				<li><a href="./search_list"><img src="./image/lowerimg01.png"></a></li>
				<li><a href="./booking_list"><img src="./image/lowerimg02.png"></a></li>
				<li><a href="./board_list"><img src="./image/lowerimg03.png"></a></li>
				<li><a href="./selfinspection'"><img src="./image/lowerimg04.png"></a></li>
			</ul>
		</div>
	</div>
	<%@ include file='./footer.jsp'%>

	<script src="./javascript/main.js">
		
	</script>
</body>
</html>