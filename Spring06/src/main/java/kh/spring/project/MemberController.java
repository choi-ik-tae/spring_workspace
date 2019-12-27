package kh.spring.project;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import kh.spring.dao.MemberDAO;
import kh.spring.dto.MemberDTO;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	private MemberDAO dao;
	
	@Autowired
	private HttpSession session = null;
	
	@RequestMapping("/signup.do")
	public String signUp() {
		
		return "member/signup";
	}
	
	@RequestMapping("/signupProc.do")
	public ModelAndView signUpProc(MemberDTO dto,HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		dto.setId(req.getParameter("id"));
		dto.setPw(req.getParameter("pw"));
		dto.setName(req.getParameter("name"));
		dto.setPhone(req.getParameter("phone"));
		
		try {
			int result = dao.insert(dto);
			if(result > 0) {
				mav.setViewName("redirect:../home");
			}
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("redirect:../error");
			return mav;
		}
		return mav;
	}
	
	@RequestMapping(value = "/overlap.do", produces = "text/html;charset=UTF-8")
	@ResponseBody // 리턴값으로 페이지를 이동하지 않는다.
	public String isExistId(String id) {
		String result = "";
		try {
			result = Integer.toString(dao.isExistId(id));
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return result;
	}
	
	@RequestMapping("/login.do")
	public String login(String id,String pw) {
		try {
			String result = Integer.toString(dao.login(id, pw));
			if(result.contentEquals("1")) {
				session.setAttribute("loginInfo", id);				
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:error";
		}
		return "redirect:../home";
	}
	
	@RequestMapping("/logout.do")
	public String logout() {
		session.invalidate();
		return "redirect:../home";
	}
	
	@RequestMapping("/memberList.do")
	public ModelAndView memberList() {
		ModelAndView mav = new ModelAndView();
		try {
			List<MemberDTO> list = dao.getMemberList();
			mav.addObject("list", list);
			mav.setViewName("member/memberlist");
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("redirect:../error");
		}
		return mav;
	}
	
	@RequestMapping("/myPage.do")
	public ModelAndView myPage() {
		ModelAndView mav = new ModelAndView();
		String id = (String)session.getAttribute("loginInfo");
		
		try {
			MemberDTO dto = dao.getMyInfo(id);
			mav.addObject("dto", dto);
			mav.setViewName("member/mypage");
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("redirect:../error");
		}
		return mav;
	}
	
	@RequestMapping("/memberOut.do")
	public ModelAndView memberOut() {
		ModelAndView mav = new ModelAndView();
		String id = (String)session.getAttribute("loginInfo");
	
		try {
			int result = dao.deleteInfo(id);
			if(result > 0) {
				session.invalidate();
				mav.setViewName("redirect:../home");
			}
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("redirect:error");
		}
		return mav;
	}
	
	@RequestMapping("/modify.do")
	public ModelAndView modify() {
		ModelAndView mav = new ModelAndView();
		String id = (String)session.getAttribute("loginInfo");
		try {
			MemberDTO dto = dao.getMyInfo(id);
			mav.addObject("dto", dto);
			mav.setViewName("member/modify");
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("redirect:../error");
		}
		return mav;
	}
	
	@RequestMapping("/modifyProc.do")
	public ModelAndView modifyProc(MemberDTO dto,HttpServletRequest req) {
		ModelAndView mav = new ModelAndView();
		String id = (String)session.getAttribute("loginInfo");
		dto.setPw(req.getParameter("pw"));
		dto.setName(req.getParameter("name"));
		dto.setPhone(req.getParameter("phone"));
		dto.setId(id);
		
		try {
			int result = dao.modifyInfo(dto);
			if(result > 0) {
				mav.setViewName("redirect:../home");
			}
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("redirect:../error");
		}
		return mav;
	}
}
