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
	<title>Create a course</title>
	<!-- Bootstrap Link -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-aFq/bzH65dt+w6FI2ooMVUpc+21e0SRygnTpmBvdBgSdnuTN7QbdgL+OapgHtvPp" crossorigin="anonymous">
</head>
<body>
	<div class="mainContainer">
		<h1>Create a Course</h1>
		<div class="midContainer">
			<form:form action="/course/new" method="POST" modelAttribute="newCourse">
				<div class="row my-4">
					<form:label path="courseName" class="col-3">Name : </form:label>
					<form:errors path="courseName" class="text-danger"/>
					<form:input path="courseName"/>
				</div>
				<div class="row my-4">
					<form:label path="dayOfWeek" class="col-3">Day Of Week : </form:label>
					<form:errors path="dayOfWeek" class="text-danger"/>
					<form:select path="dayOfWeek">
						<form:option value="Sunday">Sunday</form:option>
						<form:option value="Monday">Monday</form:option>
						<form:option value="Tuesday">Tuesday</form:option>
						<form:option value="Wednesday">Wednesday</form:option>
						<form:option value="Thursday">Thursday</form:option>
						<form:option value="Friday">Friday</form:option>
						<form:option value="Saturday">Saturday</form:option>
					</form:select>
				</div>
				<div class="row my-4">
					<form:label path="price" class="col-3">Drop-In Price : </form:label>
					<form:errors path="price" class="text-danger"/>
					<form:input type="number" path="price" min="1" max="100" step="0.01"/>
				</div>
				<div class="row my-4">
					<form:label path="time" class="col-3">Time : </form:label>
					<form:errors path="time" class="text-danger"/>
					<form:input path="time" type="time"/>
				</div>
				<div class="row my-4">
					<form:label path="description" class="col-3">Description : </form:label>
					<form:errors path="description" class="text-danger"/>
					<form:textarea path="description" rows = "5" cols = "30"/>
				</div>
				<a href="/courses" class="btn btn-secondary">Cancel</a>
				<input type="submit" value="Submit" class="btn btn-primary"/>
			</form:form>
		</div>
	</div>
</body>
</html>