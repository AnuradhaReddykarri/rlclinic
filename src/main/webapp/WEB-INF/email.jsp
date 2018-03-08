<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<title>Spring MVC textarea</title>
</head>

<body>
	<h2>Send your email!</h2>

	<form:form method="POST" commandName="email">
		<table>
			<tr>
				<td colspan="20">Enter the receiver's mail:</td>
				<td><form:input path="receiver" /></td>
			
				<td colspan="20"><form:errors path="receiver" cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr>
				<td colspan="20">Enter a subject:</td>
				<td><form:input path="subject" /></td>
			
				<td colspan="20"><form:errors path="subject" cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr>
				<td valign="top">Enter your message:</td>
				<td colspan="20"><form:textarea path="message" rows="20"/></td>
			
				<td valign="top"><form:errors path="message" cssStyle="color: #ff0000;" /></td>
			</tr>
			<tr>
				<td><input type="submit" name="submit" value="Submit"></td>
			</tr>
			<tr>
		</table>
	</form:form>

</body>
</html>