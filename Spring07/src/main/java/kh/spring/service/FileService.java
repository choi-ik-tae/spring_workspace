package kh.spring.service;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kh.spring.dto.FileDTO;

@Service
public class FileService {
	public void fileUpload(FileDTO dto,String path) {
		File filePath = new File(path);
		
		if(!filePath.exists()) {
			filePath.mkdir();
		}
		
		for(MultipartFile tmp : dto.getFile()) {
			String oriName = tmp.getOriginalFilename();
			String sysName = System.currentTimeMillis() + "_" + oriName;
			try {
				tmp.transferTo(new File(path+"/"+sysName));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("title : "+dto.getTitle()+"\ncontents : "+dto.getContents());
		
		// 트라이 캐치를를 왜 서비스에서 쓰나요??
		// 예외처리는 개발자 역량으로 로직을 직접 짜줘야하는거라 해도되고 넘겨도 되는데
		// 파일에서는 약간 다르기때문에 로직을 따로 짜줘야함으로 트라이캐치가 필요하다.
		// 파일 업로드중 하나가 실패했을 때 어떻게 할것인지. 다올리고 실패한거만 안올릴지
		// 이미 업로드 된것도 지우고 오류페이지로 보낼지 정해야한다.
	}
}
