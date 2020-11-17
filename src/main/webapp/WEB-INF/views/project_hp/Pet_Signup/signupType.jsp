<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
#memType-normal {
	text-align: left;
	width: 250px;
	border-radius: 20px;
	background-color: none;
	outline-color: none;
	padding-top: 60px;
	font-size: 30px;
	padding: 60px;
	background-color: none;
}

#memType-vet {
	text-align: left;
	width: 250px;
	border-radius: 20px;
	background-color: none;
	padding: 60px;
	font-size: 30px;
	outline-color: none;
}

#memType-vet:hover {
	cursor: pointer;
	color: white;
}

#memType-vet:hover .subText2 {
	display: block;
	font-size:13px;
}

#memType-normal:hover {
	cursor: pointer;
	color: white;
}

#memType-vet:hover .subText1 {
	display: block;
	font-size:13px;
}

#memtype {
	list-style-type: none;
	
}

.signuptype {
	background-image: url('./image/signuptype.png');
}

.subText1 {
	display: none;
}

.subText2 {
	display: none;
}
</style>
<link rel="stylesheet" href="./css/main.css">
<title>Insert title here</title>
</head>
<body class="signuptype">
	<div>
		<ul id="memtype">
			<div onclick="showPopupSignup()" style="background-color: none;">
				<li id="memType-normal">일반 회원 가입</li>
				<li class="subText1">올댓팻 서비스를 이용하시는 모든 분들이 가입 가능합니다</li>
			</div>
			<div onclick="showPopupDocSignup()">
				<li id="memType-vet">수의사 회원 가입</li>
				<li class="subText2">수의사 면허를 가진 수의사분들만 가입이 가능합니다</li>
			</div>
		</ul>
	</div>

</body>
<script src="./javascript/main.js">
	
</script>
</html>