package kh.spring.advisors;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;

public class LogCheckAdvisor {
	
	@Autowired
	private HttpSession session = null;
	
	public Object logCheck(ProceedingJoinPoint pjp) {
		String id = (String)session.getAttribute("loginInfo");
		Object result = null;
		try {
			if(id != null) {
				result = pjp.proceed(pjp.getArgs());
			} else {
				result = "error";
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return result;
	}
}
