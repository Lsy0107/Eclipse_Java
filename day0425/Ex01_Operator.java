package day0425;

public class Ex01_Operator {

	public static void main(String[] args) {
		/* 연산자 */
		// +, -, *, /, %
		int number1; //int타입의 number1 선언
		number1 = 10; //number1을 10으로 초기화
		//10을 number1으로 대입
		number1 = 20;
		number1 = 30;
		
		int number2 = 2;
		int number3 = 3;
		
		number2 = 20;
		number3 = number3 +30;
//      1. number3 + 30 >> 3+30 >> 33
//		2. number3 =33;
		System.out.println(number2);//20
		System.out.println(number3);//33
		
		int score = 80;
		int result;
		result = score + 10;
		System.out.println("덧셈결과 : " + result);
		result = score -20;
		System.out.println("뺄셈 결과 :" + result);
		
		result = score *30;
		System.out.println("곱셈결과 :" + result);
		
		result = score /40;
		System.out.println("나눗셈결과 :" + result);
		
		result = score %50;
		System.out.println("나머지결과 :" + result);
		
		
	}

}
