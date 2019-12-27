package kh.spring.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	private JdbcTemplate jdbc;
	
	@RequestMapping("/login")
	public void login() {
		System.out.println("로그인");
	}
	
	@RequestMapping("/loginProc.do")
	public String loginProc() {
		
		return "redirect:../home";
	}
	
	
	@RequestMapping("/signup")
	public void signup() {
		System.out.println("회원가입");
	}
	
	@RequestMapping("/overlap.do")
	public String overlap(String id) {
		
		return "";
	}
}
