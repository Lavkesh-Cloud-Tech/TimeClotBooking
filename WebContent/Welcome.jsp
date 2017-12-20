<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome page</title>

<style type="text/css">
.header {
	text-align: center;
	border-bottom: 2px solid gray; 
	margin: 0 auto;
}

.content {
	text-align: center;
	margin: 0 auto;
	padding: 10px;
}

.footer {
	padding: 2px;
	text-align: right;
	background-color: lightgray;
}.
</style>

</head>

<body>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<div>
		<div class="header">
			<h2>
				CA Enablement  Assessments
			</h2>
		</div>
		
		<div class="content">
			<a href="${contextPath}/show">
				Book a Slot for Assessment
			</a>
		</div>
		
		<div class="footer">
			<div class="">
				<a href="${contextPath}/show?language=en">
					English
				</a>
				
				&nbsp; &nbsp;
				
				<a href="${contextPath}/show?language=es">
					Spanish
				</a>
			</div>
		</div>
	</div>
</body>

</html>