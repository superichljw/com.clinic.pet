<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/main.css">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</head>
<body>
	<%@ include file='../header.jsp'%>
	<div id="tab">

		<div class="tabmenu">
			<button class="btn1" type="button"
				onclick="location.href='./notice_list'">공지사항</button>
			<button class="btn2 on" type="button" style="margin-left: -5px;"
				onclick="location.href='./news_list'">새소식</button>
			<button class="btn3" type="button" style="margin-left: -5px;"
				onclick="location.href='./faq_list'">FAQ</button>
			<button class="btn4" type="button" style="margin-left: -5px;"
				onclick="location.href='./qna_list'">Q&A</button>
		</div>
		<div class="tabtitle">
			<ul>
				<li style="width: 10%; border-right: 1px solid lightgray;">글번호</li>
				<li
					style="width: 49.5%; margin-left: -5px; border-right: 1px solid lightgray;">제목</li>
				<li
					style="width: 15%; margin-left: -5px; border-right: 1px solid lightgray;">등록일</li>
				<li
					style="width: 14.5%; margin-left: -5px; border-right: 1px solid lightgray;">게시자</li>
				<li style="width: 10%; margin-left: -5px;">조회수</li>
			</ul>
		</div>

		<div class="tabcontent">
			<c:forEach items="${newsdtos }" var="newsdtos">
				<ul>
					<li style="width: 10%; border-right: 1px solid lightgray;"><a
						href="./news_content_view?news_num=${newsdtos.news_num }">${newsdtos.news_num }</a></li>
					<li
						style="width: 49.5%; margin-left: -5px; border-right: 1px solid lightgray;">
						<a href="./news_content_view?news_num=${newsdtos.news_num }">${newsdtos.news_title }</a>
					</li>
					<li
						style="width: 15%; margin-left: -5px; border-right: 1px solid lightgray;"><fmt:formatDate
							value="${newsdtos.news_date }" /></li>
					<li
						style="width: 14.5%; margin-left: -5px; border-right: 1px solid lightgray;">${newsdtos.news_name }</li>
					<li style="width: 10%; margin-left: -5px;">${newsdtos.news_hit }</li>
				</ul>
			</c:forEach>
		</div>


		<div class="board-pageNum">
				<tr>
					<td colspan="5"><a
						href="./news_list?page=${newsDto.firstPageNum }
			&pageDataCount=${newsDto.pageDataCount}">
							◀◀맨앞으로 </a>&nbsp;&nbsp; <a
						href="./news_list?page=${newsDto.prevPageNum }
			&pageDataCount=${newsDto.pageDataCount}">
							◀앞으로 </a>&nbsp;&nbsp; <c:forEach var="i"
							begin="${newsDto.startPageNum }" end="${newsDto.endPageNum }"
							step="1">
							<c:choose>
								<c:when test="${i eq newsDto.currentPageNum }">
									<a style="font-weight: bold; color: blue"
										href="./news_list?page=${i }
				&pageDataCount=${newsDto.pageDataCount}">${i }
									</a>&nbsp;&nbsp;
			</c:when>
								<c:otherwise>
									<a
										href="./news_list?page=${i }
			&pageDataCount=${newsDto.pageDataCount}">${i }
									</a>&nbsp;&nbsp;
			</c:otherwise>
							</c:choose>
						</c:forEach> <a
						href="./news_list?page=${newsDto.nextPageNum }
			&pageDataCount=${newsDto.pageDataCount}">뒤로▶
					</a>&nbsp;&nbsp; <a
						href="./news_list?page=${newsDto.lastPageNum }
			&pageDataCount=${newsDto.pageDataCount}">맨뒤로▶▶
					</a></td>
				</tr>
		</div>
	</div>
	<c:choose>
		<c:when test="${empty loginUser }">
			<div
				style="width: 80%; margin: 0 auto; text-align: right; display: none;">
				<a href="./news_write_form"><input type="button" value="글쓰기"
					id="writeBtn"></a>
			</div>
		</c:when>
		<c:when test="${loginUser.usertype eq 'mem' }">
			<div
				style="width: 80%; margin: 0 auto; text-align: right; display: none;">
				<a href="./news_write_form"><input type="button" value="글쓰기"
					id="writeBtn"></a>
			</div>
		</c:when>
		<c:when test="${loginUser.usertype eq 'doc'}">
			<div
				style="width: 80%; margin: 0 auto; text-align: right; display: none;">
				<a href="./news_write_form"><input type="button" value="글쓰기"
					id="writeBtn"></a>
			</div>
		</c:when>
		<c:otherwise>
			<div style="width: 80%; margin: 0 auto; text-align: right;">
				<a href="./news_write_form"><input type="button" value="글쓰기"
					id="writeBtn"></a>
			</div>
		</c:otherwise>
	</c:choose>
	<%@ include file='../footer.jsp'%>

	<script src="./javascript/main.js">
		
	</script>
</body>
</html>