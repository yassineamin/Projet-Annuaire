<%@ include file="/WEB-INF/jsp/include.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profil</title>
<!-- Nouveau CSS -->
<spring:url value="/resources/style.css" var="styleCSS" />
<link href="${styleCSS}" rel="stylesheet" />

<spring:url value="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css" var="link1"/>
<link rel="stylesheet" href="${link1}">

<spring:url value="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900" var="link2"/>
<link rel="stylesheet prefetch" href="${link2}">

<spring:url value="http://fonts.googleapis.com/css?family=Montserrat:400,700" var="link3"/>
<link rel="stylesheet prefetch" href="${link3}">

<spring:url value="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" var="link4"/>
<link rel="stylesheet prefetch" href="${link4}">
<!-- Fin nouveau CSS -->
</head>
<body>
	<!-- Nouveau FORM -->
	<div class="container">
		<div class="info">
			<h1>Annuaire Master Informatique</h1>
			<span>Aix-Marseille université</span>
		</div>
		<div class="header">
				<a href="../../user/login.php">Accueil</a>
		</div>
		<div class="form">
			<div class="thumbnail">
				<img
					src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/169963/hat.svg" />
			</div>
	<f:form method="POST" action="../personne/modifyPerson" modelAttribute="profilPersonne">
		<table>
					<tr>
				<td><f:hidden path="idPerson"  /></td>
				<td><f:errors path="idPerson"></f:errors></td>
			</tr>
			<tr>
				<td>Nom :</td>
				<td><f:input path="firstNamePerson"  /></td>
				<td><f:errors path="firstNamePerson"></f:errors></td>
			</tr>
			<tr>
				<td>Prenom :</td>
				<td><f:input path="lastNamePerson" /></td>
				<td><f:errors path="lastNamePerson"></f:errors></td>
			</tr>
			<tr>
				<td>Date de naissance :</td>
				<td><f:input path="birthayPerson" /></td>
				<td><f:errors path="birthayPerson"></f:errors></td>
			</tr>
			<tr>
				<td>Site web :</td>
				<td><f:input path="webSitePerson" /></td>
				<td><f:errors path="webSitePerson"></f:errors></td>
			</tr>
			<tr>
				<td>Email :</td>
				<td><f:input path="emailPerson" /></td>
				<td><f:errors path="emailPerson"></f:errors></td>
			</tr>
			<tr>
				<td>Mot de passe :</td>
				<td><f:input path="pswPerson" /></td>
				<td><f:errors path="pswPerson"></f:errors></td>
			</tr>
			<tr>
				<td>Groupe :</td>
				<td><f:input path="idGroupPerson" /></td>
				<td><f:errors path="idGroupPerson" cssClass="error" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Modifier" style="background-color: #EF3B3A"></td>
			</tr>



		</table>
	</f:form>
</div>
	</div>
</body>
</html>