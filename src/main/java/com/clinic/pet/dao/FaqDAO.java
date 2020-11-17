//package com.clinic.pet.dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.util.ArrayList;
//
//import com.clinic.pet.dto.FaqBoardVO;
//import com.clinic.pet.util.DBManager_vet;
//
//public class FaqDAO {
//
//	
//
//	public FaqDAO() {
//		
//	}
//
//	private static FaqDAO instance = new FaqDAO();
//
//	public static FaqDAO getInstance() {
//		return instance;
//	}
//
//	public void insertBoard(FaqBoardVO fVo) {
//		String sql = "insert into faq_board(" + "faq_num, faq_title, faq_name, faq_hit, faq_content) "
//				+ "values (faq_seq.nextval, ?, ?, 0, ?)";
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//
//		try {
//			conn = DBManager_vet.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, fVo.getFaq_title());
//			pstmt.setString(2, fVo.getFaq_name());
//			pstmt.setString(3, fVo.getFaq_content());
//
//			pstmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DBManager_vet.close(conn, pstmt);
//		}
//	}
//
//	public ArrayList<FaqBoardVO> selectAllBoard() {
//		String sql = "select * from faq_board order by faq_num desc";
//
//		ArrayList<FaqBoardVO> list = new ArrayList<FaqBoardVO>();
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//
//		try {
//			conn = DBManager_vet.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//			while (rs.next()) {
//				FaqBoardVO fVo = new FaqBoardVO();
//				fVo.setFaq_num(rs.getInt("faq_num"));
//				fVo.setFaq_title(rs.getString("faq_title"));
//				fVo.setFaq_date(rs.getTimestamp("faq_date"));
//				fVo.setFaq_name(rs.getString("faq_name"));
//				fVo.setFaq_hit(rs.getInt("faq_hit"));
//				fVo.setFaq_content(rs.getString("faq_content"));
//				list.add(fVo);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DBManager_vet.close(conn, pstmt, rs);
//		}
//		return list;
//	}
//
//	public void upHit(String faq_num) {
//		String sql = "update faq_board set faq_hit=faq_hit+1 where faq_num=?";
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		try {
//			conn = DBManager_vet.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, faq_num);
//			pstmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DBManager_vet.close(conn, pstmt);
//		}
//	}
//
//	public FaqBoardVO selectOneBoardByNum(String Nnum) {
//		upHit(Nnum);
//		String sql = "select * from faq_board where faq_num = ?";
//		FaqBoardVO bVo = null;
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		try {
//			conn = DBManager_vet.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, Integer.parseInt(Nnum));
//			rs = pstmt.executeQuery();
//			if (rs.next()) {
//				bVo = new FaqBoardVO();
//				bVo.setFaq_num(rs.getInt("faq_num"));
//				bVo.setFaq_title(rs.getString("faq_title"));
//				bVo.setFaq_date(rs.getTimestamp("faq_date"));
//				bVo.setFaq_name(rs.getString("faq_name"));
//				bVo.setFaq_hit(rs.getInt("faq_hit"));
//				bVo.setFaq_content(rs.getString("faq_content"));
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DBManager_vet.close(conn, pstmt, rs);
//		}
//		return bVo;
//	}
//
//	public void updateBoard(FaqBoardVO bVo) {
//		String sql = "update faq_board set faq_name=?, faq_title=?, faq_content=?, "
//				+ " faq_date=sysdate where faq_num=?";
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		try {
//			conn = DBManager_vet.getConnection();
//			pstmt = conn.prepareStatement(sql);
//
//			pstmt.setString(1, bVo.getFaq_name());
//			pstmt.setString(2, bVo.getFaq_title());
//			pstmt.setString(3, bVo.getFaq_content());
//			pstmt.setInt(4, bVo.getFaq_num());
//
//			pstmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DBManager_vet.close(conn, pstmt);
//		}
//	}
//
//	public void deleteBoard(String Nnum) {
//		String sql = "delete from faq_board where faq_num=?";
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		try {
//			conn = DBManager_vet.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, Integer.parseInt(Nnum));
//			pstmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	public ArrayList<FaqBoardVO> select(String page, String pageDataCount) {
//		ArrayList<FaqBoardVO> dtos = new ArrayList<FaqBoardVO>();
//		FaqBoardVO dto = null;
//		Connection conn = null;
//		Statement stmt = null;
//		ResultSet rs = null;
//		try {
//			conn = DBManager_vet.getConnection();
//			String query = String.format(
//					"select * from " + "(select rownum as m,faq_num,faq_title, faq_date, faq_name,faq_hit, faq_content "
//							+ " from (select faq_num,faq_title, faq_date, faq_name,faq_hit, faq_content "
//							+ " from faq_board order by faq_num desc)sub where rownum <= %s*%s "
//							+ " order by faq_num desc) where m>=(%s-1)*%s+1",
//					page, pageDataCount, page, pageDataCount);
//			System.out.println(query);
//			stmt = conn.createStatement();
//			rs = stmt.executeQuery(query);
//
//			while (rs.next()) {
//				dto = new FaqBoardVO(rs.getInt("faq_num"), rs.getString("faq_title"), rs.getTimestamp("faq_date"),
//						rs.getString("faq_name"), rs.getInt("faq_hit"), rs.getString("faq_content"));
//
//				dtos.add(dto);
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
//		return dtos;
//	}
//
//	public int dataCount() {
//		int returnValue = 0;
//		Connection conn = null;
//		Statement stmt = null;
//		ResultSet rs = null;
//		String query = String.format("select count(faq_num) count from faq_board");
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
//}
