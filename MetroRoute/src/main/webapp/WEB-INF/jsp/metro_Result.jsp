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
	
	<div margin=50px; class="result">
		<ul class="list-group">
			<li class="list-group-item">
				<button type="button" class="btn btn-success">출발역: ${start}</button>
				>>>
				<button type="button" class="btn btn-warning">도착역: ${end}</button>
			</li>
			<li class="list-group-item">선택한 개발자: ${dev} / 선택한 알고리즘: ${algorithms}</li>
  			<li class="list-group-item">경로: ${route}</li>
  			<li class="list-group-item">총 이동 거리: ${distance}m</li>
  			<li class="list-group-item">환승역: ${transfer}</li>
		</ul>

	</div>
	<a href="/" target="_self" >
		<input margin=50px; class="btn btn-primary" type="button" value="뒤로가기"></a>
				

<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
	
	
</body>