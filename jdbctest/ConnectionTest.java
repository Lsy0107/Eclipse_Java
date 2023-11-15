package jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionTest {

	public static void main(String[] args) {
		System.out.println("접속테스트");
		String url = "jdbc:oracle:thin:@//localhost:1521/xe";
		String userid = "LSY_DBA"; //DB아이디
		String userpw = "1234"; //DB비밀번호
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Connection con = DriverManager.getConnection(url,userid,userpw);
			System.out.println("DB 접속 성공");
			
			//쿼리문 작성
			String sql = "SELECT * FROM EMP";
			String sql2 = "INSERT,UPDATE,DELETE";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			int result = pstmt.executeUpdate();
			//rs.next() >> 레코드의 위치를 다음으로 이동
			while(rs.next()) {
				System.out.println(rs.getString(1)+" "+rs.getString(2));
			}
			rs.close();
			pstmt.close();
			con.close();
			
			
		} catch (ClassNotFoundException e) {
			
			System.out.println("드라이버 Exception");
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			System.out.println("DB Exception");
			
			e.printStackTrace();
		} 
		

	}

}
