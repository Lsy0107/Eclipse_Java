package day0511;

public class EX01_UserMain {

	public static void main(String[] args) {
		EX01_User user = new EX01_User();
		user.publicVal = 10; //접근 가능
//		user.privateVal = 10; //접근 불가능
		user.protectedVal = 20; //접근 가능
		user.defaultVal = 30; //접근 가능
	}

}
