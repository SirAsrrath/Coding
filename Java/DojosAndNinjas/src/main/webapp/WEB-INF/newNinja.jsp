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
<title>New Ninja</title>
</head>
<body>
<div>
    <div class="container">
        <h1>New Ninja</h1>
        <form:form action="/ninjas" method="post" modelAttribute="ninja">         
            	<p>	
                    <form:label path="firstName">First Name</form:label>
                    <form:errors path="firstName"/>
                    <form:input  path="firstName"/>
                </p>
                <p>
                    <form:label path="lastName">lastName</form:label>
                    <form:errors path="lastName"/>
                    <form:input path="lastName"/>
                </p>
                <p>
                    <form:label path="age">Age</form:label>
                    <form:errors path="age"/>
                    <form:input type="number" path="age"/>
                </p>
                <p>
        			<form:label path="dojo">Dojo:</form:label>
        			<form:select path="dojo">
        				<c:forEach var="eachDojo" items="${dojos}">
		        			<option value="${eachDojo.id}"><c:out value="${eachDojo.name}"/></option>    
        				</c:forEach>
        			</form:select>
    			</p>

                <input type="submit" value="Submit" class="mt-2 btn btn-primary">
        </form:form>
    </div>
</div>
</body>
</html>