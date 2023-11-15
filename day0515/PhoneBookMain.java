package day0515;

import java.util.Scanner;

public class PhoneBookMain {
	Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		PhoneService phoneSvc = new PhoneService();
		boolean run = true;
		while (run) {
			//메뉴 출력 기능 호출
			phoneSvc.showMenu();
			
			int selectMenu = phoneSvc.scan.nextInt();
			switch (selectMenu) {
			case 1:
				phoneSvc.registInfo();
				break;
			case 2:
				phoneSvc.searchInfo();
				break;
			case 3:
				phoneSvc.modifyInfo();
				break;
			case 4:
				phoneSvc.deleteInfo();
				break;
			default:
				run = false;
			}
		}

	}

}
