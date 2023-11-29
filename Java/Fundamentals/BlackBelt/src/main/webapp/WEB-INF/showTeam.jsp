<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %> 

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <title>Team Details</title>
</head>
<body>

<h1 class="mt-5"><c:out value="${team.name}"/></h1>
<p>
    <a href="/home">dashboard</a>
</p>
<div class="container mt-4">
    <div class="row">
        <div class="col-md-6">
            <p> Team Name: <c:out value="${team.name}"/></p>
            <p> Added By: <c:out value="${user.username}"/></p>
            <p> Skill Level: <c:out value="${team.skill}"/></p>
            <p> Game Day: <c:out value="${team.gameday}"/></p>
        </div>
    </div>
    <div class="row mt-3">
        <div class="col-md-6">
            <p> Players: </p>
            <ul>
                <c:forEach var="player" items="${players}">
                    <li><c:out value="${player.name}"/></li>
                </c:forEach>
            </ul>
        </div>
    </div>
</div>


</body>
</html>
