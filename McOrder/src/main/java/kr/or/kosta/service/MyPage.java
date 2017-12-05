package kr.or.kosta.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import kr.or.kosta.dao.UserDao;
import kr.or.kosta.dto.Member;

@Service
public class MyPage {

	@Autowired
	private SqlSession session;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	public Member passwordCheck(String username, String password) {
		UserDao dao = session.getMapper(UserDao.class);
		String checkPassword = dao.getPassword(username);
		
		// security 를 사용했을 때 기존의 비밀번호와 내가 입력한 비밀번호를 비교하기 위해선 passwordEncoder.matches() 함수를 사용. 
		Boolean check = passwordEncoder.matches(password, checkPassword);
		System.out.println("받은 pass: " + password);
		System.out.println("디비 pass: " + checkPassword);
		System.out.println("체크: " + check);
		
		Member member;
		
		if(check) {
			member = dao.getMember(username);
		} else {
			member = new Member();
		}
		
		return member;
	}
	
	public void userEdit(Member member) {
		UserDao dao = session.getMapper(UserDao.class);
		
		dao.userEdit(member);
	}
}
