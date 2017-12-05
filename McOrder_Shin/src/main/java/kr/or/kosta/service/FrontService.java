package kr.or.kosta.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.kosta.dao.FrontDao;
import kr.or.kosta.dto.Event;

@Service
public class FrontService {
	
	@Autowired
	private SqlSession session;
	
	// 이벤트 리스트 가져오기
	public List<Event> getEventList(){
		FrontDao dao = session.getMapper(FrontDao.class);
		List<Event> eventList = dao.getEvent();
		System.out.println("리스트: " + eventList.toString());
		return eventList;
	}
	
}