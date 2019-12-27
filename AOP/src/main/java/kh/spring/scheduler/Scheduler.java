package kh.spring.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {
	
	// fixedRate = 3000
	@Scheduled(cron = "0 0/5 * * * ?")
	public void myJob() {
		System.out.println("Hello Schedule");
	}

/*
	fixedRate 와 fixedDelay는 같다고 보면 됨.
	그런데 다른 부분이 있다.
	fixedRate는  모든 작업마다 시점마다 이며
	fixedDelay는 작업이 끝난 시점으로 부터 라는 차이가 있다.
	
	CRON 표현식 사이트
	https://zamezzz.tistory.com/197
*/
	
}
