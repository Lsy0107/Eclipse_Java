package jdbcShop_Mstate;

import java.util.Scanner;

public class ShopAdminMain {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		boolean run = true;
		
		ShopAdminService smvc = new ShopAdminService();
		
		while(true) {
			System.out.println("[관리자모드입니다.]");
			System.out.println("[1]회원관리 [2]상품관리");
			
			int selectMenu = scan.nextInt();
			switch(selectMenu) {
			case 1:
				System.out.println("회원관리 모드입니다.");
				smvc.MemberManage();
				break;
			case 2:
				System.out.println("상품관리 모드입니다.");
				smvc.GoodsManage();
				break;
			}
		}
	}

}
