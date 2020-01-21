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
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<style type="text/css">
div.container {
	margin: 4px, 4px;
	padding: 4px;
	height: 600px;
	overflow: scroll;
	text-align: justify;
}

.heading {
	display: flex;
}

.headingbtn {
	margin-top: 16px;
	margin-left: 610px;
}
</style>
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
		<div class="heading">
			<div class="headingtext">
				<h3 style="font-style:oblique;font-weight:bold;color:#00B1D2FF; font-size: 30px;">Inventory Ration
					Detail's</h3>
			</div>
			<div class="headingbtn">
				<a href="/inventorycontroller/inventoryschedule">
					<button style="font-weight:bold;color: black;" class="btn btn-warning">Creat-Schedule's</button>
				</a>
			</div>
		</div>
		<h4 style="color: red; font-style:oblique;font-size: 20px;">${failed}</h4>
		<h4 style="color: green;font-style:oblique; font-size: 20px;">${success}</h4>
		<table class="table" style="margin-top: 15px;">
			<tr>
				<th style="font-size: 18px; color: #00B1D2FF;">Packet-Id</th>
				<th style="font-size: 18px; color: #00B1D2FF;">Packet-Type</th>
				<th style="font-size: 18px; color: #00B1D2FF;">Packet-Content</th>
				<th style="font-size: 18px; color: #00B1D2FF;">Calories</th>
				<th style="font-size: 18px; color: #00B1D2FF;">Expire-Date</th>
				<th style="font-size: 18px; color: #00B1D2FF;">Quantity-In-Litre</th>
				<th style="font-size: 18px; color: green;">Update</th>
				<th style="font-size: 18px; color: red;">Delete</th>
			</tr>
			<c:forEach items="${rationlists}" var="ration">
				<tr>
					<td>${ration.packetId}</td>
					<td>${ration.packetType}</td>
					<td>${ration.packetContent}</td>
					<td>${ration.calories}</td>
					<td>${ration.expiryDate}</td>
					<td>-</td>
					<td><a
						href="/rationcontroller/updateration?rationid=${ration.id}"
						onclick="return confirm('Do you want to Edit Ration ?')"><i
							class="fa fa-edit" style="color: green; font-size: 36px"></i></a></td>
					<td><a
						href="/rationcontroller/deleteration?rationid=${ration.id}"
						onclick="return confirm('Do you want to Delete Ration ?')"><i
							class="fa fa-trash-o" style="color: red; font-size: 36px"></i></a></td>
				</tr>
			</c:forEach>
			<c:forEach items="${waterlists}" var="water">
				<tr>
					<td>${water.packetId}</td>
					<td>${water.packetType}</td>
					<td>-</td>
					<td>-</td>
					<td>-</td>
					<td>${water.quantityInLitres}</td>
					<td><a href="/watercontroller/updatewater?waterid=${water.id}"
						onclick="return confirm('Do you want to Edit Water ?')"><i
							class="fa fa-edit" style="color: green; font-size: 36px"></i></a></td>
					<td><a href="/watercontroller/deletewater?waterid=${water.id}"
						onclick="return confirm('Do you want to Delete Water ?')"><i
							class="fa fa-trash-o" style="color: red; font-size: 36px"></i></a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>