<%-- 
<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="com.clinic.pet.dto.VetClinicBoardVO"%>
<%@page import="com.clinic.pet.dao.PetDao"%>
<%@page import="org.apache.ibatis.session.SqlSession" %>
<%@page import="org.springframework.beans.factory.annotation.Autowired"  %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	int pageSize = 5; // 한 페이지에 출력할 레코드 수

// 페이지 링크를 클릭한 번호 / 현재 페이지
String pageNum = request.getParameter("pageNum");

if (pageNum == null) { // 클릭한게 없으면 1번 페이지
	pageNum = "1";
}
// 연산을 하기 위한 pageNum 형변환 / 현재 페이지
int currentPage = Integer.parseInt(pageNum);

// 해당 페이지에서 시작할 레코드 / 마지막 레코드
int startRow = (currentPage - 1) * pageSize + 1;
int endRow = currentPage * pageSize;

int count = 0;

SqlSession sqlSession = null;

PetDao petdao = sqlSession.getMapper(PetDao.class);
count = petdao.vetboardgetCount();
/* VetClinicBoardDAO Vdao = VetClinicBoardDAO.getInstance();
count = Vdao.getCount(); // 데이터베이스에 저장된 총 갯수 */

List<VetClinicBoardVO> list = null;
if (count > 0) {
	// getList()메서드 호출 / 해당 레코드 반환
	list = petdao.vetboardgetList(startRow, endRow);
}
%>
<style>
.vet-pageNum .paging {
	text-decoration: none;
}
</style>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="./css/main.css">
<style>
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<%@ include file='../header.jsp'%>
	<div id="vetboard-middle">

		<c:choose>
			<c:when test="${empty loginUser  }">
				<div style="width: 80%; margin: 0 auto; text-align: right;">
				<input type="button" value="글쓰기" id="writeBtn" onclick="showPopupLogin()">
				</div>
			</c:when>
			<c:otherwise>
				<div style="width: 80%; margin: 0 auto; text-align: right;">
					<a href="./board_write_form"><input type="button"
						value="글쓰기" id="writeBtn"> </a>
				</div>
			</c:otherwise>
		</c:choose>

		<table class="vet-table">

			<tr>
				<td style="width: 10%;" class="t1">글번호</td>
				<td style="width: 10%;" class="t1">조회수</td>
				<td style="width: 50%;" class="t1">제목</td>
				<td style="width: 15%;" class="t1">작성자</td>
				<td style="width: 15%;" class="t1">작성일</td>
			</tr>
			<%
				if (count > 0) { // 데이터베이스에 데이터가 있으면
				int number = count - (currentPage - 1) * pageSize; // 글 번호 순번 
				for (int i = 0; i < list.size(); i++) {
					VetClinicBoardVO board = list.get(i); // 반환된 list에 담긴 참조값 할당
			%>
			<tr>
				<td style="width: 10%;" class="t2"><%=board.getNum()%></td>
				<td style="width: 10%;" class="t2"><%=board.getReadcount()%></td>
				<td style="width: 50%;" class="t2"><a
					href="./board_view?num=<%=board.getNum()%>"><%=board.getTitle()%></a></td>
				<td style="width: 15%;" class="t2"><%=board.getName()%></td>
				<td style="width: 15%;" class="t2"><%=board.getWritedate()%></td>
			</tr>

			<c:forEach var="board" items="${boardList }">
				<tr>
					<td style="width: 10%;" class="t2">${board.num }</td>
					<td style="width: 10%;" class="t2">${ board.readcount}</td>
					<td style="width: 50%;" class="t2"><a
						href="VetClinicBoardServlet?command=board_view&num=${board.num }"">${board.title }</a></td>
					<td style="width: 15%;" class="t2">${board.name }</td>
					<td style="width: 15%;" class="t2"><fmt:formatDate
							value="${board.writedate }" /></td>
				</tr>
			</c:forEach>
			<%
				}
			} else
			%>

		</table>

	</div>
	<div class="vet-pageNum">

		<%
			// 페이징  처리
		if (count > 0) {
			// 총 페이지의 수
			int pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
			// 한 페이지에 보여줄 페이지 블럭(링크) 수
			int pageBlock = 5;
			// 한 페이지에 보여줄 시작 및 끝 번호(예 : 1, 2, 3 ~ 10 / 11, 12, 13 ~ 20)
			int startPage = ((currentPage - 1) / pageBlock) * pageBlock + 1;
			int endPage = startPage + pageBlock - 1;

			// 마지막 페이지가 총 페이지 수 보다 크면 endPage를 pageCount로 할당
			if (endPage > pageCount) {
				endPage = pageCount;
			}

			if (startPage > pageBlock) { // 페이지 블록수보다 startPage가 클경우 이전 링크 생성
		%>
		<a
			href="./board_list?pageNum=<%=startPage - 5%>"
			class="paging">[이전]</a>
		<%
			}

		for (int i = startPage; i <= endPage; i++) { // 페이지 블록 번호
		if (i == currentPage) { // 현재 페이지에는 링크를 설정하지 않음
		%>
		[<%=i%>]
		<%
			} else { // 현재 페이지가 아닌 경우 링크 설정
		%>
		<a
			href="./board_list?pageNum=<%=i%>"
			class="paging">[<%=i%>]
		</a>
		<%
			}
		} // for end

		if (endPage < pageCount) { // 현재 블록의 마지막 페이지보다 페이지 전체 블록수가 클경우 다음 링크 생성
		%>
		<a
			href="./board_list?pageNum=<%=startPage + 5%>"
			class="paging">[다음]</a>
		<%
			}
		}
		%>

	</div>

	<%@ include file='../footer.jsp'%>
	<script src="./javascript/main.js">
		
	</script>
