<%@ include file="/WEB-INF/jsp/include.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Annuaire</title>

<!-- Nouveau CSS -->
<spring:url value="/resources/style.css" var="styleCSS" />
<link href="${styleCSS}" rel="stylesheet" />

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
			<f:form class="login-form" method="POST" action="login.php"
				modelAttribute="loginuser">
				<label>Email</label>
				<f:input path="emailPerson" required="required" />
				<f:errors path="emailPerson"></f:errors>
				<label>Mot de passe</label>
				<f:password path="pswPerson" />
				<f:errors path="pswPerson"></f:errors>
				<input type="submit" value="Se connecter"
					style="background-color: #EF3B3A">
				<p class="message">
					<a href="../personne/passWordRecover">Mot de passe oublié ?</a>
				</p>
				<p class="message">
					Non enregistré ? <a href="../personne/savePerson">Créer un
						compte</a>
				</p>
			</f:form>
		</div>
	</div>

</body>
</html>