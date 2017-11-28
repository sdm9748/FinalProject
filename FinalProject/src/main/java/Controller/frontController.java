package Controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class frontController {
	
	@RequestMapping("/home.htm")
	public String home() {
		return "main.user";
	}
	
	@RequestMapping("/admin.htm")
	public String admin() {
		return "redirect:Admin/manageOrder.htm";
	}
	
}

