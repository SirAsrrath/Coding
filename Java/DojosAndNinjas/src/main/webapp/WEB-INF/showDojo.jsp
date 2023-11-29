<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title><c:out value="${dojo.name }"></c:out></title>
</head>
<body>

	<h1><c:out value="${dojo.name}"/></h1>
    <div>
        <table class="table table-bordered">
            <thead class="thead-dark">
                <tr>
                    <th scope="col">First Name</th>
                    <th scope="col">Last Name</th>
                    <th scope="col">Age</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="ninja" items="${dojo.ninjas}">
                    <tr>
                        <td><c:out value="${ninja.firstName}"/></td>
                        <td><c:out value="${ninja.lastName}"/></td>
                        <td><c:out value="${ninja.age}"/></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>


	
</body>
</html>