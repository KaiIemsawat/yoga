<!-- JSP -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- JSTL -->
<!-- c: -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!-- Form/Submit workflows -->
<!-- form: -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- The 'isErrorPage' attribute indicates that the current JSP can be used as the error page for another JSP. -->
<%@ page isErrorPage="true" %>
<!-- The **errorPage** attribute tells the JSP engine which page to display if there is an error while the current page runs. The value of the errorPage attribute is a relative URL. -->
<%@ page errorPage = "MyErrorPage.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Instructor Courses</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
	<link rel="stylesheet" href="/css/style.css"/>
</head>
<body>
	<div class="container">
		<h1>Namaste, ${instructor.userName}</h1>
		<h3>Course Schedule</h3>
		<table class="dojotable">
			<thead>
			<tr>
				<th>Class Name</th>
				<th>Instructor</th>
				<th>Weekday</th>
				<th>Price</th>
				<th>Time</th>
			</tr>
			</thead>
			<%-- <tbody>
				<c:forEach var="c" items="${courses}">
					<c:choose>
						<c:when test="${c.users.id == users.id}">
							<tr>
								<td>${c.courseName}</td>							
								<td>${c.users.userName}</td>							
								<td>${c.dayOfWeek}</td>							
								<td><span>$</span>${c.price}</td>							
								<td>${c.time}</td>							
							</tr>
						</c:when>
					</c:choose>						 
				</c:forEach>
			</tbody> --%>
		</table>
		<a href="course/new" class="btn btn-primary">+ New Course</a>
	</div>

</body>
</html>