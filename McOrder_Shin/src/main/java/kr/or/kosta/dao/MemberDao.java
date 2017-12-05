package kr.or.kosta.dao;

import kr.or.kosta.dto.Member;

/*
2017-11-29
02:56
신동민
회원가입 Dao
*/
public interface MemberDao {

	// member 테이블에 회원아이디 insert
	public void join(Member member);
	
	// 로그인 성공 후 현재시간을 member table에 집어넣기.
	public void lastTime(String username);
	
	// 이름, 폰번호로 아이디 받아오기
	public String getId(String name, String phoneNum);
	
	// 비밀번호 찾기
	public Member getNamePhone(String username, String phoneNum);
	
	// 비밀번호 찾기 -> 비밀번호 수정
	public void editPassword(String id, String password);
	
	// 회원가입페이지 중복체크
	public int dupl(String id);
}
