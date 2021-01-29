<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
	<meta charset="UTF-8">
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
	<title>지하철 노선도</title>
</head>

<body>
	<div margin=50px; class="title">
		<h1>지하철 노선도 프로그램</h1>
		<hr>
	</div>
	
	<div margin=50px; class="metro-input">
		<form method="post" action="http://localhost:8080/metro_Result">
			<table class="table">
			<tbody>
				<tr>
					<th rowspan="2">
		  				<div class="input-group-text">출발역 | 도착역</div>
		  			</th>
		  			<th>
		  				<select class="form-select" name="startLine">
						    <option selected>출발 호선</option>
						    <option value="1">1호선</option>
						    <option value="2">2호선</option>
						    <option value="3">3호선</option>
						    <option value="4">4호선</option>
						    <option value="5">5호선</option>
						    <option value="6">6호선</option>
						    <option value="7">7호선</option>
						    <option value="8">8호선</option>
						</select>
					</th>
					<th>
		  				<input type="text" name="Start" class="form-control" placeholder="출발역(ex.서울/종로)">
		  			</th>
		  		<tr>
		  			<th>
		  				<select class="form-select" name="endLine">
						    <option selected>도착 호선</option>
						    <option value="1">1호선</option>
						    <option value="2">2호선</option>
						    <option value="3">3호선</option>
						    <option value="4">4호선</option>
						    <option value="5">5호선</option>
						    <option value="6">6호선</option>
						    <option value="7">7호선</option>
						    <option value="8">8호선</option>
						</select>
					</th>
		  			<th>
		  				<input type="text" name="End" class="form-control" placeholder="도착역(ex.노원/화랑대)">
					
					</th>
				</tr>
				<tr>
					<th>
		  				<span class="input-group-text">개발자|알고리즘</span>
		  			</th>
		  			<th colspan="2">
		  				<select class="form-select" name="dev">
						    <option selected>개발자/알고리즘</option>
						    <option value="Jisoon_Dijkstra">이지순/다익스트라</option>
						    <option value="Jisoon_Floyd">이지순/플로이드-워셜</option>
						    <option value="Jimin_Dijkstra">정지민/다익스트라</option>
						    <option value="Jimin_SPFA">정지민/SPFA</option>
						</select>						
		  			</th>
				</tr>
				<tr>
					<th colspan="3">
						<button type="submit" class="btn btn-primary">확인</button>
						<!-- <input type="submit" value="확인"> -->
					</th>
				</tr>
				

<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
	
	
</body>