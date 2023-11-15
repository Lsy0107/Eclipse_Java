package day0503;

import java.util.Scanner;

public class EX04 {

	public static void main(String[] args) {
		/*1. 과목수 배열 생성
		 *2. 성적을 입력
		 *3. 모든 과목의 성적 출력
		 *4. 성적분석 (총점, 평균, 최댓값, 최소값) */
		Scanner scan= new Scanner(System.in);
		boolean run = true;
		int[] scores = null; 
		int sum=0;
		int avg=0;
		boolean check = false;//2.성적 입력 기능으로 성적을 입력했으면 해제
		while (run) {
			//1. 메뉴 출력
			System.out.println("*********************************************");
			System.out.println("[1]과목수입력 [2]성적입력 [3]성적출력 [4]성적분석 [5]종료");
			System.out.println("*********************************************");
			System.out.print("메뉴선택>>");
			int selectMenu = scan.nextInt();
			if(selectMenu != 1 && scores == null) { // selectMenu의 값이 2,3,4 이면서 scores 배열이 null
				System.out.println("[1]과목수를 입력해주세요.");
				continue;
			}
			switch(selectMenu) {
			case 1://[1]과목수 입력
				System.out.print("과목수 입력>>");
				int size = scan.nextInt();
				scores = new int[size]; 
				check = false;
				break;
			case 2://[2]성적 입력
			
					for(int i=0; i < scores.length; i++) {
						System.out.print((i+1)+"번째 과목의 점수");
						scores[i] = scan.nextInt();
			}
				check = true;
				break;
			case 3://[3]성적 출력
				if (check) { // [3]성적 출력
					for(int i=0; i <scores.length; i++) {
						System.out.println((i+1)+"번째"+scores[i] +"점");
					}
				}else {// check : false >> 성적입력을 하지 않았으면
					System.out.println("[2]번을 먼저 입력해주세요.");
				}
				break;
			case 4://[4]성적 분석
				
					int max=scores[0];
					int min=scores[0];
					for (int i=0; i<scores.length; i++) {
						sum = sum + scores[i];
						avg = sum / scores.length;
						
						
						if (max < scores[i]) {
							max = scores[i];
						}if (min > scores[i]) {
							min = scores[i];
						}
					
					System.out.println("총점은"+ sum + "입니다.");
					System.out.println("평균은"+ avg + "입니다.");
					System.out.println("최대값은" + max +"입니다." );
					System.out.println("최소값은" + min +"입니다.");
					}
				break;
			default://[5]종료
				run = false;
				break;
			}	
		}
	}

}
