package kr.or.kosta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.servlet.View;

import kr.or.kosta.dto.Menu;
import kr.or.kosta.service.MenuService;

@Controller
public class MenuController {

	@Autowired
	private MenuService menuService;
	
	@Autowired
	private View jsonview;
	
	// 하위관리자가 관리자 페이지에서 매장에 판매되는 메뉴리스트 보는 것
	public String showMenuListAdmin(int branchCode, Model model) {
		return null;
	}
	// 웹상에서 매장 선택후 보이는 메뉴리스트 
	public String showMenuList(int brachCode, Model model) {
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
	
	// 웹상에서 보는 진짜 디테일 (리턴 리스트말고 메뉴객체) 리스트로 받는거는 아마 오더컨트롤러!
	public String menuDetail(String menuName, Model model) {
		return null;
	}
	
	
}
