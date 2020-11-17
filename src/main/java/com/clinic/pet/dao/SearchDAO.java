//package com.clinic.pet.dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.util.ArrayList;
//
//import com.clinic.pet.dto.PetClinicSearchVO;
//import com.clinic.pet.util.DBManager_vet;
//
//public class SearchDAO {
//	
//
//	public SearchDAO() {
//		
//	}
//
//	private static SearchDAO instance = new SearchDAO();
//
//	public static SearchDAO getInstance() {
//		return instance;
//	}
//
//	public ArrayList<PetClinicSearchVO> selectAllBoard() {
//		String sql = "select * from AHL order by AHLnum desc";
//
//		ArrayList<PetClinicSearchVO> list = new ArrayList<PetClinicSearchVO>();
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//
//		try {
//			conn = DBManager_vet.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//			while (rs.next()) {
//				PetClinicSearchVO sVo = new PetClinicSearchVO();
//				sVo.setAHLnum(rs.getInt("AHLnum"));
//				sVo.setAHLname(rs.getString("AHLname"));
//				sVo.setAHLadd1(rs.getString("AHLadd1"));
//				sVo.setAHLtel(rs.getString("AHLtel"));
//
//				list.add(sVo);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DBManager_vet.close(conn, pstmt, rs);
//		}
//		return list;
//	}
//
//	public ArrayList<PetClinicSearchVO> select(String page, String pageDataCount) {
//		ArrayList<PetClinicSearchVO> searchdtos = new ArrayList<PetClinicSearchVO>();
//		PetClinicSearchVO dto = null;
//		Connection conn = null;
//		Statement stmt = null;
//		ResultSet rs = null;
//		try {
//			conn = DBManager_vet.getConnection();
//			String query = String.format("select * from "
//					+ "(select rownum as m, AHLstatus, AHLnum,AHLname, AHLadd1,AHLtel,AHLtype,AHLdate,AHLadd2,AHLpostcode"
//					+ " from (select *" + " from AHL order by AHLnum asc)sub where rownum <= %s*%s "
//					+ " order by AHLnum asc) where m>=(%s-1)*%s+1", page, pageDataCount, page, pageDataCount);
//			System.out.println(query);
//			stmt = conn.createStatement();
//			rs = stmt.executeQuery(query);
//
//			while (rs.next()) {
//				dto = new PetClinicSearchVO(rs.getInt("AHLnum"), rs.getString("AHLtype"), rs.getString("AHLdate"),
//						rs.getString("AHLstatus"), rs.getString("AHLtel"), rs.getString("AHLadd1"),
//						rs.getString("AHLadd2"), rs.getString("AHLpostcode"), rs.getString("AHLname"));
//				searchdtos.add(dto);
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (rs != null)
//					rs.close();
//				if (stmt != null)
//					stmt.close();
//				if (conn != null)
//					conn.close();
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}
//		}
//		return searchdtos;
//	}
//
//	public ArrayList<PetClinicSearchVO> searchSelect(String page, String pageDataCount, String searchCol,
//			String searchVal) {
//		ArrayList<PetClinicSearchVO> dtos = new ArrayList<PetClinicSearchVO>();
//
////		  select * from(
////				    select rownum m, sub.*
////				    from (select * 
////				          from mvc_board 
////				          order by bgroup desc, bStep asc) sub
////				    where rownum <=2*10 and bTitle like '%%죽음%%'
////				)
////				where m>=(2-1)*10+1;
//		String sql = String.format("select * from(" + "select rownum m, sub.* " + "from (select * " + "from AHL "
//				+ "order by AHLnum asc) sub " + "where m <= %s*%s and %s like '%%%s%%') " + "where m>=(%s-1)*%s+1",
//				page, pageDataCount, searchCol, searchVal, page, pageDataCount);
//		System.out.println(sql);
//
//		// String sql="select * from mvc_board order by bGroup desc,bStep asc";
//		Statement st = null;
//		ResultSet rs = null;
//
//		try {
//			Connection conn = DBManager_vet.getConnection();
//			st = conn.createStatement();
//			rs = st.executeQuery(sql);
//			while (rs.next()) {
//				dtos.add(new PetClinicSearchVO(rs.getInt("AHLnum"), rs.getString("AHLtype"), rs.getString("AHLdate"),
//						rs.getString("AHLstatus"), rs.getString("AHLtel"), rs.getString("AHLadd1"),
//						rs.getString("AHLadd2"), rs.getString("AHLpostcode"), rs.getString("AHLname")));
//
//			}
//			DBManager_vet.close(st, rs);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return dtos;
//	}
//
//	public int dataCount() {
//		int returnValue = 0;
//		Connection conn = null;
//		Statement stmt = null;
//		ResultSet rs = null;
//		String query = String.format("select count(AHLnum) count from AHL");
//		System.out.println(query);
//		try {
//			conn = DBManager_vet.getConnection();
//			stmt = conn.createStatement();
//			rs = stmt.executeQuery(query);
//			while (rs.next()) {
//				returnValue = rs.getInt("count");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (rs != null)
//					rs.close();
//				if (stmt != null)
//					stmt.close();
//				if (conn != null)
//					conn.close();
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}
//		}
//		return returnValue;
//	}
//
//	public int dataCount(String searchCol, String searchVal) {
//		int returnValue = 0;
//
//		String sql;
//		sql = String.format("select  count(AHLnum) as bCount from AHL " + "where %s like '%%%s%%' ", searchCol,
//				searchVal);
//		Statement st = null;
//		ResultSet rs = null;
//
//		try {
//			Connection conn = DBManager_vet.getConnection();
//			st = conn.createStatement();
//			rs = st.executeQuery(sql);
//			while (rs.next()) {
//				returnValue = rs.getInt("bCount");
//			}
//			DBManager_vet.close(st, rs);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return returnValue;
//	}
//
//	public PetClinicSearchVO selectOneBoardByNum(String str) {
//
//		String sql = "select * from AHL where AHLnum = ?";
//		PetClinicSearchVO bVo = null;
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		try {
//			conn = DBManager_vet.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, Integer.parseInt(str));
//			rs = pstmt.executeQuery();
//			if (rs.next()) {
//				bVo = new PetClinicSearchVO();
//				bVo.setAHLnum(rs.getInt("AHLnum"));
//				bVo.setAHLname(rs.getString("AHLname"));
//				bVo.setAHLadd1(rs.getString("AHLadd1"));
//				bVo.setAHLtel(rs.getString("AHLtel"));
//				bVo.setAHLtype(rs.getString("AHLtype"));
//				bVo.setAHLdate(rs.getString("AHLdate"));
//				bVo.setAHLadd2(rs.getString("AHLadd2"));
//				bVo.setAHLpostcode(rs.getString("AHLpostcode"));
//
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DBManager_vet.close(conn, pstmt, rs);
//		}
//		return bVo;
//	}
//}
