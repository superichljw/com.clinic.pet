//package com.clinic.pet.dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.util.ArrayList;
//
//import com.clinic.pet.dto.QnaBoardVO;
//import com.clinic.pet.util.DBManager_vet;
//
//public class QnaDAO {
//	
//
//	public QnaDAO() {
//		
//	}
//
//	private static QnaDAO instance = new QnaDAO();
//
//	public static QnaDAO getInstance() {
//		return instance;
//	}
//
//	public void insertBoard(QnaBoardVO qVo) {
//		String sql = "insert into qna_board(" + "qna_num, qna_title, qna_name, qna_hit, qna_content) "
//				+ "values (qnaboard_seq.nextval, ?, ?, 0, ?)";
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		try {
//			conn = DBManager_vet.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, qVo.getQna_title());
//			pstmt.setString(2, qVo.getQna_name());
//			pstmt.setString(3, qVo.getQna_content());
//
//			pstmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DBManager_vet.close(conn, pstmt);
//		}
//	}
//	
//	
//
//	public ArrayList<QnaBoardVO> selectAllBoard() {
//		String sql = "select * from qna_board order by qna_num desc";
//
//		ArrayList<QnaBoardVO> list = new ArrayList<QnaBoardVO>();
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//
//		try {
//			conn = DBManager_vet.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//			while (rs.next()) {
//				QnaBoardVO qVo = new QnaBoardVO();
//				qVo.setQna_num(rs.getInt("qna_num"));
//				qVo.setQna_title(rs.getString("qna_title"));
//				qVo.setQna_date(rs.getTimestamp("qna_date"));
//				qVo.setQna_name(rs.getString("fqna_name"));
//				qVo.setQna_hit(rs.getInt("qna_hit"));
//				qVo.setQna_content(rs.getString("qna_content"));
//				list.add(qVo);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DBManager_vet.close(conn, pstmt, rs);
//		}
//		return list;
//	}
//
//	public void upHit(String qna_num) {
//		String sql = "update qna_board set qna_hit=qna_hit+1 where qna_num=?";
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		try {
//			conn = DBManager_vet.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, qna_num);
//			pstmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DBManager_vet.close(conn, pstmt);
//		}
//	}
//	
//	
//
//	public QnaBoardVO selectOneBoardByNum(String strID) {
//		upHit(strID);
//		String sql = "select * from qna_board where qna_num = ?";
//		QnaBoardVO qVo = null;
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		try {
//			conn = DBManager_vet.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, Integer.parseInt(strID));
//			rs = pstmt.executeQuery();
//			if (rs.next()) {
//				qVo = new QnaBoardVO();
//				qVo.setQna_num(rs.getInt("qna_num"));
//				qVo.setQna_title(rs.getString("qna_title"));
//				qVo.setQna_date(rs.getTimestamp("qna_date"));
//				qVo.setQna_name(rs.getString("qna_name"));
//				qVo.setQna_hit(rs.getInt("qna_hit"));
//				qVo.setQna_content(rs.getString("qna_content"));
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DBManager_vet.close(conn, pstmt, rs);
//		}
//		return qVo;
//	}
//
//	public void updateBoard(QnaBoardVO qVo) {
//		String sql = "update qna_board set qna_name=?, qna_title=?, qna_content=?, "
//				+ " qna_date=sysdate where qna_num=?";
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		try {
//			conn = DBManager_vet.getConnection();
//			pstmt = conn.prepareStatement(sql);
//
//			pstmt.setString(1, qVo.getQna_name());
//			pstmt.setString(2, qVo.getQna_title());
//			pstmt.setString(3, qVo.getQna_content());
//			pstmt.setInt(4, qVo.getQna_num());
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
//		String sql = "delete from qna_board where qna_num=?";
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
//	public ArrayList<QnaBoardVO> select(String page, String pageDataCount) {
//		ArrayList<QnaBoardVO> dtos = new ArrayList<QnaBoardVO>();
//		QnaBoardVO dto = null;
//		Connection conn = null;
//		Statement stmt = null;
//		ResultSet rs = null;
//		try {
//			conn = DBManager_vet.getConnection();
//			String query = String.format("select * from "
//					+ "(select rownum as m,qna_num,qna_title, qna_date, qna_name,qna_hit, qna_content "
//					+ " from (select qna_num,qna_title, qna_date, qna_name,qna_hit, qna_content "
//					+ " from qna_board order by qna_num desc)sub where rownum <= %s*%s "
//					+ " order by qna_num desc) where m>=(%s-1)*%s+1", page, pageDataCount, page, pageDataCount);
//			System.out.println(query);
//			stmt = conn.createStatement();
//			rs = stmt.executeQuery(query);
//
//			while (rs.next()) {
//				dto = new QnaBoardVO(rs.getInt("qna_num"), rs.getString("qna_title"),
//						rs.getTimestamp("qna_date"), rs.getString("qna_name"), rs.getInt("qna_hit"),
//						rs.getString("qna_content"));
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
//		String query = String.format("select count(qna_num) count from qna_board");
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
//}
