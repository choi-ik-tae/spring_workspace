package kh.spring.dto;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class DTO {
	private int seq;
	private String name;
	private String msg;
	private Timestamp write_date;
	
	
	
	public DTO() {
		super();
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
	
	public String getFormedDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		
		return sdf.format(this.write_date);
	}
}
