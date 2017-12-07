<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/registMenu.css">
<script src="${pageContext.request.contextPath}/resources/js/registMenu.js" type="text/javascript" charset="utf-8"></script>
<div id="content">
	<div class="container">
		<div class="row">
			<div class="col-sm-1" style="padding: 0; margin-top: auto; margin-bottom: auto;">
				<hr style="border-top-width: 2px; background-color: #fff; width: 100%">
			</div>
			<div class="col-sm-2" style="text-align: center;">
				<span style="color:#fff; font-family: 'Hanna', serif; font-size: 25px;">메뉴 등록</span>
			</div>
			<div class="col-sm-9" style="padding: 0; margin-top: auto; margin-bottom: auto;">
				<hr style="border-top-width: 2px; background-color: #fff; width: 100%">
			</div>
		</div>
	
	<form action="" method="post" enctype="multipart/form-data">
	<div id="contentLeft">
		<input type='file' name="file" style="margin-top:20px; color: #fff; font-size: 15px; font-family: 'Hanna', serif; margin-left: 30%;"/>
	<!-- 변경해줘야할거같은데 잘모르겠다 -->
		<img id="blah" src="<%=request.getContextPath()%>/${menu.menuImage}"  style="width:60%; margin-top: 20px; margin-left: 30%; text-align: center; margin-bottom: 2%;"/>
	</div>
	<div id="contentRight">
		<div class="row">
			<span style="color: #fff; font-size: 25px; font-family: 'Hanna', serif; margin-top: auto; margin-bottom: auto;">메뉴 이름&nbsp;&nbsp;</span>
			<input name="menuName" type="text" style="width: 40%; font-size: 15px; font-family: 'Hanna', serif; margin-top: auto; margin-bottom: auto;">
		</div>

		<div class="row" style="margin-top: 20px;">
			<span style="color: #fff; font-size: 25px; font-family: 'Hanna', serif; margin-top: auto; margin-bottom: auto;">메뉴 가격&nbsp;&nbsp;</span>
			<input name="price" type="text" style="width: 40%; font-size: 15px; font-family: 'Hanna', serif; margin-top: auto; margin-bottom: auto;">
		</div>
		
		<div class="row" style="margin-top: 15px;">
			<input name="menuType" type="radio" value="4" style="width: 30px; margin-top: auto; margin-bottom: auto;">
			<span style="color: #fff; font-size: 25px; font-family: 'Hanna', serif; margin-top: auto; margin-bottom: auto;">세트&nbsp;&nbsp;</span>
			<input name="menuType" type="radio" value="1" style="width: 30px; margin-top: auto; margin-bottom: auto;">
			<span style="color: #fff; font-size: 25px; font-family: 'Hanna', serif; margin-top: auto; margin-bottom: auto;">햄버거&nbsp;&nbsp;</span>
			<input name="menuType" type="radio" value="3" style="width: 30px; margin-top: auto; margin-bottom: auto;">
			<span style="color: #fff; font-size: 25px; font-family: 'Hanna', serif; margin-top: auto; margin-bottom: auto;">음료&nbsp;&nbsp;</span>
			<input name="menuType" type="radio" value="2" style="width: 30px; margin-top: auto; margin-bottom: auto;">
			<span style="color: #fff; font-size: 25px; font-family: 'Hanna', serif; margin-top: auto; margin-bottom: auto;">사이드&nbsp;&nbsp;</span>
		</div>
		<br>
		<br>
		<div class="row" style="margin-top: 20px;">
         <span style="color: #fff; font-size: 25px; font-family: 'Hanna', serif; margin-top: auto; margin-bottom: auto;">영양정보&nbsp;&nbsp;</span>
         <table style="width:100%">
            <thead>
               <tr>
                  <th style="text-align: center;width:25%">중량</th>
                  <th style="text-align: center;width:25%">열량</th>
                  <th style="text-align: center;width:25%">단백질</th>
                  <th style="text-align: center;width:25%">나트륨</th>
               </tr>
            </thead>
            <tbody >
                  <tr style="text-align: center;">
                     <td style="text-align: center;">
                        <input name="weight"  type="text" style="width: 50%; height: 70%; font-size: 15px; font-family: 'Hanna', serif; margin-top: auto; margin-bottom: auto; margin-top : 5px; margin-bottom : 5px;">
                     </td>
                     <td style="text-align: center;">
                        <input name="calorie" type="text" style="width: 50%; height: 70%; font-size: 15px; font-family: 'Hanna', serif; margin-top: auto; margin-bottom: auto; margin-top : 5px; margin-bottom : 5px;">
                     </td>
                     <td style="text-align: center;">
                        <input name="protein" type="text" style="width: 50%; height: 70%; font-size: 15px; font-family: 'Hanna', serif; margin-top: auto; margin-bottom: auto; margin-top : 5px; margin-bottom : 5px;">
                     </td>
                     <td style="text-align: center;">
                        <input name="natrium" type="text" style="width: 50%; height: 70%; font-size: 15px; font-family: 'Hanna', serif; margin-top: auto; margin-bottom: auto; margin-top : 5px; margin-bottom : 5px;">
                     </td>
                  </tr>
            </tbody>
         </table>
      </div>
      
		
		<div class="row" style="margin-top: 20px;">
		</div>
				
		<div class="row" style="margin-top: 20px;">
			<input id="saleperoid" type="checkbox" style="width: 30px; margin-top: auto; margin-bottom: auto;">
			<span style="color: #fff; font-size: 25px; font-family: 'Hanna', serif; margin-top: auto; margin-bottom: auto;">판매기간 설정&nbsp;&nbsp;</span>
		</div>
		
		<div class="row" style="padding-left: 25px;">
			<input class="startdate" type="date" name="startDate" style="width: 20%; height: 30px;" value="1999-01-01" >
			<span style="color: #fff; font-size: 25px; font-family: 'Hanna', serif; margin-top: auto; margin-bottom: auto;">&nbsp;~&nbsp;</span>
			<input class="enddate" type="date" name="endDate" style="width: 20%; height: 30px;" value="2999-01-01">
		</div>
		
		<div class="row">
			<div class="col-sm-12" style="margin-left: auto; margin-right: auto;">
				<button class="btn btn-warning" type="submit" style="width: 200px; margin-top: 30px;">
					<span style="color: #fff; font-size: 20px; font-family: 'Hanna', serif; margin-top: auto; margin-bottom: auto;">등록</span>
				</button>
				<button class="btn btn-warning" style="width: 200px; margin-top: 30px;">
					<span style="color: #fff; font-size: 20px; font-family: 'Hanna', serif; margin-top: auto; margin-bottom: auto;">취소</span>
				</button>
			</div>
		</div>	
		
	</div>
		</form>
	</div>

</div>