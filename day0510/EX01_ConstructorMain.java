package day0510;

public class EX01_ConstructorMain {

	public static void main(String[] args) {
		
		EX01_Constructor obj01 = new EX01_Constructor();
		System.out.println(obj01.name);
		System.out.println(obj01.number);

		//매개변수가 1개인 생성자로 obj02 생성
		EX01_Constructor obj02 = new EX01_Constructor(20);
		//매개변수가 2개인 생성자로 obj03 생성
		int num = 100;
		int num2=20;
		EX01_Constructor obj03 = new EX01_Constructor(num2,num);
		EX01_Constructor obj04 = new EX01_Constructor(100,"ABC");
		
	}

}


  
