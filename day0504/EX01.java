package day0504;

import java.util.Scanner;

public class EX01 {

	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		String[] menuList= {"아메리카노","바닐라라떼","아이스티"};
		int[] priceList = {2000,3500,3000};
		int totalPrice=0;
		int size = menuList.length;
		int[] orderCount = new int[menuList.length];
		while(true) {
	//		System.out.println("[1]아메리카노 [2]바닐라라떼 [3]아이스티");
			//menuList 배열의 모든 값 출력
			for (int i =0; i < menuList.length; i++) {
				System.out.print("["+(i)+"]" + menuList[i] + " ");
			}
			System.out.print("["+ menuList.length +"]주문종료");
			System.out.print("\n메뉴선택>>");
			int selectMenu = scan.nextInt();//menuList[]의 인덱스 번호 입력
	//		System.out.println("선택한 메뉴 :"+selectMenu);
			if (0 <=selectMenu && selectMenu < menuList.length) {
				System.out.println("["+menuList[selectMenu]+"] 선택");
				System.out.println(priceList[selectMenu]+"원 입니다.");
				totalPrice = totalPrice + priceList[selectMenu];
				orderCount[selectMenu] = orderCount[selectMenu]+1;
				System.out.println(menuList[selectMenu] +orderCount[selectMenu]+"개");
				//주문 내역 추가
			}else if(selectMenu == menuList.length){
				System.out.println("[주문종료]선택");
				break;
			}else {
				System.out.println("다시 선택하셈");
			}
		}//while문 종료
		int totalPrice2=0;
		for(int i=0; i< menuList.length; i++) {
			if(orderCount[i] > 0) {
			System.out.print("["+menuList[i]+"]"+orderCount[i]+"잔");
			totalPrice2= totalPrice2 +(priceList[i]*orderCount[i]);
			}else {
				break;
			}
		}
		System.out.println("결제할 금액은"+totalPrice+"원입니다.");
		System.out.println("결제할 금액은"+totalPrice2+"원입니다.");
		
	}

}
