package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/User/")
public class UserController {
	
	// 메인화면
	@RequestMapping("main.htm")
	public String main() {
		return "main.user";
	}

	// 메뉴 선택화면
	@RequestMapping("mainmenu.htm")
	public String menuMain() {
		return "mainMenu.user";
	}
	
	// 메뉴 선택했을 때 화면
	@RequestMapping("selectMenu.htm")
	public String selectMenu() {
		return "selectMenu.user";
	}

	// 메뉴를 선택 후 세트인지, 라지세트인지, 단품인지 선택했을 때 화면
	@RequestMapping("menuDetail.htm")
	public String menuDetail() {
		return "menuDetail.user";
	}
	
	// 장바구니 화면
	@RequestMapping("shoppingCart.htm")
	public String shoppingCart() {
		return "shoppingCart.user";
	}
	
	// 지도 화면
	@RequestMapping("map.htm")
	public String map() {
		return "map.user";
	}
}
