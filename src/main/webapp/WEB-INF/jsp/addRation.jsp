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
		<h3
			style="font-style: oblique; font-weight: bold; color: #00B1D2FF; font-size: 30px;">Add
			Ration Detail's</h3>
		<h4 style="color: green; font-style: oblique; font-size: 25px;">${success}</h4>
		<h4 style="color: red; font-style: oblique; font-size: 25px;">${failed}</h4>
		<h4 style="color: red; font-style: oblique; font-size: 15px;">${dateError}</h4>
		<form action="/rationcontroller/saveration" method="post">
			<div class="form-group">
				<label for="packetid">Packet Id :</label> <input
					style="width: 350px;" type="text" class="form-control" id="pid"
					name="pid" required="required"
					placeholder="Enter Packet Id, For-Exa F1,F2....." />
			</div>
			<div class="form-group">
				<label for="packettype">Packet Type:</label> <input type="text"
					style="width: 350px;" class="form-control" id="ptype" name="ptype"
					required="required" placeholder="Enter Packet Type" value="Food"
					readonly="readonly">
			</div>
			<div class="form-group">
				<label for="packetcontent">Packet Content:</label> <input
					style="width: 350px;" type="text" class="form-control"
					id="pcontent" name="pcontent" required="required"
					placeholder="Enter Packet Content" />
			</div>
			<div class="form-group">
				<label for="expirydate">Expiry Date:</label> <input
					style="width: 350px;" type="date" class="form-control"
					id="expirydate" name="expirydate" required="required"
					placeholder="Enter Packet Expiry Date" />
			</div>
			<div class="form-group">
				<label for="calories">Calories:</label> <select name="calories"
					class="form-control" style="width: 350px;" required="required">
					<option selected value="">select Food Calories</option>
					<option value="500">500</option>
					<option value="1000">1000</option>
					<option value="1500">1500</option>
					<option value="2000">2000</option>
				</select>
			</div>
			<button type="submit" class="btn btn-info">Add-Ration</button>
		</form>
	</div>
</body>
</html>