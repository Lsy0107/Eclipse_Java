package jdbcPhoneBook;

import java.util.Scanner;

public class PhoneBookMain {

	public static void main(String[] args) {

		Scanner scan = new Scanner (System.in);
		PhoneBookService pbsvc = new PhoneBookService();
		boolean run = true;
		while(run) {
			//메뉴 출력
			System.out.println("[1]등록 [2]조회 [3]수정 [4]삭제"+"\n[5]이름으로 조회");
			System.out.print("메뉴 선택>>");
			//메뉴 선택
			int selectMenu = scan.nextInt();
			
			
			
			//기능 호출
			switch(selectMenu) {
			case 1:
				pbsvc.insertPhoneBook();
				break;
				
			case 2:
				pbsvc.selectPhoneBook();
				break;
				
			case 3:
				pbsvc.UpdatePhoneBook();
				break;
			
			case 4:
				pbsvc.DeletePhoneBook();
				break;
				
			case 5:
				pbsvc.selectPhoneBook_Name();
				break;
			default:
				run = false;
			}
			
			
			break;
		}

	}

}
