package kr.or.kosta.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.kosta.dto.Order;

@Service
public class OrderService {
	@Autowired
	private SqlSession session;
	
	// 한나
	// 해당 매장의 주문 내역 리스트
	public List<Order> getOrderList(int branchCode){
		return null;
	}
	
	// 한나
	// 주문완료버튼 클릭된 주문내역은 테이블에서 주문완료시각이  sysdate로 업데이트
	public void completeOrder(int branchCode, int orderNum) {
		
	}
	
	// 웹소켓 사용할 때 쓸건데 일단 보류!!! 나중에 다시 생각해야함
	public List<Order> getOrder(int branchCode){
		return null;
	}
	
	
	
}
