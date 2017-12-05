<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="se" uri="http://www.springframework.org/security/tags" %>
<script>

	function deleteAdmin(seq) {
		var data = {branchCode : seq};
		var _data = JSON.stringify(data);
		console.log(_data);
		
		 $.ajax({
	          type: "POST",
	          url:  "deleteAdmin.htm",
	          data: _data,
	          contentType : "application/json; charset=UTF-8",
	          dataType: "json",
	          success:function(data){ 
	        	  
	               console.log("도착 데이터!!!!"+data);
	               $('#adminListBody').empty();
		           $.each(data.orderList, function(index,obj){
		               var opr="";
		               opr += "<tr style='text-align: center;'><td>"+obj.branchCode+"</td><td>"+obj.id+"</td>";
		               opr += "<td style='text-align: center;'>";
		               opr += "<button id='orderButton' class='btn btn-warning' onclick='deleteAdmin("
		            		   +obj.branchCode+")'>삭제</button></td>";
		               opr += "</td>";
		               $('#orderListBody').append(opr);
		               
		           });
	            }
	       }); 
	}

</script>
<div id="content">
	<div class="container">
		<div class="row">
			<div class="col-sm-1" style="padding: 0; margin-top: auto; margin-bottom: auto;">
				<hr style="border-top-width: 2px; background-color: #fff; width: 100%">
			</div>
			<div class="col-sm-2" style="text-align: center;">
				<span style="color:#fff; font-family: 'Hanna', serif; font-size: 25px;">관리자 관리</span>
			</div>
			<div class="col-sm-9" style="padding: 0; margin-top: auto; margin-bottom: auto;">
				<hr style="border-top-width: 2px; background-color: #fff; width: 100%">
			</div>
		</div>
	</div>
	<se:authorize access="hasRole('ROLE_TOPADMIN')">
	<a class="btn btn-warning" style="width: 200px; margin-top: 30px;" href="${pageContext.request.contextPath}/Admin/addAdmin.htm">
		<span style="color: #fff; font-size: 20px; font-family: 'Hanna', serif; margin-top: auto; margin-bottom: auto;">관리자등록</span>
	</a>
	</se:authorize> 
		<table>
		<thead>
			<tr>
				<th style="text-align: center;">매장 번호</th>
				<th style="text-align: center;">관리자 이름</th>
				<th style="text-align: center;">&nbsp;</th>
			</tr>
		</thead>
		<tbody id="adminListBody">
		
		<c:forEach items="${adminList}" var="admin">
			<tr style="text-align: center;">
				<td>${admin.branchCode}</td>
				<td>${admin.name }</td>
				<td>
				<button id="orderButton" onclick="deleteAdmin(${admin.branchCode})" class="btn btn-warning">삭제</button>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>