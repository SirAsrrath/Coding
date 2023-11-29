<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<head>
<meta charset="ISO-8859-1">
<title>Show Omikuji</title>
</head>
<body>
	<h1>Omikuji</h1>
	
	<div>
		<p>In <c:out value="${number}"/> years, you will live in <c:out value="${cityName }"/>
		 with <c:out value="${personName }"/> as your roomate, <c:out value="${hobby }"/> for a living.
		 The next time you see a <c:out value="${thing }"/>, you will have good luck. Also,
		 <c:out value="${comment }"/></p>
	</div>
	
	<a class="back" href="/back"> Go back</a>
</body>
</html>