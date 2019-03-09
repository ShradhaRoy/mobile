<html>
<head>
<style>
.error {
	color: red;
	font-weight: bold
}
</style>
</head>
<body>
<div align="center">
		<form action="customerDetails" method="post">
			<table>
				<tr>
					<td>CustomerId</td>
					<td><input type="text" name="customerID"></td>
					<td><input type="submit" value="click"></td>
					<td><a href="Index">||Home||</a></td>
				</tr>
			</table>
		</form>
	</div>
	<div align="center" class="error">${errorMessge }</div>
	<br>
	<br>
	<div align="center">
		<table>
			<tr>
				<th>CustomerId</th>
				<th>FirstName</th>
				<th>LastName</th>
				<th>EmailId</th>
				<th>Date Of Birth</th>
			</tr>
			<tr>
				<td>${customer }</td>
				
			</tr>
		</table>
	</div>
</body>
</html>