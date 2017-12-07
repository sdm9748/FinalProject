package kr.or.kosta.service;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import kr.or.kosta.dao.MemberDao;
import kr.or.kosta.dto.Member;

@Service
public class MemberService implements AuthenticationSuccessHandler {
	
	@Autowired
	private SqlSession session;
	
	  // 회원가입
	  public void joinMember(Member member) {
	      MemberDao dao = session.getMapper(MemberDao.class);
	      String addr1 = member.getSample2_address();
	      String addr2 = member.getAddress2();
	      member.setAddress(addr1 + " " + addr2);
	      // member 테이블에 회원아이디 insert
	      dao.join(member);
	      
	   }
	
	// 회원가입 페이지에서 아이디 중복체크
	public int dupl(String id) {
		MemberDao dao = session.getMapper(MemberDao.class);
		int row = dao.dupl(id);
		return row;
	}
	
	// 로그인 시 마지막 로그인 시간 설정
	public void lastLoginTime(String username) {
		MemberDao dao = session.getMapper(MemberDao.class);
		// member 테이블에 회원아이디 insert
		System.out.println("마지막 로그인시간 설정 시작 " + username);
		dao.lastTime(username);
		System.out.println("마지막 로그인시간 설정 완료");
	}
	
	// 회원아이디 찾기
	public String findMemberId(String name, String phoneNum) {
		MemberDao dao = session.getMapper(MemberDao.class);
		System.out.println(name + "/" + phoneNum);
		String id = dao.getId(name, phoneNum);
		System.out.println("아이디: " + id);
		return id;
	}
	
	// 회원비밀번호찾기
	public Member findPassword(String username, String phoneNum) {
		MemberDao dao = session.getMapper(MemberDao.class);
		Member member = dao.getNamePhone(username, phoneNum);
		return member;
	}
	
	// 회원비밀번호 찾기 -> 비밀번호 수정
	public void editPassword(String username, String phoneNum) {
		System.out.println("아이디: " + username + "/" + "비밀번호: " + phoneNum);
		MemberDao dao = session.getMapper(MemberDao.class);
		dao.editPassword(username, phoneNum);
	}
	
	// 쓰는사람 수정 필요성있어보임
	// 회원비밀번호찾기해서 아이디랑 폰번호있으면 회원정보를 가져와서 아이디를 비번변경창에뿌려주고 입력된값으로 비번 변경..?
	public void changeMemberPwd(String id, String pwd) {
		
	}
	
	// 회원탈퇴  아마 업데이트사용해서 enabled 의 값만 바꿔주면 될듯
	public void dropMember(Principal principal) {
		
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse res, Authentication auth)
			throws IOException, ServletException {
		
		res.sendRedirect(req.getContextPath()+"/User/loginIndex.htm");
	}
}
