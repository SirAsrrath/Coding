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
<title>Edit</title>
</head>
<body>
<div>
    <div class="container">
        <h2>Edit Expense</h2>
        <a href="/">Back to Main</a>
        <form:form action="/update/${expense.id}" method="post" modelAttribute="expense">         
            <p>
                    <form:label path="name">Expense</form:label>
                    <form:errors path="name"/>
                    <form:input  path="name"/>
                </p>
                <p>
                    <form:label path="vendor">Vendor</form:label>
                    <form:errors path="vendor"/>
                    <form:input path="vendor"/>
                </p>
                <p>
                    <form:label path="amount">Amount</form:label>
                    <form:errors path="amount"/>
                    <form:input type="number" path="amount"/>
                </p>
                <p>
                    <form:label path="description">Description</form:label>
                    <form:errors path="description"/>
                    <form:textarea path="description"/>
                </p>

                <input type="submit" value="Submit" class="mt-2 btn btn-primary">
        </form:form>
    </div>
</div>
</body>
</html>