package kh.spring.project;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import kh.spring.dao.DAO;

public class InputProcController implements Controller {

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
		System.out.println("/inputProc 요청 도착!");
		
		String name = request.getParameter("username");
		String msg = request.getParameter("msg");
		System.out.println("이름 : " + name);
		System.out.println("메시지 : " + msg);
		System.out.println();
		
		int result = dao.insert(name, msg);
		
		mav.setViewName("home");
		
		return mav;		
	}
}
