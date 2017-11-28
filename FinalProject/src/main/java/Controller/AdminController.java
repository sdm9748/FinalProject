package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Admin/")
public class AdminController {
	
	//관리자
	
	// 매출관리
	@RequestMapping("manageSales.htm")
	public String manageSales() {
		return "manageSales.admin";
	}
	
	// 하위 관리자가 자신의 매장에서 보여질 메뉴를 선택하는 화면
	@RequestMapping("selectMenuView.htm")
	public String selectMenuView() {
		return "selectMenuView.admin";
	}
	
	// 메뉴 등록 화면
	@RequestMapping("registMenu.htm")
	public String registMenu() {
		return "registMenu.admin";
	}
	
	// 주문 관리 화면
	@RequestMapping("manageOrder.htm")
	public String manageOrder() {
		return "manageOrder.admin";
	}
	
	// 메뉴 관리 화면(최상위 관리자)
	@RequestMapping("manageMenu.htm")
	public String manageMenu() {
		return "manageMenu.admin";
	}
	
	// 메뉴 수정 화면
	@RequestMapping("editMenu.htm")
	public String editMenu() {
		return "editMenu.admin";
	}
	
	// 메뉴 상세보기 화면
	@RequestMapping("detailMenu.htm")
	public String detailMenu() {
		return "detailMenu.admin";
	}

}
