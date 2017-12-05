package kr.or.kosta.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.View;

import kr.or.kosta.dto.Member;
import kr.or.kosta.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private View jsonview;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	// 로그인 화면
	@RequestMapping("/login.htm")
	public String login() {
		return "login.member";
	}
	
	// 회원가입 페이지 get 방식으로 폼만 보여주기
	@RequestMapping(value="/join.htm", method=RequestMethod.GET)
	public String showJoinForm() {
		return "join.member";
	}
	
	// 회원가입 페이지 주소창
	@RequestMapping(value="/addr.htm", method=RequestMethod.GET)
	public String addr() {
		return "addr.member";
	}
	
	// 회원가입 페이지 주소창
	@RequestMapping(value="/addr.htm", method=RequestMethod.POST)
	public void returnAddr() {
	}
	
	// 회원가입 페이지 주소창
	@RequestMapping(value="/findAddr.htm", method=RequestMethod.GET)
	public String findAddr() {
		return "findAddr.member";
	}
	
	// 회원가입 페이지 아이디 중복여부 체크
	@RequestMapping(value="/dupl.htm", method=RequestMethod.POST)
	@ResponseBody
	public View dupl(String id, Model model) {
		System.out.println("넘어온 아이디: " + id);
		int row = memberService.dupl(id);
		model.addAttribute("row", row);
		return jsonview;
	}
	
	// 회원가입 post 방식으로 폼에서 넘어오면!!! 들어온 패스워드 암호화 set해서 넘겨!!!!!
	@RequestMapping(value="/join.htm", method=RequestMethod.POST)
	public String joinMember(Member member) throws Exception {
		System.out.println("회원가입컨트롤러왔고 주소는 들어왔나 ? : " + member.getAddress());
		member.setPassword(this.bCryptPasswordEncoder.encode(member.getPassword()));
		memberService.joinMember(member);
		return "login.member";
	}
	
	// 아이디 찾기 화면
	@RequestMapping("findID.htm")
	public String findID() {
		return "findID.member";
	}
	
	// 이름이랑 폰넘버 받아서 아이디를 찾아 그리고 비동기로 데이터넘겨서 알려줄거임
	@RequestMapping(value="findID.htm", method=RequestMethod.POST)
	@ResponseBody
	public String findMemberId(String name, String phoneNum) {
		System.out.println("이름: " + name + "/ 폰넘: " + phoneNum);
		String id = memberService.findMemberId(name, phoneNum);
		return id;
	}
	
	// 비밀번호 찾기 화면
	@RequestMapping(value="findPassword.htm", method=RequestMethod.GET)
	public String findPassword() {
		return "findPassword.member";
	}
	
	// 이름이랑 폰넘버 받아서 아이디를 찾아 그리고 비동기로 데이터넘겨서 알려줄거임
	@ResponseBody
	@RequestMapping(value="findPassword.htm", method=RequestMethod.POST)
	public View findPassword(String id, String phoneNum, ModelMap model) {
		System.out.println("아이디: " + id + "/ 폰넘: " + phoneNum);
		Member member = memberService.findPassword(id, phoneNum);
		model.addAttribute("member", member);
		return jsonview;
	}
	
	// 이름이랑 폰넘버 받아서 아이디를 찾아 그리고 비동기로 데이터넘겨서 알려줄거임
	@ResponseBody
	@RequestMapping(value="editPassword.htm", method=RequestMethod.POST)
	public View editPassword(String password1, String password2, ModelMap model, String userid) {
		System.out.println("userid: " + userid);
		System.out.println("password: " + password1);
		if(password1.equals(password2)) {
			// 비밀번호 = 비밀번호 확인
			System.out.println("같아!");
			memberService.editPassword(userid, this.bCryptPasswordEncoder.encode(password1));
			model.addAttribute("check","true");
		} else {
			System.out.println("달라!");
			model.addAttribute("check","fail");
		}
		return jsonview;
	}
	
	// 아이디랑 폰넘버 받아서 해당 회원을 찾고 있으면 패스워드 수정창  비동기로 띄워줄거임
	public View findCompletePwd(String id, String phoneNum, ModelMap map) {
		return jsonview;
	}
	
	// 비밀번호 수정창에서 비밀번호 변경 하면 변경을하고 메인으로 보낼 거임
	public String changeMemberPwd(String id, String pwd) {
		return null;
	}
	
	// 회원탈퇴 후 메인 으로 가자 이�� 탈퇴는 enabled 값 수정이다!!!!!!
	public String dropMember(Principal principal) {
		return null;
	}
}
