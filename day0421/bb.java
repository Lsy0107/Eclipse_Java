package day0421;

public class bb {

	public static void main(String[] args) {
		
		//시험점수
		//java, score, first
		int javaScore = 90; 
		char charVal = 'A';
		String strVal = "문자열변수";
		System.out.println(javaScore);
		System.out.println("javaScore");
		System.out.println(strVal);
		
		int oracleScore = 80;
		System.out.println(oracleScore);
		
		System.out.println("ㅁㄴㅇㅂㅈㄷㅁㄴㅇㅋㅌㅇㄴ");
		System.out.println("자바 점수:" + javaScore);
		System.out.println(javaScore + oracleScore);
		System.out.println("총점 :" + javaScore + oracleScore);
		//"총점 : 90" + 80 
		System.out.println("총점 :" + (javaScore + oracleScore));
	}

}
