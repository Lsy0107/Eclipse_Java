package day0510;

public class EX03_MethodMain {

	public static void main(String[] args) {
		EX03_Method obj01 = new EX03_Method();
//		voidMethod() 호출
		obj01.voidMethod();
//		intMethod() 호출
		int result =0;
		System.out.println("result : " + result);
		result =obj01.intMethod();
		System.out.println("result : " + result);
		
//		obj01의 intVal 값 출력
		System.out.println("intVal : " + obj01.intVal);
//		obj01의 plusOne() 호출
		obj01.plusOne();
		obj01.plusOne();
		obj01.plusOne();
		System.out.println("intVal : " + obj01.intVal);
//		int resultVal = obj01.plusTwo();
		obj01.plusTwo();
		System.out.println(obj01.plusTwo());
				
	}

}

