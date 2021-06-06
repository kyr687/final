<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String result = (String)request.getAttribute("result");
		if(result == null)
		{
	%>
			${prof}교수님 [${id} : ${name}] ${count} 명 등록 완료!!
	<% 
		}else{
			out.print(result);
		}
	%>
</body>
</html>