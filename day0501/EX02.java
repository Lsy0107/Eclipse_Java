package day0501;

public class EX02 {

	public static void main(String[] args) {
		/*반복문 while*/
/*		while(반복조건) {
			반복 실행될 부분}*/
		
		System.out.println("for문 시작");
		for (int i =1; i<=5; i++) {
			System.out.print(i+" ");
		}
		System.out.println("\nfor문 종료");
		System.out.println("while문 시작");
		int j = 1;
		while(j <= 5) {
			System.out.print(j +" ");
			j++;
		}
		System.out.println("\nwhile문 종료");
		
		System.out.println();
		int k=5;
		while(true) {
			System.out.print(k + " ");
			k++;
			if(k >5) {
				break;
			}
		}
		System.out.println("\nwhile문 종료");
				
		
		int z=1;
		boolean run = true;
		while (run) {
			System.out.print(z+" ");
			z++;
			if (z >5) {
				run = false;
			}
		}
	}

}
