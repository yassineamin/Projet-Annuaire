<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	save person

	<f:form method="POST" action="../personne/savePersonDb"
		modelAttribute="savePersonDbA">
		<table>
			<tr>
				<td>Nom :</td>
				<td><f:input path="firstNamePerson" /></td>
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
				<%-- 							<td><f:input path="idGroupPerson" /></td> --%>
				<%-- 							<td><f:errors path="idGroupPerson" cssClass="error" /></td> --%>

				<td><f:select path="idGroupPerson" multiple="false">
						
						<f:options items="${listeIDGroup}" />
					</f:select></td>
				<td><f:errors path="idGroupPerson" cssClass="error" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="S'enregistrer"></td>
			</tr>



		</table>
	</f:form>

</body>
</html>