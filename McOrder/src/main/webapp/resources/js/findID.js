$(function(){
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
	
	$('#submit').click(function(){
		$.ajax({
			url: "android.htm",
			type: "POST",
			success: function(data){
				console.log(data);
			}
		})
	})
/*	$('#submit').click(function(){
		$.ajax({
			url: "findID.htm",
			type: "POST",
			data: {"name": $('#name').val(), "phoneNum": $('#phoneNum').val()},
			success: function(data){	
				$('#findDiv').animate({"background-color": "#fff"}, 100);
				
				if(data != null && data != ""){
					$('#find').html("당신의 아이디는<br>" + data + "<br>입니다.<br><button id='findPassword' class='btn btn-success' style='color: #fff; font-family: &#39;Hanna&#39;, serif; font-size: 20px;'>비밀번호 찾기 </button>");
					$('#findPassword').click(function(){
						window.location.href = "findPassword.htm";
					})
				} else {
					$('#find').html("해당하는 회원 정보가<br>없습니다.");
				}
			}
		})
	})
*/})