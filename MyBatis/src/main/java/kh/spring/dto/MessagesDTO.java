package kh.spring.dto;

public class MessagesDTO {
	private int seq;
	private String name;
	private String msg;
	private String write_date;
	
	public MessagesDTO(int seq, String name, String msg, String write_date) {
		super();
		this.seq = seq;
		this.name = name;
		this.msg = msg;
		this.write_date = write_date;
	}

	@Override
	public String toString() {
		return "MessagesDTO [seq=" + seq + ", name=" + name + ", msg=" + msg + ", write_date=" + write_date + "]";
	}

	public MessagesDTO() {
		super();
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

	public String getWrite_date() {
		return write_date;
	}

	public void setWrite_date(String write_date) {
		this.write_date = write_date;
	}
}
