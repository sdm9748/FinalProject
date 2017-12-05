<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="${pageContext.request.contextPath}/resources/js/findID.js"></script> <!-- Modernizr -->
<div id="content">
	<div class="container" style="margin-top: 80px;">
		<div class="row">
			<div class="col-xs-12" style="text-align: center;">
				<span style="color:#fff; font-family: 'Hanna', serif; font-size: 40px;">아이디 찾기</span>
			</div>
			
		</div>	
		<div class="col-xs-12" style="margin-left: auto; margin-right: auto; height: 36px;">
			<span id="LNAME" style="color: #000; font-family: 'Hanna', serif; font-size: 25px; left: 40px; top: 35px; position: relative; z-index:3">
				NAME
			</span>
		</div>
		
		<div class="col-xs-12" style="margin-left: auto; margin-right: auto; z-index:2;">
			<div style="z-index: 1;">
				<center>
					<input type="text" id="name" name="name" style="width: 250px; padding-left: 10px; border-radius: 5px; font-size: 20px; border:none; outline: none;">
				</center>
			</div>
		</div>
		
		<div class="col-xs-12" style="margin-left: auto; margin-right: auto; height: 36px;">
			<span id="LPHONE" style="color: #000; font-family: 'Hanna', serif; font-size: 25px; left: 40px; top: 35px; position: relative; z-index:3">
				PHONE
			</span>
		</div>
		
		<div class="col-xs-12" style="margin-left: auto; margin-right: auto; z-index:2;">
			<div style="z-index: 1;">
				<center>
					<input type="text" id="phoneNum" name="phoneNum" style="width: 250px; padding-left: 10px; border-radius: 5px; font-size: 20px; border:none; outline: none;">
				</center>
			</div>
		</div>
		<div class="col-xs-12" style="margin-left: auto; margin-right: auto; z-index:2;">
			<div style="z-index: 1;">
				<center>
					<span style="color: #fff; font-family: 'Hanna', serif; font-size: 15px; margin-top: 2px;">
						(000-0000-0000 형태로 입력해주세요)
					</span>
				</center>
			</div>
		</div>
		
		<div class="col-xs-12" style="margin-top: 10px;">
			<hr style="border-top-width: 5px;">
			<center>
				<button id="submit" class="btn btn-warning" style="margin-top: 15px; margin-bottom: 30px; width: 200px; font-size: 20px; color: #fff; font-family: 'Hanna', serif;">아이디찾기</button>
			</center>
		</div>
			
	</div>	
	
	<div class="container">
		<div id="findDiv" style="padding: 10px; margin-bottom: 15px; text-align: center; margin-left: auto; margin-right: auto; padding: auto; color: #fff; border-radius: 5px;">
			<div class="row">
				<div id="find" class="col-xs-12" style="text-align: center; color: #000; font-family: 'Hanna', serif; font-size: 25px; margin-top: 2px;"></div>
			</div>
		</div>
	</div>
</div>