package day0511;

public class EX01_User {
	/*접근제한자
	 * 1.public : 모든 패키지, 모든 클래스에서 접근 가능
	  			  클래스, 필드, 생성자, 메소드
	 * 2.private : 다른 클래스에서는 접근 불가능
	 				 필드, 생성자, 메소드
	 * 3.protected : 다른 패키지에 있는 클래스에서는 접근이 불가능 
	 				 자식 클래스에서는 접근이 가능
	 * 4.default : 다른 패키지에 있는 클래스에서는 접근이 불가능
	 			   
	 * */
	public int publicVal;
	private int privateVal;  
	
	void valPrint() {
		System.out.println(privateVal);//다른 클래스에서는 접근 불가능
		
	}
	
	protected int protectedVal;
	int defaultVal;
}
