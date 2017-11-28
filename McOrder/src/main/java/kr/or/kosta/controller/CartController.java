package kr.or.kosta.controller;


import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.View;

import kr.or.kosta.dto.BurgerSet;
import kr.or.kosta.dto.Menu;
import kr.or.kosta.service.CartService;


@Controller
public class CartController {
	
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private View jsonview;
	
	// 회원이 장바구니에 메뉴 하나 추가 , 장바구니 추가 전 선행되는거라 void여야함 한번더 탈거여
	public void addCart(Menu menu, Principal principal) {
		
	}
	
	// 회원이 장바구니에 버거세트 추가, 장바구니 추가 전 선행되는거라 void여야함 한번더 탈거여
	public void addCart(BurgerSet burgerSet, Principal principal) {
		
	}
	
	// 회원 장바구니 목록 보기
	public String getCart(Principal principal, ModelMap map) {
		return null;
	}
	
	// 회원 장바구니 1개 삭제 > 아마 장바구니 삭제가 한개씩만 될거얼??? 비동기!!!!
	public View deleteCart(int cartSeq, ModelMap map) {
		return jsonview;
	}
	 
	// 회원이 하나 주문하면 주문완료 되면서 장바구니에서 해당 메뉴 삭제
	public String buyDeleteCart(int cartSeq) {
		return null;
	}
	
	// 회원이 여러개 주문하면 주문완료 되면서 장바구니에서 해당 메뉴들 삭제
	public String buyDeleteCart(List<Integer> cartSeqs) {
		return null;
	}
	
	// 장바구니에서 세트메뉴 구성품 변경시 사용  비동기다!!!!
	public View editCart(int cartSeq, String type, Principal principal, ModelMap map) {
		return jsonview;
	}
	
	
}
