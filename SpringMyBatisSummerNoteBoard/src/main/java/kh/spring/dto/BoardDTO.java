package kh.spring.dto;

public class BoardDTO {
	private int seq;
	private String title;
	private String id;
	private String contents;
	private String hit;
	private String write_date;

	public BoardDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BoardDTO(int seq, String title, String id, String contents, String hit, String write_date) {
		super();
		this.seq = seq;
		this.title = title;
		this.id = id;
		this.contents = contents;
		this.hit = hit;
		this.write_date = write_date;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getHit() {
		return hit;
	}

	public void setHit(String hit) {
		this.hit = hit;
	}

	public String getWrite_date() {
		return write_date;
	}

	public void setWrite_date(String write_date) {
		this.write_date = write_date;
	}
}
