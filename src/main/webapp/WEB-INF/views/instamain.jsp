<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<style>
@media all and (max-width:300px) {
	img {
		width: 100px;
		height: 100px;
	}
}

@media all and (min-width:300px) {
	img {
		width: 150px;
		height: 150px;
	}
}

@media all and (min-width:1000px) {
	img {
		width: 300px;
		height: 300px;
	}
}
</style>

<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/main.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<%@ include file='./project_hp/header.jsp'%>
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

		<div class="instaRight">
			<h1>메인페이지</h1>

			<h2>${loginUser.userid }</h2>
			<c:choose>
				<c:when test="${empty instavo.profileimage }">
					<img style="width: 150px; height: 150px;"
						src="./image/upload/defaultface.png">
				</c:when>
				<c:otherwise>
					<img style="width: 150px; height: 150px;"
						src="${instavo.profileimage}">
				</c:otherwise>
			</c:choose>
			<form action="profile" enctype="multipart/form-data" method="post">
				<input type="file" name="uploadfile" placeholder="파일선택"> <input
					type="submit" value="프로필사진 올리기">
			</form>
			<p>나의 팔로워 : ${followNum }</p>
			<c:forEach items="${follow }" var="follow">
				<p>${follow.following },
			</c:forEach>
			<c:choose>
				<c:when test="${empty loginUser }">
					<p>로그인하셔야 서비스를 이용하실 수 있습니다</p>
					<input type="button" value="로그인하기"
						onclick="location.href='./login_form'">
				</c:when>
				<c:otherwise>
					<c:choose>
						<c:when test="${loginid == notfollow  }">
							<p>이제그만</p>
						</c:when>
						<c:otherwise>
							<a href="/pet/makefollow?userid=${instavo.userid }"><input
								type="button" value="팔로우하기"></a>
						</c:otherwise>
					</c:choose>
				</c:otherwise>
			</c:choose>
			<!-- <input type="button" value="로그아웃" onclick="location.href='logout'"> -->
			<h2>사진업로드</h2>
			<form action="my_imageupload" encType="multipart/form-data"
				method="post">
				<input type="file" name="my_imageupload" placeholder="파일선택">
				<input type="submit" value="이미지 업로드">
			</form>
			<c:choose>
				<c:when test="${empty myimage }">
					<p>첫번째 사진을 올려보세요!</p>
				</c:when>
				<c:otherwise>
					<table>
						<c:forEach items="${myimage }" var="myimage" varStatus="status">
							<c:if test="${status.first }">
								<tr>
							</c:if>
							<td style="padding: 0px; width: 300px; height: 300px;"><a
								href="imagedetailpage?imageno=${myimage.imageno }"><img
									src="${myimage.uploadimage }"></a></td>
							<c:if test="${status.count%3 == 0 }">
								</tr>
								<tr>
							</c:if>
							<c:if test="${status.last }">
								</tr>
							</c:if>
						</c:forEach>
					</table>
				</c:otherwise>
			</c:choose>
		</div>
	</div>



	<%@ include file='./project_hp/footer.jsp'%>

	<script src="./javascript/main.js">
		</body>
		</html>
	