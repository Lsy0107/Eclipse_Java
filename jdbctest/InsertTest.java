package jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTest {

	public static void main(String[] args) {
		System.out.println("INSERT 테스트");
		Connection con = null;//접속 정보 저장
		
		//1.DB접속 (DB접속 상태 확인)
		String url = "jdbc:oracle:thin:@//localhost:1521/xe"; //접속할 DB 아이피 및 포트
		String userid = "LSY_DBA"; // 접속할 DB의 아이디
		String userpw = "1234"; // 접속할 DB의 비밀번호
		try {
			Class.forName("oracle.jdbc.OracleDriver"); // 드라이버선언
			con = DriverManager.getConnection(url,userid,userpw);
		} catch (ClassNotFoundException e) { //드라이버 예외
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("드라이버 예외");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("DB 예외");
		}
		System.out.println("conn :" + con);
		if(con != null) {
			System.out.println("DB 접속");
		}else {
			System.out.println("DB접속 실패");
		}
		
		//2. 실행할 쿼리문 전송 및 결과값 반환
		String sql = "INSERT INTO CRUDTEST(NUMTEST, CHARTEST, DATETEST)" + " VALUES(100,'테스트1',SYSDATE)";
		int insertResult = 0;
		try {
			con.setAutoCommit(false);
			// 접속된 DB에 쿼리문 전송 준비
			PreparedStatement pstmt = con.prepareStatement(sql);
			// DB에서 쿼리문 실행
			insertResult = pstmt.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (insertResult >0) {
			System.out.println("insert 성공");
		}else {
			System.out.println("insert 실패");
		}
	}

}
