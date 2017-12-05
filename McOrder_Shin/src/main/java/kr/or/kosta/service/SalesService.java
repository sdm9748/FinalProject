package kr.or.kosta.service;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.kosta.dto.Order;
import kr.or.kosta.dto.Sales;

@Service
public class SalesService {
	@Autowired
	private SqlSession session;
	
	// 관리자페이지에서 매출내역보기 (매장별)
	public List<Sales> showSalesList(int branchCode){
		return null;
	}
	
	// 주문완료시각생성순간에(주문완료버튼클릭시) 그날 매출일자 매출액에 더해짐
	public void addTotalSales(int branchCode, int price) {
		
	}
	
	// 관리자페이지에서 해당일자 매출클릭시 그 날 매출(주문내역?) 리스트 보여주기
	public List<Order> salesDetail(int branchCode, Date salesDate){
		return null;
	}
}
