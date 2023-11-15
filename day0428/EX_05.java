package day0428;

import java.util.Scanner;

public class EX_05 {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("시작숫자>>");
		int startNum = scan.nextInt();
		System.out.println("종료숫자>>");
		int endNum = scan.nextInt();
		int sum = 0;
		System.out.println("for문 시작");
		for(int i = startNum; i <= endNum; i++) {
			System.out.println(i+"");
			//3의 배수인 경우의 합
			if(i % 3 !=0) {
				continue;
			}
			sum=sum+i;
			
		}
		System.out.println("\nfor문 종료");
		System.out.println("sum :" + sum);
	}

}
