package day0516;

import java.util.ArrayList;

public class EX01 {

	public static void main(String[] args) {
		Member[] memArr = new Member[10]; // 회원목록 배열
		Member member01 = new Member(); // 회원정보
		memArr[0] = member01; // 회원정보를 목록에 저장

		Member member02 = new Member();
		memArr[1] = member02;
		System.out.println("배열의 크기 :" + memArr.length);

		// ArrayList 회원목록
		ArrayList<Member> memList = new ArrayList<Member>();
		System.out.println("1_size :"+ memList.size());
		Member mem01 = new Member();
		mem01.setMid("id01");
		mem01.setMid("pw01");

		// 회원정보를 회원목록에 저장
		memList.add(mem01);
		System.out.println("2_size :" + memList.size());

		Member mem02 = new Member();
		mem02.setMid("id02");
		mem02.setMid("pw02");
		memList.add(mem02);
		System.out.println("3_size :" + memList.size());

		// 1번 회원정보 출력
		System.out.println(memList.get(0).getMid());

		// 2번 회원정보 출력
		System.out.println(memList.get(1).getMid());
		System.out.println("size :" + memList.size()); 
	}

}
