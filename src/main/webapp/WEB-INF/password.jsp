<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Spring MVC password</title>
</head>

<body>
	<h2>Let's check on Spring MVC password!</h2>

	<form:form method="POST" commandName="password">
		<table>
			<tr>
				<td>Enter a password:</td>
				<td><form:password path="password"  showPassword="true"/></td>
				<td><form:errors path="password" cssStyle="color: #ff0000;"/></td>
			<tr>
				<td>Confirm your password:</td>
				<td><form:password path="passwordConf" showPassword="true"/></td>
				<td><form:errors path="passwordConf" cssStyle="color: #ff0000;"/></td>
			</tr>
			<tr>
				<td><input type="submit" name="submit" value="Submit"></td>
			</tr>
			<tr>
		</table>
	</form:form>

</body>
</html>