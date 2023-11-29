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
<title>View Expense</title>
</head>
<body>
    <div>
        <h1><c:out value="${travels.name}"></c:out></h1>
        <a href="/">Back to Main</a>
        <table>
            <thead>
                <tr>
                    <th scope="col">Vendor</th>
                    <th scope="col">Amount</th>
                    <th scope="col">Description</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><c:out value="${expense.vendor}"></c:out></td>
                    <td><c:out value="${expense.amount}"></c:out></td>
                    <td><c:out value="${expense.description}"></c:out></td>

                </tr>
            </tbody>
        </table>
    </div>
</body>
</html>