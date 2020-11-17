<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/main.css">
<style>
.mypageMod {
	margin: 0px auto;
	width: 50%;
	vertical-align: top;
	display: inline-block;
	padding-left: 80px;
}

.mypageBack {
	width: 80%;
	margin: 0px auto;
	padding-top: 30px;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<title>Insert title here</title>
</head>
<body>
	<%@ include file='../header.jsp'%>

	<div class="mypageBack">

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


		<div class="mypageMod">

			<form id="updateForm" action="./member_info_update" method="post"
				name="frm">
				<h1>개인정보수정</h1>
				<div class="input">
					<ul class="input-block">
						<li>
							<p style="font-size: 15px;">아 이 디</p>
						</li>
						<li><input type="text" class="textblock" name="userid"
							value="${vetVo.userid }" readonly />
					</ul>
					<ul class="input-block">

						<li>
							<p style="font-size: 15px;">비밀번호</p>
						</li>
						<li><input type="password" class="textblock" name="pwd"
							value="${vetVo.pwd }" style="font-family: gulim" /></li>
					</ul>
					<ul class="input-block">
						<li>
							<p style="font-size: 15px;">비밀번호확인</p>
						</li>
						<li><input type="password" class="textblock" name="pwd_check"
							value="${vetVo.pwd }" style="font-family: gulim" /></li>
					</ul>
					<ul class="input-block">
						<li>
							<p style="font-size: 15px;">이메일</p>
						</li>
						<li><input type="text" class="textblock" name="email"
							value="${vetVo.email }" /></li>

					</ul>
					<ul class="input-block-addr">
						<li class="addr">
							<p style="font-size: 15px;">주 소</p>
						</li>
						<li class="addr">
							<ul style="list-style-type: none; margin-left: -20px;">
								<li class="addr-1"><input type="text" id="postcode"
									placeholder="(우편번호)" name="postcode" /></li>
								<li class="addr-1"><input type="button" value="우편번호검색"
									id="postcodeSearch" onclick="execDaumPostcode()" /></li>
								<li><input type="text" id="addrblock" placeholder="(주소)"
									name="address" value="${vetVo.addr }" /></li>
								<li><input type="text" id="extraAddress"
									placeholder="(참고항목)" name="referAdd" /><input type="text"
									id="detailAddress" placeholder="(상세주소)" name="detailAdd" /></li>

							</ul>
						</li>

					</ul>
					<ul class="input-block">
						<li>
							<p style="font-size: 15px;">이름</p>
						</li>
						<li><input type="text" class="textblock" name="name"
							value="${vetVo.name }" /></li>
					</ul>
					<ul class="input-block">
						<li>
							<p style="font-size: 15px;">휴대폰</p>
						</li>
						<li><input type="text" class="textblock" name="phone"
							value="${vetVo.phone }" /></li>
					</ul>
					<ul class="input-block">
						<li>
							<p style="font-size: 15px;">개인정보활용동의</p>
						</li>
						<c:choose>
							<c:when test="${vetVo.personal==1 }">
								<li><input type="radio" value="1"
									style="margin-left: 20px;" name="personal" checked="checked" />동의</li>
								<li><input type="radio" value="0" name="personal" />비동의</li>
							</c:when>
							<c:otherwise>
								<li><input type="radio" value="1"
									style="margin-left: 20px;" name="personal" />동의</li>
								<li><input type="radio" value="0" name="personal"
									checked="checked" />비동의</li>
							</c:otherwise>
						</c:choose>

					</ul>
					<ul class="input-block">
						<li>
							<p style="font-size: 15px;">이메일수신동의</p>
						</li>
						<c:choose>
							<c:when test="${vetVo.emailok==1 }">
								<li><input type="radio" value="1"
									style="margin-left: 20px;" name="emailok" checked="checked" />동의</li>
								<li><input type="radio" value="0" name="emailok" />비동의</li>
							</c:when>
							<c:otherwise>
								<li><input type="radio" value="1"
									style="margin-left: 20px;" name="emailok" />동의</li>
								<li><input type="radio" value="0" name="emailok"
									checked="checked" />비동의</li>
							</c:otherwise>
						</c:choose>

					</ul>
					<ul class="input-block">
						<li>
							<p style="font-size: 15px;">반려동물종류</p>
						</li>
						<li><input type="text" class="textblock" name="pettype"
							value="${vetVo.pettype }" /></li>
					</ul>
					<ul class="input-block">
						<li>
							<p style="font-size: 15px;">반려동물이름</p>
						</li>
						<li><input type="text" class="textblock" name="petname"
							value="${vetVo.petname }" /></li>
					</ul>
					<ul class="input-block">
						<li>
							<p style="font-size: 15px;">반려동물번호</p>
						</li>
						<li><input type="text" class="textblock" name="petnum"
							value="${vetVo.petnum }" /></li>
					</ul>
					<ul class="input-block">
						<li>
							<p style="font-size: 15px;">유저타입</p>
						</li>
						<li><input type="text" class="textblock" name="usertype"
							value="${vetVo.usertype }" /></li>
					</ul>
					<ul class="input-block">
						<li>
							<p style="font-size: 15px;">병원이름</p>
						</li>
						<li><input type="text" class="textblock" name="hospital_name"
							value="${vetVo.hospital_name }" /></li>
					</ul>
					<ul class="input-block">
						<li>
							<p style="font-size: 15px;">사업자등록번호</p>
						</li>
						<li><input type="text" class="textblock" name="hospital_num"
							value="${vetVo.hospital_num }" /></li>
					</ul>
					<ul class="input-block">
						<li>
							<p style="font-size: 15px;">수의사면허번호</p>
						</li>
						<li><input type="text" class="textblock" name="hospital_li"
							value="${vetVo.hospital_li}" /></li>
					</ul>
					<ul class="input-block">
						<li>
							<p style="font-size: 15px;">권한</p>
						</li>
						<li><input type="text" class="textblock" name="auth"
							value="${vetVo.auth }" /></li>
					</ul>
					<div class="submit">
						<a href="javascript:vetjoinCheck()"><input type="submit"
							value="확인" /></a> <input type="button" value="취소"
							onclick="location.href='./main'" />
					</div>
					<div>${message }</div>
				</div>
			</form>

		</div>
	</div>
	<%@ include file='../footer.jsp'%>

	<script src="./javascript/main.js">
		
	</script>
	<script
		src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</body>
</html>