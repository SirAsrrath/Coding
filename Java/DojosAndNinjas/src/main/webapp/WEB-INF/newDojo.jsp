<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
    <!-- Formatting (like dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    <!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
    <!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Dojo</title>
</head>
<body>
<div>
	<h1>New Dojo</h1>
    <div class="container">
        
        <form:form action="/dojos" method="post" modelAttribute="dojo" class="form-control">         
            <p>
                    <form:label path="name">Name:</form:label>
                    <form:errors path="name"/>
                    <form:input  path="name"/>
            </p>
                <input type="submit" value="Submit" class="mt-2 btn btn-primary">
        </form:form>
    </div>
</div>
</body>
</html>