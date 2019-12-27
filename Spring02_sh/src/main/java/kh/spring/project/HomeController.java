package kh.spring.project;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//request를 받기 위해 Controller interface를 구현해야 함
public class HomeController implements Controller {
	
	@Override  // handleRequest는 결과물인 Model과 생성물인 View를 다루기 위한 처리 method
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		ModelAndView mav = new ModelAndView();  // 요청에 대한 처리 결과를 담을 객체
		System.out.println("/home 요청 도착!");
		System.out.println();
		
		mav.addObject("key", "value");  // request.setAttribute와 같은 역할
		mav.setViewName("home");  // 전달 방식은 기본적으로 forward임
//		mav.setViewName("redirect:WEB-INF/views/home.jsp");  // redirect를 하려면 맨 앞에 redirect: 을 붙여주면 됨
		
		return mav;
	}
}
