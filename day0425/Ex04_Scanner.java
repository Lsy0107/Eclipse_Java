package day0425;

import java.util.Scanner;

public class Ex04_Scanner {

	public static void main(String[] args) {
		
		// 스캐너로 숫자를 두 개 입력
		Scanner scan = new Scanner(System.in);
		int num1, num2;
		System.out.print("첫번째 숫자 입력 :");
		num1 = scan.nextInt();
		System.out.print("두번째 숫자 입력 :");
		num2 = scan.nextInt();
		
		
		System.out.println("덧셈 : " + (num1 + num2));
		System.out.println("뺄셈 : " + (num1 - num2));
		System.out.println("곱셈 : " + (num1 * num2));
		System.out.println("나눗셈 : " + (num1 / num2));
		System.out.println("나머지 : " + (num1 % num2));
		
	}

}
