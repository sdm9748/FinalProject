<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=7a58ecdfababe232ec16390a59fad150"></script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/map.css">
<script src="${pageContext.request.contextPath}/resources/js/map.js" type="text/javascript" charset="utf-8"></script>
<div id="content">
	<div id="myCarousel" class="carousel slide" data-ride="carousel" style="margin-top: 45px;">
    	<!-- Wrapper for slides -->
    	<div class="carousel-inner">
      		<c:forEach var="event" items="${eventList }" varStatus="index">
      			<c:if test="${index.index == 0 }">
	    			<div class="item active">
		        		<img class="event" src="${event.eventImage2 }"  style="width:100%;">
		        		<input type="hidden" id="${event.eventImage2 }" value="${event.eventImage1 }">
		      		</div>
      			</c:if>
      			<c:if test="${index.index != 0 }">
	    			<div class="item">
		        		<img class="event" src="${event.eventImage2 }" style="width:100%;">
		        		<input type="hidden" id="${event.eventImage2 }" value="${event.eventImage1 }">
		      		</div>
      			</c:if>
			</c:forEach>
    	</div>

    	<!-- Left and right controls -->
    	<a class="left carousel-control" href="#myCarousel" data-slide="prev">
      		<span class="glyphicon glyphicon-chevron-left"></span>
      		<span class="sr-only">Previous</span>
    	</a>
    	<a class="right carousel-control" href="#myCarousel" data-slide="next">
      		<span class="glyphicon glyphicon-chevron-right"></span>
      		<span class="sr-only">Next</span>
    	</a>
  	</div>
  	
  	<div class="row" style="margin-top: 20px; width: 360px; margin-right: 0; margin-left: 0;">
  		<div class="col-xs-6" style="text-align: right;">
		  	<button type="button" class="btn btn-warning btn-lg" style="width:120px; color: #fff; font-family: 'Hanna', serif;">근처 매장</button>
  		</div>
  		<div class="col-xs-6" style="text-align: left;">
		  	<button type="button" class="btn btn-warning btn-lg" style="width:120px; color: #fff; font-family: 'Hanna', serif;">지역별 매장</button>
  		</div>
  	</div>

	<!-- 맵 API -->
	<center>
		<div id="map" style="margin-top: 20px; width:100%; height:300px;"></div>
	</center>
	
	<div class="container">
		<hr style="border-top-width: 2px; background-color: #fff; ">
	</div>
			
	<table>
		<thead>
			<tr>
				<th colspan="3">Atividades do projeto</th>
			</tr>
			<tr>
				<th>#</th>
				<th colspan="2">Atividade</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>1</td>
				<td>Atualizar página da equipe</td>
				<td>
					<i class="material-icons button edit">edit</i>
					<i class="material-icons button delete">delete</i>
				</td>
			</tr>
			<tr>
				<td>2</td>
				<td>Design da nova marca</td>
				<td>
					<i class="material-icons button edit">edit</i>
					<i class="material-icons button delete">delete</i>
				</td>
			</tr>
			<tr>
				<td>3</td>
				<td>Encontrar desenvolvedor front-end</td>
				<td>
					<i class="material-icons button edit">edit</i>
					<i class="material-icons button delete">delete</i>
				</td>
			</tr>
		</tbody>
	</table>
</div>

<!-- The Modal -->
<div id="myModal" class="modal">
  <span class="close">×</span>
  <img class="modal-content" id="img01">
  <div id="caption"></div>
</div>