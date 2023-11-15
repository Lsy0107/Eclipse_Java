package day0510;

public class UserInfo {
	String userId;
	String userPw;
	String userPhone;
	String userName;

	
	public UserInfo(String userId, String userPw, String userPhone, String userName) {
		super();
		this.userId = userId;
		this.userPw = userPw;
		this.userPhone = userPhone;
		this.userName = userName;
	}


	public boolean loginCheck(String loginId, String loginPw) {
		System.out.println("아이디 비번 확인 기능 호출");
/*		boolean result = false;
		if (this.userId.equals(loginId) && this.userPw.equals(loginPw)) {
			result = true;
			
		}*/
		if (this.userId.equals(loginId) && this.userPw.equals(loginPw)) {
			System.out.println("아이디 : "+this.userId);
			System.out.println("비번 : "+this.userPw);
			System.out.println("이름 : "+this.userName);
			System.out.println("전화번호 : "+this.userPhone);
			
			return true;
		}else {
			System.out.println("아이디/비번이 일치하지 않습니다.");
			return false;
		}

	}


	public void showInfo() {
		System.out.println("아이디 : "+this.userId);
		System.out.println("비번 : "+this.userPw);
		System.out.println("이름 : "+this.userName);
		System.out.println("전화번호 : "+this.userPhone);
		
	}


	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", userPw=" + userPw + ", userPhone=" + userPhone + ", userName="
				+ userName + "]";
	}
	
	
	
}
