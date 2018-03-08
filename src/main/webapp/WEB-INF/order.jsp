<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<title>Spring MVC radiobutton</title>
</head>

<body>
	<h2>Order your ice cream! </h2>

	<form:form method="POST" commandName="order">
		<table>
			<tr>
				<td>Do you want the big size?</td>
				<td><form:radiobutton path="size" value="big"/> Yes
				 <form:radiobutton path="size" value="small"/> No </td>
			</tr>
			<tr>
				<td>Choose the flavor you like:</td>
				<td><form:radiobuttons path="flavors" items="${flavors}" /></td> 
			</tr>
			<tr>
				<td><form:errors path="flavors" cssStyle="color: #ff0000;"/></td>
			</tr>
			<tr>
				<td><input type="submit" name="submit" value="Submit"></td>
			</tr>
			<tr>
		</table>
	</form:form>

</body>
</html>