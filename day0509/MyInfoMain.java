package day0509;

public class MyInfoMain {

	public static void main(String[] args) {
		int score = 100;
		int score2 = 90;
		System.out.println(score);
		String str = "B";
		System.out.println(str);
		MyInfo info01 = new MyInfo();
//		info01의 필드값 사용
		System.out.println(info01.name);
		System.out.println(info01.age);
//		info01의 printMyInfo() 호출	
		info01.printMyInfo();

//		info01의 name필드에 이름 저장	
		System.out.println("필드값 저장");
		info01.age = 23;
		System.out.println(info01.age);
		
		MyInfo info02 = new MyInfo();
		info01.printMyInfo();
		info02.printMyInfo();
		
		
	}
	
}
