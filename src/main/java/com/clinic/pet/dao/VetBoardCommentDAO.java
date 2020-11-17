//package com.clinic.pet.dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//import com.clinic.pet.dto.vetboardCommentVO;
//import com.clinic.pet.util.DBManager_vet;
//
//public class VetBoardCommentDAO {
//	private VetBoardCommentDAO() {
//		
//	}
//	private static VetBoardCommentDAO instance = new VetBoardCommentDAO();
//
//	public static VetBoardCommentDAO getInstance() {
//		return instance;
//	}
//	public List<vetboardCommentVO> selectAllBoards() {
//		String sql = "select * from board_comment where order by comment_num desc";
//		List<vetboardCommentVO> list = new ArrayList<vetboardCommentVO>();
//		Connection conn = null;
//		Statement stmt = null;
//		ResultSet rs = null;
//		try {
//			conn = DBManager_vet.getConnection();
//			stmt = conn.createStatement();
//			rs = stmt.executeQuery(sql);
//			while (rs.next()) {
//				vetboardCommentVO bVo = new vetboardCommentVO();
//				bVo.setComment_num(rs.getInt("comment_num"));
//				bVo.setComment_board(rs.getInt("comment_board"));
//				bVo.setComment_id(rs.getString("comment_id"));
//				bVo.setComment_date(rs.getTimestamp("comment_date"));
//				bVo.setComment_content(rs.getString("comment_content"));
//				
//				list.add(bVo);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DBManager_vet.close(conn, stmt, rs);
//		}
//		return list;
//	}
//	public void insertBoard(vetboardCommentVO bVo) {
//		String sql = "insert into board_comment(comment_num,comment_board,comment_id,comment_content) "
//				+ "values(boardComment_seq.nextval, ?, ?, ?)";
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		try {
//			conn = DBManager_vet.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, bVo.getComment_board());
//			pstmt.setString(2, bVo.getComment_id());
//			pstmt.setString(3, bVo.getComment_content());
//			
//			pstmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DBManager_vet.close(conn, pstmt);
//		}
//	}
//	public List<vetboardCommentVO> selectOneBoardByNum(String commentnum) {
//		
//		String sql = "select * from board_comment where comment_board=? order by comment_num desc";
//		List<vetboardCommentVO> list = new ArrayList<vetboardCommentVO>();
//		vetboardCommentVO bVo = null;
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		try {
//			conn = DBManager_vet.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, Integer.parseInt(commentnum));
//			rs = pstmt.executeQuery();
//			while (rs.next()) {
//				bVo = new vetboardCommentVO();
//				bVo.setComment_num(rs.getInt("comment_num"));
//				bVo.setComment_board(rs.getInt("comment_board"));
//				bVo.setComment_id(rs.getString("comment_id"));
//				bVo.setComment_date(rs.getTimestamp("comment_date"));
//				bVo.setComment_content(rs.getString("comment_content"));
//				
//				
//				list.add(bVo);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DBManager_vet.close(conn, pstmt, rs);
//		}
//		
//		return list;
//		
//	}
//}
