package day0509;

public class EX01 {

	public static void main(String[] args) {
		
int [] [] scores2 = {{1,2,3},
					{4,5,6,7,8},
					{9,10}};
					
	System.out.println("scores2");
	System.out.println(scores2[0][0]);
	System.out.println(scores2[0][1]);
	System.out.println(scores2[0][2]);
	
	System.out.println("행의 개수 :"+scores2.length);
	System.out.println("0행의크기 :"+scores2[0].length);
	System.out.println("1행의크기 :"+scores2[1].length);
	System.out.println("2행의크기 :"+scores2[2].length);
	
	}

}
