<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style>
.bookinglist .blist-li2 {
	font-size: 15px;
}
</style>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/main.css">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</head>
<body>
	<%@ include file='../header.jsp'%>
	<div id="booking">
		<table class="logTable">
			<tr>
				<c:choose>
					<c:when test="${empty loginUser.userid }">
						<td style="border-right: 1px solid lightgray;">
							<h2>회원이시라면?</h2>
							<p>
								로그인을 하시면 더 빠르고 편리하게<br> 서비스를 이용하실 수 있습니다.
							</p>
							<div class="login" onclick="showPopupLogin()">LOGIN</div>
					</c:when>
					<c:otherwise>
						<td style="border-right: 1px solid lightgray;">
							<h2>회원이시라면?</h2>
							<p style="margin-bottom: 35px;">
								로그인을 하시면 더 빠르고 편리하게<br> 서비스를 이용하실 수 있습니다.
							</p>
							<form action="./logout">
								<input type="submit" value="LOGOUT" name="logout" class="logout">
							</form>
					</c:otherwise>
				</c:choose>

				<td><h2>아직도 회원이 아니세요?</h2>
					<p>
						회원가입을 하시면 예약, 예약내역 등의<br> 서비스를 간편하게 이용하실 수 있습니다.
					</p>
					<div class="mypage" onclick="showPopupSignup()">SIGNUP</div></td>
			</tr>
		</table>
		<!-- <div class="bookingsearch">
			<h2>예약자 검색</h2>
			<div style="background-color: lightgray; height: 60px;">
				<label>이 름</label> <input type="text"> <label>연락처</label> <input
					type="text"> <label>비밀번호</label> <input type="password">
				<input type="submit" class="subbtn" value="검색"
					style="font-size: 15px; height: 30px; width: 60px; font-family: 'NanumSquare';">
			</div>
		</div> -->
		<div class="bookinglist">
			<h2>예약목록</h2>
			<ul>
				<li style="width: 8%;" class="blist-li">예약번호</li>
				<li style="width: 10%;" class="blist-li">예약자아이디</li>
				<li style="width: 15%;" class="blist-li">예약병원명</li>
				<li style="width: 40%;" class="blist-li">예약병원주소</li>
				<li style="width: 8%;" class="blist-li">예약일시</li>
				<li style="width: 10%;" class="blist-li">전화번호</li>
			</ul>
			<c:forEach items="${bookingdtos }" var="bookingdtos">
				<ul>
					<li style="width: 8%;" class="blist-li2">${bookingdtos.booking_num }</li>
					<li style="width: 10%;" class="blist-li2">${bookingdtos.booking_id }</li>
					<li style="width: 15%;" class="blist-li2">${bookingdtos.booking_Name }</li>
					<li style="width: 40%;" class="blist-li2">${bookingdtos.booking_Add}
					</li>
					<li style="width: 8%;" class="blist-li2">${bookingdtos.booking_Date }</li>
					<li style="width: 10%;" class="blist-li2">${bookingdtos.booking_Tel }</li>
				</ul>
			</c:forEach>
			<div class="board-pageNum">
				<tr>
					<td colspan="5"><a
						href="./booking_list?page=${bookingPage.firstPageNum }
			&pageDataCount=${bookingPage.pageDataCount}">
							◀◀맨앞으로 </a>&nbsp;&nbsp; <a
						href="./booking_list?page=${bookingPage.prevPageNum }
			&pageDataCount=${bookingPage.pageDataCount}">
							◀앞으로 </a>&nbsp;&nbsp; <c:forEach var="i"
							begin="${bookingPage.startPageNum }"
							end="${bookingPage.endPageNum }" step="1">
							<c:choose>
								<c:when test="${i eq bookingPage.currentPageNum }">
									<a style="font-weight: bold; color: blue"
										href="./booking_list?page=${i }
				&pageDataCount=${bookingPage.pageDataCount}">${i }
									</a>&nbsp;&nbsp;
			</c:when>
								<c:otherwise>
									<a
										href="./booking_list?page=${i }
			&pageDataCount=${bookingPage.pageDataCount}">${i }
									</a>&nbsp;&nbsp;
			</c:otherwise>
							</c:choose>
						</c:forEach> <a
						href="./booking_list?page=${bookingPage.nextPageNum }
			&pageDataCount=${bookingPage.pageDataCount}">뒤로▶
					</a>&nbsp;&nbsp; <a
						href="./booking_list?page=${bookingPage.lastPageNum }
			&pageDataCount=${bookingPage.pageDataCount}">맨뒤로▶▶
					</a></td>
				</tr>
			</div>
		</div>
	</div>
	<%@ include file='../footer.jsp'%>
	<script src="./javascript/main.js">
		
	</script>
</body>
</html>