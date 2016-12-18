<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/include.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accueil</title>
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
	
	<div class="container">
		<div class="info">
			<h1>Annuaire Master Informatique</h1>
			<span>Aix-Marseille universit�</span>
		</div>
		<div class="form">
			<div class="thumbnail">
				<img
					src="https://s3-us-west-2.amazonaws.com/s.cdpn.io/169963/hat.svg" />
			</div>
			
			<a href="../user/grouplist/1">Afficher les groupes</a>
			<br><br>
			<a href="../personne/personlist/1">Afficher les personnes</a>
			<br><br>
			<a href="../personne/profil">Modifier le profil</a>	
			
		</div>
	</div>
	
	<!-- <a href="../user/grouplist/1">View Groups</a>   -->
</body>
</html>