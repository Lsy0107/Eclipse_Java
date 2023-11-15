package day0510;

import java.util.Scanner;

public class UserMain {

	public static void main(String[] args) {
		UserInfo myInfo = new UserInfo("LSY","0107","이승열","010-2819-3627");
//		로그인 기능 : 1.아이디, 비번입력
//				  2.입력된 아이디, 비번 회원정보와 일치하는지 확인
//				  3.일치하면 "로그인 성공", 일치하지 않으면 "아이디/비번이 일치하지 않습니다."		

		Scanner scan = new Scanner(System.in);
		System.out.print("아이디 입력 :");
		String loginId = scan.next();
		System.out.print("비번 입력 :");
		String loginPw = scan.next();
//		입력된 아이디,비번 회원정보와 일치하는지 확인
//		확인된 결과값을 반환하는 메소드		
		boolean Check = myInfo.loginCheck(loginId, loginPw); //check :: 일치=true, 일치x=false
		if(Check) {
			//로그인 성공
			//회원정보 출력 >> myInfo객체의 모든 필드값을 출력
			//myInfo의 showInfo 메소드 호출
			myInfo.showInfo();
			System.out.println(myInfo); //toString >> myInfo를 문자열로 바꾸는 역할
		}else {
			
			//로그인 실패
			
			
		}
}

}
