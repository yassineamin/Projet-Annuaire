<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="true" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>

<%-- <c:url var="list" value="/actions/groupe/GroupList" />  --%>

 <c:redirect url="/actions/user/loginForm" /> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<style>
.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
</head>

<body>
	<h1>Edit Group : </h1>

<%-- 	<form:form method="POST" commandName="actions/user"> --%>
<!-- 		<tr> -->
<!-- 			<td> Id :</td> -->
<%--  			<td> <form:input path="idGroup"/> </td> --%>
<!-- 		</tr> -->
<!-- 		<tr> -->
<!-- 			<td> <input type="submit"/> </td> -->
<!-- 		</tr> -->
<%-- 	</form:form> --%>
	
<%-- 	<a href="${list}">Se co</a> --%>

	
</body>
</html>



<%-- <a href="${contextPath}/actions/groupe/GroupList">afficher grp</a> --%>