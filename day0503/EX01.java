package day0503;

public class EX01 {

	public static void main(String[] args) {
		/* 배열 */
		/* 같은 타입의 데이터를 하나의 변수에 저장하는 구조*/
//		타입[] 배열이름 = {값1, 값2}
		int[] numbers = {11,12,13,14,15};
//      |11|12|13|14|15|
//	idx |0 |1 |2 |3 |4 |			
		System.out.println("numbers[0]:" + numbers[0]);//11출력
		int[] numArr1 = new int [5]; //크기가 5인 int타입의 배열을 선언 		
//		|  |  |  |  |  | 데이터가 들어갈 공간만 미리 만들어 놓음
//	idx	|0 |1 |2 |3 |4 |		
		System.out.println("numArr1[0]:" + numArr1[0]);//0출력
		numArr1[0] = 100;
		numArr1[1] = 200;
		System.out.println("배열의 크기 :"+ numArr1.length);
	}

}
