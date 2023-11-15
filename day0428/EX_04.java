package day0428;

public class EX_04 {

	public static void main(String[] args) {
		
		for(int i=1; i<=10; i++) {
			//break; continue;
			//i가 5이면 중지
			if(i == 5) {
				break;
			}
			System.out.println("i=" + i);
	}
		System.out.println("");
		for(int i=1; i<=10; i++) {
		
			if(i == 5) {
				System.out.println("continue");
				
				continue;
			}
			System.out.println("i="+i);
		}
		
		}

	}

