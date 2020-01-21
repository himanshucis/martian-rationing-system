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
					<a
						style="font-weight: bold; font-size: 25px; font-style: oblique; color: #FEE715FF;"
						class="navbar-brand" href="/controller/home">Martian-Rationing
						System</a>
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
		<h1
			style="color: red; text-align: center; margin-top: 200px; font-weight: bold; font-style: oblique; font-size: 60px;">Martian
			- Rationing System</h1>
	</div>
</body>
</html>