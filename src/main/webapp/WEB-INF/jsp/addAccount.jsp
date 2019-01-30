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
<title>Add New Account</title>
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
					<li style="color: red"><a href="AddAccount"
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
		<h2>Account Registration</h2>
		<h3>${message}</h3>
		<form action="OpenAccount">
			<div class="form-group">
				<label for="name">Account holder name:</label> <input type="text" class="form-control" name="accountHolderName">
			</div>
			<div class="form-group">
				<label for="name">Account Balance:</label> <input type="number"
					class="form-control" name="accountBal">
			</div>
			<div>
				<label for="name">Salary:</label> 
				<label class="form-check-label">
					<input class="form-check-input radio-inline" type="radio"
					name="rdSalary" id="gridRadios1" value="YES" checked> YES
				</label> 
				<label class="form-check-label"> <input
					class="form-check-input radio-inline" type="radio"
					name="rdSalary" id="gridRadios2" value="NO" > NO
				</label>
			</div>
			<div>
				<label for="name">Over Draft Limit:</label> 
				<input type="text" name="odLimit" value="N/A"/>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>

</body>
</html>