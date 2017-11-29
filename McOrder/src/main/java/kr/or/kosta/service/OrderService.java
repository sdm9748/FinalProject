package kr.or.kosta.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.emp.common.Criteria;
import kr.or.kosta.dao.OrderDao;
import kr.or.kosta.dto.Order;

@Service
public class OrderService {
	@Autowired
	private SqlSession session;
	
	// 한나
	// 게시물 총 갯수 구하기
	public int totalCount() {
		
		OrderDao orderdao = session.getMapper(OrderDao.class);
		int totalCount = orderdao.getCount();
		return totalCount;
		
	}
	
	// 한나
	// 해당 매장의 주문 내역 리스트
	public List<Order> getOrderList(int branchCode){
		
		OrderDao orderdao = session.getMapper(OrderDao.class);
		List<Order> orderList = orderdao.getCompletedOrder(branchCode);
		
		return orderList;
	}
	
	// 한나
	// 해당 매장의 주문 내역 리스트
/*	public List<Order> getOrderList(int branchCode, Criteria cri){
		
		OrderDao orderdao = session.getMapper(OrderDao.class);
		int pageStart = cri.getPageStart();
		int perPageNum = cri.getPerPageNum();
		System.out.println(pageStart);
		System.out.println(perPageNum);
		List<Order> orderList = orderdao.getCompletedOrder(branchCode, pageStart, perPageNum);
		
		return orderList;
	}*/

	// 한나
	// 주문완료버튼 클릭된 주문내역은 테이블에서 주문완료시각이  sysdate로 업데이트
	public void completeOrder(int branchCode, int orderNum) {
		OrderDao orderdao = session.getMapper(OrderDao.class);
		orderdao.completeOrder(branchCode, orderNum);
	}
	
	// 웹소켓 사용할 때 쓸건데 일단 보류!!! 나중에 다시 생각해야함
	public List<Order> getOrder(int branchCode){
		return null;
	}
	
	
	
}
