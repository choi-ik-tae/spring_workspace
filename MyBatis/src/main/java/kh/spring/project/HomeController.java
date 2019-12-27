package kh.spring.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kh.spring.dao.MessagesDAO;
import kh.spring.dto.MessagesDTO;

@Controller
public class HomeController {
	
	@Autowired
	private MessagesDAO dao ;
	
	@RequestMapping("/home")
	public String home() {

		return "home";
	}
	
	@RequestMapping("/write.do")
	public String write(MessagesDTO dto) {
		System.out.println("name : "+dto.getName()+"\n"+"msg : "+dto.getMsg());
		dao.insert(dto);
		
		return "redirect:home";
	}
	
	@RequestMapping("output.do")
	public ModelAndView output() {
		ModelAndView mav = new ModelAndView();
		List<MessagesDTO> list = dao.selectAll();
		mav.addObject("list", list);
		mav.setViewName("output");
		
		return mav;
	}
	
	@RequestMapping("delete.do")
	public String delete(String col, String val) {
		dao.deleteBy(col, val);
		return "redirect:output.do";
	}
	
	@RequestMapping("selectDyn1")
	public String selectDyn1() {
		
		List<MessagesDTO> list = dao.selectDyn1(null);
		for(MessagesDTO tmp : list) {
			System.out.println(tmp.toString());
		}
		
		return "redirect:home";
	}
	
}
