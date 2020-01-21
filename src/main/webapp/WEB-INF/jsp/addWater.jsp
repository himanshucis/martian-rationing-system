<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>Rationing System</title>
</head>
<body>
	<div>
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					<a style="font-weight: bold; font-size: 25px; font-style: oblique; color: #FEE715FF;"
						class="navbar-brand" href="/controller/home">Martian-Rationing System</a>
				</div>
				<ul class="nav navbar-nav">
					<!-- <li class="active"><a href="/controller/home">Home</a></li> -->
					<li><a href="/controller/addration">AddRation</a></li>
					<li><a href="/controller/addwater">AddWater</a></li>
					<li><a href="/rationcontroller/viewration">Inventory</a></li>
					<li><a href="/inventorycontroller/viewinventoryration">View-Schedule's</a></li>
				</ul>
			</div>
		</nav>
	</div>
	<div class="container">
		<h3 style="font-style:oblique;color:#00B1D2FF;font-weight:bold;font-size: 30px;">Add Water Detail's</h3>
		<h4 style="color: green; font-size: 25px;">${watersuccess}</h4>
		<h4 style="color: red; font-size: 25px;">${waterError}</h4>
		<form action="/watercontroller/savewater" method="post">
			<div class="form-group">
				<label for="packetid">Packet Id :</label> <input
					style="width: 350px;" type="text" class="form-control" id="pid"
					name="pid" required="required" placeholder="Enter Packet Id, For-Exa W1,W2....." />
			</div>
			<div class="form-group">
				<label for="packettype">Packet Type:</label> <input type="text"
					style="width: 350px;" class="form-control" id="ptype" name="ptype"
					required="required" placeholder="Enter Packet Type" value="Water"
					readonly="readonly">
			</div>
			<div class="form-group">
				<label for="quantity">Quantity :</label> <select name="quantity"
					class="form-control" style="width: 350px;" required="required">
					<option selected value="">select Quantity in Liter</option>
					<option value="1">1</option>
					<option value="2">2</option>
				</select>
			</div>
			<button type="submit" class="btn btn-info">Add-Water</button>
		</form>
	</div>
</body>
</html>