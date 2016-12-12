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
<style>
	@import '../../shared/mixins',
        '../../shared/reset',
        '../../shared/about-light';
body {
  font: 13px/20px 'Lucida Grande', Tahoma, Verdana, sans-serif;
  color: #404040;
  background: #0ca3d2;
}

.container {
  margin: 80px auto;
  width: 640px;
}

.login {
  position: relative;
  margin: 0 auto;
  padding: 20px 20px 20px;
  width: 310px;
  background: white;
  border-radius: 3px;
  @include box-shadow(0 0 200px rgba(white, .5), 0 1px 2px rgba(black, .3));

  &:before {
    content: '';
    position: absolute;
    top: -8px; right: -8px; bottom: -8px; left: -8px;
    z-index: -1;
    background: rgba(black, .08);
    border-radius: 4px;
  }

  h1 {
    margin: -20px -20px 21px;
    line-height: 40px;
    font-size: 15px;
    font-weight: bold;
    color: #555;
    text-align: center;
    text-shadow: 0 1px white;
    background: #f3f3f3;
    border-bottom: 1px solid #cfcfcf;
    border-radius: 3px 3px 0 0;
    @include linear-gradient(top, whiteffd, #eef2f5);
    @include box-shadow(0 1px #f5f5f5);
  }

  p { margin: 20px 0 0; }
  p:first-child { margin-top: 0; }
</style>
</head>
<body>
	<div class="container">
		<div class="login">
			<h1>Authentification</h1>

			<f:form method="POST" action="login.php" modelAttribute="loginuser">
				<table>
					<tr>
						<td> <p> Email : </p> </td>
						<td>
							<p>
								<f:input path="emailPerson"/>
							</p>
						</td>
						<td>
							<p>
								<f:errors path="emailPerson"></f:errors>
							</p>
						</td>
					</tr>
					<tr>
						<td> <p> Mot de passe : </p> </td>
						<td> <p> <f:input path="pswPerson" /> </p> </td>
						<td> <p> <f:errors path="pswPerson"></f:errors> </p> </td>
					</tr>
					<tr>
						<td> <p class="submit"> <input type="submit"> </p> </td>
					</tr>
				</table>
			</f:form>
		</div>
		</div>
</body>
</html>