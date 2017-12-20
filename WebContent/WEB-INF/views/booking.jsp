<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="springForm"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page session="false"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Booking Page</title>
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

.footer {
	padding: 2px;
	text-align: right;
	background-color: lightgray;
}

.error {
	color: #ff0000;
	font-style: italic;
	font-weight: bold;
}

.radioButtonDiv > span {
	margin-left: 5px;
	margin-right: 5px;
}

.radioButtonDiv > span:first-child {
	margin-left: 0px;
}

.radioButtonDiv > span > label {
	margin-left: 5px;
}

</style>
</head>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<div>
		<div class="header">
			<h2>
				<spring:message code="label.header"/>
			</h2>
		</div>
		
		<div class="content">
			<div class="contentHeader">
				<b><spring:message code="label.header2"/></b>
			</div>
			
			<div>
				<springForm:form action="${contextPath}/confirm" method="POST" commandName="bookingSlot">
					<table cellpadding="5">
						<tr>
							<td>
								<springForm:label path="employeeId">
									<spring:message code="label.employeeId" />
								</springForm:label>
							</td>
							
							<td>
								<springForm:input path="employeeId"/>
							</td>
							
							<td>
								<springForm:errors path="employeeId" cssClass="error"/>
							</td>
						</tr>
						
						<tr>
							<td>
								<springForm:label path="employeeName">
									<spring:message code="label.employeeName" />
								</springForm:label>
							</td>
							
							<td>
								<springForm:input path="employeeName"/>
							</td>
							
							<td>
								<springForm:errors path="employeeName" cssClass="error"/>
							</td>
						</tr>
						
						<tr>
							<td>
								<springForm:label path="email">
									<spring:message code="label.email" />
								</springForm:label>
							</td>
							
							<td>
								<springForm:input path="email"/>
							</td>
							
							<td>
								<springForm:errors path="email" cssClass="error"/>
							</td>
						</tr>
						
						<tr>
							<td>
								<springForm:label path="phone">
									<spring:message code="label.phone" />
								</springForm:label>
							</td>
							
							<td>
								<springForm:input path="phone"/>
							</td>
							
							<td>
								<springForm:errors path="phone" cssClass="error"/>
							</td>
						</tr>
						
						<tr>
							<td>
								<springForm:label path="accountName">
									<spring:message code="label.accountName" />
								</springForm:label>
							</td>
							
							<td>
								<springForm:input path="accountName"/>
							</td>
							
							<td>
								<springForm:errors path="accountName" cssClass="error"/>
							</td>
						</tr>
						
						<tr>
							<td>
								<springForm:label path="assessmentName">
									<spring:message code="label.assessmentName" />
								</springForm:label>
							</td>
							
							<td>
								<springForm:select path="assessmentName">
									<springForm:option value="">--- Select ---</springForm:option>
									<springForm:options items="${assessmentList}" />
								</springForm:select>
							</td>
							
							<td>
								<springForm:errors path="assessmentName" cssClass="error"/>
							</td>
						</tr>
						
						<tr>
							<td>
								<springForm:label path="level">
									<spring:message code="label.level" />
								</springForm:label>
							</td>
							
							<td>
								<div class="radioButtonDiv">
									<springForm:radiobuttons path="level" items="${levelList}" />
								</div>
							</td>
							
							<td>
								<springForm:errors path="level" cssClass="error"/>
							</td>
						</tr>
						
						<tr>
							<td>
								<springForm:label path="dateOfAssessment">
									<spring:message code="label.dateOfAssessment" />
								</springForm:label>
							</td>
							
							<td>
								<springForm:input path="dateOfAssessment" placeholder="dd-MMM-yyyy"/>
							</td>
							
							<td>
								<springForm:errors path="dateOfAssessment" cssClass="error"/>
							</td>
						</tr>
						
						<tr>
							<td>
								<springForm:label path="slot">
									<spring:message code="label.slot" />
								</springForm:label>
							</td>
							
							<td>
								<springForm:select path="slot">
									<springForm:option value="">--- Select ---</springForm:option>
									<springForm:options items="${slotList}" />
								</springForm:select>
							</td>
							
							<td>
								<springForm:errors path="slot" cssClass="error"/>
							</td>
						</tr>
						
						<tr>
							<td colspan="3">
								<springForm:button type="submit">
									Confirm Booking
								</springForm:button>
							</td>
						</tr>
						
						<tr>
							<td colspan="3">
								<center>
									| &nbsp; <a href="${contextPath}/"> Back </a> &nbsp; |
								</center>								
							</td>
						</tr>
					</table>
				</springForm:form>
			</div>
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