package kr.or.kosta.dao;

import java.util.List;

import kr.or.kosta.dto.Event;

/*
2017-12-04
17:21
신동민
회원가입 Dao
*/
public interface FrontDao {
	
	// 이벤트 리스트 가져오기
	public List<Event> getEvent();
	
}
