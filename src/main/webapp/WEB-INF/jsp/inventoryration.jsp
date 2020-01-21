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
<style type="text/css">
div.container {
	margin: 4px, 4px;
	padding: 4px;
	height: 550px;
	overflow: scroll;
	text-align: justify;
}

.heading {
	display: flex;
}

.headingbtn {
	margin-top: 16px;
	margin-left: 580px;
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
				<h3 style="font-style:oblique;font-weight:bold;color:#00B1D2FF; font-size: 30px;">Inventory
					Ration Schedule's</h3>
			</div>
			<div class="headingbtn">
				<a href="/inventorycontroller/clearschedules">
					<button style="color: black;font-weight:bold;" class="btn btn-warning">Reset</button>
				</a>
			</div>
		</div>
		<h4 style="color: red;font-style:oblique; font-size: 22px;">${rationerror}</h4>
		<table class="table" style="margin-top: 15px;">
			<tr>
				<th style="font-size: 18px; color: #00B1D2FF;">Packet-Id</th>
				<th style="font-size: 18px; color: #00B1D2FF;">Packet-Type</th>
				<th style="font-size: 18px; color: #00B1D2FF;">Packet-Content</th>
				<th style="font-size: 18px; color: #00B1D2FF;">Calories</th>
				<th style="font-size: 18px; color: #00B1D2FF;">Expire-Date</th>
				<th style="font-size: 18px; color: #00B1D2FF;">Quantity-In-Litre</th>
			</tr>

			<c:forEach items="${inventoryList}" var="inventorydata">
				<tr>
					<th style="font-size: 18px; color: red;">Schedule-Date</th>
					<th style="font-size: 18px; color: green;">${inventorydata.date}</th>
					<c:forEach items="${inventorydata.rationList}" var="rationdata">
						<tr>
							<td>${rationdata.packetId}</td>
							<td>${rationdata.packetType}</td>
							<td>${rationdata.packetContent}</td>
							<td>${rationdata.calories}</td>
							<td>${rationdata.expiryDate}</td>
							<td>-</td>
						</tr>
					</c:forEach>
					<c:forEach items="${inventorydata.waterList}" var="waterdata">
						<tr>
							<td>${waterdata.packetId}</td>
							<td>${waterdata.packetType}</td>
							<td>-</td>
							<td>-</td>
							<td>-</td>
							<td>${waterdata.quantityInLitres}</td>
						</tr>
					</c:forEach>
				</tr>
			</c:forEach>
		</table>
		<h4 style="font-style:oblique;font-weight:bold;color:red;">
			Number of days you can survive with current inventory :
			<c:if test="${not empty listsize}">
				<span style="font-weight:bold; color: green;">${listsize} days</span>
			</c:if>
			<c:if test="${empty listsize}">
				<span style="font-weight:bold; color: green;">0 days</span>
			</c:if>

		</h4>
	</div>
</body>
</html>