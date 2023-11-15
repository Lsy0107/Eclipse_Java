package day0511;

public class EX02_Member {
	private String id; //아이디
	private String pw; //비밀번호
	

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPw() {
		return pw;
	}


	public void setPw(String pw) {
			this.pw = pw;			
	}


	public EX02_Member(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}
	
	
}
