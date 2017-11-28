package kr.or.kosta.dao;

import java.sql.Date;
import java.util.List;

import kr.or.kosta.dto.Order;

public interface SalesDao {

	// 주문완료시 매출액에 자동 합산
	public int addTotalSales(int branchCode, int price);
	
	// 매출 리스트 보기 (차트 사용시 수정 들어가거나 메소드 추가해야할 수도)
	public List<Order> getSalesList(int branchCode);
	
	// 매출리스트에서 클릭하면 매출 상세보기 
	public List<Order> salesDetail(int branchCode, Date salesDate);
	
}
