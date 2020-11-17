<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="frm" method="post" enctype="multipart/form-data" >
		<table>
			<tr>
				<td>슬라이드파일-1</td>
				<td><input type="file" name="pic"></td>

			</tr>
			<tr>
				<td>슬라이드파일-2</td>
				<td><input type="file" name="pic"></td>

			</tr>
			<tr>
				<td>슬라이드파일-3</td>
				<td><input type="file" name="pic"></td>

			</tr>
			<tr>
				<td>슬라이드파일-4</td>
				<td><input type="file" name="pic"></td>

			</tr>
			<tr>
				<td><input class="btn" type="submit" value="슬라이드사진등록"></td>
				<td><input class="btn" type="button" value="취소"
					onClick="go_mov()"></td>
			</tr>
		</table>
	</form>
	<script>
		function go_save() {
			var theForm = document.frm;

			if (theForm.pic.value == '') {
				alert('슬라이드 이미지들 입력하세요.');
				theForm.pic.focus();
			} else {
				theForm.encoding = "multipart/form-data";

				// productWrite.jsp 폼 페이지에서 입력받은 값을
				// 디비에 추가하기 위한 페이지인 product_save.jsp로 이동하되
				// 입력받은 상품 코드를 쿼리 스트링 형태로 전달한다.
				// 상품 코드로 폴더를 만들어 거기에 이미지 파일을 업로드한다.
				theForm.action = "../VetClinicBoardServlet?command=slide";
				theForm.submit();
				alert("저장되었습니다");
				
			}
			
		}
		

		function go_mov() {
			var theForm = document.frm;
			theForm.action = "VetClinicBoardServlet?command=main";
			theForm.submit();
		}
	</script>
</body>
</html>