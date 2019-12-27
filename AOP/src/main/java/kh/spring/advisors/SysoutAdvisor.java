package kh.spring.advisors;

import java.text.SimpleDateFormat;

import org.aspectj.lang.JoinPoint;

public class SysoutAdvisor {
	
	private SimpleDateFormat fm1 = new SimpleDateFormat("yyyy년 mm월 dd일 hh시 MM분 ss초");
	
	public void before(JoinPoint jp) {
		System.out.print(fm1.format(System.currentTimeMillis()) + "에 " + jp.toShortString() + " 메서드가 실행되었다.\n");
	}
	
	public void afterReturn(JoinPoint jp) {
		System.out.print(fm1.format(System.currentTimeMillis()) + "에 " + jp.toShortString() + " 메서드가 종료되었다.\n");
	}
}
