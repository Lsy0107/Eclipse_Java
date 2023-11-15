package day0501;

import java.util.Scanner;

public class EX03 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean run = true;
		while (true) {
			System.out.print("숫자입력>>");
			int inputNum = scan.nextInt();
			System.out.println("입력한 숫자 :" + inputNum);
//			if (inputNum == 0) {
//				break;
//			}
		
			switch(inputNum) {
			case 0:
				System.out.println("switch case");
				run = false;
				break;
			}
			
		}
}

}
