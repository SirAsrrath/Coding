<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Kickball League</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<div class="container">
    <h1 class="mt-5">Welcome!</h1>

    <div class="row justify-content-center">
        <div class="col-md-6 mt-3">
            <form:form action="/register" method="post" modelAttribute="user">
                <div class="form-group">
                    <form:label path="username">Username:</form:label>
                    <form:errors path="username" cssClass="text-danger"/>
                    <form:input path="username" class="form-control"/>
                </div>
                <div class="form-group">
                    <form:label path="email">Email:</form:label>
                    <form:errors path="email" cssClass="text-danger"/>
                    <form:input path="email" class="form-control"/>
                </div>
                <div class="form-group">
                    <form:label path="password">Password:</form:label>
                    <form:errors path="password" cssClass="text-danger"/>
                    <form:input type="password" path="password" class="form-control"/>
                </div>
                <div class="form-group">
                    <form:label path="confirmpw">Confirm Password:</form:label>
                    <form:errors path="confirmpw" cssClass="text-danger"/>
                    <form:input type="password" path="confirmpw" class="form-control"/>
                </div>
                <input type="submit" value="Submit" class="mt-2 btn btn-primary">
            </form:form>
        </div>
    </div>

    <div class="row justify-content-center mt-4">
        <div class="col-md-6">
            <form:form action="/login" method="post" modelAttribute="login">
                <div class="form-group">
                    <form:label path="email">Email:</form:label>
                    <form:errors path="email" cssClass="text-danger"/>
                    <form:input path="email" class="form-control"/>
                </div>
                <div class="form-group">
                    <form:label path="password">Password:</form:label>
                    <form:errors path="password" cssClass="text-danger"/>
                    <form:input type="password" path="password" class="form-control"/>
                </div>
                <input type="submit" value="Submit" class="mt-2 btn btn-primary">
            </form:form>
        </div>
    </div>
</div>

</body>
</html>

