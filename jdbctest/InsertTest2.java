package jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertTest2 {

	public static void main(String[] args) {
		//CRUDTEST 테이블이 새로운 데이터 입력
		//1. 사용자로부터 데이터 입력
		
		Scanner scan = new Scanner(System.in);
		System.out.print("숫자입력>>");
		int inputNum = scan.nextInt();
		System.out.print("문자입력>>");
		String inputStr = scan.next();
		System.out.print("날짜입력(yyyymmdd)>>");
		String inputDate = scan.next();
		
		//받은 데이터를 CRUDTEST 테이블에 INSERT 처리
		//2.DB 접속
		Connection con = null;
		String url = "jdbc:oracle:thin:@//localhost:1521/xe";
		String userid = "LSY_DBA";
		String userpw = "1234";		
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(url,userid,userpw);
		} catch (ClassNotFoundException e) { //드라이버 예외
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) { //DB 예외
		 	// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (con == null) {
			System.out.println("DB접속 실패");
		}else {
			System.out.println("DB접속 성공");
		}
		
		//3.쿼리문 실행 및 결과값 반환
		String sql = "INSERT INTO CRUDTEST(NUMTEST,CHARTEST,DATETEST)" + " VALUES(?,?,?)";
		
		int insertResult = 0; // insert 처리 결과값 저장
		
		try {	//접속된 DB 쿼리문 전송 준비
			con.setAutoCommit(false);
			PreparedStatement pstmt = con.prepareStatement(sql);
			//?자리에 값 입력
			pstmt.setInt(1,inputNum);
			pstmt.setString(2,inputStr);
			pstmt.setString(3,inputDate);
			
			//쿼리문 실행 및 경과 값 반환
			insertResult = pstmt.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("insertResult :" + insertResult);
		
		if(insertResult > 0) {
			System.out.println("입력성공");
		}else {
			System.out.println("입력실패");
		}
	}

}
