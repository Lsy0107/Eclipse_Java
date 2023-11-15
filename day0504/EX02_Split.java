package day0504;

public class EX02_Split {

	public static void main(String[] args) {
		String[] menuList= {"아메리카노:2000",
							"바닐라라떼:3500",
							"아이스티:3000"};
		String[] menuInfo = menuList[0].split(":");//아메리카노 , 2000
		String menuName = menuInfo[0];
		String menuPrice = menuInfo[1];
		int price = Integer.parseInt(menuPrice);// 2000 >> 2000
		
		System.out.println(menuList[0]);
		System.out.println("메뉴명:" + menuName);
		System.out.println("가격:" +price);
		
		String strVal = "010-2819-3627";// "010" "2819" "3627"
		String[] splitResult = strVal.split("-");
		System.out.println(splitResult[0]);
		System.out.println(splitResult[1]);
		System.out.println(splitResult[2]);
		
	}

}
