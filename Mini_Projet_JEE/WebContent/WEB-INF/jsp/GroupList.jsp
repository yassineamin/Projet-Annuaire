<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Liste des groupes : </h1>
<table>
		<c:forEach items="${group}" var="grp">
			<tr>
				<td><a href="../personne/personsInGroup?id=${grp.idGroup}"> <c:out
							value="${grp.nameGroup}" /></a></td>
				<td><c:out value="${grp.nameGroup}" /></td>
				<td><i><c:out value="${grp.idGroup}" /></i></td>
			</tr>
		</c:forEach>
	</table>
	<p>
	</p>
	
	<a href="../personne/profil" >Mon profil </a>
	
</body>
</html>