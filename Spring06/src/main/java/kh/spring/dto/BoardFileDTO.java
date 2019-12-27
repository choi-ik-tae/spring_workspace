package kh.spring.dto;

import org.springframework.web.multipart.MultipartFile;

public class BoardFileDTO {
	private int seq;
	private String ori_name;
	private String sys_name;
	private MultipartFile[] file;
	
	public BoardFileDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BoardFileDTO(int seq, String ori_name, String sys_name, MultipartFile[] file) {
		super();
		this.seq = seq;
		this.ori_name = ori_name;
		this.sys_name = sys_name;
		this.file = file;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getOri_name() {
		return ori_name;
	}

	public void setOri_name(String ori_name) {
		this.ori_name = ori_name;
	}

	public String getSys_name() {
		return sys_name;
	}

	public void setSys_name(String sys_name) {
		this.sys_name = sys_name;
	}

	public MultipartFile[] getFile() {
		return file;
	}

	public void setFile(MultipartFile[] file) {
		this.file = file;
	}
}
