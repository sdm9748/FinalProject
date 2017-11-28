package kr.or.kosta.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;

import kr.or.kosta.service.MenuService;
import kr.or.kosta.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	private MenuService menuService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private View jsonview;
	
	// 초기화면에서 매장들 보여주고 선택하게 하는 뷰? (매장이름 리스트가 필요한가? 일단 Model 추가)
	// 필요하면 매장이름 리스트로 받아서 뿌려주자 > dao 메소드 추가해야할듯
	public String selectBranch(Model model) {
		return null;
	}
	
	// 매장선택후 주문하기로 넘어가기전 매뉴를 선택하는 페이지 아마 매장코드를 받아서 그 매장에해당하느느
	// 메뉴리스트만 뿌려줄거야!!!
	public String selectedBranch(int branchCode, Model model) {
		return null;
	}
	
	// 메뉴타입을? 오더바이? 해서 인기순, 뭐순으로 뿌려주게....
	public View seletedMenuType(int branchCode, String menuType, String orderBy, ModelMap map) {
		return jsonview; // 왜필요한지 생각좀
	}
	
	
	// 메뉴보여주는 리스트에서 위에 카테고리를 누르면 그게 menuType으로 들어오고 그거에 따라 해당되는
	// 메뉴리스트들을 보여줄거야!!! 비동기로 뿌려>??? 일단 String 처리!!
	public String selectedMenu(int branchCode, String menuName, Model momdel) {
		return null;
	}
	
	// 위의 메뉴리스트들 중에서 선택된 메뉴의 상세페이지
	public String selectedMenuDetail(int branchCode, String menuName, Model model) {
		return null;
	}
	
	// 메인화면 ~ 주문관리
	// 한나
	// 리스트 두개받아서 합쳐서붙일거임.
	// 매장별 주문 내역 리스트 뿌리기
	@RequestMapping("admin.htm")
	public String getOrderList(Model model, Principal principal) {
		
		return "manageOrder.admin";
	}
	
	@RequestMapping("adminLogin.htm")
	public String adminLogin() {
		return "login.admin";
	}
	
	// 한나
	// 주문내역리스트에서 주문완료버튼 누르면!!! 주문완료시각 생성되고 비동기로 주문내역 리스트 다시뿌려주자!!
	public View completeOrder(int branchCode, int orderNum, ModelMap map) {
		return jsonview;
	}

	// 웹소켓 인디 나중에 생각좀...
	public View getOrder(int branchCode, ModelMap map) {
		return jsonview;
	}
	
}
