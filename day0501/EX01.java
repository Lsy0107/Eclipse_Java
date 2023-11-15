package day0501;

public class EX01 {

	public static void main(String[] args) {
		for (int i =2; i <=9; i++) {
			if (i > 7) {
				continue;
			}
			for(int j=1; j<=9; j++) {
				System.out.println(i+ "X"+ j +"=" + (i * j));
			}
			
		}

	}

}
