<%@ include file="/WEB-INF/jsp/include.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>S'enregistrer</title>

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


	<%-- 	<f:form method="POST" action="../personne/savePersonDb" --%>
	<%-- 		modelAttribute="savePersonDbA"> --%>
	<!-- 		<table> -->
	<!-- 			<tr> -->
	<!-- 				<td>Nom :</td> -->
	<%-- 				<td><f:input path="firstNamePerson" required="required" /></td> --%>
	<%-- 				<td><f:errors path="firstNamePerson"></f:errors></td> --%>
	<!-- 			</tr> -->
	<!-- 			<tr> -->
	<!-- 				<td>Prenom :</td> -->
	<%-- 				<td><f:input path="lastNamePerson"  required="required"/></td> --%>
	<%-- 				<td><f:errors path="lastNamePerson"></f:errors></td> --%>
	<!-- 			</tr> -->
	<!-- 			<tr> -->
	<!-- 				<td>Date de naissance :</td> -->
	<%-- 				<td><f:input pattern="[A-Za-z]{3}" path="birthayPerson" required="required" /></td> --%>
	<%-- 				<td><f:errors path="birthayPerson" cssClass="error" > Darouri </f:errors></td> --%>
	<!-- 			</tr> -->
	<!-- 			<tr> -->
	<!-- 				<td>Site web :</td> -->
	<%-- 				<td><f:input path="webSitePerson" /></td> --%>
	<%-- 				<td><f:errors path="webSitePerson"></f:errors></td> --%>
	<!-- 			</tr> -->
	<!-- 			<tr> -->
	<!-- 				<td>Email :</td> -->
	<%-- 				<td><f:input path="emailPerson" required="required"/></td> --%>
	<%-- 				<td><f:errors path="emailPerson"></f:errors></td> --%>
	<!-- 			</tr> -->
	<!-- 			<tr> -->
	<!-- 				<td>Mot de passe :</td> -->
	<%-- 				<td><f:input path="pswPerson" required="required"/></td> --%>
	<%-- 				<td><f:errors path="pswPerson"></f:errors></td> --%>
	<!-- 			</tr> -->
	<!-- 			<tr> -->
	<!-- 				<td>Groupe :</td> -->

	<%-- 				<td><f:select path="idGroupPerson" multiple="false"> --%>

	<%-- 						<f:options items="${listeIDGroup}" /> --%>
	<%-- 					</f:select></td> --%>
	<%-- 				<td><f:errors path="idGroupPerson" cssClass="error" /></td> --%>
	<!-- 			</tr> -->
	<!-- 			<tr> -->
	<!-- 				<td><input type="submit" value="S'enregistrer" onclick="ok()" ></td> -->
	<!-- 			</tr> -->



	<!-- 		</table> -->
	<%-- 	</f:form> --%>

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
			<f:form method="POST" action="../personne/savePersonDb"
				modelAttribute="savePersonDbA">


				<label>Nom</label>
				<f:input path="firstNamePerson" required="required" />
				<f:errors path="firstNamePerson"></f:errors>

				<label>Prenom</label>
				<f:input path="lastNamePerson" required="required" />
				<f:errors path="lastNamePerson"></f:errors>

				<label>Date de naissance</label>
				<f:input path="birthayPerson" required="required" />
				<f:errors path="birthayPerson" cssClass="error"></f:errors>

				<label>Site web</label>
				<f:input path="webSitePerson" />
				<f:errors path="webSitePerson"></f:errors>

				<label>Email</label>
				<f:input path="emailPerson" required="required" />
				<f:errors path="emailPerson"></f:errors>

				<label>Mot de passe</label>
				<f:password path="pswPerson" required="required" />
				<f:errors path="pswPerson"></f:errors>

				<label>Groupe</label>
				<f:select path="idGroupPerson" multiple="false">
					<f:options items="${listeIDGroup}" />
				</f:select>
				<f:errors path="idGroupPerson" cssClass="error" />
				<br>
				<br>
				<input type="submit" value="S'enregistrer" onclick="ok()">


			</f:form>
		</div>
	</div>
	<script>
		function ok() {
			alert("Inscription réussie");
		}
	</script>
</body>
</html>