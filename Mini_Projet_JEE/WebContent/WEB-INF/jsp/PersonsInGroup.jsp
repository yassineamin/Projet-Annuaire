<%@ include file="/WEB-INF/jsp/include.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Liste des personnes dans le groupe  :</h1>
	<table>
		<c:forEach items="${person}" var="p">
			<tr>
				<td><c:out value="${p.idPerson}" /></td>
				<td><c:out value="${p.firstNamePerson}" /></td>
				<td><c:out value="${p.lastNamePerson}" /></td>
				<td><c:out value="${p.emailPerson}" /></td>
				<td><c:out value="${p.webSitePerson}" /></td>
				<td><c:out value="${p.birthayPerson}" /></td>
				<td><c:out value="${p.idGroupPerson}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>