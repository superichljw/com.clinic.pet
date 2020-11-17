<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./css/main.css">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file='../header.jsp'%>
	<form action="./booking_insert" name="frm">
		<input type="hidden" name="booking_num" value="${searchVO.AHLnum}" />
		<table class="boardViewTable">
			<tr>
				<th width="10%">병원명</th>
				<td width="30%"><input type="hidden" id="clinicName"
					value="${searchVO.AHLname}" name="booking_name">${searchVO.AHLname}</td>
				<th width="10%">병원주소</th>
				<td width="50%"><input type="hidden"
					value="${searchVO.AHLadd1}" name="booking_add">${searchVO.AHLadd1}</td>

			</tr>
			<tr>
				<th width="10%">전화번호</th>
				<td><input type="hidden" name="booking_tel"
					value="${searchVO.AHLtel}">${searchVO.AHLtel }</td>
				<th>예약</th>



				<c:choose>
					<c:when test="${empty loginUser }">
						<td width="10%"><input type="text" id="datepicker"
							onclick="pickdate()" name="booking_date"> <input
							type="button" value="예약하기" onclick="showPopupLogin()"></td>
					</c:when>
					<c:otherwise>
						<td width="10%"><input type="text" id="datepicker"
							onclick="pickdate()" name="booking_date"> <input
							type="submit" name="submit" value="예약하기"></td>
					</c:otherwise>
				</c:choose>


			</tr>

			<tr>
				<th>지도보기</th>
				<td colspan="5"><input type="hidden" id="keyword"
					value="${searchVO.AHLadd1 }">
					<div class="map_wrap">
						<div id="map"
							style="width: 100%; height: 100%; position: relative; overflow: hidden;"></div>

					</div></td>
			</tr>

		</table>
	</form>
	<%@ include file='../footer.jsp'%>
	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=2ec2bfa47631d8e701977257798c9658&libraries=services"></script>
	<script>
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		mapOption = {
			center : new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
			level : 3
		// 지도의 확대 레벨
		};

		// 지도를 생성합니다    
		var map = new kakao.maps.Map(mapContainer, mapOption);

		// 주소-좌표 변환 객체를 생성합니다
		var geocoder = new kakao.maps.services.Geocoder();

		var mapAdd = document.getElementById('keyword').value;
		var mapName = document.getElementById('clinicName').value;

		// 주소로 좌표를 검색합니다
		geocoder
				.addressSearch(
						mapAdd,
						function(result, status) {

							// 정상적으로 검색이 완료됐으면 
							if (status === kakao.maps.services.Status.OK) {

								var coords = new kakao.maps.LatLng(result[0].y,
										result[0].x);

								// 결과값으로 받은 위치를 마커로 표시합니다
								var marker = new kakao.maps.Marker({
									map : map,
									position : coords
								});

								// 인포윈도우로 장소에 대한 설명을 표시합니다
								var infowindow = new kakao.maps.InfoWindow(
										{
											content : '<div style="width:150px;text-align:center;padding:6px 0;">'
													+ mapName + '</div>'
										});
								infowindow.open(map, marker);

								// 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
								map.setCenter(coords);
							}
						});

		$(function() {
			//input을 datepickFer로 선언
			$("#datepicker").datepicker.css
			$("#datepicker")
					.datepicker(
							{
								dateFormat : 'yy-mm-dd' //Input Display Format 변경
								,
								showOtherMonths : true //빈 공간에 현재월의 앞뒤월의 날짜를 표시
								,
								showMonthAfterYear : true //년도 먼저 나오고, 뒤에 월 표시
								,
								changeYear : true //콤보박스에서 년 선택 가능
								,
								changeMonth : true //콤보박스에서 월 선택 가능                
								,
								showOn : "both" //button:버튼을 표시하고,버튼을 눌러야만 달력 표시 ^ both:버튼을 표시하고,버튼을 누르거나 input을 클릭하면 달력 표시  
								,
								buttonImage : "http://jqueryui.com/resources/demos/datepicker/images/calendar.gif" //버튼 이미지 경로
								,
								buttonImageOnly : true //기본 버튼의 회색 부분을 없애고, 이미지만 보이게 함
								,
								buttonText : "선택" //버튼에 마우스 갖다 댔을 때 표시되는 텍스트                
								,
								yearSuffix : "년" //달력의 년도 부분 뒤에 붙는 텍스트
								,
								monthNamesShort : [ '1', '2', '3', '4', '5',
										'6', '7', '8', '9', '10', '11', '12' ] //달력의 월 부분 텍스트
								,
								monthNames : [ '1월', '2월', '3월', '4월', '5월',
										'6월', '7월', '8월', '9월', '10월', '11월',
										'12월' ] //달력의 월 부분 Tooltip 텍스트
								,
								dayNamesMin : [ '일', '월', '화', '수', '목', '금',
										'토' ] //달력의 요일 부분 텍스트
								,
								dayNames : [ '일요일', '월요일', '화요일', '수요일', '목요일',
										'금요일', '토요일' ] //달력의 요일 부분 Tooltip 텍스트
								,
								minDate : "-1y" //최소 선택일자(-1D:하루전, -1M:한달전, -1Y:일년전)
								,
								maxDate : "+1y" //최대 선택일자(+1D:하루후, -1M:한달후, -1Y:일년후)                
							});

			//초기값을 오늘 날짜로 설정
			$('#datepicker').datepicker('setDate', 'today');
			//(-1D:하루전, -1M:한달전, -1Y:일년전), (+1D:하루후, -1M:한달후, -1Y:일년후)            
		});

		function movePage() {
			location.href = "booking_insert.do";
		}
	</script>

	<script src="./javascript/main.js">
		
	</script>

	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</body>
</html>