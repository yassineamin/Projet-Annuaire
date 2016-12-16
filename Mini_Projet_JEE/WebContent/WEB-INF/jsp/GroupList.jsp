<%@ include file="/WEB-INF/jsp/include.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Liste des groupes :</h1>
	<table>
		<c:forEach items="${group}" var="grp">
			<tr>
				<td><a href="../personne/personsInGroup?id=${grp.idGroup}">
						<c:out value="${grp.nameGroup}" />
				</a></td>
				<td><c:out value="${grp.nameGroup}" /></td>
				<td><i><c:out value="${grp.idGroup}" /></i></td>
			</tr>
		</c:forEach>
	</table>
	<p></p>

	<a href="../personne/profil">Mon profil </a>

	<div>
		<f:form method="POST" action="../personne/rechercher"
			modelAttribute="recherche">
			<table>
				<tr>
					<td>
						<p>
							<f:input path="lastNamePerson" required="required" />
						</p>
					</td>
				<tr>
					<td>
						<p class="submit">
							<input type="submit" value="Rechercher">
						</p>
					</td>
				</tr>
			</table>
		</f:form>
	</div>
	<c:if test="${person != null}">
		<h1>Liste des personnes rechérchées :</h1>
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
	</c:if>
</body>
</html>