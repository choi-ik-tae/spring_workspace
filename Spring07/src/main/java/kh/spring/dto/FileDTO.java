package kh.spring.dto;

import org.springframework.web.multipart.MultipartFile;

public class FileDTO {
	private String title;
	private String contents;
	private MultipartFile[] file;
	
	public FileDTO(String title, String contents, MultipartFile[] file) {
		super();
		this.title = title;
		this.contents = contents;
		this.file = file;
	}
	
	public FileDTO() {
		super();
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public MultipartFile[] getFile() {
		return file;
	}
	public void setFile(MultipartFile[] file) {
		this.file = file;
	}
}
