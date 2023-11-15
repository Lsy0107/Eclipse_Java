package day0512;

import java.util.Scanner;

import day0511.MemberInfo;

public class MemberService {
	/* 기능 정의 클래스 */
	Scanner scan = new Scanner(System.in);
	// 회원 목록
	Member[] memList = new Member[5];

	// 회원가입 기능 메소드
	public void memberJoin() {

		// 2.입력된 정보를 하나로 모으고
		// 3.회원목록에 저장(memberList 배열의 비어있는 인덱스에 저장)

		// 3. 회원 목록에 저장
		// memberList 배열의 비어있는 인덱스 검색
		int idx = -1;
		for (int i = 0; i < memList.length; i++) {
			if (memList[i] == null) {
				idx = i;
				break;
			}
		}
		if (idx == -1) {
			System.out.println("회원가입 할 수 없습니다");
			return;
		}
		// 회원가입 처리
		// 1.가입정보 입력받고

		// 아이디 중복확인 기능 메소드
		System.out.print("아이디 입력 :");
		String inputMid = scan.next();
		for (int i = 0; i < memList.length; i++) {
			if (memList[i] != null) {
				if (inputMid.equals(memList[i].getMid())) {
					System.out.println("중복된 아이디입니다.");
					return;
				}
			}
		}

		System.out.print("비밀번호 입력 :");
		String inputMpw = scan.next();
		System.out.print("이름 :");
		String inputName = scan.next();
		Member mem = new Member();
		mem.setMid(inputMid);
		mem.setMpw(inputMpw);
		mem.setMname(inputName);
		System.out.println();
		memList[idx] = mem;
		System.out.println("가입되었습니다.");

	}

	// 메뉴 출력 기능 메소드
	public void showMenu() {
		System.out.println("\n*********************");
		System.out.println("[1]회원가입 [2]로그인 [3]종료");
		System.out.println("*********************");
		System.out.print("메뉴선택 :");
	}

	// 로그인 기능 메소드
	public void memLogin() {
		System.out.print("아이디 입력:");
		String LoginId = scan.next();
		System.out.print("비밀번호 입력:");
		String LoginPw = scan.next();

//		int idx = -1;
		for (int i = 0; i < memList.length; i++) {
			if (LoginId.equals(memList[i].getMid()) && LoginPw.equals(memList[i].getMpw())) {
//					idx = i;
				System.out.println("로그인되었습니다.");
					break;
			}
//			if (idx > -1) {// 일치하는 회원이 있을 경우 "아이디" "비번" "이름" 출력
//				System.out.println("로그인 성공");
//				System.out.println("아이디 : "+memList[idx].getMid());
//				System.out.println("비밀번호 : "+memList[idx].getMpw());}
		
			 else {// 일치하는 회원이 없을 경우 "아이디/비번/이름" 출력
				System.out.println("아이디 또는 비번이 일치하지 않습니다.");
				break;
			}
		}
	}

}
