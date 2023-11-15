package day0428;

public class EX01_FOR {

	public static void main(String[] args) {
		/* 반복문 - for문 */
		//    초기화 식  /  조건식  / 증감식 i=i+1
//		for (int i = 0; i < 10; i++) {
		//	i가 10보다 작으면 반복 실횅
			
//		}
		
		System.out.println("for문 시작");
		for (int i = 0; i<5; i++) {
			System.out.println("i=" + i);
			/*
			 * 1. int i=0 초기화 식
			 * 2. i<5; 조건 확인
			 * 3. System.out.println("i=" + i); 실행
			 * 4. i++ 증가식 실행 i:0 >> i:1
			 * 5. i<5; 조건 확인
			 * 6. System.out.println("i=" + i); 실행
			 * 7. i++ 증가식 실행 i:1 >> i:2
			 * ...위 과정을 반복
			 * ...i<5; 조건 확인 :: false이면 반복문 종료
			 * */
		}
		System.out.println("for문 종료");
		
		System.out.println();
		for(int i=1; i<=10; i++) {
			System.out.println("i=" + i);
		}
		// i = 1 ... 1 = 10
	}

}
