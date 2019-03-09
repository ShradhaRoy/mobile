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
		<form action="monthBill" method="post">
			<table>
				<tr>
					<td>CustomerId</td>
					<td><input type="text" name="customerID"></td>
				</tr>
				<tr>
					<td>Mobile Number</td>
					<td><input type="text" name="mobileNo"></td>
				</tr>
				<tr>
					<td>Bill Month</td>
					<td><input type="text" name="billMonth"></td>
				</tr>
				<tr>
					<td>Number of Local SMS</td>
					<td><input type="text" name="noOfLocalSMS"></td>
				</tr>
				<tr>
					<td>No of Std SMS</td>
					<td><input type="text" name="noOfStdSMS"></td>
				</tr>
				<tr>
					<td>no Of Std Calls</td>
					<td><input type="text" name="noOfStdCalls"></td>
				</tr>
				<tr>
					<td>no Of Local Calls</td>
					<td><input type="text" name="noOfLocalCalls"></td>
				</tr>
				<tr>
					<td>Internet Data Usage Units</td>
					<td><input type="text" name="internetDataUsageUnits"></td>
					</tr>
					<tr>
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
		<tr>
		
			<td>monthlyBill</td>
			</tr>
			
			<tr>
				<td>${bill }</td>
				
			</tr>
	</div>
</body>
</html>