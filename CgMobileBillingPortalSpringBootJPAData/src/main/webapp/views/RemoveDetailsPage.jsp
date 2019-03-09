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
		<form action="remove" method="post">
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
				<td>${customer}</td>
				
			</tr>
		</table>
	</div>
</body>
</html>