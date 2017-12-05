package kr.or.kosta.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;

import kr.or.kosta.dto.Event;
import kr.or.kosta.service.FrontService;

@Controller
public class FrontController {

	@Autowired
	private FrontService frontService;
	
	@Autowired
	private View jsonview;
	
	// 사용자 페이지 이동
	@RequestMapping("/index.htm")
	public String home(Model model) {
		List<Event> eventList = frontService.getEventList();
		model.addAttribute("eventList", eventList);
		return "main.user";
	}
	
	// 관리자 페이지 이동
	@RequestMapping("/admin.htm")
	public String admin() {
		return "redirect:Admin/manageOrder.htm";
	}
	
	
}
