package jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class SelectTest {

	public static void main(String[] args) {
		//CRUDTEST 테이블의 모든 데이터 조회(SELECT)
		Scanner scan = new Scanner(System.in);
		System.out.println("NUMTEST 입력>>");
		int inputNum = scan.nextInt();
		
		//1.DB 접속
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
		
		//2. 쿼리문 실행 및 변환값 반환
		String sql = "SELECT NUMTEST,CHARTEST, TO_CHAR(DATETEST,'YYYY-MM-DD')" +" FROM CRUDTEST"+" WHERE NUMTEST = ?";
		//결과값을 저장할 변수
		//VO 데이터가 저장만 수정 X
		//DTO 수정이 가능
		ArrayList<CrudDto> crudList = new ArrayList<CrudDto>();
		//where절
		CrudDto cruddto = null;
		
		
		try {
			//접속된 DB에 쿼리문 전송 준비
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, inputNum);
			//쿼리문 실행 및 결과 값 반환
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {	//행을 지정해주는 명령어 .next()
				CrudDto crud = new CrudDto();
				crud.setNumtest(rs.getInt(1)); //변수 타입에따라 다르게
				crud.setChartest(rs.getString("CHARTEST"));
				crud.setDatetest(rs.getString(3));
				crudList.add(crud);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//3.출력
		for(int i =0; i< crudList.size(); i++) {
			System.out.println(crudList.get(i).getNumtest());
			System.out.println(" "+crudList.get(i).getChartest());
			System.out.println(" "+crudList.get(i).getDatetest());
		}
	}

}
