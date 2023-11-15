package jdbcPhoneBook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PhoneBookDao {
	Connection getConnection() {
	Connection con = null;
	String url = "jdbc:oracle:thin:@//localhost:1521/xe";
	String userid = "LSY_DBA";
	String userpw = "1234";

	try {
		Class.forName("oracle.jdbc.OracleDriver");
		con = DriverManager.getConnection(url, userid, userpw);
	} catch (ClassNotFoundException e) { // 드라이버 예외
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) { // DB 예외
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return con;
	}
	public int insert(PhoneBook pb) { //PHONEBOOK 테이블 INSERT 수행
		// TODO Auto-generated method stub
		Connection con = getConnection();
		
		if (con == null) {
			System.out.println("DB 연결 실패");
			return 0;
		}
		//2. 쿼리문 실행
		String sql = "INSERT INTO PHONEBOOK(NAME,PHONENUM)" + " VALUES(?,?)";
		int result = 0; // 결과값 저장할 변수
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,pb.getName());
			pstmt.setString(2,pb.getPhonenum());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
		
	}
	public ArrayList<PhoneBook> select() {
		// TODO Auto-generated method stub
		//1.
		Connection con = getConnection();
		
		if (con == null) {
			System.out.println("DB 연결 실패");
			return null;
		}
		//2. 쿼리문 실행 결과값 반환
		String sql = "SELECT * FROM PHONEBOOK";
		ArrayList<PhoneBook> pbList = new ArrayList<PhoneBook>(); //결과값 저장할 변수
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql); //쿼리문 준비
			ResultSet rs = pstmt.executeQuery(); //쿼리문 실행 결과값 반환
			while(rs.next()) {	// ResultSet >> ArrayList 반환
				PhoneBook pb = new PhoneBook();
				pb.setName (rs.getString("NAME"));
				pb.setPhonenum (rs.getString(2));
				pbList.add(pb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pbList;
	}
	public ArrayList<PhoneBook> select_Name(String inputName) {
		Connection con = getConnection();
		if (con == null) {
			return null;
		}
		ArrayList<PhoneBook> pbList =new ArrayList<PhoneBook>();
		
		String sql = "SELECT * FROM PHONEBOOK WHERE NAME = ?";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,inputName);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				PhoneBook pb = new PhoneBook();
				pb.setName(rs.getString("NAME"));
				pb.setPhonenum(rs.getString(2));
				pbList.add(pb);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return pbList;
	}
	public int update(PhoneBook pb, String inputPhoneNum) {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		if(con == null) {
			return 0;
		}
		//쿼리문 실행 
		String sql = "UPDATE PHONEBOOK SET PHONENUM = ? WHERE NAME = ? AND PHONENUM = ?";
		int result = 0;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString (1, inputPhoneNum);
			pstmt.setString (2, pb.getName());
			pstmt.setString (3, pb.getPhonenum());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public int delete(PhoneBook pb) {
		Connection con = getConnection();
		if(con == null) {
			return 0;
		}
		//쿼리문
		String sql = "DELETE FROM PHONEBOOK WHERE NAME = ? AND PHONENUM = ?";
		int result = 0;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, pb.getName());
			pstmt.setString(2, pb.getPhonenum());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}


}
