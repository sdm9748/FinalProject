$(function(){
	$('#username').focus(function(){
		$('#LID').animate({"top": "5px", "color": "#fff", "font-size": "20px"}, 200);
	})
	
	$('#username').blur(function(){
		if($("#username").val() == null || $("#username").val() == ""){
			$('#LID').animate({"top": "35px", "color": "#000", "font-size": "25px"}, 200);
		}
	})
	
	$('#LID').click(function(){
		$("#username").focus();
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
	
	$('.submit').click(function(){
		console.log($('#username').val() + " // " + $('#phoneNum').val());
		$('#userid').val($('#username').val());
		$.ajax({
			url: "findPassword.htm",
			type: "POST",
			data: {"id": $('#username').val(), "phoneNum": $('#phoneNum').val()},
			success: function(data){
				
				if(data.member != null && data.member != ""){
					
					$('#findDiv').animate({"background-color": "#DB0000"}, 100);
					$('#find').animate({"color": "#DB0000"}, 100);
					
					$('#title').html("비밀번호 수정");
					$('#LID').html("새로운 비밀번호");
					$('#LID').animate({"top": "35px", "color": "#000", "font-size": "25px"}, 200);
					$('#LPHONE').html("비밀번호 확인");
					$('#LPHONE').animate({"top": "35px", "color": "#000", "font-size": "25px"}, 200);
					
					$('#description').remove();
					
					$('#phoneNum').val("");
					$('#phoneNum').attr("type", "password");
					$('#username').val("");
					$('#username').attr("type", "password");
					
					$('#btnappend').remove();
					
					var str = '<div id="btnappend" class="col-xs-12" style="margin-top: 10px;">'
							+ '<hr style="border-top-width: 5px;">'
							+ '<center>'
							+ '<button class="editPassword btn btn-warning" style="margin-top: 15px; margin-bottom: 30px; width: 200px; font-size: 20px; color: #fff; font-family: \'Hanna\', serif;">비밀번호 수정</button>'
							+ '</center>'
							+ '</div>';
					
					$('#app').append(str);
					
					$('.editPassword').click(function(){
						$.ajax({
							url: "editPassword.htm",
							type: "POST",
							data: {"userid": $('#userid').val(), "password1": $('#username').val(), "password2": $('#phoneNum').val()},
							success: function(data){
								console.log(data.check);
								var check = data.check;
								if(check == 'true'){
									window.location.href = "index.htm";
								} else {
									$('#find').html("비밀번호가 서로 다릅니다.");
									$('#findDiv').animate({"background-color": "#fff"}, 100);
									$('#find').animate({"color": "#000"}, 100);
								}
							}
						})
					})
				} else {
					$('#findDiv').animate({"background-color": "#fff"}, 100);
					$('#find').html("해당하는 회원 정보가<br>없습니다.");
				}
			}
		})
	})
})
