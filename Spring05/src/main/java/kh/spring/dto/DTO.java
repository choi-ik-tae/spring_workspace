package kh.spring.dto;

import java.sql.Timestamp;

public class DTO {
	private int seq;
	private String name;
	private String msg;
	private Timestamp write_date;
	
	public DTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DTO(int seq, String name, String msg, Timestamp write_date) {
		super();
		this.seq = seq;
		this.name = name;
		this.msg = msg;
		this.write_date = write_date;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Timestamp getWrite_date() {
		return write_date;
	}

	public void setWrite_date(Timestamp write_date) {
		this.write_date = write_date;
	}
}
