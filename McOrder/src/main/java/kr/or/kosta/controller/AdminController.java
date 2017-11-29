package kr.or.kosta.controller;

import java.security.Principal;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;

import kr.or.kosta.dto.Event;
import kr.or.kosta.dto.Menu;
import kr.or.kosta.dto.Order;
import kr.or.kosta.service.CartService;
import kr.or.kosta.service.EventService;
import kr.or.kosta.service.MenuService;
import kr.or.kosta.service.OrderService;
import kr.or.kosta.service.SalesService;

@Controller
@RequestMapping("/Admin/")
public class AdminController {
	
	@Autowired
	private CartService cartService;
	
	@Autowired
	private EventService eventService;
	
	@Autowired
	private MenuService menuService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private SalesService salesService;
	
	@Autowired
	private View jsonview;
	
	// 이벤트 리스트보기 (관리자페이지) 하위 최상위 다볼 수 있음
		public String showEventListAdmin(Model model) {
			return null;
		}
		
		// 이벤트 상세보기 (관리자페이지)
		public String showEventDetailAdmin(int eventNum, Model model) {
			return null;
		}
		
		// 최상위 관리자가 이벤트 등록
		public String addEvent(Event event) {
			return null;
		}
		
		// 관리자가 이벤트 수정할 때 수정 페이지 get방식으로 뿌리는 것
		// dao 에서 event 객체 받아서 수정페이지에 내용 주자
		public String showEditEventForm(int eventNum, Model model) {
			return null;
		}
		
		// 관리자가 수정 후 리스트로 돌아간다.
		public String editCompleteEvent(Event event) {
			return null;
		}
		
		// 관리자가 이벤트 삭제했을때 > 비동기로? 아니다 페이지전환으로 리스트페이지로 다시가
		public String deleteEvent(int eventNum, Model model) {
			return null;
		}
///////////////
		

		// 하위관리자가 관리자 페이지에서 매장에 판매되는 메뉴리스트 보는 것
		public String showMenuListAdmin(int branchCode, Model model) {
			return null;
		}
		

		// 최상위 관리자가 관리자 페이지에서 메뉴 리스트 보는 것
		public String showMenuListTopAdmin(Model model) {
			return null;
		}
		
		// 최상위 관리자가 메뉴수정하려고 가는 페이지 뷰단만 보여주는것
		public String showEditMenu(String menuName) {
			return null;
		}
		
		// 최상위 관리자가 메뉴수정완료후 다시 메뉴리스트로 돌아 가는 것
		public String editCompletedMenu(Menu menu, Model model) {
			return null;
		}
		
		// 하위관리자, 상위관리자가 메뉴 상세보기 > 페이지는 같으니까 같이 써도 되지않나요?
		public String showMenuDetail(String menuName, Model model) {
			return null;
		}
		
		// 하위관리자가 메뉴 추가하러 가는 페이지
		public String showaddMenu(int branchCode) {
			return null;
		}
		
		// 하위관리자가 메뉴 추가후 리스트로 돌아가는것 이때 서비스 두개부르자 먼저 전체삭제하고 
		// 페이지에서 체크한거 통째로 추가
		public String addMenu(int branchCode, List<Menu> list) {
			return null;
		}
		
		// 최상위 관리지가 메뉴 하나 등록
		public String addMenu(Menu menu) {
			return null;
		}
		//////
		// 메인화면 ~ 주문관리
		// 한나
		// 리스트 두개받아서 합쳐서붙일거임.
		// 매장별 주문 내역 리스트 뿌리기
		@RequestMapping("manageOrder.htm")
		public String getOrderList(Model model, Principal principal) {
			
			int branchCode = Integer.parseInt(principal.getName());
			List<Order> orderList = orderService.getOrderList(branchCode);
			
			model.addAttribute("orderList", orderList);
			
			return "manageOrder.admin";
		}
	/*	@RequestMapping("Admin/manageOrder.htm")
		public String getOrderList(Criteria cri, Model model, Principal principal) {
			
			int branchCode = Integer.parseInt(principal.getName());
			List<Order> orderList = orderService.getOrderList(branchCode, cri);
			
			model.addAttribute("orderList", orderList);
			
			PagerMaker pagerMaker = new PagerMaker();
			pagerMaker.setCri(cri);
			int totalCount = orderService.totalCount();
			System.out.println("totalCount(controller)" + totalCount);
			pagerMaker.setTotalCount(totalCount);
			model.addAttribute("pageMaker", pagerMaker);
			
			return "manageOrder.admin";
		}*/
		
		// 한나
		// 주문내역리스트에서 주문완료버튼 누르면!!! 주문완료시각 생성되고 비동기로 주문내역 리스트 다시뿌려주자!!
		@RequestMapping("completeOrderList.htm")
		public View completeOrder(Principal principal, @RequestBody Order order, ModelMap map) {
			
			int orderNum = order.getOrderNum();
			
			System.out.println("주문완료버튼 컨트롤러왔나" + orderNum);
			int branchCode = Integer.parseInt(principal.getName());
			orderService.completeOrder(branchCode, orderNum);
			List<Order> list = orderService.getOrderList(branchCode);
			
			map.addAttribute("orderList", list);
			return jsonview;
		}

		// 웹소켓 인디 나중에 생각좀...
		public View getOrder(int branchCode, ModelMap map) {
			return jsonview;
		}
		
		///////
		
		// 매장별 매출 리스트 보여주기
		public String showSalesList(int branchCode, Model model) {
			return null;
		}
		
		// 매출 리스트에서 매출일자 클릭하면 그 일자에 판매 리스트 모두 보여주기
		public String salesDetail(int branchCode, Date salesDate, Model model) {
			return null;
		}
}