</body>
</html> --%>


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
	<div id="vetboard-middle">

		<c:choose>
			<c:when test="${empty loginUser  }">
				<div style="width: 80%; margin: 0 auto; text-align: right;">
					<input type="button" value="글쓰기" id="writeBtn"
						onclick="showPopupLogin()">
				</div>
			</c:when>
			<c:otherwise>
				<div style="width: 80%; margin: 0 auto; text-align: right;">
					<a href="./board_write_form"><input type="button" value="글쓰기"
						id="writeBtn"> </a>
				</div>
			</c:otherwise>
		</c:choose>

		<table class="vet-table">

			<tr>
				<td style="width: 10%;" class="t1">글번호</td>
				<td style="width: 10%;" class="t1">조회수</td>
				<td style="width: 50%;" class="t1">제목</td>
				<td style="width: 15%;" class="t1">작성자</td>
				<td style="width: 15%;" class="t1">작성일</td>
			</tr>

			<c:forEach items="${boardList }" var="boardList" >
				<tr>
					<td style="width: 10%;" class="t2">${boardList.num }</td>
					<td style="width: 10%;" class="t2">${ boardList.readcount}</td>
					<td style="width: 50%;" class="t2"><a
						href="./board_view?num=${boardList.num }">${boardList.title }</a></td>
					<td style="width: 15%;" class="t2">${boardList.name }</td>
					<td style="width: 15%;" class="t2"><fmt:formatDate
							value="${boardList.writedate }" /></td>
				</tr>
			</c:forEach>

		</table>

	</div>
	<div class="vet-pageNum">
		<tr>
			<td colspan="5"><a
				href="./board_list?page=${vetboardPage.firstPageNum }
			&pageDataCount=${vetboardPage.pageDataCount}">
					◀◀맨앞으로 </a>&nbsp;&nbsp; <a
				href="./board_list?page=${vetboardPage.prevPageNum }
			&pageDataCount=${vetboardPage.pageDataCount}">
					◀앞으로 </a>&nbsp;&nbsp; <c:forEach var="i"
					begin="${vetboardPage.startPageNum }"
					end="${vetboardPage.endPageNum }" step="1">
					<c:choose>
						<c:when test="${i eq vetboardPage.currentPageNum }">
							<a style="font-weight: bold; color: blue"
								href="./board_list?page=${i }
				&pageDataCount=${vetboardPage.pageDataCount}">${i }
							</a>&nbsp;&nbsp;
			</c:when>
						<c:otherwise>
							<a
								href="./board_list?page=${i }
			&pageDataCount=${vetboardPage.pageDataCount}">${i }
							</a>&nbsp;&nbsp;
			</c:otherwise>
					</c:choose>
				</c:forEach> <a
				href="./board_list?page=${vetboardPage.nextPageNum }
			&pageDataCount=${vetboardPage.pageDataCount}">뒤로▶
			</a>&nbsp;&nbsp; <a
				href="./board_list?page=${vetboardPage.lastPageNum }
			&pageDataCount=${vetboardPage.pageDataCount}">맨뒤로▶▶
			</a></td>
		</tr>
	</div>

	<%@ include file='../footer.jsp'%>
	<script src="./javascript/main.js">
		
	</script>
</body>
</html>