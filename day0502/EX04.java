package day0502;

import java.util.Scanner;

public class EX04 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String orderList =""; //주문한 메뉴이름들이 저장될 변수
		int sum=0;
		int totalPrice=0;
		boolean menuOpen = true;
		while(menuOpen) { //while
			System.out.println("[1]아메리카노(2000) [2]바닐라라떼(3500) [3]아이스티(3000) [0]종료");
			System.out.print("메뉴선택>>");
			int selectMenu = scan.nextInt();
			switch(selectMenu) {
			case 1:
				System.out.println("[아메리카노]선택");
				orderList = orderList + "[아메리카노]";
				totalPrice = totalPrice + 2000;
				break;
			case 2:
				System.out.println("[바닐라라떼]선택");
				orderList = orderList + "[바닐라라떼]";
				totalPrice = totalPrice + 3500;
				break;
			case 3:
				System.out.println("[아이스티]선택");
				orderList = orderList + "[아이스티]";
				totalPrice = totalPrice+ 2000;
				break;
			case 0:	
				System.out.println("[주문종료]");
				menuOpen = false;
				
				break;
			default:	
				System.out.println("잘못 선택 했습니다.\n다시 입력해주세요.");
			}//switch문 종료
			
		
		}//while문 종료
		if (totalPrice>0) {
			System.out.println("주문한 메뉴는" + orderList + "입니다.");
			System.out.println("결제금액은"+totalPrice + "입니다.");
			
		}else {
			
			System.out.println("주문한 메뉴가 없습니다.");
		}
	}

}
