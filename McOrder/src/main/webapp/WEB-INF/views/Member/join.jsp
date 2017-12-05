<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/join.css"> <!-- Resource style -->
<script src="${pageContext.request.contextPath}/resources/js/join.js"></script> <!-- Modernizr -->
<div class="container" style="margin-top: 80px;">
	<div class="row">
		<div class="col-xs-12" style="text-align: center;">
			<span style="color:#fff; font-family: 'Hanna', serif; font-size: 40px;">회원가입</span>
		</div>
		
	</div>
	<div id="callBackDiv">
		<form action="" method="POST">
			<div class="col-xs-12" style="margin-left: auto; margin-right: auto; height: 36px;">
				<span id="LID" style="color: #000; font-family: 'Hanna', serif; font-size: 25px; left: 40px; top: 35px; position: relative; z-index:3">
					ID
				</span>
			</div>
			
			<div class="col-xs-12" style="margin-left: auto; margin-right: auto; z-index:2;">
				<div style="z-index: 1;">
					<center>
						<input type="text" id="id" name="id" style="width: 250px; padding-left: 10px; border-radius: 5px; font-size: 20px; border:none; outline: none;">
					</center>
				</div>
			</div>
			
			<div class="col-xs-4" style="padding: 0; padding-left: 25px;">
				<center>
					<button type="button" id="dupl" class="btn btn-success" style="margin-left: 10px; margin-top: 10px; font-size: 15px; color: #fff; font-family: 'Hanna', serif;">중복여부</button>
				</center>
			</div>
			<div id="duplcheck" class="col-xs-8" style="margin-top: 11px; padding-left: 0; padding-right: 20px; text-align: center; font-size: 20px; color: #fff; font-family: 'Hanna', serif;">
			</div>
			
			<div class="col-xs-12" style="margin-left: auto; margin-right: auto; height: 36px;">
				<span id="LPASSWORD" style="color: #000; font-family: 'Hanna', serif; font-size: 25px; left: 40px; top: 35px; position: relative; z-index:3">
					PASSWORD
				</span>
			</div>
			
			<div class="col-xs-12" style="margin-left: auto; margin-right: auto; z-index:2;">
				<div style="z-index: 1;">
					<center>
						<input type="password" id="password" name="password" style="width: 250px; padding-left: 10px; border-radius: 5px; font-size: 20px; border:none; outline: none;">
					</center>
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
				<span id="LBIRTH" style="color: #000; font-family: 'Hanna', serif; font-size: 25px; left: 40px; top: 35px; position: relative; z-index:3">
					BIRTH
				</span>
			</div>
			
			<div class="col-xs-12" style="margin-left: auto; margin-right: auto; z-index:2;">
				<div style="z-index: 1;">
					<center>
						<input type="date" id="birth" name="birth" style="font-family: 'Hanna', serif; width: 250px; padding-left: 10px; border-radius: 5px; font-size: 20px; border:none; outline: none;">
					</center>
				</div>
			</div>
			
			<div class="col-xs-12" style="margin-left: auto; margin-right: auto; height: 36px;">
				<span id="LEMAIL" style="color: #000; font-family: 'Hanna', serif; font-size: 25px; left: 40px; top: 35px; position: relative; z-index:3">
					EMAIL
				</span>
			</div>
			
			<div class="col-xs-12" style="margin-left: auto; margin-right: auto; z-index:2;">
				<div style="z-index: 1;">
					<center>
						<input type="text" id="email" name="email" style="width: 250px; padding-left: 10px; border-radius: 5px; font-size: 20px; border:none; outline: none;">
					</center>
				</div>
			</div>
			
			<div class="col-xs-12" style="margin-left: auto; margin-right: auto; height: 36px; margin-top: 20px;">
				<center>
					<input type="text" id="sample2_postcode" style="margin-right: 25px; width: 130px; padding-left: 15px; border-radius: 5px; font-size: 20px; border:none; outline: none;" placeholder="우편번호">
					<input type="button" class="btn btn-success" onclick="sample2_execDaumPostcode()" value="우편번호 찾기" style="margin-bottom: 10px; font-size: 15px; color: #fff; font-family: 'Hanna', serif;"><br>
				</center>
			</div>
			
			<div class="col-xs-12" style="margin-left: auto; margin-right: auto; height: 36px; margin-top: 1px;">
				<center>
					<input type="text" id="sample2_address" placeholder="주소" style="padding-left: 15px; width: 251px; border-radius: 5px; font-size: 20px; border:none; outline: none;">
					<input type="text" id="address2" placeholder="상세주소" style="padding-left: 15px; width: 251px; border-radius: 5px; font-size: 20px; border:none; outline: none; margin-top: 3px;">
				</center>
			</div>
			
			<div class="col-xs-12" style="margin-top: 35px; margin-left: auto; margin-right: auto; height: 36px;">
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
					<input id="sub" type="submit" class="btn btn-warning" value="회원가입" style="margin-top: 15px; margin-bottom: 20px; width: 200px; font-size: 20px; color: #fff; font-family: 'Hanna', serif;">
				</center>
			</div>
			
			<!-- iOS에서는 position:fixed 버그가 있음, 적용하는 사이트에 맞게 position:absolute 등을 이용하여 top,left값 조정 필요 -->
			<div id="layer" style="display:none;position:fixed;overflow:hidden;z-index:5;-webkit-overflow-scrolling:touch;">
			<img src="//t1.daumcdn.net/localimg/localimages/07/postcode/320/close.png" id="btnCloseLayer" style="cursor:pointer;position:absolute;right:-3px;top:-3px;z-index:1" onclick="closeDaumPostcode()" alt="닫기 버튼">
			</div>
			
			<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
			<script>
			    // 우편번호 찾기 화면을 넣을 element
			    var element_layer = document.getElementById('layer');
			
			    function closeDaumPostcode() {
			        // iframe을 넣은 element를 안보이게 한다.
			        element_layer.style.display = 'none';
			    }
			
			    function sample2_execDaumPostcode() {
			        new daum.Postcode({
			            oncomplete: function(data) {
			                // 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
			
			                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
			                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
			                var fullAddr = data.address; // 최종 주소 변수
			                var extraAddr = ''; // 조합형 주소 변수
			
			                // 기본 주소가 도로명 타입일때 조합한다.
			                if(data.addressType === 'R'){
			                    //법정동명이 있을 경우 추가한다.
			                    if(data.bname !== ''){
			                        extraAddr += data.bname;
			                    }
			                    // 건물명이 있을 경우 추가한다.
			                    if(data.buildingName !== ''){
			                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
			                    }
			                    // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
			                    fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
			                }
			
			                // 우편번호와 주소 정보를 해당 필드에 넣는다.
			                document.getElementById('sample2_postcode').value = data.zonecode; //5자리 새우편번호 사용
			                document.getElementById('sample2_address').value = fullAddr;
			
			                // iframe을 넣은 element를 안보이게 한다.
			                // (autoClose:false 기능을 이용한다면, 아래 코드를 제거해야 화면에서 사라지지 않는다.)
			                element_layer.style.display = 'none';
			            },
			            width : '100%',
			            height : '100%',
			            maxSuggestItems : 5
			        }).embed(element_layer);
			
			        // iframe을 넣은 element를 보이게 한다.
			        element_layer.style.display = 'block';
			
			        // iframe을 넣은 element의 위치를 화면의 가운데로 이동시킨다.
			        initLayerPosition();
			    }
			
			    // 브라우저의 크기 변경에 따라 레이어를 가운데로 이동시키고자 하실때에는
			    // resize이벤트나, orientationchange이벤트를 이용하여 값이 변경될때마다 아래 함수를 실행 시켜 주시거나,
			    // 직접 element_layer의 top,left값을 수정해 주시면 됩니다.
			    function initLayerPosition(){
			        var width = 300; //우편번호서비스가 들어갈 element의 width
			        var height = 400; //우편번호서비스가 들어갈 element의 height
			        var borderWidth = 5; //샘플에서 사용하는 border의 두께
			
			        // 위에서 선언한 값들을 실제 element에 넣는다.
			        element_layer.style.width = width + 'px';
			        element_layer.style.height = height + 'px';
			        element_layer.style.border = borderWidth + 'px solid';
			        // 실행되는 순간의 화면 너비와 높이 값을 가져와서 중앙에 뜰 수 있도록 위치를 계산한다.
			        element_layer.style.left = (((window.innerWidth || document.documentElement.clientWidth) - width)/2 - borderWidth) + 5 + 'px';
			        element_layer.style.top = (((window.innerHeight || document.documentElement.clientHeight) - height)/2 - borderWidth) + 15 + 'px';
			    }
			</script>
		</form>
	</div>
</div>	