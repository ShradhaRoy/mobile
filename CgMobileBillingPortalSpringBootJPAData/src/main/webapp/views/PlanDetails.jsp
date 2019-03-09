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
		<form action="PlanDetail" method="post">
			<table>
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
				<td>${plan}</td>
				
			</tr>
		</table>
	</div>
</body>
</html>