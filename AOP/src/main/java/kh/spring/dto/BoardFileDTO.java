package kh.spring.dto;

import java.util.Arrays;

import org.springframework.web.multipart.MultipartFile;

public class BoardFileDTO {
	private int seq;
	private int board_seq;
	private String ori_name;
	private String sys_name;
	private MultipartFile[] files;
	
	@Override
	public String toString() {
		return "BoardFileDTO [seq=" + seq + ", board_seq=" + board_seq + ", ori_name=" + ori_name + ", sys_name="
				+ sys_name + ", files=" + Arrays.toString(files) + "]";
	}

	public BoardFileDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BoardFileDTO(int seq, int board_seq, String ori_name, String sys_name, MultipartFile[] files) {
		super();
		this.seq = seq;
		this.board_seq = board_seq;
		this.ori_name = ori_name;
		this.sys_name = sys_name;
		this.files = files;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public int getBoard_seq() {
		return board_seq;
	}

	public void setBoard_seq(int board_seq) {
		this.board_seq = board_seq;
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

	public MultipartFile[] getFiles() {
		return files;
	}

	public void setFiles(MultipartFile[] files) {
		this.files = files;
	}
}
