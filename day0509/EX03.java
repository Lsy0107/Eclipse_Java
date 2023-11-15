package day0509;

public class EX03 {

	public static void main(String[] args) {
		String[][] strArr = {{"A","B","C"},
							{"D","E"},
							{"F","G","H","I"}};
		//0행의 모든 문자 출력
		System.out.println("0행");
		for(int i=0; i< strArr[0].length; i++) {
			System.out.println(strArr[0][i]);
		}
		System.out.println("1행");
		for(int i=0; i< strArr[1].length; i++) {
			System.out.println(strArr[1][i]);
		}
		System.out.println("2행");
		for(int i=0; i< strArr[2].length; i++) {
			System.out.println(strArr[2][i]);
		}
		System.out.println();
		for(int i=0; i<strArr.length; i++) {//행번호 반복 0~2
			System.out.println(i+"행");
			for(int j=0; j < strArr[i].length; j++) {//열번호 반복 
				System.out.println(strArr[i][j]);
			}
		}
	}

}
