package day0511_1;

import day0511.EX01_User;

public class EX01_UserMain {

	public static void main(String[] args) {
		EX01_User user = new EX01_User();
		user.publicVal = 10; //접근 가능
//		user.privateVal = 10; //접근 불가능
//		user.protectedVal = 20; //접근 가능
//		user.defaultVal = 30; //접근 가능
	}

}
