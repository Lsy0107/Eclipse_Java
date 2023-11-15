package day0501;

import java.util.Scanner;

public class EX04 {

		public static void main(String[] args) {
			Scanner scan = new Scanner(System.in);
			loopWhile:
			while (true) {
				System.out.print("숫자입력>>");
				int inputNum = scan.nextInt();
				System.out.println("입력한 숫자 :" + inputNum);

				switch(inputNum) {
				case 0:
					System.out.println("switch case");
					break loopWhile;
				}
				
			}
	}



	}

