package day0428;

public class EX_02 {

	public static void main(String[] args) {
		int i;
		for (i = 0; i<5; i++) {
			System.out.println("i=" + i);	
		}
		System.out.println("for문 종료");
		System.out.println("i="+i);
		
		System.out.println();
		//1~10 합 = 55
//		int sum = 0; // 총합을 저장할 변수
//		sum=sum+1;
//		sum=sum+2;
//		sum=sum+3;
//		sum=sum+4;
//		sum=sum+5;
//		sum=sum+6;
//		sum=sum+7;
//		sum=sum+8;
//		sum=sum+9;
//		sum=sum+10;
		int sum = 0;
		for(i=1; i<=10; i++) {
			System.out.println("i="+i);
			sum=sum+i;
		}
		System.out.println("총합은=" + sum);
		
	}
	// i= 1 .... i = 10

}
