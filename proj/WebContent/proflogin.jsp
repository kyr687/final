<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="proflogin.do" method="post">
	<h3>YongIn LMS</h3>
		I      D : <input type="text" name="id"/><br>
		PASSWORD : <input type="password" name="pwd"/><br>
		<input type="radio" name="login" value="prof" checked/>Professor
		<input type="radio" name="login" value="stu" />Student
		<input type="submit" value="login"/>
	</form>
</body>
</html>