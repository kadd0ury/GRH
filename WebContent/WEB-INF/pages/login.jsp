<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	  <link href="<c:url value="/resources/css/app.css" />"
          rel="stylesheet">
<title>Login</title>
</head>
<body class="security-app">
	<div class="details">
		<h2>GRH - Gestion des Ressouces Humaines</h2>
	</div>

	<form:form action="login" method="post" modelAttribute="login">

		<div class="lc-block">
			<div>
				<form:input type="text"  path="email" class="style-4" name="email"
					placeholder="Email" />
			</div>
			<div>
				<form:input type="password" path="password" class="style-4" name="password"
					placeholder="Password" />
			</div>
			<div>
				<input type="submit" value="Sign In" class="button red small" />
			</div>
		</div>
	</form:form>
	
	 <table align="center">
                <tr>
                    <td style="font-style: italic; color: red;">${message}</td>
                </tr>
            </table>
</body>
</html>