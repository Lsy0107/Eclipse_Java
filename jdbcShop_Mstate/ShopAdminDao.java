package jdbcShop_Mstate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class ShopAdminDao {
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

	public ArrayList<Member> select_meminfo() {
		Connection con = getConnection();

		if (con == null) {
			System.out.println("DB연결 실패");
		} else {
			System.out.println("DB연결 성공");
		}
		String sql = "SELECT * FROM MEMBERS";
		ArrayList<Member> meminfo = new ArrayList<Member>(); 
		try {
			PreparedStatement pstmt = con.prepareCall(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Member Info = new Member();
				Info.setMid(rs.getString(1));
				Info.setMpw(rs.getString(2));
				Info.setMname(rs.getString(3));
				Info.setMphone(rs.getString(4));
				Info.setMbirth(rs.getString(5));
				Info.setMstate(rs.getString(6));
				meminfo.add(Info);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return meminfo;
	}

	private Object getString(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	public int selectCountOrder() {
		Connection con = getConnection();

		if (con == null) {
			System.out.println("DB연결 실패");
		} else {
			System.out.println("DB연결 성공");
		}
		String sql = "SELECT COUNT(*) FROM ORDERS";
		int Countresult = 0;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Countresult = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Countresult;
	}

	public int selectTotalPrice() {
		Connection con = getConnection();

		if (con == null) {
			System.out.println("DB연결 실패");
		} else {
			System.out.println("DB연결 성공");
		}
		String sql ="SELECT SUM(ODQTY*GPRICE) FROM ORDERS OD, GOODS GD WHERE OD.ODGCODE = GD.GCODE";
		int totalresult = 0;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				totalresult = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return totalresult;
	}

	public int select_mstate(String Mid,int stateNum) {
		Connection con = getConnection();

		if (con == null) {
			System.out.println("DB연결 실패");
		} else {
			System.out.println("DB연결 성공");
		}
		String sql = "UPDATE MEMBERS";
		if(stateNum == 1) {
			sql += " SET MSTATE = 'N' WHERE MID = ?";
		}else if (stateNum == 2) {
			sql += " SET MSTATE = 'Y' WHERE MID = ?";
		}
		int mresult = 0;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, Mid);
			mresult = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mresult;
	}

	public ArrayList<Goods> select_GoodsList() {
		Connection con = getConnection();

		if (con == null) {
			System.out.println("DB연결 실패");
		} else {
			System.out.println("DB연결 성공");
		}
		String sql = "SELECT * FROM GOODS";
		ArrayList<Goods> selectResult = new ArrayList<Goods>();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Goods gd = new Goods();
				gd.setGcode(rs.getString(1));
				gd.setGname(rs.getString(2));
				gd.setGprice(rs.getInt(3));
				gd.setGtype(rs.getString(4));
				gd.setGstock(rs.getInt(5));
				gd.setGstste(rs.getString(6));
				selectResult.add(gd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return selectResult;
	}

	public int update_goodsN(String Gcode) {//------------상태를 N으로
		Connection con = getConnection();

		if (con == null) {
			System.out.println("DB연결 실패");
		} else {
			System.out.println("DB연결 성공");
		}
		String sql = "UPDATE GOODS SET GSTATE = 'N' WHERE GCODE = ?";
		int Nresult = 0;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, Gcode);
			Nresult = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Nresult;
	}

	public int update_goodsY(String Gcode) {//--------------상태를 Y로
		Connection con = getConnection();

		if (con == null) {
			System.out.println("DB연결 실패");
		} else {
			System.out.println("DB연결 성공");
		}
		String sql ="UPDATE GOODS SET GSTATE = 'Y' WHERE GCODE = ?";
		int Yresult = 0;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, Gcode);
			Yresult = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Yresult;
	}

}
