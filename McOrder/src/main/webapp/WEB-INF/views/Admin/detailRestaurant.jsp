<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/detailMenu.css">
<script src="${pageContext.request.contextPath}/resources/js/detailMenu.js" type="text/javascript" charset="utf-8"></script>    


<!-- 모달 js css -->
<link href='http://fonts.googleapis.com/css?family=Lato:300,400,700' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/reset.css"> <!-- CSS reset -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"> <!-- Resource style -->
<script src="${pageContext.request.contextPath}/resources/js/modernizr.js"></script> <!-- Modernizr -->

<!-- 20171202_수진 추가 -->
<div id="content">
	<div class="container">
		<div class="row">
			<div class="col-sm-1" style="padding: 0; margin-top: 2%; margin-bottom: auto;">
				<hr style="border-top-width: 2px; background-color: #fff; width: 100%">
			</div>
			<div class="col-sm-3" style="text-align: center; margin-top: 2%;" >
				<span style="color:#fff; font-family: 'Hanna', serif; font-size: 25px;">매장 상세보기</span>
			</div>
			<div class="col-sm-8" style="padding: 0; margin-top: 2%; margin-bottom: auto;">
				<hr style="border-top-width: 2px; background-color: #fff; width: 100%">
			</div>
		</div>
		
	
	<div id="contentRight">
		<div class="row">
			<span style="color: #fff; font-size: 25px; font-family: 'Hanna', serif; margin-top: 10%; margin-bottom: auto;">매장번호&nbsp;&nbsp;</span>
			<input id="eventTitle" type="text" 
			style="width: 40%; font-size: 15px; font-family: 'Hanna', serif; 
			margin-top: 10%; margin-bottom: auto;" value="${restaurant.branchCode}" readonly="readonly">
		</div>

		<div class="row" style="margin-top: 20px;">
			<span style="color: #fff; font-size: 25px; font-family: 'Hanna', serif; margin-top: auto; margin-bottom: auto;">매장이름&nbsp;&nbsp;</span>
			<input id="eventContent" type="text" style="width: 40%; font-size: 15px; 
			font-family: 'Hanna', serif; margin-top: auto; 
			margin-bottom: auto;" value="${restaurant.branchName}" readonly="readonly">
		</div>
		<div class="row" style="margin-top: 20px;">
			<span style="color: #fff; font-size: 25px; font-family: 'Hanna', serif; margin-top: auto; margin-bottom: auto;">매장주소&nbsp;&nbsp;</span>
			<input id="eventContent" type="text" style="width: 40%; font-size: 15px; 
			font-family: 'Hanna', serif; margin-top: auto; 
			margin-bottom: auto;" value="${restaurant.branchAddress}" readonly="readonly">
		</div>

	
	</div>
	</div>
	
</div>
    