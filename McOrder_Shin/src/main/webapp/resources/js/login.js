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
	
})