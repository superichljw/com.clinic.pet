<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./css/main.css">
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</head>
<body>
	<%@ include file='../header.jsp'%>
	<input type="hidden" name="searchCol" value="">
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
					<th style="width: 10%">유저타입</th>
					<th style="width: 10%">아이디</th>
					<th style="width: 15%">연락처</th>
					<th style="width: 50%">주소</th>
					<th style="width: 10%">가입일</th>
					<th style="width: 10%">회원정보수정</a></th>

				</tr>


				<c:forEach items="${searchdtos }" var="searchdtos"
					varStatus="status">
					<form action="./mem_update_byadmin" name="frm" method="post">
						<tr>
							<td>${searchdtos.usertype }</td>
							<td><input type="hidden" name="userid"
								value="${searchdtos.userid }">${searchdtos.userid }</td>
							<td>${searchdtos.phone}</td>
							<td>${searchdtos.addr }</td>
							<td>${searchdtos.joindate }</td>
							<td><input type="submit" value="회원정보수정"></td>
						</tr>
					</form>
				</c:forEach>
			</table>
			<div class="board-pageNum">
				<tr>
					<td colspan="5"><a
						href="./mypage_mod_byadmin?page=${searchPage.firstPageNum }
			&pageDataCount=${searchPage.pageDataCount}&searchCol=${searchPage.searchCol }
			&searchVal=${searchPage.searchVal }">
							◀◀맨앞으로 </a>&nbsp;&nbsp; <a
						href="./mypage_mod_byadmin?page=${searchPage.prevPageNum }
			&pageDataCount=${searchPage.pageDataCount}&searchCol=${searchPage.searchCol }
			&searchVal=${searchPage.searchVal }">
							◀앞으로 </a>&nbsp;&nbsp; <c:forEach var="i"
							begin="${searchPage.startPageNum }"
							end="${searchPage.endPageNum }" step="1">
							<c:choose>
								<c:when test="${i eq searchPage.currentPageNum }">
									<a style="font-weight: bold; color: blue"
										href="./mypage_mod_byadmin?page=${i }
				&pageDataCount=${searchPage.pageDataCount}&searchCol=${searchPage.searchCol }
			&searchVal=${searchPage.searchVal }">${i }
									</a>&nbsp;&nbsp;
			</c:when>
								<c:otherwise>
									<a
										href="./mypage_mod_byadmin?page=${i }
			&pageDataCount=${searchPage.pageDataCount}&searchCol=${searchPage.searchCol }
			&searchVal=${searchPage.searchVal }">${i }
									</a>&nbsp;&nbsp;
			</c:otherwise>
							</c:choose>
						</c:forEach> <a
						href="./mypage_mod_byadmin?page=${searchPage.nextPageNum }
			&pageDataCount=${searchPage.pageDataCount}&searchCol=${searchPage.searchCol }
			&searchVal=${searchPage.searchVal }">뒤로▶
					</a>&nbsp;&nbsp; <a
						href="./mypage_mod_byadmin?page=${searchPage.lastPageNum }
			&pageDataCount=${searchPage.pageDataCount}&searchCol=${searchPage.searchCol }
			&searchVal=${searchPage.searchVal }">맨뒤로▶▶
					</a></td>
				</tr>
			</div>
		</div>
	</div>
	<%@ include file='../footer.jsp'%>
</body>
</html>