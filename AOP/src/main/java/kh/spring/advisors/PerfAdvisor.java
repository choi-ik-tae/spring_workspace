package kh.spring.advisors;

import org.aspectj.lang.ProceedingJoinPoint;

public class PerfAdvisor {
	// 현재 진행중인 참여지점
	// proceed 콜하는 순간 원본 메서드 실행
	public Object perfCheck(ProceedingJoinPoint pjp) {
		long start = System.currentTimeMillis();
		Object result = null;
		try {
			result = pjp.proceed(pjp.getArgs());
		} catch (Throwable e) { // Exception보다 더 높은 단계에 있는 예외 최고 조상
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		System.out.println(end-start+"ms 소요");
		return result;
	}
}
/*
	원본메서드가 매개변수가 없는 메서드라면 인자값을 안주고 proceed() 실행 가능.
	원래 원본메서드가 받을 예정이였던 매개변수를 넘겨줘야함.
 	
 	getArgs()
 	 - 원래 포인터가 받아야할 매개변수를 어라운드가 개입해서 값을 뺏어온 매개변수 값들을 저장하는 곳
 	
	리턴값도 뭔지 모르니까 Object 형으로 반환
	
	매개변수에 Model 변수 받아오고
	m.addAttribute 통해 key,value 정해주고
	String 리턴하면 viewResolver가 알아서 해줌 개신기.
*/
