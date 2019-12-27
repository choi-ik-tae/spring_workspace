package kh.spring.project;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kh.spring.dto.FileDTO;
import kh.spring.service.FileService;

@Controller
public class HomeController {
	
	@Autowired
	private FileService fileService;
	
	@Autowired
	private HttpSession session = null;
	
	@RequestMapping("/home")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/upload.do")
	public String upload(FileDTO dto) {
		String path = session.getServletContext().getRealPath("files");
		fileService.fileUpload(dto,path);
		return "redirect:home";
	}
	
}
