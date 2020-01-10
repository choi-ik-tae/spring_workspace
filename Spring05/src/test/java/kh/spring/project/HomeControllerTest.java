package kh.spring.project;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration // Web 환경을 만들어 주는 놈. 빈 만들어줌 그래서 Autuwired가 됨.
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"}) // 스프링 컨테이너 동작시켜주는 놈 그러기위해서 위치를 알려줘야한다!
public class HomeControllerTest {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeControllerTest.class);
	
	@Autowired
	private WebApplicationContext wac;
	
	private MockMvc mvc;
	
	@Before
	public void setUp() throws Exception {
		// 테스트를 하기 전에 먼저 해야하는 작업을 담는 어노테이션
		// 테서트가 실행되기 전에 제일먼저 실행되는 부분 예전 생성자 역할
		// 다 실행 된 뒤 @Test 코드 실행
		this.mvc = MockMvcBuilders.webAppContextSetup(wac).build(); // 이렇게하면 mvc 빈이 생성됨.
	}

	@Test
	public void test() throws Exception{
		// 테스트 로직 작성
		// 웹환경 제공해줌 프론트 부분
		
		logger.info("테스트 시작!");
		
		RequestBuilder rb = MockMvcRequestBuilders.post("/inputProc.do")
				.param("name", "Jack")
				.param("msg", "JUnit!!"); // 빌더패턴 또는 체이닝 기법. 메서드 하나 부르면 this를 리턴
		
		this.mvc.perform(rb)
			.andDo(MockMvcResultHandlers.print())
			.andExpect(MockMvcResultMatchers.status().isOk());
		
		logger.info("테스트 종료");
	}

}
