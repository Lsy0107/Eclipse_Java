package day0428;

import java.awt.geom.Area;
import java.util.Scanner;

public class EX_03 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("?~10까지 총합");
		System.out.print("시작할 숫자>>");
		int startNum = scan.nextInt();
		System.out.print("마지막 숫자>>");
		int lastNum = scan.nextInt();
		int sum = 0;
		for(int i=startNum; i<=lastNum; i++) {
			sum=sum+i;
		}
		System.out.println("총합은=" + sum);
		
	}

	}


