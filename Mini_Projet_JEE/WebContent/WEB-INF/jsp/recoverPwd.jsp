<%@ include file="/WEB-INF/jsp/include.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<f:form method="POST" action="passWordRecover2" modelAttribute="currEmail">
		<table>
			<tr>
				<td>
					<p>Email :</p>
				</td>
				<td>
					<p>
						<f:input path="email" required="required"/>
					</p>
				</td>
				<td>
					<p>
						<f:errors path="email"></f:errors>
					</p>
				</td>
			<tr>
				<td></td>
				<td>
					<p>
						<f:hidden path="pwd" />
					</p>
				</td>
				<td>
					<p>
						<f:errors path="pwd"></f:errors>
					</p>
				</td>
			</tr>
			<tr>
				<td>
					<p class="submit">
						<input type="submit" onclick="recover()" >
					</p>
				</td>
			</tr>
		</table>
	</f:form>
<script>
function recover() {
    alert("Vous allez reçevoir un mail contient votre mot de passe !! ");
}
</script>
</body>
</html>