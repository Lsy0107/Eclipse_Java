package day0425;

import java.util.Scanner; // ctrl + shift + o

public class Ex03_Scanner {

	public static void main(String[] args) {
		
		/* Scanner 클래스 */
		Scanner scan = new Scanner(System.in);
//		scan.nextInt(); // 정수를 입력받는 기능
//		int number = 100;
		System.out.print("숫자를 입력");
		int number = scan.nextInt();
		System.out.println("입력받은 수 : " + number);
		
//		scan.next(); 문자를 입력받는 기능
		System.out.print("문자를 입력");
		String strVal = scan.next();
		System.out.println("입력받은 문자 : " + strVal);
	}
}
