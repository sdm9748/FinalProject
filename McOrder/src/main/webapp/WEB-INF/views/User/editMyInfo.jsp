<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="se" uri="http://www.springframework.org/security/tags" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/mainMenu.css">
<script>
	$(function(){
		$('#submit').click(function(){
			$.ajax({
				url: "${pageContext.request.contextPath}/User/passwordCheck.htm",
				type: "POST",
				data: {"username": $('#username').val(), "password": $('#password').val()},
				dataType: "json",
				success: function(data){
					console.log(data);
					var member = data.member;
					if(member.id != null){
						console.log("멤버: " + member.birth);
						var birth = member.birth.split(" ");
						console.log(birth[0]);
						var Year = birth[0].split("-");
						$('#delete').remove();

						var str = "";
						
						str = '<form action="userEdit.htm" method="POST">'
						    + '<div class="col-xs-12" style="margin-left: auto; margin-right: auto; height: 36px;">'
						    + '<span id="LID" style="color: #fff; font-family: \'Hanna\', serif; font-size: 20px; left: 50px; top: 5px; position: relative; z-index:3">'
						    + 'ID'
						    + '</span>'
						    + '</div>'
					
						    + '<div class="col-xs-12" style="margin-left: auto; margin-right: auto; z-index:2;">'
						    + '<div style="z-index: 1;">'
						    + '<center>'
						    + '<input readonly value="' + member.id + '" type="text" id="id" name="id" style="width: 250px; padding-left: 10px; border-radius: 5px; font-size: 20px; border:none; outline: none;">'
						    + '</center>'
						    + '</div>'
						    + '</div>'
					
						    + '<div class="col-xs-12" style="margin-left: auto; margin-right: auto; height: 36px;">'
						    + '<span id="LPASSWORD" style="color: #fff; font-family: \'Hanna\', serif; font-size: 20px; left: 50px; top: 5px; position: relative; z-index:3">'
						    + 'PASSWORD'
						    + '</span>'
						    + '</div>'
					
						    + '<div class="col-xs-12" style="margin-left: auto; margin-right: auto; z-index:2;">'
						    + '<div style="z-index: 1;">'
						    + '<center>'
						    + '<input readonly value="' + member.password + '" type="password" id="password" name="password" style="width: 250px; padding-left: 10px; border-radius: 5px; font-size: 20px; border:none; outline: none;">'
						    + '</center>'
						    + '</div>'
						    + '</div>'
					
						    + '<div class="col-xs-12" style="margin-left: auto; margin-right: auto; height: 36px;">'
						    + '<span id="LNAME" style="color: #fff; font-family: \'Hanna\', serif; font-size: 20px; left: 50px; top: 5px; position: relative; z-index:3">'
						    + 'NAME'
						    + '</span>'
						    + '</div>'
						    + '<div class="col-xs-12" style="margin-left: auto; margin-right: auto; z-index:2;">'
						    + '<div style="z-index: 1;">'
						    + '<center>'
						    + '<input readonly value="' + member.name + '" type="text" id="name" name="name" style="width: 250px; padding-left: 10px; border-radius: 5px; font-size: 20px; border:none; outline: none;">'
						    + '</center>'
						    + '</div>'
						    + '</div>'
					
						    + '<div class="col-xs-12" style="margin-left: auto; margin-right: auto; height: 36px;">'
						    + '<span id="LBIRTH" style="color: #fff; font-family: \'Hanna\', serif; font-size: 20px; left: 50px; top: 5px; position: relative; z-index:3">'
						    + 'BIRTH'
						    + '</span>'
						    + '</div>'
					
						    + '<div class="col-xs-12" style="margin-left: auto; margin-right: auto; z-index:2;">'
						    + '<div style="z-index: 1;">'
						    + '<center>'
						    + '<input readonly value="' + Year[0] + '-' + Year[1]  + '-' + Year[2] + '" type="date" id="birth" name="birth" style="font-family: \'Hanna\', serif; width: 250px; padding-left: 10px; border-radius: 5px; font-size: 20px; border:none; outline: none;">'
						    + '</center>'
						    + '</div>'
						    + '</div>'
					
						    + '<div class="col-xs-12" style="margin-left: auto; margin-right: auto; height: 36px;">'
						    + '<span id="LEMAIL" style="color: #fff; font-family: \'Hanna\', serif; font-size: 20px; left: 50px; top: 5px; position: relative; z-index:3">'
						    + 'EMAIL'
						    + '</span>'
						    + '</div>'
					
						    + '<div class="col-xs-12" style="margin-left: auto; margin-right: auto; z-index:2;">'
						    + '<div style="z-index: 1;">'
						    + '<center>'
						    + '<input value="' + member.email + '" type="text" id="email" name="email" style="width: 250px; padding-left: 10px; border-radius: 5px; font-size: 20px; border:none; outline: none;">'
						    + '</center>'
						    + '</div>'
						    + '</div>'
					
						    + '<div class="col-xs-12" style="margin-left: auto; margin-right: auto; height: 36px;">'
						    + '<span id="LADDRESS" style="color: #fff; font-family: \'Hanna\', serif; font-size: 20px; left: 50px; top: 5px; position: relative; z-index:3">'
						    + 'ADDRESS'
						    + '</span>'
						    + '</div>'
					
						    + '<div class="col-xs-12" style="margin-left: auto; margin-right: auto; z-index:2;">'
						    + '<div style="z-index: 1;">'
						    + '<center>'
						    + '<input value="' + member.address + '" type="text" id="address" name="address" style="width: 250px; padding-left: 10px; border-radius: 5px; font-size: 20px; border:none; outline: none;">'
						    + '</center>'
						    + '</div>'
						    + '</div>'
					
						    + '<div class="col-xs-12" style="margin-left: auto; margin-right: auto; height: 36px;">'
						    + '<span id="LPHONE" style="color: #fff; font-family: \'Hanna\', serif; font-size: 20px; left: 50px; top: 5px; position: relative; z-index:3">'
						    + 'PHONE'
						    + '</span>'
						    + '</div>'
					
						    + '<div class="col-xs-12" style="margin-left: auto; margin-right: auto; z-index:2;">'
						    + '<div style="z-index: 1;">'
						    + '<center>'
						    + '<input value="' + member.phoneNum + '" type="text" id="phoneNum" name="phoneNum" style="width: 250px; padding-left: 10px; border-radius: 5px; font-size: 20px; border:none; outline: none;">'
						    + '</center>'
						    + '</div>'
						    + '</div>'
						    + '<div class="col-xs-12" style="margin-left: auto; margin-right: auto; z-index:2;">'
						    + '<div style="z-index: 1;">'
						    + '<center>'
						    + '<span style="color: #fff; font-family: \'Hanna\', serif; font-size: 15px; margin-top: 2px;">'
						    + '(000-0000-0000 형태로 입력해주세요)'
							+ '</span>'
							+ '</center>'
							+ '</div>'
							+ '</div>'
				
							+ '<div class="col-xs-12" style="margin-top: 10px;">'
							+ '<hr style="border-top-width: 5px;">'
							+ '<center>'
							+ '<input type="submit" class="btn btn-warning" value="수정" style="margin-top: 15px; margin-bottom: 20px; width: 200px; font-size: 20px; color: #fff; font-family: \'Hanna\', serif;">'
							+ '</center>'
							+ '</div>'
					
							+ '</form>';
						
							$('#append').append(str);
							
							$(function(){
								
								$('#id').focus(function(){
									$('#LID').animate({"top": "5px", "color": "#fff", "font-size": "20px"}, 200);
								})
								
								
								$('#id').blur(function(){
									if($("#id").val() == null || $("#id").val() == ""){
										$('#LID').animate({"top": "35px", "color": "#000", "font-size": "25px"}, 200);
									}
								})
								
								$('#LID').click(function(){
									$("#id").focus();
								})
								
								$('#password').focus(function(){
									$('#LPASSWORD').animate({"top": "5px", "color": "#fff", "font-size": "20px"}, 200);
								})
								
								$('#password').blur(function(){
									if($("#password").val() == null || $("#password").val() == ""){
										$('#LPASSWORD').animate({"top": "35px", "color": "#000", "font-size": "25px"}, 200);
									}
								})
								
								$('#LPASSWORD').click(function(){
									$("#password").focus();
								})
								
								$('#name').focus(function(){
									$('#LNAME').animate({"top": "5px", "color": "#fff", "font-size": "20px"}, 200);
								})
								
								$('#name').blur(function(){
									if($("#name").val() == null || $("#name").val() == ""){
										$('#LNAME').animate({"top": "35px", "color": "#000", "font-size": "25px"}, 200);
									}
								})
								
								$('#LNAME').click(function(){
									$("#name").focus();
								})
								
								$('#phoneNum').focus(function(){
									$('#LPHONE').animate({"top": "5px", "color": "#fff", "font-size": "20px"}, 200);
								})
								
								$('#phoneNum').blur(function(){
									if($("#phoneNum").val() == null || $("#phoneNum").val() == ""){
										$('#LPHONE').animate({"top": "35px", "color": "#000", "font-size": "25px"}, 200);
									}
								})
								
								$('#LPHONE').click(function(){
									$("#phoneNum").focus();
								})
								
								$('#address').focus(function(){
									$('#LADDRESS').animate({"top": "5px", "color": "#fff", "font-size": "20px"}, 200);
								})
								
								$('#address').blur(function(){
									if($("#address").val() == null || $("#address").val() == ""){
										$('#LADDRESS').animate({"top": "35px", "color": "#000", "font-size": "25px"}, 200);
									}
								})
								
								$('#LADDRESS').click(function(){
									$("#address").focus();
								})
								
								$('#email').focus(function(){
									$('#LEMAIL').animate({"top": "5px", "color": "#fff", "font-size": "20px"}, 200);
								})
								
								$('#email').blur(function(){
									if($("#email").val() == null || $("#email").val() == ""){
										$('#LEMAIL').animate({"top": "35px", "color": "#000", "font-size": "25px"}, 200);
									}
								})
								
								$('#LEMAIL').click(function(){
									$("#email").focus();
								})
								
							})
					} else {
						$('#show').html("비밀번호가 틀렸습니다.<br>다시 입력해주세요.");
					}
				}
			})
		})
	})
	
