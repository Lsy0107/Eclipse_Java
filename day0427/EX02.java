package day0427;

import java.util.Scanner;

public class EX02 {

	public static void main(String[] args) {
		/*Scanner scan = new Scanner(System.in);
		System.out.println("커피 메뉴: [1]아메리카노 2000원 [2]바닐라라떼 3500원");
		System.out.println("커피를 선택 하십시오.");
		int selectMenu = scan.nextInt();
		//selectMenu == 1 : "아메리카노 선택" 출력
		//selectMenu == 2 : "바닐라라떼 선택" 출력
		switch(selectMenu) {
		
		case 1:
			System.out.println("아메리카노");
			break;
		case 2: 
			System.out.println("바닐라라떼");
			break;
		default:
			System.out.println("잘못된 선택입니다.");
		}
		
		*/
		int num1 = 10;
		
		if(num1 == 5) {
			int num2 = 20;
			System.out.println("if num2 :" + num2);
		}else {
			int num2 = 20;
			System.out.println("else num2 :" + num2);
		}
		int num3 = 10;
		switch(num3) {
		case 10:
			int num4 = 40;
			System.out.println("case 10 num4 :" + num4);
			break;
		default:
			//int num4 = 40;
		}
		
	}

}
