<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Form Withdraw</title>
<link rel="stylesheet"
	href="C:\HTML_Assingments\Banking_application\footer.css">
</head>
<body>
	<header>
		<nav class="navbar navbar-inverse"
			style="background-color: orange; border-block-end-color: red">
			<div class="container-fluid">
				<div class="navbar-header">
					<h1 style="color: red">
						<i>Money Money Bank</i>
					</h1>
				</div>
				<ul class="nav navbar-nav" style="float: right;">
					<li style="color: red"><a href="AddNewAccount"
						style="color: red">Create New Account</a></li>
					<li><a href="Account" style="color: red">Update Account</a></li>
					<li><a href="closeaccount" style="color: red">Close
							Account</a></li>
					<li><a href="searchaccount" style="color: red">Search
							Account</a></li>
					<li><a href="withdraw" style="color: red">Withdraw</a></li>
					<li><a href="deposit" style="color: red">Deposit</a></li>
					<li><a href="transferfund" style="color: red">Fund
							Transfer</a></li>
					<li><a href="getcurrentbalance" style="color: red">Check
							Current Balance</a></li>
					<li><a href="getAllTheAccounts" style="color: red">Get All
							The Accounts</a></li>
					<li><a href="getAllThestatements?offset=1&size=5"
						style="color: red">Mini-Statement</a></li>
				</ul>
			</div>
		</nav>
	</header>
	<div class="container">
		<h2>Deposit Details</h2>
		<h1>${message}</h1>
		<form action="depositForm">
			<div class="form-group">
				<label for="acc_no">Account Number:</label> <input type="number"
					class="form-control" id="acc_no" name="accountNumber">
			</div>
			<div class="form-group">
				<label for="amount_withdraw">Amount to deposit:</label> <input
					type="number" class="form-control" id="withdraw_amount"
					name="amount">
			</div>
			<button type="submit" class="btn btn-primary" onclick="boolean">Deposit</button>
		</form>
	</div>
	<div class="footer">
		<p style="color: red; text-align: center">copyright@2018. ICICI
			pvt ltd.</p>
	</div>
</body>
</html>