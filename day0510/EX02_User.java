package day0510;

public class EX02_User {
	String id; //아디
	String pw; //비번

//	public EX02_User(String id,String pw) {
//		this.id = id;
//		this.pw = pw;
//	}
	public EX02_User() {
		
	}

	public EX02_User(String id, String pw) {
		super(); //부모 클래스 
		this.id = id;
		this.pw = pw;
	}
}
