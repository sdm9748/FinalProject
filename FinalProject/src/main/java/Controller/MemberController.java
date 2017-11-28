package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {

	// 로그인 화면
	@RequestMapping("/login.htm")
	public String login() {
		return "login.member";
	}
	
	// 회원가입 화면
	@RequestMapping("/join.htm")
	public String join() {
		return "join.member";
	}
	
	// 아이디 찾기 화면
	@RequestMapping("/findID.htm")
	public String findID() {
		return "findID.member";
	}
	
	// 비밀번호 찾기 화면
	@RequestMapping("/findPassword.htm")
	public String findPassword() {
		return "findPassword.member";
	}
	
}
