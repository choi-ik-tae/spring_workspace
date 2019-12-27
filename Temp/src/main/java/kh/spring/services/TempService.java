package kh.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import kh.spring.dao.DAO;

@Service
public class TempService {
	
	@Autowired
	private DAO dao;
	
	@Transactional("txManager")
	public void buy() {
		dao.insert1();
		dao.insert2();
	}
	
//	@Transactional("txManager")
//	public void buy() {
//		try {
//			dao.insert1();
//			dao.insert2();
//		} catch(Exception e) {
//			e.printStackTrace();
//			// 트랜잭셔널 써도 롤백하는 문법
//			TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//		}
//	}
}

/*

이제 컨트롤러에서 DAO 안씀....

Controller 와 DAO 사이에 Service가 끼어듬
Controller가 Service를 통해 DAO를 사용하게끔 바뀜
서비스 계층도 인터페이스를 이용해서 조립가능하게 만들자
DAO 작업을 여러번 해야 할 컨트롤러의 비지니스 로직을 단순화 시킨다.

insert1,2가 작업의 원자성을 가져야 한다.
하나가 성공하고 다른 하나가 실패하면 매우 치명적인 오류.
그래서 성공하려면 둘다 되던가 아니면 둘다 실패해야 한다.

컨트롤러에 어울리지 않는 기능들을 모아논것이라고 보면 됨

*/