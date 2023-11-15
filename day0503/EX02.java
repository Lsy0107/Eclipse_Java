package day0503;

public class EX02 {

	public static void main(String[] args) {
		//80,88,90,78,100 scores
		int[] scores = {80,88,90,78,100};
//		System.out.println(scores[0]);
//		System.out.println(scores[1]);
//		System.out.println(scores[2]);
//		System.out.println(scores[3]);
//		System.out.println(scores[4]);
		for(int i=0; i <5; i++) {
			System.out.println(scores[i]);
		}
		//scores 배열에 90이 몇번 인덱스에 있는지를 출력
		for(int i=0; i < scores.length; i++) {
			if (scores[i] == 90  ) {
			System.out.println("90은 " + i +"번 인덱스에 있습니다.");
			scores[i] = 95; //scores[2] = 95;
			
			}
		}
		//scores 배열의 모든 값을 더한 총점. 평균 
		int sum =0;
		for(int i=0; i < scores.length; i++) {
			sum =sum + scores[i]; 
		}
		System.out.println("총점은" + sum  +"점입니다.");
		double avg = (double)sum/scores.length;
		System.out.println("평균은" + avg + "점입니다.");
	}
		

}
