package kh.spring.project;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import kh.spring.dao.DAO;
import kh.spring.dto.DTO;

public class OutputProcController implements Controller {
	
	private DAO dao;
	public void setDao(DAO dao) {
		this.dao = dao;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		ModelAndView mav = new ModelAndView();
		System.out.println("/output.do 요청 도착!");
		System.out.println();
		
		List<DTO> list = dao.selectAll();
		mav.addObject("list", list);
		mav.setViewName("output");
		
		return mav;
	}
}
