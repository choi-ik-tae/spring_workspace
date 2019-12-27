package kh.spring.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.spring.services.TempService;

@Controller
public class HomeController {
	
	@Autowired
	private TempService service;
	
	@RequestMapping("/home")
	public String home() {
		
		return "home";
	}
	
	@RequestMapping("/work.do")
	public String work() {
		
		service.buy();
		
		return "home";
	}
	
}
