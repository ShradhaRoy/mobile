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
		<form action="postpaid" method="post">
			<table>
				<tr>
					<td>CustomerId</td>
					<td><input type="text" name="customerID"></td>
				</tr>
				<tr>
					<td>PlanId</td>
					<td><input type="text" name="planID"></td>
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
				<th>PlanId</th>
				<th>MobileNumber</th>
			</tr>
			<tr>
			<td>${account}</td>
			</tr>
		</table>
	</div>
</body>
</html>