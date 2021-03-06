<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" type="text/css"  href="${pageContext.request.contextPath}/resources/css/registMenu.css">

<script src="${pageContext.request.contextPath}/resources/js/registMenu.js" type="text/javascript" charset="utf-8"></script>


<!-- 모달 js css -->
<link href='http://fonts.googleapis.com/css?family=Lato:300,400,700' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/reset.css"> <!-- CSS reset -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"> <!-- Resource style -->
<script src="${pageContext.request.contextPath}/resources/js/modernizr.js"></script> <!-- Modernizr -->
<script type="text/javascript">

</script>
<!-- 20171202_수진 추가 -->

<div id="content">
	<div class="container">
		<div class="row">
			<div class="col-sm-1" style="padding: 0; margin-top: 2%; margin-bottom: auto;">
				<hr style="border-top-width: 2px; background-color: #fff; width: 100%">
			</div>
			<div class="col-sm-3" style="text-align: center; margin-top: 2%;" >
				<span style="color:#fff; font-family: 'Hanna', serif; font-size: 25px;">이벤트 수정하기</span>
			</div>
			<div class="col-sm-8" style="padding: 0; margin-top: 2%; margin-bottom: auto;">
				<hr style="border-top-width: 2px; background-color: #fff; width: 100%">
			</div>
		</div>
		
		<form action="editDetailEvent.htm" method="post" enctype="multipart/form-data">
			
			<div id="contentLeft">
				<div class="row">
					<input type='file' name='files[0]' id="imgInp" value="event.eventImage1" style="margin-top:20px; color: #fff; font-size: 15px; font-family: 'Hanna', serif; margin-left: 30%;"/>
		      		<img id="blah" src="<%=request.getContextPath()%>/${event.eventImage1}"  style="width:60%; margin-top: 20px; margin-left: 30%; text-align: center; margin-bottom: 2%;"/>
		      		<input type="hidden" name="eventImage1" value="${event.eventImage1 }">
		      	</div>
		      		<div class="row">
					<input type='file' name='files[1]' id="imgInp2" style="margin-top:20px; color: #fff; font-size: 15px; font-family: 'Hanna', serif; margin-left: 30%;"/>
		      		<img id="blah2" src="<%=request.getContextPath()%>/${event.eventImage2}"  style="width:60%; margin-top: 20px; margin-left: 30%; text-align: center; margin-bottom: 2%;"/>
		      		<input type="hidden" name="eventImage2" value="${event.eventImage2 }">
		      	</div>
			</div>
			
			<div id="contentRight">
			
				<div class="row">
					<span style="color: #fff; font-size: 25px; font-family: 'Hanna', serif; margin-top: 10%; margin-bottom: auto;">제목&nbsp;&nbsp;</span>
					<input id="eventTitle" name="eventTitle" type="text" 
					style="width: 40%; font-size: 15px; font-family: 'Hanna', serif; 
					margin-top: 10%; margin-bottom: auto;" value="${event.eventTitle}" />
				</div>
		
				<div class="row" style="margin-top: 20px;">
					<span style="color: #fff; font-size: 25px; font-family: 'Hanna', serif; margin-top: auto; margin-bottom: auto;">내용&nbsp;&nbsp;</span>
					<input id="eventContent"  name="eventContent" type="text" style="width: 40%; font-size: 15px; 
					font-family: 'Hanna', serif; margin-top: auto; 
					margin-bottom: auto;" value="${event.eventContent}" />
				</div>
				
				<div class="col-sm-12" style="margin-left: auto; margin-right: auto;">
				<input type="hidden"  id="eventNum"  name="eventNum"  value="${event.eventNum}" />
					<button class="btn btn-warning" type="submit"style="width: 200px; margin-top: 30px;">
						<span style="color: #fff; font-size: 20px; font-family: 'Hanna', serif; margin-top: auto; margin-bottom: auto;">수정</span>
					</button>					
					<a class="btn btn-warning" style="width: 200px; margin-top: 30px;" href="manageEvent.htm" >
						<span style="color: #fff; font-size: 20px; font-family: 'Hanna', serif; margin-top: auto; margin-bottom: auto;">취소</span>
					</a>
				</div>
				
				
				<%-- <p class="article-comment margin-small">
					<input type="hidden"  id="eventNum"  name="eventNum"  value="${event.eventNum}" />
					<input type="submit" value="수정" class="btn-save button" /> 
					<a class="btn-cancel button"  href="manageEvent.htm">취소</a>
				</p>
				 --%>
				
			</div>
		</form>
	</div>
</div>
