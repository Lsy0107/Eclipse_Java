package day0502;

import java.util.Scanner;

public class EX03 {

	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		int myBalance = 0;
		boolean run = true;
		while(run) {
			//메뉴출력
			System.out.println("[1]입금 [2]출금 [3]잔고 [4]종료");
			System.out.println("메뉴선택>>");
			int selectMenu = scan.nextInt();
			if(selectMenu == 1) {
				System.out.println("[입금]");
				System.out.println("입금할 금액>>");
				int deposit = scan.nextInt();
				myBalance += deposit;
				System.out.println("현재 잔액은" + myBalance +"원 입니다.");
			}else if(selectMenu == 2) {
				System.out.println("[출금]");
				System.out.println("출금할 금액>>");
				int withdraw = scan.nextInt();
				if(myBalance >= withdraw) {
				myBalance = myBalance - withdraw;
				}else {
					System.out.println("잔액이 부족합니다.");
				}
			}else if (selectMenu == 3) {
				System.out.println("[잔고]");
				System.out.println("현재잔액은" +myBalance+ "원 입니다.");
			}else {
				System.out.println("[종료]");
				run = false;	
			}
			}

		}
}
