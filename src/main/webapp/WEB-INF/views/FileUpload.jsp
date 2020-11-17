<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>파일 업로드</h1>
<form method="post" encType="multipart/form-data" action="fileupload">
<input type="file" name="uploadfile" placeholder="파일선택">
<input type="submit" value="업로드">
</form>
</body>
</html>