</script>
<div id="content">
	<div class="container" style="padding: 0;">
		<div id="myCarousel" class="carousel slide" data-ride="carousel" style="width: 360px; margin-top: 45px;">
			<!-- Wrapper for slides -->
			<div class="carousel-inner">
				<div class="item active">
					<img src="${pageContext.request.contextPath}/resources/images/이벤트1_1.jpg" alt="Los Angeles" style="width: 100%;">
				</div>

				<div class="item">
					<img src="${pageContext.request.contextPath}/resources/images/이벤트2_1.jpg" alt="Chicago" style="width: 100%;">
				</div>

				<div class="item">
					<img src="${pageContext.request.contextPath}/resources/images/이벤트3_1.jpg" alt="New york" style="width: 100%;">
				</div>
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

		<center>
			<span style="color: #fff; font-family: 'Hanna', serif; font-size: 40px;">내 정보 수정하기</span>
		</center>
	</div>
	
	<div id="append"></div>
	<div id="delete" class="container" style="padding: 0;">
		<div class="row">
			<div class="col-xs-12" style="padding: 0;">
				<div style="padding-top: 10px; text-align: center; border-radius:5px; width: 300px; height: 200px; background-color: #fff; margin-left: auto; margin-right: auto; margin-top: 30px;">
					<div id="show" style="color: #000; font-family: 'Hanna', serif; font-size: 20px; text-align: center;">정보 확인을 위해<br>비밀번호를 입력해주세요</div>
					<br>
					<input type="password" id="password" name="password" style="font-size: 20px; margin-top: 20px; width: 150px; border: none; outline: none; border-bottom: 1px solid black;">
					<se:authentication property="name" var="loginUser" />
					<input type="hidden" id="username" name="username" value="${loginUser}">
					<br>
					
					<button id="submit" class="btn btn-warning" style="margin-top: 15px; color: #fff; font-family: 'Hanna', serif; font-size: 15px; width: 70px; text-align: center;">입력완료</button>
				</div>
			</div>
		</div>
	</div>

</div>