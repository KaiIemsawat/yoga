<!-- JSP -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- JSTL -->
<!-- c: -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!-- Form/Submit workflows -->
<!-- form: -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- The&nbsp;'isErrorPage'&nbsp;attribute indicates that the current JSP can be used as the error page for another JSP. -->
<%@ page isErrorPage="true" %>
<!-- The&nbsp;errorPage&nbsp;attribute tells the JSP engine which page to display if there is an error while the current page runs. The value of the errorPage attribute is a relative URL. -->
<%@ page errorPage = "MyErrorPage.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Course Details</title>
	<!-- Bootstrap Link -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
	<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/style.css"/>
</head>
<body>
	<div class="mainContainer">
		<h1>${course.courseName} with ${course.instructorName}</h1>
		<p>Day : ${course.dayOfWeek}</p>
		<p>Cost : <span>$</span>${course.price}</p>
		<p>${course.description}</p>
		<!-- <a href="/courses" class="btn btn-secondary">Back</a> -->
		<form>
			<input type="button" value="Back" class="btn btn-primary" onclick="history.back()">
		</form>
	</div>
</body>
</html>