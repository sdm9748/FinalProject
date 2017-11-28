package kr.or.kosta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;

import kr.or.kosta.service.ViewService;

@Controller
public class ViewController {

	@Autowired
	private ViewService viewService;
	
	@Autowired
	private View jsonview;
	
	@RequestMapping("index.htm")
	public String showIndex() {
		
		return "main.jsp";
	}
	

	
	// 지도 메뉴보여주는 창 (스크립트인건가? 어케할지 생각좀)
	public String showMap() {
		return null;
	}
	
	// 매장리스트 보여주기 (경도위도로 직선거리 근처 매장들 보여주는것)
	public View getBranchList(float x, float y, ModelMap mpa) {
		return jsonview;
	}
	
	// 선택된 주소 근처 매장 리스트 뿌리기???
	public View getBranchList(String address, ModelMap map) {
		return jsonview;
	}
	
}
