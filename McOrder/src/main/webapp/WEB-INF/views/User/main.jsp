<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/slick/slick.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/slick/slick-theme.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">
<script src="${pageContext.request.contextPath}/resources/slick/slick.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/resources/js/modernizr.custom.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/main.js"></script>
<div id="content">
	<div class="container">
		<center>
			<div class="slider col-sm-10" style="width: 280px; margin-top: 80px;">
	        	<c:forEach var="event" items="${eventList }">
		            <a class="no-uline" href="#">
		          		<img id="${event.eventNum }" class="event pad img-rounded" src="${event.eventImage1 }" style=" height:250px">
		            </a>
				</c:forEach>
	        </div>
		</center>
		<hr style="border-top-width: 5px;">
		
		<div class="row">
			<div class="col-xs-6">
				<img src="${pageContext.request.contextPath}/resources/images/맥딜.png" style="width:150px; height:130px;">				
			</div>
			<div class="col-xs-6">
				<img src="${pageContext.request.contextPath}/resources/images/주문확인1.png" style="width:150px; height:130px;">				
			</div>
		</div>
		<div class="row">
			<div class="col-xs-6" style="text-align: center;">
				<h3 style="color: #fff; margin-top:5px; font-family: 'Hanna', serif; ">맥딜리버리</h3>
			</div>
			<div class="col-xs-6" style="text-align: center;">
				<h3 style="color: #fff; margin-top:5px; font-family: 'Hanna', serif;">주문확인</h3>
			</div>
		</div>
	</div>
</div>

<!-- The Modal -->
<div id="myModal" class="modal">
  <span class="close">×</span>
  <img class="modal-content" id="img01">
  <div id="caption"></div>
</div>

