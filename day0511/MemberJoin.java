package day0511;

import java.util.Scanner;

public class MemberJoin {

	public static void main(String[] args) {
		//회원 정보들을 저장할 배열 (회원 5명)
		MemberInfo[] memList = new MemberInfo[5];
		Scanner scan = new Scanner(System.in);
		//1번 회원이 가입하면 1번 회원 정보를 저장
		//회원가입
		//1.가입정보를 입력
		//2.입력된 정보를 MemberInfo의 객체에 저장
		System.out.print("아이디 입력 : ");
		String inputMid =scan.next();
		System.out.print("비번 입력 : ");
		String inputMpw =scan.next();
		System.out.print("이름 입력 : ");
		String inputMname =scan.next();
		System.out.print("전화번호 입력 : ");
		String inputMphone =scan.next();
		
		//2.입력된 정보를 MemberInfo의 객체에 저장
		MemberInfo mem01 = new MemberInfo(inputMid,inputMpw,inputMname,inputMphone);
/*		mem01.setMid(inputMid); //mid 필드에 입력한 아이디 저장
		mem01.setMpw(inputMpw);
		mem01.setMname(inputMname);
		mem01.setMphone(inputMphone);*/
			
		//3.memList배열에 0번 인덱스에 저장
		memList[0] = mem01;
		
		//4.memList배열의 0번 인덱스에 있는 회원 정보 출력
		System.out.println("아이디 : " + memList[0].getMid());
		System.out.println("비밀번호 : " + memList[0].getMpw());
		System.out.println("이름 : "+memList[0].getMname());
		System.out.println("전화번호 : "+memList[0].getMphone());
		
		//5. 2번회원 가입 >> 가입할 아이디 입력 >> 중복확인  
		System.out.println("가입할 아이디 : ");
		
		inputMid = scan.next();
		boolean idCheck = true;
		
		for(int i=0; i<memList.length; i++ ) {
			if(memList[i] != null) {
				if (memList[i].getMid().equals(inputMid)) {
					idCheck = false;
				}
			}
		}
		if (idCheck) {
			System.out.println("사용 가능한 아이디입니다.");
		}else {
			System.out.println("중복된 아이디입니다.");
		}
		
	}

}
