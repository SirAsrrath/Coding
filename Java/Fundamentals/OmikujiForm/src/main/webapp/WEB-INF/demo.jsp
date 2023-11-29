<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<head>
<meta charset="ISO-8859-1">

<title>Create an omikuji</title>
</head>
<body>
	<form action="/submit" method="POST">
        <div class="container-md">
            <div>
                <label for="formControlInput" class="form-label">Pick any number between 5 and 25: </label>
                <input type="text" name="number">
            </div>
            <div>
                <label for="formControlInput" class="form-label">Enter the name of a city</label>
                <input type="text" name="cityName" class="form-control" id="formControlInput">
            </div>
            <div>
                <label for="formControlInput" class="form-label">Enter the name of any real person</label>
                <input type="text" name="personName" class="form-control" id="formControlInput">
            </div>
            <div>
                <label for="formControlInput" class="form-label">Enter professional endeavor or hobby</label>
                <input type="text" name="hobby" class="form-control" id="formControlInput">
            </div>
            <div>
                <label for="formControlInput" class="form-label">Enter any type of living thing</label>
                <input type="text" name="thing" class="form-control" id="formControlInput">
            </div>
            <div>
                <label for="formControlInput" class="form-label">Say something nice about someone</label>
                <textarea name="comment" cols="30" rows="10"></textarea>
            </div>
            <div>
                <p>Send and show a friend</p>
            </div>
            <div>
                <input type="submit">
            </div>
        </div>
	</form>
</body>
</html>