package kr.or.kosta.dao;

import kr.or.kosta.dto.Member;

public interface UserDao {

	/*
	2017-11-29
	15:58
	신동민
	내 정보 수정 Dao
	*/
	
	// 체크할 비밀번호 return
	public String getPassword(String username);
	
	// 비밀번호 체크 후 세션 아이디의 정보를 member객체에 담아서 return
	public Member getMember(String username);
	
	// 회원 정보 수정
	public void userEdit(Member member);
}
