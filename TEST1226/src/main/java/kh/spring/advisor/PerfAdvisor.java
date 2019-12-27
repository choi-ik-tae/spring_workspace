package kh.spring.advisor;

import org.aspectj.lang.ProceedingJoinPoint;

public class PerfAdvisor {
	public void perfCheck(ProceedingJoinPoint jp) {
		long start = System.currentTimeMillis();
		Object returnObj = null;
		
		try {
			returnObj = jp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		System.out.println(end-start);
	}
}
