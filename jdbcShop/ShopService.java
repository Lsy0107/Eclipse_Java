package jdbcShop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ShopService {
	Scanner scan = new Scanner(System.in);
	ShopDao shopdao = new ShopDao(); // DB
	private String loginId = null; // 로그인아이디

	public String getLoginId() {
		return loginId;
	}

	/* 회원가입 */
	public void memberJoin() {
		System.out.println("[회원가입]");
		System.out.print("[아이디]>>");
		String inputmid = scan.next();
		String idCheck = shopdao.select_idCheck(inputmid);
		if (idCheck == null) {
			System.out.println("사용가능한 아이디입니다.");
		} else {
			System.out.println("현재사용중인 아이디입니다.");
			System.out.println("회원가입을 다시 시도해주세요.");
			return;
		}
		System.out.println("[비밀번호]>>");
		String inputmpw = scan.next();
		System.out.println("[이름]>>");
		String inputmname = scan.next();
		System.out.println("[전화번호]>>");
		String inputmphone = scan.next();
		System.out.println("[생년월일]>>");
		String inputmbirth = scan.next();

		Member mb = new Member();

		mb.setMid(inputmid);
		mb.setMpw(inputmpw);
		mb.setMname(inputmname);
		mb.setMphone(inputmphone);
		mb.setMbirth(inputmbirth);

		int JoinResult = shopdao.MemberJoin(mb);

		if (JoinResult > 0) {
			System.out.println("회원가입에 성공했습니다.");
		} else {
			System.out.println("회원가입에 실패했습니다.");
		}
	}

	/* 로그인 */
	public void memberLogin() {
		System.out.println("[로그인]");
		System.out.println("[아이디]");
		String inputmid = scan.next();
		System.out.println("[비밀번호]");
		String inputmpw = scan.next();

		Member loginMember = shopdao.selelct_loginMem(inputmid, inputmpw);

		if (loginMember != null) {
			if (loginMember.getMstate().equals("Y")) { // 상태값 Y
				System.out.println("로그인되었습니다.");
				loginId = loginMember.getMid();
			} else { // 상태값 N
				System.out.println("이용이 정지된 계정입니다.");
				System.out.println("관리자에게 문의해주세요.");
			}
		} else {
			System.out.println("로그인 실패하였습니다.");
			System.out.println("아이디 혹은 비밀번호가 일치하지 않습니다.");

		}

	}

	/* 로그아웃 */
	public void memberLogout() {
		System.out.println("[로그아웃]");
		loginId = null;
		System.out.println("로그아웃되었습니다.");

	}

	public void memberinfo() {
		System.out.println("[내정보확인]");
		// 회원정보 출력, 주문정보 출력
		/*
		 * 1.회원정보 조회(SELECT .....FROM MEMBERS WHERE MID = ?) - 현재 로그인중인 회원의 정보를 조회
		 */
		Member meminfo = shopdao.select_Memberinfo(loginId);
		if (meminfo == null) {
			System.out.println("회원정보를 찾을 수 없습니다.");
		} else {
			System.out.println("[아이디]" + meminfo.getMid());
			System.out.println("[비밀번호]" + meminfo.getMpw());
			System.out.println("[이름]" + meminfo.getMname());
			System.out.println("[전화번호]" + meminfo.getMphone());
			System.out.println("[생년월일]" + meminfo.getMbirth());

			int countOrder = shopdao.selectCountOrder(loginId);
			int totalPrice = shopdao.selectTotalPrice(loginId);

			System.out.println("[총 주문수]" + countOrder);
			System.out.println("[총 결제금액]" + totalPrice);

		}
	}

	ArrayList<Goods> getGoodsList() { // 상품 목록 조회
		ArrayList<Goods> goodsList = null;
		System.out.println("[1]전체상품 [2]종류별상품 [3]인기상품");
		// 상품목록 출력↗
		System.out.println("선택 >>");
		int selectList = scan.nextInt();
		switch (selectList) { // 상품목록 조회
		case 1: // SELECT * FROM GOODS WHERE GSTGOCK > 0;
			System.out.println("[전체상품목록]");
			goodsList = shopdao.selectGoods_All();
			
			
			
			break;
		case 2:
			System.out.println("[종류별상품목록]");

			ArrayList<Goods> gtypeList = shopdao.selectGoods_Type();
			if (gtypeList != null) {
				for (int i = 0; i < gtypeList.size(); i++) {
					System.out.print("[" + i + "]" + gtypeList.get(i).getGtype() + " ");
				}
				System.out.println("\n선택>>");
				int selectType = scan.nextInt();
				String gtype = gtypeList.get(selectType).getGtype();
				goodsList = shopdao.selectGoods_Type(gtype);
				// SELECT * FROM GOODS WHERE GTYPE = ?
				
				
			}
			break;
		case 3:
			System.out.println("[인기상품목록]");
			goodsList = shopdao.selectGoods_Best();
			break;
		}// seitch 종료

		return goodsList;
	}

	public void goodsOrder() {
		/*
		 * 1.판매중인 상품 목록 출력 (ORDERS(SELECT)) -전체상품목록, 종류별상품목록, 인기상품목록 2.구매할 상품 선택(상품코드
		 * 선택)
		 * 
		 * 3.구매 수량 입력(주문수량입력) -주문코드 생성 (ORDERS(SELECT)) 주문코드, 주문자아이디, 상품코드, 주문수량 4.주문
		 * 처리(Orders - INSERT) 후 결과 출력 --GOODS(UPDATE) -상품재고 수정 --ORDERS(INSERT)-주문정보 입력
		 */
		ArrayList<Goods> goodsList = getGoodsList();

		if (goodsList == null || goodsList.size() <= 0) {
			System.out.println("다시 선택해주세요.");
			return;
		}
		// 상품 목록 출력
		for (int i = 0; i < goodsList.size(); i++) {
			System.out.print("[" + i + "]" + goodsList.get(i).getGname() + ", 가격:" + goodsList.get(i).getGprice()
					+ "원, 재고" + goodsList.get(i).getGstock() + "개\n");
		}
		System.out.println("상품선택>>");
		int selectGoods = scan.nextInt();
		if(goodsList.get(selectGoods).getGstate().equals("N")) {
			System.out.println("판매중지된 상품입니다.");
			return;
		}
		Goods goods = goodsList.get(selectGoods);
		System.out.println(goods.getGname() + "[가격]" + goods.getGprice());
		System.out.println("상품을 선택했습니다");
		String odgcode = goods.getGcode();

		System.out.println("주문할 수량 입력>>");
		int odqty = scan.nextInt(); // 주문수량
		if (odqty > goods.getGstock()) {
			System.out.println("재고가 부족합니다.");
			System.out.println("다시 선택해주세요!");
			return;
		}
		// 주문자아이디(odmid) = 로그인아이디(loginId), 주문시간(oddate) = SYSDATE

		// 주문코드 생성 'O0001','O0002','O0003'
		/*
		 * 1.현재 주문코드 최대값 조회('A0001') --SELECT NVL(MAX(ODCODE),'O0001') FROM ORDERS
		 */
		String maxOdcode = shopdao.selectMaxOdcode();
		if (maxOdcode == null) {
			System.out.println("주문처리중에 문제가 발생했습니다.");
			System.out.println("다시 주문해주세요.");
			return;
		}
		System.out.println("maxOdcode : " + maxOdcode);
		// 'O0000' >> [0][1][2][3][4]
		String strCode = maxOdcode.substring(0, 1); // 'O'
		int numCode = Integer.parseInt(maxOdcode.substring(1)) + 1; // +1 을 함으로써 새로운 코드를 지정함.

		String odcode = strCode + String.format("%04d", numCode); // d라는 자리에 4자리 숫자형식으로 (0을 안쓰면 빈자리에 공백이 나옴.)
		/* %4d >> "0  1" || %04d >> "0001" */
		System.out.println("odcode : " + odcode);
		Order od = new Order();
		od.setOdcode(odcode);
		od.setOddate(odcode);
		od.setOdgcode(odgcode);
		od.setOdmid(loginId);
		od.setOdqty(odcode);
		int Odinsert = shopdao.InsertOdcode(odcode, odgcode, odqty, loginId);

		if (Odinsert > 0) {
			int Gdupdate = shopdao.UpdateGoods(odqty, odgcode);
			System.out.println("주문이 정상적으로 처리되었습니다.");
		} else {
			System.out.println("주문 실패하였습니다. 다시 시도해주십시오.");
		}

		// 주문처리 (ORDERS - INSERT , GOODS - UPDATE)

		/*
		 * 2.'A0000' >> 'A','0000'로 분리 3.'0000'을 숫자1로 변환 4. 숫자1에 +1 5. 숫자를 4자라의 '0000'
		 * 형식으로 변환 6. 'A' + '0002' >> 'A0002'
		 * 
		 * --SELECT 'O'||LPAD(NVL(SUBSTR(MAX(ODCODE,2),'0000')+1,4,0) FROM ORDERS
		 * 
		 */

	}

	public void orderList() { // 주문 내역
		System.out.println("[1]최신주문 순 [2]총 결제금액 순");
		System.out.print("선택>>");
		int inputNum = scan.nextInt();

		ArrayList<HashMap<String, String>> odList1 = shopdao.OrderList_oddate(loginId, inputNum);
		if (odList1 == null) {
			System.out.println("주문내역 조회 실패.");
			return;
		} else if (odList1.size() == 0) {
			System.out.println("주문내역이 없습니다.");
			return;
		}
		for (int i = 0; i < odList1.size(); i++) {
			System.out.println(
					"[" + i + "]" + "주문코드:" + odList1.get(i).get("ODCODE") + "상품이름:" + odList1.get(i).get("GNAME")
							+ "상품가격:" + odList1.get(i).get("GPRICE") + "주문수량:" + odList1.get(i).get("ODQTY") + "총액:"
							+ odList1.get(i).get("GPRICE * ODQTY") + "주문일시:" + odList1.get(i).get("ODDATE"));
		}
		System.out.println();

	}

	// Map으로 상품 목록 조회
	public void goodsList_Map() {
		System.out.println("[상품목록(Map)]");
		// 1. 상품목록 조회 (dao_SELECT >> service 리턴)
		ArrayList<HashMap<String, String>> goodsList = shopdao.selectGoods_Map();
		// 2. 조회된 상품목록 출력
		for (int i = 0; i < goodsList.size(); i++) {
			System.out.print(goodsList.get(i).get("GCODE") + " ");
			System.out.print(goodsList.get(i).get("GNAME") + " ");
			System.out.print(goodsList.get(i).get("GPRICE") + " ");
			System.out.print(goodsList.get(i).get("GTYPE") + " ");
			System.out.println(goodsList.get(i).get("GSTOCK") + " ");
		}
	}

	public void cancelOrder() { // 주문취소
		Order od = new Order();
		od.setOdmid(loginId);
		System.out.println("[주문취소]");
		ArrayList<Order> odList = shopdao.oList(od); // 내가 주문한
		if (odList == null) {
			System.out.println("주문내역이 없습니다.");
			return;
		} else {
			System.out.println("최근주문내역입니다.");
		}
		for (int i = 0; i < odList.size(); i++) {
			System.out
					.println("[" + i + "]" + "주문코드:" + odList.get(i).getOdcode() + "상품코드:" + odList.get(i).getOdgcode()
							+ "주문수량:" + odList.get(i).getOdqty() + "주문일시:" + odList.get(i).getOddate());
		}
		System.out.println();

		// 취소할 주문 선택
		System.out.println("취소할 상품코드를 선택해주세요.EX)[1] => 1");
		System.out.println("선택>>");
		int inputNum = scan.nextInt();
		Order setOdcode = odList.get(inputNum);
		String Odcode = setOdcode.getOdcode();
		if (inputNum > odList.size()) {
			System.out.println("상품 범위 내에서 골라주세요");
			return;
		}
		Order setOdqty = odList.get(inputNum);
		String Odqty = setOdqty.getOdqty();

		Order setOdgcode = odList.get(inputNum);
		String Odgcode = setOdgcode.getOdgcode();
		// ORDER테이블에 DELETE ODCODE
		int CancelOd = shopdao.Clist(od, Odcode);
		if (CancelOd > 0) {
			System.out.println("정상적으로 주문 취소되었습니다.");
		} else {
			System.out.println("주문 취소 오류");
		}
		// GOODS테이블에 UPDATE ODGCODE ODQTY
		int UpdateGD = shopdao.Upgoods(Odqty, Odgcode);
		if (UpdateGD > 0) {
			System.out.println("업데이트 완료");
		} else {
			System.out.println("업데이트 실패");
		}
	}

}
