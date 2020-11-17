function showPopupLogin() {
	window.open("./login_form", "a", "width=500, height=680");

}

function showPopupSignup() {
	window
			.open("./signup_form", "a",
					"width=630, height=900, left=400, top=50");
}
function showPopupSelfIn() {
	window.open("./login_form", "a", "width=500, height=680");
}
function showPopupSignupType() {
	window.open("./signup_type_form", "a",
			"width=630, height=830, left=400, top=50");
}
function showPopupDocSignup() {
	window.open("./docsignup", "a", "width=630, height=1000, left=400, top=50");
	window.open("./docsignup", "a", "width=630, height=1000, left=400, top=50");
}


function go_apply() {

	alert("적용되었습니다");
	location.reload();

}
function showPopupInspec() {
	window.open("./selfinspection_popup", "a",
			"width=1000, height=550, left=100, top=50");
}

/* 메뉴버튼클릭시 사이드메뉴등장 */
$('.labelBtn').click(function(e) {
	jQuery(".coverMenu").animate({
		left : 0
	}, 300);
});
$('.close').click(function(e) {
	jQuery(".coverMenu").animate({
		left : '-100%'
	}, 300);
});
$('.rightmenu').click(function(e) {
	jQuery(".coverMenu").animate({
		left : '-100%'
	}, 300);
});

/*
 * var btn = $('#clinicTable'); var noshow = $('.noshowTable'); var pageNum =
 * $('.pageNum'); $('.searchBtn').click(function () { btn.show();
 * pageNum.show(); noshow.hide(); })
 */

var slideIndex = 0;
showSlides();

function showSlides() {
	var i;
	var slides = document.getElementsByClassName("mySlides");
	var dots = document.getElementsByClassName("dot");
	for (i = 0; i < slides.length; i++) {
		slides[i].style.display = "none";
	}
	slideIndex++;
	if (slideIndex > slides.length) {
		slideIndex = 1
	}
	for (i = 0; i < dots.length; i++) {
		dots[i].className = dots[i].className.replace(" active", "");
	}
	slides[slideIndex - 1].style.display = "block";
	dots[slideIndex - 1].className += " active";
	setTimeout(showSlides, 5000); // Change image every 2 seconds
}
// 자동슬라이드

var Index = 1;
changeSlides(Index);

function plusSlides(n) {
	changeSlides(Index += n);
}

function currentSlide(n) {
	changeSlides(Index = n);
}

function changeSlides(n) {
	var i;
	var slides = document.getElementsByClassName("mySlides");
	var dots = document.getElementsByClassName("dot");
	if (n > slides.length) {
		Index = 1
	}
	if (n < 1) {
		Index = slides.length
	}
	for (i = 0; i < slides.length; i++) {
		slides[i].style.display = "none";
	}
	for (i = 0; i < dots.length; i++) {
		dots[i].className = dots[i].className.replace(" active", "");
	}
	slides[Index - 1].style.display = "block";
	dots[Index - 1].className += " active";
}

// 주소

function execDaumPostcode() {
	new daum.Postcode({
		oncomplete : function(data) {
			// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

			// 각 주소의 노출 규칙에 따라 주소를 조합한다.
			// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
			var addr = ''; // 주소 변수
			var extraAddr = ''; // 참고항목 변수

			// 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
			if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
				addr = data.roadAddress;
			} else { // 사용자가 지번 주소를 선택했을 경우(J)
				addr = data.jibunAddress;
			}

			// 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
			if (data.userSelectedType === 'R') {
				// 법정동명이 있을 경우 추가한다. (법정리는 제외)
				// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
				if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
					extraAddr += data.bname;
				}
				// 건물명이 있고, 공동주택일 경우 추가한다.
				if (data.buildingName !== '' && data.apartment === 'Y') {
					extraAddr += (extraAddr !== '' ? ', ' + data.buildingName
							: data.buildingName);
				}
				// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
				if (extraAddr !== '') {
					extraAddr = ' (' + extraAddr + ')';
				}
				// 조합된 참고항목을 해당 필드에 넣는다.
				document.getElementById("extraAddress").value = extraAddr;

			} else {
				document.getElementById("extraAddress").value = '';
			}

			// 우편번호와 주소 정보를 해당 필드에 넣는다.
			document.getElementById('postcode').value = data.zonecode;
			document.getElementById("addrblock").value = addr;
			// 커서를 상세주소 필드로 이동한다.
			document.getElementById("detailAddress").focus();
		}
	}).open();
}

function loginCheck() {
	if (document.frm.userid.value.length == 0) {
		alert("아이디를 써주세요");
		frm.userid.focus();
		return false;
	}
	if (document.frm.pwd.value == "") {
		alert("암호는 반드시 입력해야 합니다.");
		frm.pwd.focus();
		return false;
	}
	return true;
}
function vetidCheck() {
	if (document.frm.userid.value == "") {
		alert('아이디를 입력하여 주십시오.');
		document.frm.userid.focus();
		return;
	}
	var url = "./signup_id_check?userid="
			+ document.frm.userid.value;
	window.open(url, "_blank_1", "toolbar=no, menubar=no, scrollbars=yes,"
			+ " resizable=no, width=450, height=200");

}

function vetIdOk() {

	// opener.frm.userid.value = "${userid}";
	// opener.frm.reid.value = "${userid}";

	opener.frm.userid.value = document.frm.userid.value;
	opener.frm.reid.value = document.frm.userid.value;
	self.close();

}

function vetjoinCheck() {
	if (document.frm.name.value.length == 0) {
		alert("이름을 써주세요.");
		frm.name.focus();
		return false;
	}
	if (document.frm.userid.value.length == 0) {
		alert("아이디를 써주세요");
		frm.userid.focus();
		return false;
	}
	if (document.frm.userid.value.length < 4) {
		alert("아이디는 4글자이상이어야 합니다.");
		frm.userid.focus();
		return false;
	}
	if (document.frm.pwd.value == "") {
		alert("암호는 반드시 입력해야 합니다.");
		frm.pwd.focus();
		return false;
	}
	if (document.frm.pwd.value != document.frm.pwd_check.value) {
		alert("암호가 일치하지 않습니다.");
		frm.pwd.focus();
		return false;
	}
	if (document.frm.reid.value.length == 0) {
		alert("중복 체크를 하지 않았습니다.");
		frm.userid.focus();
		return false;
	}
	return true;
}

/* 게시판 */

function boardCheck() {
	if (document.frm.name.value.length == 0) {
		alert("작성자를 입력하세요.");
		return false;
	}
	if (document.frm.pass.value.length == 0) {
		alert("비밀번호를 입력하세요.");
		return false;
	}
	if (document.frm.title.value.length == 0) {
		alert("제목을 입력하세요.");
		return false;
	}
	return true;
}

function open_win(url, name) {
	window.open(url, name, "width=500, height=230");
}
function passCheck() {
	if (document.frm.pass.value.length == 0) {
		alert("비밀번호를 입력하세요.");
		return false;
	}
	return true;
}



function cb(){
	alert("cb");
}



function cb(obj){
	//alert("ccccccccccccccccccc");
	console.log("home.jsp callback");
	console.log(obj);
	
	var target = $(obj);
	
	var srcStr = target.attr('src').split("/")[2];
	
	target.attr("id", srcStr);
	
	if(confirm("해당 이미지를 삭제하시겠습니까?")){
	
		$.post("/deleteEditorFile", {fileName:srcStr}, function(result){
			
			console.log("삭제...");
			
			target.remove();
			
		});	
		
		
		return;
	}
	
}
