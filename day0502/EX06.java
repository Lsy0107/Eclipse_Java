package day0502;

public class EX06 {

	public static void main(String[] args) {
		/* 배열 Array 		  		  		 
		 * 타입 이름 = 값;
		 * */
		int num = 10;
		num = 20;
		System.out.println(num);
		
		
		
//배열 선언
// 타입[] 이름 = {값1,값2 };
// 타입 이름[] = {값1,값2 };
		int[] arrNumber = {10,20};
		int arrNumber2 [] = {10,20};
		
		int[] menuCount = {3,5,4};
		System.out.println(menuCount[0]); //몇 번째 배열을 쓰느냐에 따라 결과가 달라짐
		System.out.println(menuCount[1]);// 배열의 첫번째 값 쓰려면 [0]
		System.out.println(menuCount[2]);
//		System.out.println(menuCount[3]);
		System.out.println(menuCount.length);
		
		System.out.println("for");
		for (int i=0; i <menuCount.length; i++) {
			System.out.println(menuCount[i]);
		}
	}

}
