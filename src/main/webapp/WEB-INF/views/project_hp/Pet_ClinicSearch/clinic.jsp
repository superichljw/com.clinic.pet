<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/main.css">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<style>
</style>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>


<title>Insert title here</title>
</head>
<body>
	<%@ include file='../header.jsp'%>
	<div style="text-align: center; padding-top: 40px;">
		<h2>가깝고 믿을만한 동물병원을 한번에!</h2>
	</div>
	<div id="search">
		<div style="margin-top: 100px; display: inline-block;">
			<form action="./search_list">
				<input type="hidden" name="searchCol" value="AHLname"> <input
					type="text" style="width: 300px; height: 50px;" class="searchInput"
					name="searchVal" value="${dtos.searchVal }"> <input
					type="submit" value="" class="searchBtn"
					style="background-image: url('./image/searchBtn.png');">
			</form>
		</div>
	</div>
	<div id="searchResult">
		<table id="clinicTable">
			<tr>
				<td
					style="height: 40px; background-color: #22a8f1; color: white; width: 5%; font-size: 15px;">번호</td>
				<td
					style="height: 40px; background-color: #22a8f1; color: white; width: 15%; font-size: 15px;">병원명</td>
				<td
					style="height: 40px; background-color: #22a8f1; color: white; width: 45%; font-size: 15px;">주소</td>
				<td
					style="height: 40px; background-color: #22a8f1; color: white; width: 15%; font-size: 15px;">연락처</td>
				<td
					style="height: 40px; background-color: #22a8f1; color: white; width: 10%; font-size: 15px;">지도보기</td>

			</tr>
			<c:forEach items="${searchdtos }" var="searchdtos">
				<tr>
					<td
						style="width: 5%; border-right: 1px solid lightgray; height: 40px;; font-size: 15px;">
						${searchdtos.AHLnum }</td>
					<td
						style="width: 15%; margin-left: -5px; border-right: 1px solid lightgray; height: 40px;; font-size: 15px;">
						<a href="./booking_content_view?AHLnum=${searchdtos.AHLnum }">${searchdtos.AHLname }</a>
					</td>
					<td
						style="width: 50%; margin-left: -5px; border-right: 1px solid lightgray; height: 40px;; font-size: 15px;">
						<a href="./booking_content_view?AHLnum=${searchdtos.AHLnum }">${searchdtos.AHLadd1 }</a>
					</td>

					<td
						style="width: 15%; margin-left: -5px; height: 40px;; font-size: 15px;">${searchdtos.AHLtel }</td>

					<form>
						<td style="width: 15%; font-size: 15px;"><input type="hidden"
							id="keyword" value="${searchdtos.AHLadd1 }">
							<button type="submit" class="submitBtn"
								onclick="searchPlaces('${searchdtos.AHLadd1 }','${searchdtos.AHLname }');showmap();return false;">지도보기</button>
							</input></td>
					</form>

					<!-- <td style="width: 10%; font-size: 15px;">
						<input type="text" id="datepicker" onclick="pickdate()"><button
						type="submit" onclick="movePage()">예약하기</button></td> -->

				</tr>
				<!-- <tr
					style="width: 100%; height: 100%; position: relative; overflow: hidden;">
					<td colspan="6" style="text-align: center; display:none" id="showmap">
						<div class="map_wrap">
							<div id="map"
								style="width: 100%; height: 100%; position: relative; overflow: hidden;"></div>

						</div>
					</td>
				</tr> -->
			</c:forEach>
			<tr
				style="width: 100%; height: 100%; position: relative; overflow: hidden;">
				<td colspan="6" style="text-align: center; display: none"
					id="showmap">
					<div class="map_wrap">
						<div id="map"
							style="width: 100%; height: 100%; position: relative; overflow: hidden;"></div>

					</div>
				</td>
			</tr>
			</div>
		</table>


		<!-- 문자열.substring(0,"번지"); -->
		<div class="board-pageNum">
			<tr>
				<td colspan="5"><a
					href="./search_list?page=${searchPage.firstPageNum }
			&pageDataCount=${searchPage.pageDataCount}&searchCol=${searchPage.searchCol }
			&searchVal=${searchPage.searchVal }">
						◀◀맨앞으로 </a>&nbsp;&nbsp; <a
					href="./search_list?page=${searchPage.prevPageNum }
			&pageDataCount=${searchPage.pageDataCount}&searchCol=${searchPage.searchCol }
			&searchVal=${searchPage.searchVal }">
						◀앞으로 </a>&nbsp;&nbsp; <c:forEach var="i"
						begin="${searchPage.startPageNum }"
						end="${searchPage.endPageNum }" step="1">
						<c:choose>
							<c:when test="${i eq searchPage.currentPageNum }">
								<a style="font-weight: bold; color: blue"
									href="./search_list?page=${i }
				&pageDataCount=${searchPage.pageDataCount}&searchCol=${searchPage.searchCol }
			&searchVal=${searchPage.searchVal }">${i }
								</a>&nbsp;&nbsp;
			</c:when>
							<c:otherwise>
								<a
									href="./search_list?page=${i }
			&pageDataCount=${searchPage.pageDataCount}&searchCol=${searchPage.searchCol }
			&searchVal=${searchPage.searchVal }">${i }
								</a>&nbsp;&nbsp;
			</c:otherwise>
						</c:choose>
					</c:forEach> <a
					href="./search_list?page=${searchPage.nextPageNum }
			&pageDataCount=${searchPage.pageDataCount}&searchCol=${searchPage.searchCol }
			&searchVal=${searchPage.searchVal }">뒤로▶
				</a>&nbsp;&nbsp; <a
					href="./search_list?page=${searchPage.lastPageNum }
			&pageDataCount=${searchPage.pageDataCount}&searchCol=${searchPage.searchCol }
			&searchVal=${searchPage.searchVal }">맨뒤로▶▶
				</a></td>
			</tr>
		</div>
	</div>

	<%@ include file='../footer.jsp'%>
	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=2ec2bfa47631d8e701977257798c9658&libraries=services"></script>

	<script>
		function showmap() {
			$('.submitBtn').click(function() {
				$('#showmap').show();
			})
		}

		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		mapOption = {
			center : new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
			level : 3
		// 지도의 확대 레벨
		};

		// 지도를 생성합니다    
		var map;

		// 주소-좌표 변환 객체를 생성합니다
		var geocoder = new kakao.maps.services.Geocoder();

		// 주소로 좌표를 검색합니다
		function searchPlaces(str, name) {

			map = new kakao.maps.Map(mapContainer, mapOption);

			var mapName = name;
			var keyword = str;

			if (!keyword.replace(/^\s+|\s+$/g, '')) {
				alert('키워드를 입력해주세요!');
				return false;
			}

			// 장소검색 객체를 통해 키워드로 장소검색을 요청합니다
			geocoder
					.addressSearch(
							keyword,
							function(result, status) {

								// 정상적으로 검색이 완료됐으면 
								if (status === kakao.maps.services.Status.OK) {

									for (var i = 0; i < result.length; i++) {

										var coords = new kakao.maps.LatLng(
												result[i].y, result[i].x);

									}

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
		}
		function pickdate() {
			$(function() {
				//input을 datepicker로 선언
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
									monthNamesShort : [ '1', '2', '3', '4',
											'5', '6', '7', '8', '9', '10',
											'11', '12' ] //달력의 월 부분 텍스트
									,
									monthNames : [ '1월', '2월', '3월', '4월',
											'5월', '6월', '7월', '8월', '9월',
											'10월', '11월', '12월' ] //달력의 월 부분 Tooltip 텍스트
									,
									dayNamesMin : [ '일', '월', '화', '수', '목',
											'금', '토' ] //달력의 요일 부분 텍스트
									,
									dayNames : [ '일요일', '월요일', '화요일', '수요일',
											'목요일', '금요일', '토요일' ] //달력의 요일 부분 Tooltip 텍스트
									,
									minDate : "-1M" //최소 선택일자(-1D:하루전, -1M:한달전, -1Y:일년전)
									,
									maxDate : "+1M" //최대 선택일자(+1D:하루후, -1M:한달후, -1Y:일년후)                
								});

				//초기값을 오늘 날짜로 설정
				$('#datepicker').datepicker('setDate', 'today');
				//(-1D:하루전, -1M:한달전, -1Y:일년전), (+1D:하루후, -1M:한달후, -1Y:일년후)            
			});
		}
		function movePage() {
			location.href = "./booking_insert";
		}
	</script>

	<script src="./javascript/main.js">
		
	</script>

	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

</body>
</html>