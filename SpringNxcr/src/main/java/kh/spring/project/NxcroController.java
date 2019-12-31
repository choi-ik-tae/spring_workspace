package kh.spring.project;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nexacro17.xapi.tx.PlatformRequest;

@Controller
@RequestMapping("/nxcr/")
public class NxcroController {
	@RequestMapping("insert.do")
	public String insert(HttpServletRequest request) {
		System.out.println("넥사크로 요청 받음.");
		
		try {
			PlatformRequest pReq = new PlatformRequest(request.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "redirect:/resources/index.html";
	}
}
