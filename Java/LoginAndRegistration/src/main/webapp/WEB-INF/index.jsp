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
<title>Login and Registration</title>
</head>
<body>
<div>
	<h1>Create an user</h1>
    <div class="container">
        
        <form:form action="/register" method="post" modelAttribute="user" class="form-control">         
            <p>
                    <form:label path="username">Username:</form:label>
                    <form:errors path="username"/>
                    <form:input  path="username"/>
            </p>
            <p>
                    <form:label path="email">Email:</form:label>
                    <form:errors path="email"/>
                    <form:input  path="email"/>
            </p>
            <p>
                    <form:label path="password">Password:</form:label>
                    <form:errors path="password"/>
                    <form:input   type="password" path="password"/>
            </p>
            <p>
                    <form:label path="confirmpw">Confirm Password:</form:label>
                    <form:errors path="confirmpw"/>
                    <form:input type="password"  path="confirmpw"/>
            </p>
                <input type="submit" value="Submit" class="mt-2 btn btn-primary">
        </form:form>
    </div>
    
    <div class="container">
    	<form:form action="/login" method="post" modelAttribute="login" class="form-control">         
            
            <p>
                    <form:label path="email">Email:</form:label>
                    <form:errors path="email"/>
                    <form:input  path="email"/>
            </p>
            <p>
                    <form:label path="password">Password:</form:label>
                    <form:errors path="password"/>
                    <form:input type="password" path="password"/>
            </p>
          
                <input type="submit" value="Submit" class="mt-2 btn btn-primary">
        </form:form>
    </div>
</div>

</body>
</html>