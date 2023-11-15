package day0501;

import java.util.Scanner;

public class EX06_a {

	public static void main(String[] args) {
		
		int coffeePrice = 0;
		int sum=0;
		while(true) {
		
		Scanner scan = new Scanner (System.in);
		System.out.println("[1]아메리카노(2000) [2]바닐라라떼(3500)");
		System.out.print("메뉴선택>>");
		int selectMenu = scan.nextInt();
		switch(selectMenu) {
		case 1:
			coffeePrice = 2000;
			
			break;
		case 2:
			coffeePrice = 2000;
			
			break;
		}
		System.out.println("돈을 넣어 주세여");
		
		int money = scan.nextInt();
		System.out.println("거스름돈" + (money - coffeePrice) + "원입니다.");
		sum = sum+coffeePrice;
		//커피 총 판매금액이 만원 이상인 경우 종료
		if(sum >=10000) {
			System.out.println("목표 수익 달성!");
			break;
		}
		
	}
		System.out.println("while문 종료");
	}
}
