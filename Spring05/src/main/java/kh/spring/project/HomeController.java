package kh.spring.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kh.spring.dao.DAO;
import kh.spring.dto.DTO;

@Controller 
// 옛날에는 Component 각 기능별 업데이트 때문에 세분화 시켰다.
// Controller , Repository, Service 세 가지
public class HomeController {
	
	@Autowired
	private DAO dao;
	
	@RequestMapping("/home")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home");
		return mav;
	}
	
	@RequestMapping("/input.do")
	public String toInput() {
		return "input";
	}
		
	@RequestMapping("/inputProc.do")
	public String inputProc(DTO dto) {
		try {
			int result = dao.insert(dto);
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "home";
	}
	
	@RequestMapping("/outputProc.do")
	public ModelAndView outputProc() {
		ModelAndView mav = new ModelAndView();
		
		try {
			List<DTO> list = dao.selectAll();
			mav.addObject("list", list);
			mav.setViewName("output");
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("error");
			return mav;
		}
		return mav;
	}
	
	@RequestMapping("/deleteProc.do")
	public ModelAndView deleteProc(int seq) {
		ModelAndView mav = new ModelAndView();
		
		try {
			int result = dao.delete(seq);
			System.out.println(result);
			mav.setViewName("redirect:outputProc.do");			
		} catch (Exception e) {
			e.printStackTrace();
			mav.setViewName("error");
			return mav;
		}
		return mav;
	}
}
