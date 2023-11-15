package day0511;

public class EX02_MemerMain {

	public static void main(String[] args) {
		EX02_Member memInfo = new EX02_Member("LSY","0107");
//		System.out.println(memInfo.id);
//		String userId = memInfo.id;
		String myId = memInfo.getId();
		System.out.println(myId);
		memInfo.setId( "LSY0107" );
	}

}
