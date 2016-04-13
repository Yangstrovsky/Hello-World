<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GBK">
<title>Insert title here</title>
</head>
<body>
<h1>TEST PROGRAM</h1>
<hr/>
<% request.setCharacterEncoding("GBK"); %>
<form action="usersearch.do" method="post" >
Plz input the ID for serach:
<input type="text" name="id"/>
<br>
<input type="submit" value="查询"/>
<input type="reset" value="重置"/>

</form>
</body>
</html>