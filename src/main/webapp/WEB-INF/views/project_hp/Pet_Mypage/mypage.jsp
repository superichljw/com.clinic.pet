<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<div class="mypageMod">
			<c:choose>
				<c:when test="${loginUser.usertype eq 'oper' }">
					<form id="updateForm" action="./member_info_update" method="post"
						name="frm">
						<h1>개인정보수정</h1>
						<div class="input">
							<ul class="input-block">
								<li>
									<p style="font-size: 15px;">아 이 디</p>
								</li>
								<li><input type="text" class="textblock" name="userid"
									value="${loginUser.userid }" readonly />
							</ul>
							<ul class="input-block">

								<li>
									<p style="font-size: 15px;">비밀번호</p>
								</li>
								<li><input type="password" class="textblock" name="pwd"
									style="font-family: gulim" /></li>
							</ul>
							<ul class="input-block">
								<li>
									<p style="font-size: 15px;">비밀번호확인</p>
								</li>
								<li><input type="password" class="textblock"
									name="pwd_check" style="font-family: gulim" /></li>
							</ul>
							<ul class="input-block">
								<li>
									<p style="font-size: 15px;">이메일</p>
								</li>
								<li><input type="text" class="textblock" name="email"
									value="${mVo.email }" /></li>

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
											name="address" value="${mVo.addr }" /></li>
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
									value="${mVo.name }" /></li>
							</ul>
							<ul class="input-block">
								<li>
									<p style="font-size: 15px;">휴대폰</p>
								</li>
								<li><input type="text" class="textblock" name="phone"
									value="${mVo.phone }" /></li>
							</ul>
							<ul class="input-block">
								<li>
									<p style="font-size: 15px;">개인정보활용동의</p>
								</li>
								<c:choose>
									<c:when test="${mVO.personal==1 }">
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
									<c:when test="${mVo.emailok==1 }">
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
									value="${mVo.pettype }" /></li>
							</ul>
							<ul class="input-block">
								<li>
									<p style="font-size: 15px;">반려동물이름</p>
								</li>
								<li><input type="text" class="textblock" name="petname"
									value="${mVo.petname }" /></li>
							</ul>
							<ul class="input-block">
								<li>
									<p style="font-size: 15px;">반려동물번호</p>
								</li>
								<li><input type="text" class="textblock" name="petnum"
									value="${mVo.petnum }" /></li>
							</ul>
							<ul class="input-block">
								<li>
									<p style="font-size: 15px;">유저타입</p>
								</li>
								<li><input type="text" class="textblock" name="usertype"
									value="${mVo.usertype }" /></li>
							</ul>
							<ul class="input-block">
								<li>
									<p style="font-size: 15px;">병원이름</p>
								</li>
								<li><input type="text" class="textblock"
									name="hospital_name" value="${mVo.hospital_name }" /></li>
							</ul>
							<ul class="input-block">
								<li>
									<p style="font-size: 15px;">사업자등록번호</p>
								</li>
								<li><input type="text" class="textblock"
									name="hospital_num" value="${mVo.hospital_num }" /></li>
							</ul>
							<ul class="input-block">
								<li>
									<p style="font-size: 15px;">수의사면허번호</p>
								</li>
								<li><input type="text" class="textblock" name="hospital_li"
									value="${mVo.hospital_li}" /></li>
							</ul>
							<ul class="input-block">
								<li>
									<p style="font-size: 15px;">권한</p>
								</li>
								<li><input type="text" class="textblock" name="auth"
									value="${mVo.auth }" /></li>
							</ul>
							<div class="submit">
								<a href="javascript:vetjoinCheck()"><input type="submit"
									value="확인" /></a> <input type="button" value="취소"
									onclick="location.href='./main'" />
							</div>
							<div>${message }</div>
						</div>
					</form>
				</c:when>
				<c:when test="${loginUser.usertype eq 'doc' }">
					<form id="updateForm" action="./member_info_update" method="post"
						name="frm">
						<h1>개인정보수정</h1>
						<div class="input">
							<ul class="input-block">
								<li>
									<p style="font-size: 15px;">아 이 디</p>
								</li>
								<li><input type="text" class="textblock" name="userid"
									value="${loginUser.userid }" readonly />
							</ul>
							<ul class="input-block">

								<li>
									<p style="font-size: 15px;">비밀번호</p>
								</li>
								<li><input type="password" class="textblock" name="pwd"
									style="font-family: gulim" /></li>
							</ul>
							<ul class="input-block">
								<li>
									<p style="font-size: 15px;">비밀번호확인</p>
								</li>
								<li><input type="password" class="textblock"
									name="pwd_check" style="font-family: gulim" /></li>
							</ul>
							<ul class="input-block">
								<li>
									<p style="font-size: 15px;">이메일</p>
								</li>
								<li><input type="text" class="textblock" name="email"
									value="${mVo.email }" /></li>

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
											name="address" value="${mVo.addr }" /></li>
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
									value="${mVo.name }" /></li>
							</ul>
							<ul class="input-block">
								<li>
									<p style="font-size: 15px;">휴대폰</p>
								</li>
								<li><input type="text" class="textblock" name="phone"
									value="${mVo.phone }" /></li>
							</ul>
							<ul class="input-block">
								<li>
									<p style="font-size: 15px;">개인정보활용동의</p>
								</li>
								<c:choose>
									<c:when test="${mVO.personal==1 }">
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
									<c:when test="${mVo.emailok==1 }">
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
									value="${mVo.pettype }" /></li>
							</ul>
							<ul class="input-block">
								<li>
									<p style="font-size: 15px;">반려동물이름</p>
								</li>
								<li><input type="text" class="textblock" name="petname"
									value="${mVo.petname }" /></li>
							</ul>
							<ul class="input-block">
								<li>
									<p style="font-size: 15px;">반려동물번호</p>
								</li>
								<li><input type="text" class="textblock" name="petnum"
									value="${mVo.petnum }" /></li>
							</ul>
							<ul class="input-block">
								<li>
									<p style="font-size: 15px;">유저타입</p>
								</li>
								<li><input type="text" class="textblock" name="usertype"
									value="${mVo.usertype }" readonly /></li>
							</ul>
							<ul class="input-block">
								<li>
									<p style="font-size: 15px;">병원이름</p>
								</li>
								<li><input type="text" class="textblock"
									name="hospital_name" value="${mVo.hospital_name }" /></li>
							</ul>
							<ul class="input-block">
								<li>
									<p style="font-size: 15px;">사업자등록번호</p>
								</li>
								<li><input type="text" class="textblock"
									name="hospital_num" value="${mVo.hospital_num }" /></li>
							</ul>
							<ul class="input-block">
								<li>
									<p style="font-size: 15px;">수의사면허번호</p>
								</li>
								<li><input type="text" class="textblock" name="hospital_li"
									value="${mVo.hospital_li}" /></li>
							</ul>
							<ul class="input-block">

								<li><input type="hidden" class="textblock" name="auth"
									value="${mVo.auth }" /></li>
							</ul>
							<div class="submit">
								<a href="javascript:vetjoinCheck()"><input type="submit"
									value="확인" /></a> <input type="button" value="취소"
									onclick="location.href='./main'" />
							</div>
							<div>${message }</div>
						</div>
					</form>
				</c:when>
				<c:otherwise>
					<form id="updateForm" action="./member_info_update" method="post"
						name="frm">
						<h1>개인정보수정</h1>
						<div class="input">
							<ul class="input-block">
								<li>
									<p style="font-size: 15px;">아 이 디</p>
								</li>
								<li><input type="text" class="textblock" name="userid"
									value="${loginUser.userid }" readonly />
							</ul>
							<ul class="input-block">

								<li>
									<p style="font-size: 15px;">비밀번호</p>
								</li>
								<li><input type="password" class="textblock" name="pwd"
									style="font-family: gulim" /></li>
							</ul>
							<ul class="input-block">
								<li>
									<p style="font-size: 15px;">비밀번호확인</p>
								</li>
								<li><input type="password" class="textblock"
									name="pwd_check" style="font-family: gulim" /></li>
							</ul>
							<ul class="input-block">
								<li>
									<p style="font-size: 15px;">이메일</p>
								</li>
								<li><input type="text" class="textblock" name="email"
									value="${mVo.email }" /></li>

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
											name="address" value="${mVo.addr }" /></li>
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
									value="${mVo.name }" /></li>
							</ul>
							<ul class="input-block">
								<li>
									<p style="font-size: 15px;">휴대폰</p>
								</li>
								<li><input type="text" class="textblock" name="phone"
									value="${mVo.phone }" /></li>
							</ul>
							<ul class="input-block">
								<li>
									<p style="font-size: 15px;">개인정보활용동의</p>
								</li>
								<c:choose>
									<c:when test="${mVO.personal==1 }">
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
									<c:when test="${mVo.emailok==1 }">
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
									value="${mVo.pettype }" /></li>
							</ul>
							<ul class="input-block">
								<li>
									<p style="font-size: 15px;">반려동물이름</p>
								</li>
								<li><input type="text" class="textblock" name="petname"
									value="${mVo.petname }" /></li>
							</ul>
							<ul class="input-block">
								<li>
									<p style="font-size: 15px;">반려동물번호</p>
								</li>
								<li><input type="text" class="textblock" name="petnum"
									value="${mVo.petnum }" /></li>
							</ul>
							<ul class="input-block">
								<li>
									<p style="font-size: 15px;">유저타입</p>
								</li>
								<li><input type="text" class="textblock" name="usertype"
									value="${mVo.usertype }" readonly /></li>
							</ul>
							<ul class="input-block">

								<li><input type="hidden" class="textblock"
									name="hospital_name" value="${mVo.hospital_name }" /></li>
							</ul>
							<ul class="input-block">

								<li><input type="hidden" class="textblock"
									name="hospital_num" value="${mVo.hospital_num }" /></li>
							</ul>
							<ul class="input-block">

								<li><input type="hidden" class="textblock"
									name="hospital_li" value="${mVo.hospital_li}" /></li>
							</ul>
							<ul class="input-block">

								<li><input type="hidden" class="textblock" name="auth"
									value="${mVo.auth }" /></li>
							</ul>
							<div class="submit">
								<a href="javascript:vetjoinCheck()"><input type="submit"
									value="확인" /></a> <input type="button" value="취소"
									onclick="location.href='./main'" />
							</div>
							<div>${message }</div>
						</div>
					</form>
				</c:otherwise>
			</c:choose>

		</div>
	</div>
	<%@ include file='../footer.jsp'%>

	<script src="./javascript/main.js">
		
	</script>
	<script
		src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</body>
</html>