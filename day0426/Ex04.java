package day0426;

import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {
	/*	Scanner scan = new Scanner(System.in);
		System.out.println("[1]메뉴1 [2]메뉴2");
		System.out.println("메뉴선택>>");
		int selectMenu = scan.nextInt();
		
		if(selectMenu == 1) {
			System.out.println("1선택");
		}else if(selectMenu ==2) {
			System.out.println("2선택");
		}
*/
		
		Scanner scan = new Scanner(System.in);
		System.out.println("현재 가지고 있는 돈 :");
		int money = scan.nextInt();
		int aa = 2000;
		int bb = 3500;
		
		System.out.println("[1]아메리카노(2000) [2]바닐라라떼(3500)");
		System.out.println("메뉴 선택 :");
		int selectMenu = scan.nextInt();
		if (selectMenu == 1) {
			System.out.println("[1]아메리카노(2000)");
			money = money - 2000;
		}else if (selectMenu == 2) {
			System.out.println("[2]바닐라라떼(3500)");
			money = money - 3500;
		}
		if (money >= 0 ) {
		System.out.println("잔액은" + money + "입니다");
		}else {
		System.out.println("잔액이 부족합니다.");
		}
	}

}
