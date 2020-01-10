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
@WebAppConfiguration
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class MemberControllerTest {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private WebApplicationContext wac;
	private MockMvc mvc;
	
	@Before
	public void setUp() throws Exception {
		MockMvcBuilders.webAppContextSetup(wac);
	}

	@Test
	public void test() {
		try {
		RequestBuilder rb = MockMvcRequestBuilders.post("/beginSpring/memberRegister.action")
				.param("userid", "leess")
				.param("passwd", "qwer1234$")
				.param("name", "이순신")
				.param("email", "leess@gmail.com")
				.param("tel", "01023456789");
		
		this.mvc.perform(rb).andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk());
		
		logger.info("테스트 수행 성공!!");
		
		} catch(Exception e) {
			logger.error("테스트 수행 실패 : 오류메시지");
			e.printStackTrace();
		}
	}

}
