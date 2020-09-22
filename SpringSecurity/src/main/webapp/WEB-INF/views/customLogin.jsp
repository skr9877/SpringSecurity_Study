<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
</head>
<body>

	<h1>Custom 로그인 페이지</h1>
	<h2><c:out value="${error}"/></h2>
	<h3><c:out value="${logout}"/></h3>
	
	<form method='post' action="/login">
		<div>
			<input type='text' name='username' value='admin'>
		</div>
	</form>
</body>
</html>