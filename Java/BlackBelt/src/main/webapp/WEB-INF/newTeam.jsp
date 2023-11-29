<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>New Team</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<div class="container">
    <h1 class="mt-5">Create a Team</h1>
    <p>
        <a href="/home">dashboard</a>
    </p>
    <form:form action="/teams/create" method="post" modelAttribute="team">
        <div class="form-group">
            <form:label path="name">Team Name:</form:label>
            <form:errors path="name" cssClass="text-danger"/>
            <form:input path="name" class="form-control"/>
        </div>
        <div class="form-group">
            <form:label path="skill">Skill Level:</form:label>
            <form:select path="skill" class="form-control">
                <form:option value="1">1</form:option>
                <form:option value="2">2</form:option>
                <form:option value="3">3</form:option>
                <form:option value="4">4</form:option>
                <form:option value="5">5</form:option>
            </form:select>
        </div>
        <div class="form-group">
            <form:label path="gameday">Game Day:</form:label>
            <form:select path="gameday" class="form-control">
                <form:option value="Monday">Monday</form:option>
                <form:option value="Tuesday">Tuesday</form:option>
                <form:option value="Wednesday">Wednesday</form:option>
                <form:option value="Thursday">Thursday</form:option>
                <form:option value="Friday">Friday</form:option>
                <form:option value="Saturday">Saturday</form:option>
                <form:option value="Sunday">Sunday</form:option>
            </form:select>
        </div>
        <input type="submit" value="Submit" class="mt-2 btn btn-primary">
    </form:form>
</div>



</body>
</html>
