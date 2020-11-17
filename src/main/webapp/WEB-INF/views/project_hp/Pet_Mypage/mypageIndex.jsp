<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./css/main.css">
<style>
.mypageBack {
	width: 80%;
	margin: 0 auto;
	padding-top: 30px;
}
</style>


<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</head>
<body>
	<%@ include file='../header.jsp'%>
	<input type="hidden" name="searchCol" value="AHLname">
	<input type="hidden" name="searchVal" value="${loginUser.userid }">
	<div class="mypageBack">
		<c:choose>
			<c:when test="${loginUser.usertype eq 'oper' }">
				<div class="mypageLeft">
					<ul>
						<li><h1>마이페이지</h1></li>
						<li><h3>
								<a href="./booking_mypage">나의예약보기</a>
							</h3></li>
						<li><h3>
								<a href="./member_info">개인정보수정</a>
							</h3></li>
						<li><h3>
								<a href="./mypage_mod_byadmin">회원정보수정</a>
							</h3></li>
							<li><h3>
								<a href="./instapage">개인페이지</a>
							</h3></li>
					</ul>
				</div>
			</c:when>
			<c:otherwise>
				<div class="mypageLeft">
					<ul>
						<li><h1>마이페이지</h1></li>
						<li><h3>
								<a href="./booking_mypage">나의예약보기</a>
							</h3></li>
						<li><h3>
								<a href="./member_info">개인정보수정</a>
							</h3></li>
							<li><h3>
								<a href="./instapage">개인페이지</a>
							</h3></li>
					</ul>
				</div>
			</c:otherwise>
		</c:choose>

		<div class="mypageRight">

			<table>
				<tr>
					<th style="width: 10%">예약번호</th>
					<th style="width: 15%">예약병원</th>
					<th style="width: 50%">예약병원주소</th>
					<th style="width: 10%">예약날짜</th>
					<th style="width: 10%">병원전화</th>

				</tr>


				<c:forEach items="${bookingidList }" var="bookingidList">

					<tr>
						<td>${bookingidList.booking_num }</td>
						<td>${bookingidList.booking_Name }</td>
						<td>${bookingidList.booking_Add}</td>
						<td>${bookingidList.booking_Date }</td>
						<td>${bookingidList.booking_Tel }</td>
					</tr>
				</c:forEach>
			</table>
			<%-- <div class="board-pageNum">
				<tr>
					<td colspan="5"><a
						href="booking_pageview.do?page=${bookingPage.firstPageNum }
			&pageDataCount=${bookingPage.pageDataCount}&searchCol=${bookingPage.searchCol }
			&searchVal=${bookingPage.searchVal }">
							◀◀맨앞으로 </a>&nbsp;&nbsp; <a
						href="booking_pageview.do?page=${bookingPage.prevPageNum }
			&pageDataCount=${bookingPage.pageDataCount}&searchCol=${bookingPage.searchCol }
			&searchVal=${bookingPage.searchVal }">
							◀앞으로 </a>&nbsp;&nbsp; <c:forEach var="i"
							begin="${bookingPage.startPageNum }"
							end="${bookingPage.endPageNum }" step="1">
							<c:choose>
								<c:when test="${i eq bookingPage.currentPageNum }">
									<a style="font-weight: bold; color: blue"
										href="booking_pageview.do?page=${i }
				&pageDataCount=${bookingPage.pageDataCount}&searchCol=${bookingPage.searchCol }
			&searchVal=${bookingPage.searchVal }">${i }
									</a>&nbsp;&nbsp;
			</c:when>
								<c:otherwise>
									<a
										href="booking_pageview.do?page=${i }
			&pageDataCount=${bookingPage.pageDataCount}&searchCol=${bookingPage.searchCol }
			&searchVal=${bookingPage.searchVal }">${i }
									</a>&nbsp;&nbsp;
			</c:otherwise>
							</c:choose>
						</c:forEach> <a
						href="booking_pageview.do?page=${bookingPage.nextPageNum }
			&pageDataCount=${bookingPage.pageDataCount}&searchCol=${bookingPage.searchCol }
			&searchVal=${bookingPage.searchVal }">뒤로▶
					</a>&nbsp;&nbsp; <a
						href="booking_pageview.do?page=${bookingPage.lastPageNum }
			&pageDataCount=${bookingPage.pageDataCount}&searchCol=${bookingPage.searchCol }
			&searchVal=${bookingPage.searchVal }">맨뒤로▶▶
					</a></td>
				</tr>
			</div> --%>
		</div>
	</div>
	<%@ include file='../footer.jsp'%>
	<script src="./javascript/main.js">
		
	</script>
</body>
</html>