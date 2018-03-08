<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<title>Spring MVC hidden value</title>
</head>

<body>
	<form:form method="POST" commandName="hiddenMessage">
	<h2>Do you know what the hidden message is? </h2>
		<table>
			<tr>				
				<form:hidden path="message"/>
			</tr>
			<tr>
				<td><input type="submit" name="submit" value="Click here to see"></td>
			</tr>
			<tr>
		</table>
	</form:form>

</body>
</html>