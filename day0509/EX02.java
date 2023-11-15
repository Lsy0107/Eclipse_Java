package day0509;

public class EX02 {

	public static void main(String[] args) {
		String[][] strArr = new String[2][3];
// 인덱스는 비어있고 행은 2줄, 열은 3줄
// |	|	 |	  |
// |	|	 |	  |		
		strArr[0][0] = "A";
//		strArr[0][3] = "A"; >>ArrayIndexOutOfBoundsException
		System.out.println(strArr.length);
		System.out.println(strArr[0].length);
		System.out.println(strArr[1].length);
		
		String[][] strArr2 = new String[3][]; //행 3개가 먼저 만들어지고 열운 나중에 채움.
// 행에만 번호가 써져있으면 오류 x
// [0]행
// [1]행
// [2]행	 
		System.out.println(strArr2.length);
//		System.out.println(strArr2[0].length);
		strArr2[0] = new String[2];
		strArr2[1] = new String[5];
		strArr2[1] = new String[3];
		System.out.println(strArr2[0].length);
		System.out.println(strArr2[1].length); 
// [0]행 |	|	|	
// [1]행 |	|	|	|	|	|
// [2]행		
		
		
		
		
		
		
		
		
		
	}

}
