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
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<head>
<meta charset="UTF-8">
<title>Save Travels</title>
</head>
<body>
    <div class="container">
        <h1>Save Travels</h1>
        <div>
            <c:if test="${empty list}">
                <table class="table">
                    <thead>
                        <tr>
                            <th scope="col">Expense</th>
                            <th scope="col">Vendor</th>
                            <th scope="col">Amount</th>
                            <th scope="col">Actions</th>
                        </tr>
                    </thead>
                    <c:forEach var="expense" items="${expenses}">
                        <tbody>
                            <tr>
                                <th scope="row"><a href="/view/<c:out value="${expense.id}"></c:out>"><c:out value="${expense.name}"></c:out></a></th>
                                <td><c:out value="${expense.vendor}"></c:out></td>
                                <td><c:out value="${expense.amount}"></c:out></td>
                                <td>
                                    <a href='/edit/<c:out value="${expense.id}"/>' class="edit"> Edit</a>
                                    <a href='/delete/<c:out value="${expense.id}"/>' class="edit"> Delete</a>
                                    
                                </td>
                            </tr>
                        </tbody>
                    </c:forEach>
                </table>
            </c:if>
        </div>

      <div class="container">
            <h2>Add Expense</h2>
            <form:form action="/create" method="post" modelAttribute="expense">                
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