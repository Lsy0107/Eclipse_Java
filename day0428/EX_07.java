package day0428;



public class EX_07 {

	public static void main(String[] args) {
		/*1. 1~30번 까지의 학생
		 *2. 짝수번 학생, 홀수번 학생
		 *3. 짝수: 통새우 와퍼세트 9700원 
		 *   홀수: 와퍼세트 8900원
		 *   5의 배수인 학생의 경우 와퍼주니어세트 6600원
		 *4. 통새우 와퍼세트의 총액
		     와퍼세트의 총액
		 */
		int aset=0;
		int bset=0;
		int cset=0;
		for(int i=1; i <=30; i++) { // 1~30번 학생
			if(i%2 ==0 && i%5 !=0) { // 짝수번호 학생의 경우
				aset = aset + 9700;
				continue;
			}else if(i%2 != 0 && i%5 !=0){ // 홀수번호 학생인 경우
				bset = bset + 8900;
				
			}else if(i%5 ==0) {
				cset = cset + 6600;
				
			}
			
		}
		System.out.println("통새우 와퍼세트:" + aset);
		System.out.println("와퍼세트:" + bset);
		System.out.println("와퍼주니어세트:" + cset);
	}
	

}
