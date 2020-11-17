<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="top">
	<ul>
		<li style="width: 23%;">
			<div class="top01">
				<label for="menuBtn" class="labelBtn">MENU</label>
				<div class="coverMenu">
					<div class="leftmenu">
						<ul class="submenu">
							<li><a href="./search_list">병원조회</a></li>
							<br>
							<li><a href="./booking_list">예약조회</a></li>
							<br>

							<li><a
								href="./board_list">전문가
									문의</a></li>

							<br>
							<li><a href="./selfinspection">자가진단</a></li>
							<br>

							<li><a href="./notice_list">공지사항</a></li>
							<br>
							<br>


							<div>
								<a class="close">닫기 X</a>
							</div>
						</ul>
					</div>
					<div class="rightmenu"></div>
				</div>
			</div>

		</li>
		<li style="width: 50%;">
			<div class="top02">
				<a href="./main"><img
					src="./image/new_logo.png"
					style="width: 100px; height: 100px;"></a>
			</div>
		</li>
		<li style="width: 23%;"><c:choose>
				<c:when test="${empty loginUser}">
					<div class="top03">
						<a onclick="showPopupLogin()">LOGIN</a> <a
							onclick="showPopupSignupType()">SIGNUP</a>
					</div>
				</c:when>
				<c:otherwise>
					<c:choose>
						<c:when test="${loginUser.usertype eq 'oper' }">
							<div class="top03">${loginUser.userid }(${loginUser.name })(${loginUser.usertype })
								<form action="./logout">
									<input type="submit" value="LOGOUT" name="logout"
										class="logout"
										style="border: none; background-color: white; font-size: 20px;">
								</form>
								<input type="button" value="ADMINPAGE" name="mypage"
									class="mypage"
									onclick="location.href='./booking_mypage'"
									style="border: none; background-color: white; font-size: 20px;">

							</div>
						</c:when>
						<c:when test="${loginUser.usertype eq 'doc' }">
							<div class="top03">${loginUser.userid }(${loginUser.name })(${loginUser.usertype })
								<form action="./logout">
									<input type="submit" value="LOGOUT" name="logout"
										class="logout"
										style="border: none; background-color: white; font-size: 20px;">
								</form>
								<input type="button" value="DOCPAGE" name="mypage"
									class="mypage"
									onclick="location.href='./booking_mypage'"
									style="border: none; background-color: white; font-size: 20px;">

							</div>
						</c:when>
						<c:otherwise>
							<div class="top03">${loginUser.userid }(${loginUser.name })(${loginUser.usertype })
								<form action="./logout">
									<input type="submit" value="LOGOUT" name="logout"
										class="logout"
										style="border: none; background-color: white; font-size: 20px;">
								</form>
								<input type="button" value="MYPAGE" name="mypage" class="mypage"
									onclick="location.href='./booking_mypage'"
									style="border: none; background-color: white; font-size: 20px;">

							</div>
						</c:otherwise>
					</c:choose>

				</c:otherwise>
			</c:choose></li>
	</ul>
</div>
