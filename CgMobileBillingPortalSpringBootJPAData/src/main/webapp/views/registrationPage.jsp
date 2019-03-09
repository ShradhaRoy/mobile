<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
<style>
.error {
	color: red;
	font-weight: bold;
}
</style>
</head>
<body>
	<div align="center">
		<h2>Enter Customer Details</h2>
		<table>
			<form:form action="registerCustomer" method="post"
				modelAttribute="customer">
				<tr>
					<td>First Name</td>
					<td><form:input path="firstName" size="30" /></td>
					<td><form:errors path="firstName" cssClass="error" /></td>
				</tr>
				<tr>
					<td>LastName</td>
					<td><form:input path="lastName" size="30" /></td>
					<td><form:errors path="lastName" cssClass="error" /></td>
				</tr>
				<tr>
					<td>EmailId</td>
					<td><form:input path="emailID" size="30" /></td>
					<td><form:errors path="emailID" cssClass="error" /></td>
				</tr>
				<tr>
					<td>Date Of Birth</td>
					<td><form:input path="dateOfBirth" size="30" /></td>
					<td><form:errors path="dateOfBirth" cssClass="error" /></td>
				</tr>
				<tr>
					<td>City</td>
					<td><form:input path="address.city" size="30" /></td>
					<td><form:errors path="address.city" cssClass="error" /></td>
				</tr>
				<tr>
					<td>State</td>
					<td><form:input path="address.state" size="30" /></td>
					<td><form:errors path="address.state" cssClass="error" /></td>
				</tr>
				<tr>
					<td>PinCode</td>
					<td><form:input path="address.pinCode" size="30" /></td>
					<td><form:errors path="address.pinCode" cssClass="error" /></td>
				</tr>
				
				<tr>
					<td><input type="submit" value="Submit"></input></td>
				</tr>
			</form:form>
		</table>
	</div>
	<div align="center">
	<h2>Welcome</h2>
	<h2> CustomerId :- ${customer.customerID} </h2>
	</div>
</body>
</html>