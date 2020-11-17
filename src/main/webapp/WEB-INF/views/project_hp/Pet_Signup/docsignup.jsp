<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/main.css">
<title>Insert title here</title>
</head>
<body>
	<form id="signupForm" action="./signup" name="frm">
		<h1>수의사회원가입</h1>


		<div class="input">
			<ul class="input-block">

				<li>
					<p style="font-size: 15px;">아 이 디</p>
				</li>
				<li><input type="text" class="textblock" name="userid"
					value="${userid }" /> <input type="hidden" name="reid" size="20"
					value="${reid }" /></li>
				<li><input type="button" value="중복체크" onclick="vetidCheck()"
					class="idck" /></li>
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
				<li><input type="password" class="textblock" name="pwd_check"
					style="font-family: gulim" /></li>
			</ul>
			<ul class="input-block">
				<li>
					<p style="font-size: 15px;">이메일</p>
				</li>
				<li><input type="text" class="textblock" name="email" /></li>

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
							name="address" /></li>
						<li><input type="text" id="extraAddress" placeholder="(참고항목)"
							name="referAdd" /><input type="text" id="detailAddress"
							placeholder="(상세주소)" name="detailAdd" /></li>

					</ul>
				</li>

			</ul>
			<ul class="input-block">
				<li>
					<p style="font-size: 15px;">이름</p>
				</li>
				<li><input type="text" class="textblock" name="name" /></li>
			</ul>
			<ul class="input-block">
				<li>
					<p style="font-size: 15px;">휴대폰</p>
				</li>
				<li><input type="text" class="textblock" name="phone" /></li>
			</ul>
			<ul class="input-block">
				<li>
					<p style="font-size: 15px;">개인정보활용동의</p>
				</li>
				<li><input type="radio" value="1" style="margin-left: 20px;"
					name="personal" />동의</li>
				<li><input type="radio" value="0" name="personal" />비동의</li>
			</ul>
			<ul class="input-block">
				<li>
					<p style="font-size: 15px;">이메일수신동의</p>
				</li>
				<li><input type="radio" value="1" style="margin-left: 20px;"
					name="emailok" />동의</li>
				<li><input type="radio" value="0" name="emailok" />비동의</li>
			</ul>
			<ul class="input-block">
				<li>
					<p style="font-size: 15px;">반려동물종류</p>
				</li>
				<li><input type="text" class="textblock" name="pettype" /></li>
			</ul>
			<ul class="input-block">
				<li>
					<p style="font-size: 15px;">반려동물이름</p>
				</li>
				<li><input type="text" class="textblock" name="petname" /></li>
			</ul>
			<ul class="input-block">
				<li>
					<p style="font-size: 15px;">반려동물번호</p>
				</li>
				<li><input type="text" class="textblock" name="petnum" /></li>
			</ul>
			<input type="hidden" name="usertype" value="doc">

			<ul class="input-block">
				<li>
					<p style="font-size: 15px;">병원이름</p>
				</li>
				<li><input type="text" class="textblock" name="hospital_name" /></li>
			</ul>
			<ul class="input-block">
				<li>
					<p style="font-size: 15px;">병원사업자등록번호</p>
				</li>
				<li><input type="text" class="textblock" name="hospital_num" /></li>
			</ul>
			<ul class="input-block">
				<li>
					<p style="font-size: 15px;">수의사면허번호</p>
				</li>
				<li><input type="text" class="textblock" name="hospital_li" /></li>
			</ul>
			<input type="hidden" name="auth" value="0">
			<div class="submit">
				<input type="submit" onclick="return vetjoinCheck()"
					value="가입" name="applyMem" > <input type="reset" value="취소" />
			</div>
			<div>${message }</div>
		</div>
	</form>
	
	<script
		src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script type="text/javascript"
		src="./javascript/main.js"></script>
</body>
</html>