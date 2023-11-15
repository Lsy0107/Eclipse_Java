package day0427;

import java.util.Scanner;

public class EX_03 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.print("문자입력:");
		String strVal = scan.next();
		System.out.println("strVal " + strVal);
		switch(strVal) {
		case "A":
			System.out.println("switch A");
			break;
		case "B":
			System.out.println("switch B");
			break;
		case "ABC":
			System.out.println("switch ABC");
			break;
		default:
		}
	
		System.out.println("switch문 종료");
		System.out.println("if문 시작");
		System.out.println(strVal);
		if (strVal.equals ("A")) {
			System.out.println("if A");
		}
		else if (strVal.equals ("B")) {
			System.out.println("if B");
		}
		else if (strVal.equals ("ABC")) {
			System.out.println("if ABC");
		}
		System.out.println("if문 종료");
	}
	


}
