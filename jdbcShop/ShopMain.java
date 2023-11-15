package jdbcShop;

import java.util.Scanner;

public class ShopMain {
	/*
	 * 1.Member,Goods,Order 2.ShopService 3.ShopDao 4.ShopMain
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean run = true;
		ShopService shopsvc = new ShopService();

		while (run) {
			// 메뉴 출력 (로그인 유무)
			String loginId = shopsvc.getLoginId();

			if (loginId == null) { // 로그인 X
				System.out.println("[1]회원가입 [2]로그인 [9]상품목록(MAP)");

			} else { // 로그인 O
				System.out.println("[1]내정보확인 [2]로그아웃 [3]상품주문 [4]주문내역 [5]주문취소");
			}
			System.out.println("메뉴선택 >>");
			int selectMenu = scan.nextInt();
			switch (selectMenu) {
			case 5: //주문취소
				shopsvc.cancelOrder();
				break;
			case 9:
				shopsvc.goodsList_Map();
				break;
			case 1:
				if (loginId == null) { //회원가입 기능 호출
					shopsvc.memberJoin();
				} else { //내정보확인 기능 호출
					shopsvc.memberinfo();
				}
				break;
			case 2:
				if (loginId == null) { //로그인 기능 호출
					shopsvc.memberLogin();
				} else { //로그아웃 기능 호출
					shopsvc.memberLogout();
				}
				break;
			case 3:
				if (loginId != null) {
					shopsvc.goodsOrder();
					
				}
				break;
			case 4:
				if (loginId != null) {
					shopsvc.orderList();
				} 
				
				break;
			default:
				run = false;
			}

		}

	}

}
