<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>	
<%@ taglib prefix="se" uri="http://www.springframework.org/security/tags" %>
<link href="${pageContext.request.contextPath}/resources/css/component.css" type="text/css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/resources/css/demo.css" type="text/css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/resources/css/normalize.css" type="text/css" rel="stylesheet" />

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">\
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css">
<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="Stylesheet" type="text/css" />
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/earlyaccess/hanna.css">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
<meta name="viewport" content="width=device-width, initial-scale=1.0"> 

<div id="header">
	<div class="container">
		<ul id="gn-menu" class="gn-menu-main">
			<li class="gn-trigger">
				<a class="gn-icon gn-icon-menu" style="padding-top: 35px;"><span>Menu</span></a>
				<nav class="gn-menu-wrapper">
					<div class="gn-scroller">
						<ul class="gn-menu">
							<li>
								<div class="row menuRow">
									<div class="col-xs-2" style="margin: auto; padding-left: 30px; padding-right: 0;">
										<img src="${pageContext.request.contextPath}/resources/images/맥로고.png" style="width: 100%;">
									</div>
									<div class="col-xs-10" style="padding-top: auto; padding-bottom: auto;">
										<a href="${pageContext.request.contextPath}/index.htm">메인화면</a>
									</div>
								</div>
							</li>
							<se:authorize access="!hasAnyRole('ROLE_ADMIN','ROLE_USER')">
								<li>
									<div class="row menuRow">
										<div class="col-xs-2" style="margin: auto; padding-left: 30px; padding-right: 0;">
											<img src="${pageContext.request.contextPath}/resources/images/회원가입.png" style="width: 100%;">
										</div>
										<div class="col-xs-10" style="padding-top: auto; padding-bottom: auto;">
											<a href="${pageContext.request.contextPath}/join.htm">회원가입</a>
										</div>
									</div>
								</li>
								<li>
									<div class="row menuRow">
										<div class="col-xs-2" style="margin: auto; padding-left: 30px; padding-right: 0;">
											<img src="${pageContext.request.contextPath}/resources/images/login.png" style="width: 100%;">
										</div>
										<div class="col-xs-10" style="padding-top: auto; padding-bottom: auto;">
											<a href="${pageContext.request.contextPath}/login.htm">로그인</a>
										</div>
									</div>
								</li>
							</se:authorize>
							<se:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_TOPADMIN')">
								<li>
									<div class="row menuRow">
										<div class="col-xs-2" style="margin: auto; padding-left: 30px; padding-right: 0;">
											<img src="${pageContext.request.contextPath}/resources/images/마이페이지.png" style="width: 100%;">
										</div>
										<div class="col-xs-10" style="padding-top: auto; padding-bottom: auto;">
											마이페이지
										</div>
									</div>
								</li>
								<li style="padding-left: 15px;">
									<div class="row menuRow">
										<div class="col-xs-2" style="margin: auto; padding-left: 30px; padding-right: 0;">
											<img src="${pageContext.request.contextPath}/resources/images/정보수정.png" style="width: 100%;">
										</div>
										<div class="col-xs-10" style="padding-top: auto; padding-bottom: auto;">
											<a href="${pageContext.request.contextPath}/User/editMyInfo.htm">내 정보 수정하기</a>
										</div>
									</div>
								</li>
								<li>
									<div class="row menuRow">
										<div class="col-xs-2" style="margin: auto; padding-left: 30px; padding-right: 0;">
											<img src="${pageContext.request.contextPath}/resources/images/logout.png" style="width: 100%;">
										</div>
										<div class="col-xs-10" style="padding-top: auto; padding-bottom: auto;">
											<a href="${pageContext.request.contextPath}/logout.htm">로그아웃</a>
										</div>
									</div>
								</li>
							</se:authorize>
							<li>
								<div class="row menuRow">
									<div class="col-xs-2" style="margin: auto; padding-left: 30px; padding-right: 0;">
										<img src="${pageContext.request.contextPath}/resources/images/장바구니.png" style="width: 100%;">
									</div>
									<div class="col-xs-10" style="padding-top: auto; padding-bottom: auto;">
										<a href="${pageContext.request.contextPath}/User/shoppingCart.htm">장바구니</a>
									</div>
								</div>
							</li>
							<li class="menuR">
								<div class="row">
									<div class="col-xs-2" style="margin: auto; padding-left: 30px; padding-right: 0;">
										<img src="${pageContext.request.contextPath}/resources/images/지도.png" style="width: 100%;">
									</div>
									<div class="col-xs-10" style="padding-top: auto; padding-bottom: auto;">
										<a href="${pageContext.request.contextPath}/User/map.htm">지도</a>
									</div>
								</div>
							</li>
							<li><a href="${pageContext.request.contextPath}/User/mainmenu.htm" class="gn-icon gn-icon-illustrator">매장QR코드 찍었을때</a></li>
							<li><a href="${pageContext.request.contextPath}/User/selectMenu.htm" class="gn-icon gn-icon-photoshop">메뉴 선택시</a></li>
							<li><a href="${pageContext.request.contextPath}/User/menuDetail.htm" class="gn-icon gn-icon-photoshop">메뉴 디테일</a></li>
						</ul>
					</div><!-- /gn-scroller -->
				</nav>
			</li>
			<center>
				<img class="macimg" src="${pageContext.request.contextPath}/resources/images/맥도날드.png" style="margin-top: 8px; width:15%; ">
			</center>
		</ul>
		
	</div><!-- /container -->
	
	<script src="${pageContext.request.contextPath}/resources/js/classie.js"></script>
	<script src="${pageContext.request.contextPath}/resources/js/gnmenu.js"></script>
	<script>
		new gnMenu( document.getElementById( 'gn-menu' ) );
	</script>
</div>