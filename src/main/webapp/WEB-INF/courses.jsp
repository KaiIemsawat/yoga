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
	<div class="mainContainer">
		<h1>Namaste, ${loggeredUser.userName}</h1>
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
			<tbody>
				<c:forEach var="c" items="${courses}">
							<tr>																		
								<td><a href="/course/${c.id}">${c.courseName}</a>
									<c:if test="${loggeredUser.userName == c.instructorName}">
										<a href="/course/${c.id}/edit" class="btn btn-warning">Edit</a>
									</c:if>
								</td>													
								<td>${c.instructorName}</td>													
								<td>${c.dayOfWeek}</td>													
								<td><span>$</span>${c.price}</td>													
								<td>${c.time}</td>													
							</tr>	 
				</c:forEach>
			</tbody>
		</table>
		<a href="course/new" class="btn btn-primary">+ New Course</a>
		<!-- <a href="courses/all" class="btn btn-primary">See Courses</a> -->
		<a href="/logout" class="btn btn-secondary">Log out</a>
	</div>

</body>
</html>