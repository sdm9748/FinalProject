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
	
	$('#birth').focus(function(){
		$('#LBIRTH').animate({"top": "5px", "color": "#fff", "font-size": "20px"}, 200);
	})
	
	$('#birth').blur(function(){
		if($("#birth").val() == null || $("#birth").val() == ""){
			$('#LBIRTH').animate({"top": "35px", "color": "#000", "font-size": "25px"}, 200);
		}
	})
	
	$('#LBIRTH').click(function(){
		$("#birth").focus();
	})
	
	$('#address').focus(function(){
		$('#LADDRESS').animate({"top": "5px", "color": "#fff", "font-size": "20px"}, 200);
	})
	
	$('#address').click(function(){
		goPopup();
	})
	
	$('#address').blur(function(){
		if($("#address").val() == null || $("#address").val() == ""){
			$('#LADDRESS').animate({"top": "35px", "color": "#000", "font-size": "25px"}, 200);
		}
	})
	
	$('#LADDRESS').click(function(){
		$("#address").focus();
		goPopup();
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
	
	// ===============중복체크======================
	$('#dupl').click(function(){
		if($('#id').val() == null || $('#id').val() == ""){
			$('#duplcheck').html("아이디를 입력해주세요.");
		} else {
			$.ajax({
				url: "dupl.htm",
				type: "POST",
				data: {"id": $('#id').val()},
				success: function(data){
					console.log(data.row);
					if(data.row == 1){
						$('#duplcheck').html("존재하는 아이디입니다.");
					} else {
						$('#duplcheck').html("사용가능한 아이디입니다.");
					}
				}
			})
		}
	})
	
	// ===============예외체크======================
	$('#sub').click(function(){
		var korean = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣|" "|\{\}\[\]\/?.,;:|\)*~`!^\-_+<>@\#$%&\\\=\(\'\"]/;
		var name = /[가-힣]/;

		if($('#id').val() == null || $('#id').val() == ""){
			alert("아이디를 입력해주세요");
			$('#id').focus();
			return false;
		} else if(korean.test($('#id').val())){
			
		}
			

	})
	
})
