<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/manageEvent.css">
<script src="http://code.jquery.com/jquery-3.2.0.js"></script>
   <script type="text/javascript" src="http://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/dataTables.css">
<script>
$(function(){
    $('#dataList').DataTable({
             "paging": true ,
             "lengthChange": true,
             "searching": true,
             "ordering": true,
             "info": false,
             "autoWidth": false,
             "oLanguage": {
                 "sSearch": "<span>검색</span> _INPUT_", //search
                 "sLengthMenu" : " _MENU_<span> 개씩 보기</span>",
               },
               "oPaginate": {
                   "sFirst":    "처음",
                   "sLast":     "마지막",
                   "sNext":     "다음",
                   "sPrevious": "이전"
               }

           });
  });
</script>
<div id="content">
	<div class="container">
		<div class="row">
			<div class="col-sm-1" style="padding: 0; margin-top: auto; margin-bottom: auto;">
				<hr style="border-top-width: 2px; background-color: #fff; width: 100%">
			</div>
			<div class="col-sm-2" style="text-align: center;">
				<span style="color:#fff; font-family: 'Hanna', serif; font-size: 25px;">이벤트 관리</span>
			</div>
			<div class="col-sm-9" style="padding: 0; margin-top: auto; margin-bottom: auto;">
				<hr style="border-top-width: 2px; background-color: #fff; width: 100%">
			</div>
		</div>
	
	<!-- 수진 추가_20171202 -->
		<p class="article-comment margin-small">
			<a class="btn btn-warning" href="regEvent.htm"  style="width: 200px; margin-top: 30px;"> 
			<span 	style="color: #fff; font-size: 20px; font-family: 'Hanna', serif; margin-top: auto; margin-bottom: auto;">이벤트 등록하기</span>
			</a>
		</p>
		
	
		<table id="dataList">
		<thead>
			<tr>
				<th class="eventNum" style="text-align: center;">번호</th>
				<th class="eventTitle" style="text-align: center;">제목</th>				
				<th class="content" style="text-align: center;">내용</th>
			
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="n">
				<tr style="text-align: center;">
					<td class="eventNum" style="text-align: center;">${n.eventNum}</td>
					<td class="eventTitle" style="text-align: center;"><a href="showEventDetailAdmin.htm?eventNum=${n.eventNum}">${n.eventTitle}</a></td>
					<td class="content" style="text-align: center;">${n.eventContent}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>	
	
</div>
</div>