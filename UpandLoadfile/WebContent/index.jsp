<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>文件上传</title>
</head>
<body>
 		<form action="uploadservlet" method="post" enctype="multipart/form-data">
 			上传文件<input type="file" name="transfile"/><br/>
 			<input type="submit" value="提交"/>
 		</form>
</body>
</html>