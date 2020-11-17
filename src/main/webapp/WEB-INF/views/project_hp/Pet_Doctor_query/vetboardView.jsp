<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<style>
</style>
<link rel="stylesheet" href="./css/main.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file='../header.jsp'%>
	<div>
		<h1 style="text-align: center; padding: 20px;">게시글 상세보기</h1>

		<table class="boardViewTable">
			<tr>
				<th>작성자</th>
				<td>${board.name}</td>
				<th>이메일</th>
				<td>${board.email}</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td><fmt:formatDate value="${board.writedate}" /></td>
				<th>조회수</th>
				<td>${board.readcount }</td>
			</tr>
			<tr>
				<th>제목</th>
				<td colspan="3">${board.title }</td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="3"><pre>${board.content }</pre></td>
			</tr>

		</table>
		<c:choose>
			<c:when test="${empty loginUser }">
				<input type="hidden" name="comment_num">
				<input type="hidden" name="comment_board" value="${board.num}"
					readonly>
				<table width="60%" style="margin: 0 auto">
					<tr>
						<td rowspan="3" width="10%" style="border: 1px solid lightgray">
							<img src="./image/personvec1.png">
						</td>
						<td width="50%" style="border: 1px solid lightgray"><input
							type="hidden" name="comment_id" value="${loginUser.userid }"
							readonly>로그인후 사용가능합니다</td>
						<td width="50%" style="border: 1px solid lightgray">날짜</td>
					</tr>
					<tr>
						<td colspan="2" rowspan="2" style="border: 1px solid lightgray">
							<textarea cols="100" rows="5" name="comment_content"
								style="border: none" readonly></textarea>
						</td>
					</tr>
				</table>
			</c:when>
			<c:otherwise>
				<form name="frm" action="./board_comment" method="post">
					<input type="hidden" name="comment_num" /> <input type="hidden"
						name="comment_board" value="${board.num}" readonly />
					<table width="60%" style="margin: 0 auto">
						<tr>
							<td rowspan="3" width="10%" style="border: 1px solid lightgray"><img
								src="./image/personvec1.png"></td>
							<td width="50%" style="border: 1px solid lightgray"><input
								type="hidden" name="comment_id" value="${loginUser.userid }">${loginUser.userid }</td>
							<td width="50%" style="border: 1px solid lightgray">날짜</td>
						</tr>
						<tr>
							<td colspan="2" rowspan="2" style="border: 1px solid lightgray"><textarea
									cols="100" rows="5" name="comment_content" style="border: none"></textarea>
							</td>
							<td><input type="submit" value="답글등록"></td>
						</tr>

					</table>
				</form>
			</c:otherwise>
		</c:choose>


		<c:choose>
			<c:when test="${empty vbcList}">
				<p style="text-align: center">댓글이 없습니다</p>
			</c:when>
			<c:otherwise>
				<div class="tabcontent">
					<c:forEach items="${vbcList }" var="vbcList" varStatus="status">

						<table width="80%" style="margin: 0 auto">

							<tr>
								<td rowspan="3" width="10%" style="border: 1px solid lightgray"><img
									src="./image/personvec1.png"></td>
								<td style="border: 1px solid lightgray">${vbcList.comment_id }</td>
								<td style="border: 1px solid lightgray">${vbcList.comment_date }</td>
							</tr>
							<tr>
								<td colspan="2" rowspan="2" style="border: 1px solid lightgray">${vbcList.comment_content }</td>

							</tr>

						</table>
					</c:forEach>
				</div>
			</c:otherwise>
		</c:choose>

		<div class="boardViewBtn">
			<br> <br> <input type="button" value="게시글 수정"
				class="boardViewBtnUpdate" onclick="open_win('./board_check_pass_form?num=${board.num}', 'update')">
			<input type="button" value="게시글 삭제" class="boardViewBtnDelete"
				onclick="open_win('./board_check_pass_form?num=${board.num}', 'delete')">
			<input type="button" value="게시글 리스트" class="boardViewBtnList"
				onclick="location.href='./board_list'">
			<c:choose>
				<c:when test="${empty loginUser  }">
					<input type="button" value="게시글 등록" class="boardViewBtnApply"
						onclick="showPopupLogin()">
				</c:when>
				<c:otherwise>
					<input type="button" value="게시글 등록" class="boardViewBtnApply"
						onclick="location.href='./board_write_form'">

				</c:otherwise>
			</c:choose>

		</div>

	</div>

	<%@ include file='../footer.jsp'%>
	<script type="text/javascript" src="./javascript/main.js"></script>
</body>
</html>