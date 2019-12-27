package kh.spring.project;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class HomeController {
	
	@Autowired
	private HttpSession session = null;
	
	private List<String> fileList = new ArrayList<>();
	
	@RequestMapping("/home")
	public String home() {

		return "home";
	}
	
	@RequestMapping(value="/ajaxImage.do",produces="text/html;charset=utf8")
	@ResponseBody
	public String ajaxIamge(MultipartFile img) {
		session.setAttribute("fileList", fileList);
		
		String oriName = img.getOriginalFilename();
		((List<String>)session.getAttribute("fileList")).add(oriName); // 리스트에 파일목록 추가
		
		String sysName = System.currentTimeMillis()+"_"+oriName;
		String path = session.getServletContext().getRealPath("files");
		
		File filePath = new File(path);
		
		if(!filePath.exists()) {
			filePath.mkdir();
		}
		
		try {
			img.transferTo(new File(path+"/"+sysName));
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		return "/files/"+sysName;
	}
	
	@RequestMapping("/writeProc.do")
	public String writeForm(String title, String contents, MultipartFile[] files) {
		
		System.out.println("제목 : "+title+"\n"+"내용 : "+contents);
		
		for(MultipartFile tmp : files) {
			System.out.println("파일이름 : "+tmp.getOriginalFilename());
		}
		
		return "redirect:home";
	}
	
	@RequestMapping("/unloadAlarm.do")
	public void unloadAarm() {
		System.out.println("확인");
		
		List<String> files = (List<String>)session.getAttribute("fileList");
		for(String tmp : files) {
			System.out.println(tmp);
		}
	}
	
	
	
	
	
	
	
	
	
}
