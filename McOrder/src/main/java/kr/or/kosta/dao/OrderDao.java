package kr.or.kosta.dao;

import java.util.List;

import kr.or.kosta.dto.Order;

public interface OrderDao {

	// 한나
	// 실시간 주문완료시  주문완료 클릭되지않은 주문리스트들 가져오기
	public List<Order> getNotCompleteOrder(int branchCode);
	
	// 한나
	// 주문완료 클릭 된 주문내역 리스트 
	public List<Order> getCompletedOrder(int branchCode); 
	
	// 한나
	// 주문 상세 내역보기
	public List<Order> completeOrder(int branchCode, int orderNum);
	
	// 웹소켓 getOrder????????
	public List<Order> getOrder(int branchCode);
	
}
