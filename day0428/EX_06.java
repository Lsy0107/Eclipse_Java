package day0428;

import java.util.Scanner;

public class EX_06 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("시작숫자>>");
		int startNum = scan.nextInt();
		System.out.println("종료숫자>>");
		int endNum = scan.nextInt();
		int count=0;
		int sum=0;
		System.out.println("for문 시작");
		for(int i =startNum; i<= endNum; i++) {
			System.out.print(i+" "
					+ "");
			if(i%3 == 0) {
				count = count + 1;
				sum=sum+i;
			}
		}
		System.out.println("\nfor문 종료");
		System.out.println("3의 배수의 개수" + count + "개");
		System.out.println("총힙은" + sum);

	}

}
