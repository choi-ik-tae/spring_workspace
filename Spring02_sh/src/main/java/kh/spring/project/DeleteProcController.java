package kh.spring.project;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import kh.spring.dao.DAO;

public class DeleteProcController implements Controller {

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
		System.out.println("/delete.do 요청 도착!");
		System.out.println();
		
		int seq = Integer.parseInt(request.getParameter("seq"));
		int result = dao.delete(seq);
		
		mav.setViewName("home"); // viewResoulver는 기본적으로 forward로 동작
		//mav.setViewName("redirect:output.do"); // viewResoulver 동작 안함. 컨트롤러로 이동하려면 forward가 아닌 redirect 해야함.
		
		return mav;
	}
}
