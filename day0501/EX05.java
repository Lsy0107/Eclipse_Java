package day0501;

import java.util.Scanner;

public class EX05 {

	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		int coffeeStock = 10; //커피재고
		int coffeePrice = 300; //한잔 가격
		while (true) {
			System.out.println("돈을 넣어주세요");
			int money = scan.nextInt();
			//투입한 금액 커피 가격 비교 판매 조건 확인
			if(money == coffeePrice) {
				System.out.println("커피 1잔을 준다.");
				coffeePrice--;
			}else if(money > coffeePrice) {
				System.out.println("커피 1잔을 준다.");
				System.out.println("거스름돈" + (money - coffeePrice));
				coffeePrice--;
			}else {
				 System.out.println("돈이 부족합니다");
			}
			if(coffeePrice <= 0) {
				System.out.println("재고소진");
				break;
			}
		}

	}

}
