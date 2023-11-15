package day0515;

import java.util.Scanner;

public class PhoneService {
	Scanner scan = new Scanner(System.in);
	PhoneBook[] pbList = new PhoneBook[5];
	
	public void showMenu() {
		/* 기능정의 클래스 */
		
		/*메뉴 출력 기능: showMenu()*/
		
		System.out.println("****************************");
		System.out.println("[1]등록 [2]검색 [3]수정 [4]삭제");
		System.out.println("****************************");
	}
	/*연락처 검색 기능 : searchInfo()
	 * -이름으로 연락처 검색
	 * -전화번호로 연락처 검색
	 * 검색된 연락처를 출력("이름 :","전화번호 :")*/
		public void searchInfo() {
			System.out.println("[1]<이름으로 검색>    [2]<전화번호로 검색>");
			System.out.println();
			int selectWay = scan.nextInt();
			int idx = -1;
			switch(selectWay) {
			case 1: //이름을 골랐을때
				System.out.print("이름을 입력해주세요!");
				String inputName = scan.next();
				for(int i=0; i<pbList.length; i++) {
					if(pbList[i] != null) {
					if(inputName.equals(pbList[i].getName())) {
						idx = i;
						System.out.println("이름 :"+pbList[i].getName()+"\n"+"전화번호 :"+pbList[i].getPhoneNum()  );
					break;
					}		
				}
				}
				if (idx == -1) {
					System.out.println("연락처를 찾을 수 없습니다.");
				}
				break;
				
			case 2: //전화번호를 골랐을때
				System.out.print("전화번호를 입력해주세요!");
				String inputNum = scan.next();
				idx = -1;
				for(int i=0; i<pbList.length; i++) {
					if(pbList[i] != null) {
					if(inputNum.equals(pbList[i].getPhoneNum())) {
						idx = i;
						System.out.println("이름 :"+pbList[i].getName()+"\n"+"전화번호 :"+pbList[i].getPhoneNum());
					break;
					}		
					}
				}
				if(idx == -1) {
					System.out.println("연락처를 찾을 수 없습니다.");
				}
				break;
			default :
				System.out.println("잘못된 메뉴입니다.");
			}
			
		}
	
	/*연락처 수정기능 : modifyInfo ()
	 * 1.수정할 연락처를 검색
	 * 2.연락처가 검색되었을 경우
	 *     ㄴ 이름을 수정
	 *     ㄴ 전화번호를 수정
	 * 3.검색되지 않을 경우
	 *     ㄴ "등록되지 않은 연락처입니다." 출력   */
		
		public void modifyInfo() {
			System.out.print("수정할 이름 검색 :");
			String inputUser = scan.next();
			int idx = -1;
			for(int i=0; i<pbList.length; i++) {
				idx = 0;
				if(inputUser.equals(pbList[i].getName())) {
					System.out.println("이름을 수정 :");
					String inputName = scan.next();
					System.out.println("전화번호를 수정");
					String inputNum = scan.next();
					pbList[i].setName(inputName);
					pbList[i].setPhoneNum(inputNum);
					System.out.println("["+inputName+"]"+"["+inputNum+"]으로"+"수정 되었습니다.");
					break;
				}
			}
			if (idx == -1) {
				System.out.println("등록되지 않은 연락처입니다.");
			}
				
		}

	/*연락처 삭제 기능: deleteInfo()
	 * 1.삭제할 연락처를 검색
	 * 2.연락처가 검색되었을 경우
	 *     ㄴ연락처를 삭제
	 * 3.검색되지 않았을 경우
	 *     ㄴ "등록되지 않은 연락처입니다." 출력  */
	
	public void deleteInfo() {
		System.out.println("삭제할 연락처를 검색 :");
		String deleteUser = scan.next();
		int idx = -1;
		for(int i=0; i<pbList.length; i++) {
			if(pbList[i] != null) {
			idx = 0;
			if(deleteUser.equals(pbList[i].getName())) {
				pbList[i] = null;
				System.out.println("연락처가 삭제되었습니다.");
				break;
			}
		}
		}	
		if (idx == -1) {
			System.out.println("등록되지 않은 연락처입니다.");
		}
	}
	
	
		
	
	/*연락처 저장 기능 : registInfo()*/
	
	public void registInfo() {
		System.out.println("[등록]");
		//pbList 비어있는 인덱스 조회
		int idx = -1;
		for(int i=0; i < pbList.length; i++) {
			if (pbList[i] == null) {
				idx = i;
				break;
			}
		}
		if(idx ==-1) {
			System.out.println("더이상 연락처를 저장할 수 없습니다.");
			System.out.println("연락처를 삭제 해주세요!");
			return;
		}
		System.out.println("이름입력 : ");
		String inputName = scan.next();
		System.out.println("번호입력 : ");
		String inputNum = scan.next();
		PhoneBook newInfo = new PhoneBook();
		newInfo.setName(inputName);
		newInfo.setPhoneNum(inputNum);
		//연락처 목록(pbList) 저장
		pbList[idx] = newInfo;
		System.out.println("새 연락처가 등록 되었습니다!");
		
		
	}
}
