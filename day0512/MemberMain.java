package day0512;

public class MemberMain {

	public static void main(String[] args) {
		
		MemberService memsvc = new MemberService();
		boolean run =true;
		while(run) {
			//메뉴 출력 기능 메소드 호출
			memsvc.showMenu();
			//메뉴 선택			
			int selectMenu = memsvc.scan.nextInt();
			switch(selectMenu) {
			case 1: //회원가입 기능 메소드 호출
				memsvc.memberJoin();
				break;
			case 2://로그인 기능 메소드 호출
				memsvc.memLogin();
				break;
			default:
				run = false;
			}
			
			 
		}

	}

}
