package kh.spring.project;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class IndexController {
	
	@Autowired
	private HttpSession session = null;
	
	@RequestMapping("/index")
	public String index() {
		
		return "index";
	}
	
	@RequestMapping("/writeProc2.do")
	public String writeProc(String title, String contents, MultipartFile[] files) {
		
		String rootPath = session.getServletContext().getRealPath("files");
		
		Pattern p = Pattern.compile("<img.+?src=\"(.+?)\".+?data-filename=\"(.+?)\".*?>");
		Matcher m = p.matcher(contents);
		
		StringBuffer sb = new StringBuffer();
		
		try {
			while(m.find()) {
				String oriName = m.group(2);
				String sysName = System.currentTimeMillis()+"_"+oriName;
				String imgString  = m.group(1).split(",")[1];
				byte[] imgBytes = Base64Utils.decodeFromString(imgString);
				
				FileOutputStream fos = new FileOutputStream(rootPath+"/"+sysName);
				DataOutputStream dos = new DataOutputStream(fos);
				
				dos.write(imgBytes);
				dos.flush();
				dos.close();
				
				contents = contents.replaceFirst(Pattern.quote(m.group(1)), "/files/"+sysName);
			}
			
			System.out.println(contents);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:index";
	}
	
}
