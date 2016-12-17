<%@ include file="/WEB-INF/jsp/include.jsp"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!-- Nouveau CSS -->
<spring:url value="/resources/style.css" var="styleCSS" />
<link href="${styleCSS}" rel="stylesheet" />

<spring:url value="/resources/table.css" var="tableCSS" />
<link href="${tableCSS}" rel="stylesheet" />

<spring:url
	value="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css"
	var="link1" />
<link rel="stylesheet" href="${link1}">

<spring:url
	value="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900"
	var="link2" />
<link rel="stylesheet prefetch" href="${link2}">

<spring:url
	value="http://fonts.googleapis.com/css?family=Montserrat:400,700"
	var="link3" />
<link rel="stylesheet prefetch" href="${link3}">

<spring:url
	value="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css"
	var="link4" />
<link rel="stylesheet prefetch" href="${link4}">
<!-- Fin nouveau CSS -->
</head>
<body>
	<!-- 	<table> -->
	<%-- 		<c:forEach items="${group}" var="grp"> --%>
	<!-- 			<tr> -->
	<%-- 				<td><a href="../personne/personsInGroup?id=${grp.idGroup}"> --%>
	<%-- 						<c:out value="${grp.nameGroup}" /> --%>
	<!-- 				</a></td> -->
	<%-- 				<td><c:out value="${grp.nameGroup}" /></td> --%>
	<%-- 				<td><i><c:out value="${grp.idGroup}" /></i></td> --%>
	<!-- 			</tr> -->
	<%-- 		</c:forEach> --%>

	<!-- 	</table> -->
	<!-- Nouveau FORM -->
	<div class="container">
		<div class="info">
			<h1>Annuaire Master Informatique</h1>
			<span>Aix-Marseille université</span>
		</div>
		
		<div class="form">
			<div class="thumbnail">
				<img
					src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/169963/hat.svg" />
			</div>
			<table>
				<tr>
					
					<th>Liste des groupes</th>
				</tr>
				<c:forEach var="grp" items="${list}">
					<tr>
						<td><a href="${contextPath}/actions/personne/personsInGroup?id=${grp.idGroup}"> 
 						<c:out value="${grp.nameGroup}" /> 	</a> </td>
					</tr>
				</c:forEach>
			</table>

			<c:forEach items="${nbrepage}" var="grps">
				<a href="../grouplist/${grps}"><c:out value="${grps}"></c:out></a>
			</c:forEach>
</div></div>
			<br /> <br> <br> 

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