package day0425;

import java.util.Scanner;

public class Ex05_Q {

	public static void main(String[] args) {
		
		int coffeePrice = 3000;
		int latte = 5000;
		
		/* 내가 가지고 있는 돈을 입력 받아서
		 * 커피를 구매했을 때 남은 잔액 출력 */
		
		Scanner scan = new Scanner(System.in);
		int money;
		System.out.print("내가 가지고 있는 돈 :");
		money = scan.nextInt();
		
		
		
		
		
		int cnt, sum;
		System.out.print("커피의 갯수 :");
		cnt = scan.nextInt();
		sum = cnt * coffeePrice;
		if (money < coffeePrice ) {
			System.out.println("돈이 부족합니다.");}
		else {
		System.out.println("남은 잔액은" + (money - sum) + "입니다.");
		
		}
	}

}
