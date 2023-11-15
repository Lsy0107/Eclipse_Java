package jdbcShop_Mstate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ShopAdminService {
	Scanner scan = new Scanner(System.in);
	ShopAdminDao admindao = new ShopAdminDao();

	public void MemberManage() {

		ArrayList<Member> Meminfo = admindao.select_meminfo();
		int countOrder = admindao.selectCountOrder();
		int totalPrice = admindao.selectTotalPrice();

		System.out.println("회원정보입니다.");
		if (Meminfo.size() > 0) {
			for (int i = 0; i < Meminfo.size(); i++) {
				System.out.println("[" + i + "]" + "["+Meminfo.get(i).getMstate() + "]" + "[아이디]"
						+ Meminfo.get(i).getMid() + " [비밀번호]" + Meminfo.get(i).getMpw() + " [이름]"
						+ Meminfo.get(i).getMname() + " [전화번호]" + Meminfo.get(i).getMphone() + " [생년월일]"
						+ Meminfo.get(i).getMbirth());
			}
			System.out.print("상태관리할 회원 선택>>");
			int inputNum = scan.nextInt();
			
			System.out.println("[1]회원상태 N으로 [2] 회원상태 Y로");
			int stateNum = scan.nextInt();
			Member setMid = Meminfo.get(inputNum);
			String Mid = setMid.getMid();
			
			int MemManage = admindao.select_mstate(Mid, stateNum);
			
		}


	}

	public void GoodsManage() {
		
		ArrayList<Goods> GoodsInfo = admindao.select_GoodsList();
		
		System.out.println("상품목록 관리");
		if(GoodsInfo.size()>0) {
			for(int i =0; i<GoodsInfo.size(); i++) {
				System.out.println("["+i+"]"+" ["+GoodsInfo.get(i).getGstste()+"]"+" ["+GoodsInfo.get(i).getGname()+"]"+
				" ["+GoodsInfo.get(i).getGcode()+"]"+" ["+GoodsInfo.get(i).getGprice()+"]"+" ["+GoodsInfo.get(i).getGstock()+"]"+" ["+GoodsInfo.get(i).getGtype()+"]");
			}
			System.out.print("물품관리 할 상품 선택>>");
			int inputNum = scan.nextInt();
			if(GoodsInfo.get(inputNum).getGstste().equals("N")) {
				System.out.println("선택한 상품 ["+GoodsInfo.get(inputNum).getGname()+"]은 현재 판매가 중지된 상품입니다.");				
			}else if(GoodsInfo.get(inputNum).getGstste().equals("Y")) {
				System.out.println("선택한 상품 ["+GoodsInfo.get(inputNum).getGname()+"]은 현재 판매가 혀가된 상품입니다.");	
			}
			Goods setGcode = GoodsInfo.get(inputNum);
			String Gcode = setGcode.getGcode();
			
			System.out.println("판매 상태를 변경하시겠습니까?");
			System.out.print("[1]예 [2]아니오");
			int changeNum = scan.nextInt();
			switch(changeNum) {
			case 1:
				if(GoodsInfo.get(inputNum).getGstste().equals("Y")) {
					int GoodsUpdateN = admindao.update_goodsN(Gcode);
					if(GoodsUpdateN >0) {
						System.out.println("정상적으로 업데이트 되었습니다.");
						System.out.println(GoodsInfo.get(inputNum).getGstste()+"]"+" ["+GoodsInfo.get(inputNum).getGname()+"]"+
				" ["+GoodsInfo.get(inputNum).getGprice()+"]"+" ["+GoodsInfo.get(inputNum).getGstock()+"]"+" ["+GoodsInfo.get(inputNum).getGtype()+"]");
						System.out.println();
						
					}else if(GoodsUpdateN <=0){
						System.out.println("업데이트에 실패했습니다.");
					}
				}else if(GoodsInfo.get(inputNum).getGstste().equals("N")) {
					int GoodsUpdateY = admindao.update_goodsY(Gcode);
					if(GoodsUpdateY != 0) {
						System.out.println("정상적으로 업데이트 되었습니다.");
						System.out.println(GoodsInfo.get(inputNum).getGstste()+"]"+" ["+GoodsInfo.get(inputNum).getGname()+"]"+
				" ["+GoodsInfo.get(inputNum).getGprice()+"]"+" ["+GoodsInfo.get(inputNum).getGstock()+"]"+" ["+GoodsInfo.get(inputNum).getGtype()+"]");
						System.out.println();
					}else if(GoodsUpdateY == 0){
						System.out.println("업데이트에 실패했습니다.");
					}
				}
				break;
		
			case 2:
				break;
			}
		}
		
	}

}
