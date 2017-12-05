package kr.or.kosta.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.kosta.dto.Event;

@Service
public class EventService {
	@Autowired
	private SqlSession session;
	
	// 이벤트 리스트보기 (관리자 사용자 모두)
	public List<Event> getEventList(){
		return null;
	}
	
	// 이벤트 상세보기 (관리자, 사용자 모두 사용)
	public Event getEvent(int eventNum) {
		return null;
	}
	
	// 최상위 관리자가 이벤트 등록
	public void addEvent(Event event) {
		
	}
	
	// 최상위 관리자가 이벤트 수정
	public void editCompleteEvent(Event event) {
		
	}
	
	// 최상위 관리자가 이벤트 삭제
	public void deleteEvent(int eventNum) {
		
	} 
}