$(function(){
	
	$('#NAME').focus(function(){
		$('#LNAME').animate({"top": "5px", "color": "#fff", "font-size": "20px"}, 200);
	})
	
	$('#NAME').blur(function(){
		if($("#NAME").val() == null || $("#NAME").val() == ""){
			$('#LNAME').animate({"top": "35px", "color": "#000", "font-size": "25px"}, 200);
		}
	})
	
	$('#LNAME').click(function(){
		$("#NAME").focus();
	})
	
	$('#PHONE').focus(function(){
		$('#LPHONE').animate({"top": "5px", "color": "#fff", "font-size": "20px"}, 200);
	})
	
	$('#PHONE').blur(function(){
		if($("#PHONE").val() == null || $("#PHONE").val() == ""){
			$('#LPHONE').animate({"top": "35px", "color": "#000", "font-size": "25px"}, 200);
		}
	})
	
	$('#LPHONE').click(function(){
		$("#PHONE").focus();
	})
	
})