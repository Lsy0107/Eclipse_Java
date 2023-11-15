package day0510;

public class EX01_Constructor {
	
	int number; //번호
	String name; //이름
	
	//기본 생성자
	public EX01_Constructor() {
		System.out.println("기본생성자 호츌");
	}
	//생성자 - 매개변수가 1개인 생성자
	public EX01_Constructor(int num) {
		System.out.println("매개변수가 1개인 생성자 호출");
		System.out.println("num : "+num);
	}
	//생성자 - 매개변수가 2개인 생성자 
	public EX01_Constructor(int num,int num2) {
		System.out.println("매개변수가 2개인 생성자 호출");
		System.out.println("num : "+num);
		System.out.println("num2 : "+num2);
		
	}
	//생성자 - 매개변수가 2개인 생성자
	public EX01_Constructor(int num,String str) {
		System.out.println("매개변수가 2개인 생성자 호출");
		System.out.println("num : "+num);
		System.out.println("num2 : "+str);
	}
}
