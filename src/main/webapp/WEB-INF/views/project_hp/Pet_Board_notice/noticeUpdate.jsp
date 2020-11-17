<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<style>
</style>
<link rel="stylesheet" href="./css/main.css">
<script type="text/javascript"
	src="resources/smarteditor2/js/HuskyEZCreator.js" charset="utf-8"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file='../header.jsp'%>
	<form name="frm" action="./notice_update" method="post"
		enctype="multipart/form-data">
		<div>
			<h1 style="text-align: center; padding: 20px;">공지사항 수정하기</h1>
			<input type="hidden" name="notice_num" value="${bVo.notice_num }">
			<table class="boardViewTable">
				<tr>
					<th>작성자</th>
					<td width="15%"><input type="text" name="notice_name"
						value="${bVo.notice_name}" style="border: none; outline: none;"
						readonly></td>
					<th>작성일</th>
					<td width="15%">${bVo.notice_date}</td>
					<th>조회수</th>
					<td width="15%">${bVo.notice_hit }</td>
				</tr>
				<tr>
					<th>제목</th>
					<td colspan="5"><input type="text" name="notice_title"
						size="101" value="${bVo.notice_title }"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td colspan="3"><textarea cols="100" rows="20" id="content"
							name="notice_content" >${bVo.notice_content }</textarea></td>
				</tr>
			</table>
			<div class="boardViewBtn">
				<br> <br> <input type="submit" value="게시글 수정"
					onclick="updateSe();" class="boardViewBtnUpdate"> <input
					type="reset" value="수정 취소" class="boardViewBtnDelete">
			</div>
		</div>
		<script type="text/javascript" src="./javascript/main.js"></script>
	</form>
	<%@ include file='../footer.jsp'%>

	<script type="text/javascript">
		var oEditors = [];
		nhn.husky.EZCreator.createInIFrame({
			oAppRef : oEditors,
			elPlaceHolder : "content",
			sSkinURI : "resources/smarteditor2/SmartEditor2Skin.html",
			htParams : {
				// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
				bUseToolbar : true,
				// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
				bUseVerticalResizer : true,
				// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
				bUseModeChanger : true,

				fOnBeforeUnload : function() {

				}
			},
			fOnAppLoad : function() {
				//기존 저장된 내용의 text 내용을 에디터상에 뿌려주고자 할때 사용
				oEditors.getById["content"].exec("PASTE_HTML", [ "" ]);
			},
			fCreator : "createSEditor2"
		});

		//저장버튼 클릭시 form 전송
		function pasteHTML(filepath) {
			alert(filepath);
			var sHTML = '<img src="/resources/upload'+filepath+'">';
			oEditors.getById["content"].exec("PASTE_HTML", [ sHTML ]);
		}

		function updateSe() {
			// 에디터의 내용이 textarea에 적용된다.
			oEditors.getById["content"].exec("UPDATE_CONTENTS_FIELD", []);
			// 에디터의 내용에 대한 값 검증은 이곳에서
			// document.getElementById("rev_contents").value를 이용해서 처리한다.

			try {
				document.formm.submit();
			} catch (e) {
			}
		}
	</script>

</body>
</html>