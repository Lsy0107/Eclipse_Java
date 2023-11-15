package day0425;

import java.util.Scanner;

public class Ex05_Q2 {

	public static void main(String[] args) {
		
		int coffeePrice = 3000;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("내가 가지고 있는 돈 :");
		int money = scan.nextInt();
		
		int result = money - coffeePrice;
		System.out.print("커피의 갯수 :");

		if (result >= 0) {
			System.out.println("남은 잔액은" + result + "입니다.");}
		else {
		System.out.println("잔액이 부족합니다.");
		
		
	}}

}
