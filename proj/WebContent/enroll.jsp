<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="search.do" method="post">
	<h3>Subject</h3>
		I      D : <input type="text" name="sid"/>
		<input type="submit" value="Search"/>
	</form>
	<%
	String result = (String)request.getAttribute("msg");
	if(result != null && result.equals("true"))
	{
	%>
	<form action="enroll.do" method="post">
		${sid}:${name}
		<input type="submit" value="Enrollment"/>
	</form>
	<%}else if(result != null && result.equals("false")){
		out.print("NO subject ID");
	}	
	%>
	<a href="proj/stumenu.jsp">Menu</a><br>
</body>
</html>