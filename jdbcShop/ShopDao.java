package jdbcShop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class ShopDao {
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

	public int MemberJoin(Member mb) {
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
			result = pstmt.executeUpdate();
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
			pstmt.setString(1, inputmid);
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

	public Member selelct_loginMem(String inputmid, String inputmpw) {
		Connection con = getConnection();

		if(con == null) {
			System.out.println("DB연결 실패");
		}else {
			System.out.println("DB연결 성공");
		}
		String sql = "SELECT MID, MSTATE FROM MEMBERS WHERE MID = ? AND MPW = ?";
		Member loginMember = null;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,inputmid);
			pstmt.setString(2, inputmpw);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				loginMember = new Member();
				loginMember.setMid(rs.getString(1));
				loginMember.setMstate(rs.getString(2));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return loginMember;
	}

	public Member select_Memberinfo(String loginId) {
		Connection con = getConnection();

		if(con == null) {
			System.out.println("DB연결 실패");
		}else {
			System.out.println("DB연결 성공");
		}
		String sql = "SELECT MID,MPW,MNAME,MPHONE,TO_CHAR(MBIRTH,'YYYY-MM-DD') FROM MEMBERS WHERE MID = ?";
		Member mem = null;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, loginId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				mem = new Member();
				mem.setMid(rs.getString(1));
				mem.setMpw(rs.getString(2)); 
				mem.setMname(rs.getString(3));
				mem.setMphone(rs.getString(4));
				mem.setMbirth(rs.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mem;
	}

	public ArrayList<Goods> selectGoods_All() {
		Connection con = getConnection();

		if(con == null) {
			System.out.println("DB연결 실패");
		}else {
			System.out.println("DB연결 성공");
		}
		String sql = "SELECT * FROM GOODS WHERE GSTOCK > 0";
		ArrayList<Goods> gdList = new ArrayList<Goods>();
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
				gd.setGstate(rs.getString(6));
				gdList.add(gd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gdList;
	}

	public ArrayList<Goods> selectGoods_Type() {
		Connection con = getConnection();

		if(con == null) {
			System.out.println("DB연결 실패");
		}else {
			System.out.println("DB연결 성공");
		}
		String sql = "SELECT GTYPE FROM GOODS GROUP BY GTYPE";
		ArrayList <Goods> gtypeList = new ArrayList<Goods>();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Goods gd = new Goods();
				gd.setGtype(rs.getString(1));
				
				gtypeList.add(gd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gtypeList;
	}

	public ArrayList<Goods> selectGoods_Best() {
		Connection con = getConnection();

		if(con == null) {
			System.out.println("DB연결 실패");
		}else {
			System.out.println("DB연결 성공");
		}
		String sql = "SELECT * FROM GOODS GD INNER JOIN (SELECT ODGCODE,SUM(ODQTY) AS TOTAL FROM ORDERS GROUP BY ODGCODE) OD ON GD.GCODE=OD.ODGCODE ORDER BY OD.TOTAL DESC";
		ArrayList<Goods> goodsList = new ArrayList<Goods>();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Goods odr= new Goods();
				odr.setGcode(rs.getString(1));
				odr.setGname(rs.getString(2));
				odr.setGprice(rs.getInt(3));
				odr.setGtype(rs.getString(4));
				odr.setGstock(rs.getInt(5));
				odr.setGstate(rs.getString(6));
				goodsList.add(odr);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return goodsList;
	}


	public String selectMaxOdcode() {
		Connection con = getConnection();

		if(con == null) {
			System.out.println("DB연결 실패");
		}else {
			System.out.println("DB연결 성공");
		}
		String sql = "SELECT NVL(MAX(ODCODE),'O0000') FROM ORDERS";
		String maxOdcode = null;
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				maxOdcode = rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return maxOdcode;
	}

	public int InsertOdcode(String odcode,String odgcode,int qty,String loginId) {
		Connection con = getConnection();

		if(con == null) {
			System.out.println("DB연결 실패");
		}else {
			System.out.println("DB연결 성공");
		}
		String sql = "INSERT INTO ORDERS(ODCODE,ODMID,ODGCODE,ODQTY,ODDATE) VALUES(?,?,?,?,SYSDATE)";
		int result = 0;

		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, odcode);
			pstmt.setString(2, loginId);
			pstmt.setString(3, odgcode);
			pstmt.setInt(4, qty);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
	}

	public int UpdateGoods(int odqty,String odgcode) {
		Connection con = getConnection();

		if(con == null) {
			System.out.println("DB연결 실패");
		}else {
			System.out.println("DB연결 성공");
		}
		String sql = "UPDATE GOODS SET GSTOCK = GSTOCK - ? WHERE GCODE = ?";
		int result = 0;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, odqty);
			pstmt.setString(2, odgcode);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
	}

	public ArrayList<HashMap<String, String>> OrderList_oddate(String loginId,int inputNum) {// ---------------------------주문내역 조회 최신순
		Connection con = getConnection();

		if(con == null) {
			System.out.println("DB연결 실패");
		}else {
			System.out.println("DB연결 성공");
		}
		String sql = "SELECT OD.ODCODE,GD.GNAME,GD.GPRICE,OD.ODQTY,(GD.GPRICE * OD.ODQTY),OD.ODDATE FROM ORDERS OD, GOODS GD WHERE OD.ODGCODE=GD.GCODE AND ODMID = ?";
		if(inputNum == 1) {
			sql += "ORDER BY OD.ODDATE DESC";
		}else {
			sql += "ORDER BY GD.GPRICE * OD.ODQTY DESC";
		}
		
		ArrayList<HashMap<String,String>> List = new ArrayList<HashMap<String,String>>();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,loginId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				HashMap<String,String> ods = new HashMap<String,String>();
				ods.put("ODCODE", rs.getString("ODCODE"));
				ods.put("GNAME", rs.getString(2));
				ods.put("GPRICE", rs.getString(3));
				ods.put("ODQTY", rs.getString(4));
				ods.put("GPRICE * ODQTY", rs.getString(5));
				ods.put("ODDATE", rs.getString(6));
				List.add(ods);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return List;
	}
	

	
	
	
	public ArrayList<Goods> selectGoods_Type(String gtype) {//---------------종류별
		Connection con = getConnection();

		if(con == null) {
			System.out.println("DB연결 실패");
		}else {
			System.out.println("DB연결 성공");
		}
		String sql = "SELECT * FROM GOODS WHERE GTYPE = ?";
		ArrayList<Goods> typeResult = new ArrayList<Goods>();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, gtype);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Goods Gt = new Goods();
				Gt.setGcode(rs.getString(1));
				Gt.setGname(rs.getString(2));
				Gt.setGprice(rs.getInt(3));
				Gt.setGtype(rs.getString(4));
				Gt.setGstock(rs.getInt(5));
				Gt.setGstate(rs.getString(6));
				typeResult.add(Gt);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return typeResult;
	}

	//상품목록 조회(Map)
	public ArrayList<HashMap<String, String>> selectGoods_Map() {
		Connection con = getConnection();

		if(con == null) {
			System.out.println("DB연결 실패");
		}else {
			System.out.println("DB연결 성공");
		}
		String sql = "SELECT * FROM GOODS";
		ArrayList<HashMap<String,String>> goodsList = new ArrayList<HashMap<String,String>>();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				HashMap<String,String> goods = new HashMap<String,String>();
				goods.put("GCODE", rs.getString("GCODE"));
				goods.put("GNAME", rs.getString("GNAME"));
				goods.put("GPRICE", rs.getString("GPRICE"));
				goods.put("GTYPE", rs.getString("GTYPE"));
				goods.put("GSTOCK", rs.getString("GSTOCK"));
				goodsList.add(goods);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return goodsList;
	}

	public int selectCountOrder(String loginId) {//-------------------총주문 수량
		Connection con = getConnection();

		if(con == null) {
			System.out.println("DB연결 실패");
		}else {
			System.out.println("DB연결 성공");
		}
		String sql = "SELECT COUNT(*) FROM ORDERS WHERE ODMID = ?";
		int orderCount = 0;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, loginId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				orderCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return orderCount;
	}

	public int selectTotalPrice(String loginId) {//------------------주문금액 합계
		Connection con = getConnection();

		if(con == null) {
			System.out.println("DB연결 실패");
		}else {
			System.out.println("DB연결 성공");
		}
		String sql = "SELECT SUM(GD.GPRICE * OD.ODQTY) FROM ORDERS OD, GOODS GD WHERE(OD.ODGCODE = GD.GCODE) AND (OD.ODMID = ?)";
		int totalResult = 0;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, loginId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				totalResult = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return totalResult;
	}

	public ArrayList<Order> oList(Order od) { //===========주문취소 ==============================
		Connection con = getConnection();

		if(con == null) {
			System.out.println("DB연결 실패");
		}else {
			System.out.println("DB연결 성공");
		}
		String sql = "SELECT ODCODE,ODGCODE,ODQTY,ODDATE FROM ORDERS WHERE ODMID = ? ORDER BY ODCODE";
		ArrayList<Order> ods = new ArrayList<Order>();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, od.getOdmid());
			ResultSet rs =pstmt.executeQuery();
			while (rs.next()) {
				Order O = new Order();
				O.setOdcode(rs.getString(1));
				O.setOdgcode(rs.getString(2));
				O.setOdqty(rs.getString(3));
				O.setOddate(rs.getString(4));
				ods.add(O);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ods;
	}

	public int Clist(Order od, String Odcode) {//=================주문 취소
		Connection con = getConnection();

		if(con == null) {
			System.out.println("DB연결 실패");
		}else {
			System.out.println("DB연결 성공");
		}
		String sql = "DELETE FROM ORDERS WHERE ODCODE = ?";
		int Cancelresult = 0;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, Odcode);
			Cancelresult = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Cancelresult;
	}

	public int Upgoods(String odqty, String odgcode) {//===============상품테이블 업데이트
		Connection con = getConnection();

		if(con == null) {
			System.out.println("DB연결 실패");
		}else {
			System.out.println("DB연결 성공");
		}
		String sql = "UPDATE GOODS SET GSTOCK = GSTOCK + ? WHERE GCODE = ?";
		int UpdateResult = 0;
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, odqty);
			pstmt.setString(2, odgcode);
			UpdateResult = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return UpdateResult;
	}


	}

