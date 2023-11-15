package day0510;

public class EX03_Method {
//	int intVal;
//	String strVal;
	
	public EX03_Method() {
		
		
	}
// void : 리턴값이 없는 메소드
// 타입 : 해당 타입의 값을 리턴하는 메소드	
// 메소드타입 메소드이름(매개변수1,매개변수2....){

// }
	void voidMethod() {
		System.out.println("voidMethod() 호출");
	}
	int intMethod() { //리턴해줄 값을 지정해줘야 함
		System.out.println("intMethod() 호출");
		return 10;
		
	}
	
	int intVal;
	String strVal;
	
	void plusOne() {
		System.out.println("intVal값을 1증가");
		intVal++;
		
		
	}
	int plusTwo() {
		System.out.println("intVal값을 2 증가");
		intVal = intVal +2;
		return intVal;
	}
}
