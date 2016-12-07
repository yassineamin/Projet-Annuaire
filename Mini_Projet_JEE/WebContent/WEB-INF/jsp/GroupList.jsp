<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Groupe : </h1>
	<table border='1'>
		<c:forEach items="${group}" var="prod">
			<tr>
				<td><c:out value="${prod.nameGroup}" /></td>
				<td><i>$<c:out value="${prod.idGroup}" /></i></td>
			</tr>

		</c:forEach>
	</table>
	<p>
	</p>
</body>
</html>