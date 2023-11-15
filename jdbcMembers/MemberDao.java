package jdbcMembers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDao {
		Connection getConnection() {
		Connection con = null;
		String url = "jdbc:oracle:thin:@//localhost:1521/xe";
		String userid = "LSY_DBA";
		String userpw = "1234";
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(url, userid, userpw);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
		}
	public int insert(Member mb) {
		Connection con = getConnection();
		
		if(con == null) {
			System.out.println("DB연결 실패");
		}else {
			System.out.println("DB연결 성공");
		}
		String sql = "INSERT INTO MEMBERS(MID,MPW,MNAME,MPHONE,MBIRTH) VALUES (?,?,?,?,?)";
		int result = 0;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,mb.getMid());//?채워야 하는데
			pstmt.setString(2,mb.getMpw());
			pstmt.setString(3,mb.getMname());
			pstmt.setString(4,mb.getMphone());
			pstmt.setString(5,mb.getMbirth());
			result = pstmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public String select_idCheck(String inputmid) {
		Connection con = getConnection();
		
		if(con == null) {
			System.out.println("DB연결 실패");
			return null;
		}
		String sql = "SELECT MID FROM MEMBERS WHERE MID = ?";
		String idCheck = null;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,inputmid);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				idCheck = rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return idCheck;
	}
	public Member select_login(String inputMid, String inputMpw) {
		Connection con = getConnection();
		
		if(con == null) {
			System.out.println("DB연결 실패");
			return null;
		}
		String sql = "SELECT MID FROM MEMBERS WHERE MID = ? AND MPW = ?";
		Member loginMember = null;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,inputMid);
			pstmt.setString(2,inputMpw);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				loginMember = new Member();
				loginMember.setMid(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return loginMember;
	}

}
