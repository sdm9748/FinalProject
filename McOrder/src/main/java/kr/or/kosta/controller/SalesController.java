package kr.or.kosta.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.servlet.View;

import kr.or.kosta.service.SalesService;

@Controller
public class SalesController {

	@Autowired
	private SalesService salesService;
	
	@Autowired
	private View jsonview;	
	
	
	// 매장별 매출 리스트 보여주기
	public String showSalesList(int branchCode, Model model) {
		return null;
	}
	
	// 매출 리스트에서 매출일자 클릭하면 그 일자에 판매 리스트 모두 보여주기
	public String salesDetail(int branchCode, Date salesDate, Model model) {
		return null;
	}
}
