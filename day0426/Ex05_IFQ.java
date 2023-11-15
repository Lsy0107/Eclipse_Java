package day0426;

import java.util.Scanner;

public class Ex05_IFQ {

	public static void main(String[] args) {
		/*
		 * 커피 메뉴 출력 [1]아메리카노 2000원 [2]바닐라라떼 3500원
		 * 커피메뉴 선택
		 * 결제 방법 출력 [1]카드 [2]현금
		 * 결제 방법 선택
		 * 카드결제일 경우 "결제되었습니다"
		 * 현금결제일 경우 
		 * 투입 금액 입력
		 * 결제 후 남은 잔액 출력
		 * */
		Scanner scan = new Scanner(System.in);
		System.out.println("커피 메뉴: [1]아메리카노 2000원 [2]바닐라라떼 3500원");
		System.out.println("커피를 선택 하십시오.");
		int coffee = scan.nextInt();
		System.out.println("결제방법을 선택하시오 : [1]카드결제 [2]현금결제");
		int method = scan.nextInt();
		if (method == 1) {
			System.out.println("결제 되었습니다.");
		}else if (method == 2) {
			System.out.println("투입 금액 입력:");
			int money = scan.nextInt();
			if (coffee == 1) {
				money = money - 2000;
				if (money < 0) {
					System.out.println("현금이 부족합니다.");}
				else {
				System.out.println("거스름돈" + money +"입니다.");
				
				}
			}else if (coffee == 2) {
				money = money - 3500;
				if (money < 0) {
					System.out.println("현금이 부족합니다.");}
				else {
				System.out.println("거스름돈" + money + "입니다.");
				
				}
			}else {
				System.out.println("잘못된 선택입니다.");
			}
			
		}
	}

}



