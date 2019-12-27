package kh.spring.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kh.spring.dao.DAO;
import kh.spring.dto.DTO;

@Controller
public class HomeController{
	
	@Autowired
	private DAO dao;
	
	@RequestMapping("/home") // /로 들어오는애는 여기 경로로 받아라!
	public ModelAndView home() {
		System.out.println("home 도착");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home");
		
		return mav;
	}
	
	@RequestMapping("/input.do")
	public String toInput() { // String으로 넣으면 자동으로 ViewName으로 인식
		
		return "input";
	}
	
	@RequestMapping("/inputProc.do")
	public String inputProc(DTO dto) {
		dto = new DTO(0,dto.getName(),dto.getMsg(),null);
		
		try {
			int result = dao.insert(dto);
			System.out.println(dto.getName() + " : " + dto.getMsg());
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "home";
	}
	
	
	
	
	
	
	
//	@RequestMapping("/inputProc.do")
//	// 동적 타입 바인딩
//	// 매개변수를 받으면 그 변수의 타입을 인지해서 변수에 맞는 타입을 넣어준다.
//	public ModelAndView inputProc(String name, String msg) {
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("home");
//		
//		System.out.println("이름 : " + name + "\n" + "메세지 : " + msg);
//		
//		return mav;
//	}
	
//	@RequestMapping("/inputProc.do") 
//	public ModelAndView inputProc(HttpServletRequest req) {
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("home");
//		
//		// 동적 타입 바인딩
//		// 매개변수를 받으면 그 변수의 타입을 인지해서 변수에 맞는 타입을 넣어준다.
//		String name = req.getParameter("name");
//		String msg = req.getParameter("msg");
//		System.out.println("이름 : " + name + "\n" + "메세지 : " + msg);
//		
//		return mav;
//	}

}
