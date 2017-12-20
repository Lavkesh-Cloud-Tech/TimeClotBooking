<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Slot Booking Success Page</title>
<style type="text/css">

* {
	margin: 0 auto;
}

.header {
	text-align: center;
	border-bottom: 2px solid gray;
	padding: 10px; 
}

.content {
	padding: 10px;
}

.contentHeader {
	text-align: center;
	padding-bottom: 5px;
}

.error {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}

.paddingBottom15 {
	padding-bottom: 15px;
}
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
			<div class="contentHeader paddingBottom15">
				<b>Booking Successfully Done</b>
			</div>
			
			<div class="contentHeader">
				<a href="${contextPath}/show">Confirm Another Booking</a>
			</div>
		</div>
	</div>
</body>	
</html>