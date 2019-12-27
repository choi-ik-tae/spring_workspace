package kh.spring.project;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kh.spring.dto.MemberDTO;
import kh.spring.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	private MemberService mService;
	
	@Autowired
	private HttpSession session = null;
	
	@RequestMapping("/signup.do")
	public String signup() {
		return "member/signup";
	}
	
	@RequestMapping("/signupProc.do")
	public String signupProc(MemberDTO dto) {	
		mService.signup(dto);
		return "redirect:../home";
	}
	
	@RequestMapping("/overlap.do")
	public void overlap(String id) {
		
		
	}
	
	@RequestMapping("/login.do")
	public String login(MemberDTO dto) {
		String rt = null;
		MemberDTO lgcheck = mService.login(dto);
		
		if(lgcheck.getId() != null) {
			session.setAttribute("loginInfo", dto.getId());
			rt = "redirect:../home";
		} else {
			rt = "redirect:../error";
		}
		
		return rt;
	}
	
	@RequestMapping("/logout.do")
	public String logout() {
		session.invalidate();
		return "redirect:../home";
	}
	
	@RequestMapping("/memberlist.do")
	public ModelAndView memberlist() {
		ModelAndView mav = new ModelAndView();
		List<MemberDTO> list = mService.memberlist();
		mav.addObject("list", list);
		mav.setViewName("member/memberlist");
		
		return mav;
	}
	
	@RequestMapping("/mypage.do")
	public ModelAndView mypage() {
		ModelAndView mav = new ModelAndView();
		String id = (String)session.getAttribute("loginInfo");
		MemberDTO dto = mService.mypage(id);
		
		mav.addObject("dto", dto);
		mav.setViewName("member/mypage");
		
		return mav;
	}
	
	@RequestMapping("/modify.do")
	public ModelAndView modify() {
		ModelAndView mav = new ModelAndView();
		String id = (String)session.getAttribute("loginInfo");
		
		MemberDTO dto = mService.mypage(id);
		mav.addObject("dto", dto);
		mav.setViewName("member/modify");
		
		return mav;
	}
	
	@RequestMapping("/modifyProc.do")
	public String modifyProc(MemberDTO dto) {
		int result = mService.modfify(dto);
		String rt = null;
		if(result > 0) {
			rt = "redirect:../home";
		} else {
			rt = "redirect:../error";
		}
		
		return rt;
	}
	
	@RequestMapping("/memberout.do")
	public String memberout() {
		String id = (String)session.getAttribute("loginInfo");
		String rt = null;
		int result = mService.memberout(id);
		
		if(result > 0) {
			session.invalidate();
			rt = "redirect:../home";
		} else {
			rt = "redirect:../error";
		}
		
		return rt;
	}
}
