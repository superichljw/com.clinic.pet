//package com.clinic.pet.dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.util.ArrayList;
//
//import com.clinic.pet.dto.NewsBoardVO;
//import com.clinic.pet.dto.NoticeVO;
//import com.clinic.pet.util.DBManager_vet;
//
//public class NoticeDAO {
//
//
//	public NoticeDAO() {
//		
//	}
//
//	private static NoticeDAO instance = new NoticeDAO();
//
//	public static NoticeDAO getInstance() {
//		return instance;
//	}
//
//	public void insertBoard(NoticeVO bVo) {
//		String sql = "insert into notice_board(" + "notice_num, notice_title, notice_name, notice_hit, notice_content) "
//				+ "values (notice_seq.nextval, ?, ?, 0, ?)";
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		try {
//			conn = DBManager_vet.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, bVo.getNotice_title());
//			pstmt.setString(2, bVo.getNotice_name());
//			pstmt.setString(3, bVo.getNotice_content());
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
//	public ArrayList<NoticeVO> selectAllBoard() {
//		String sql = "select * from notice_board order by notice_num desc";
//
//		ArrayList<NoticeVO> list = new ArrayList<NoticeVO>();
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//
//		try {
//			conn = DBManager_vet.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//			while (rs.next()) {
//				NoticeVO bVo = new NoticeVO();
//				bVo.setNotice_num(rs.getInt("notice_num"));
//				bVo.setNotice_title(rs.getString("notice_title"));
//				bVo.setNotice_date(rs.getTimestamp("notice_date"));
//				bVo.setNotice_name(rs.getString("notice_name"));
//				bVo.setNotice_hit(rs.getInt("notice_hit"));
//				bVo.setNotice_content(rs.getString("notice_content"));
//				list.add(bVo);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DBManager_vet.close(conn, pstmt, rs);
//		}
//		return list;
//	}
//
//	public void upHit(String notice_num) {
//		String sql = "update notice_board set notice_hit=notice_hit+1 where notice_num=?";
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		try {
//			conn = DBManager_vet.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, notice_num);
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
//	public NoticeVO selectOneBoardByNum(String strID) {
//		upHit(strID);
//		String sql = "select * from notice_board where notice_num = ?";
//		NoticeVO bVo = null;
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		try {
//			conn = DBManager_vet.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, Integer.parseInt(strID));
//			rs = pstmt.executeQuery();
//			if (rs.next()) {
//				bVo = new NoticeVO();
//				bVo.setNotice_num(rs.getInt("notice_num"));
//				bVo.setNotice_title(rs.getString("notice_title"));
//				bVo.setNotice_date(rs.getTimestamp("notice_date"));
//				bVo.setNotice_name(rs.getString("notice_name"));
//				bVo.setNotice_hit(rs.getInt("notice_hit"));
//				bVo.setNotice_content(rs.getString("notice_content"));
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DBManager_vet.close(conn, pstmt, rs);
//		}
//		return bVo;
//	}
//
//	public void updateBoard(NoticeVO bVo) {
//		String sql = "update notice_board set notice_name=?, notice_title=?, notice_content=?, "
//				+ " notice_date=sysdate where notice_num=?";
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		try {
//			conn = DBManager_vet.getConnection();
//			pstmt = conn.prepareStatement(sql);
//
//			pstmt.setString(1, bVo.getNotice_name());
//			pstmt.setString(2, bVo.getNotice_title());
//			pstmt.setString(3, bVo.getNotice_content());
//			pstmt.setInt(4, bVo.getNotice_num());
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
//		String sql = "delete from notice_board where notice_num=?";
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
//	public ArrayList<NoticeVO> select(String page, String pageDataCount) {
//		ArrayList<NoticeVO> dtos = new ArrayList<NoticeVO>();
//		NoticeVO dto = null;
//		Connection conn = null;
//		Statement stmt = null;
//		ResultSet rs = null;
//		try {
//			conn = DBManager_vet.getConnection();
//			String query = String.format("select * from "
//					+ "(select rownum as m,notice_num,notice_title, notice_date, notice_name,notice_hit, notice_content "
//					+ " from (select notice_num,notice_title, notice_date, notice_name,notice_hit, notice_content "
//					+ " from notice_board order by notice_num desc)sub where rownum <= %s*%s "
//					+ " order by notice_num desc) where m>=(%s-1)*%s+1", page, pageDataCount, page, pageDataCount);
//			System.out.println(query);
//			stmt = conn.createStatement();
//			rs = stmt.executeQuery(query);
//
//			while (rs.next()) {
//				dto = new NoticeVO(rs.getInt("notice_num"), rs.getString("notice_title"),
//						rs.getTimestamp("notice_date"), rs.getString("notice_name"), rs.getInt("notice_hit"),
//						rs.getString("notice_content"));
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
//		String query = String.format("select count(notice_num) Ncount from notice_board");
//		System.out.println(query);
//		try {
//			conn = DBManager_vet.getConnection();
//			stmt = conn.createStatement();
//			rs = stmt.executeQuery(query);
//			while (rs.next()) {
//				returnValue = rs.getInt("Ncount");
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
//		System.out.println(returnValue);
//		return returnValue;
//	}
//
//	
//
//	
//
//	
//	
//	
////	새소식 게시판 다오
//	
//	
//	public void NewsinsertBoard(NewsBoardVO newsVo) {
//		String sql = "insert into news_board(" + "news_num, news_title, news_name, news_hit, news_content) "
//				+ "values (news_seq.nextval, ?, ?, 0, ?)";
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		try {
//			conn = DBManager_vet.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, newsVo.getNews_title());
//			pstmt.setString(2, newsVo.getNews_name());
//			pstmt.setString(3, newsVo.getNews_content());
//
//			pstmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DBManager_vet.close(conn, pstmt);
//		}
//	}
//	
//	public ArrayList<NewsBoardVO> Newsselect(String page, String pageDataCount) {
//		ArrayList<NewsBoardVO> dtos = new ArrayList<NewsBoardVO>();
//		NewsBoardVO newsdto = null;
//		Connection conn = null;
//		Statement stmt = null;
//		ResultSet rs = null;
//		try {
//			conn = DBManager_vet.getConnection();
//			String query = String.format(
//					"select * from "
//							+ "(select rownum as m,news_num,news_title, news_date, news_name,news_hit, news_content "
//							+ " from (select news_num,news_title, news_date, news_name,news_hit, news_content "
//							+ " from news_board order by news_num desc)sub where rownum <= %s*%s "
//							+ " order by news_num desc) where m>=(%s-1)*%s+1",
//					page, pageDataCount, page, pageDataCount);
//			System.out.println(query);
//			stmt = conn.createStatement();
//			rs = stmt.executeQuery(query);
//			
//			while (rs.next()) {
//				newsdto = new NewsBoardVO(
//						rs.getInt("news_num"), 
//						rs.getString("news_title"), 
//						rs.getTimestamp("news_date"),
//						rs.getString("news_name"), 
//						rs.getInt("news_hit"), 
//						rs.getString("news_content"));
//				dtos.add(newsdto);
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
//	public void NewsupHit(String news_num) {
//		String sql = "update news_board set news_hit=news_hit+1 where news_num=?";
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		try {
//			conn = DBManager_vet.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, news_num);
//			pstmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DBManager_vet.close(conn, pstmt);
//		}
//	}
//	
//	public int NewsdataCount() {
//		int returnValue = 0;
//		Connection conn = null;
//		Statement stmt = null;
//		ResultSet rs = null;
//		String query = String.format("select count(news_num) Ncount from news_board");
//		System.out.println(query);
//		try {
//			conn = DBManager_vet.getConnection();
//			stmt = conn.createStatement();
//			rs = stmt.executeQuery(query);
//			while (rs.next()) {
//				returnValue = rs.getInt("Ncount");
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
//	public NewsBoardVO NewsselectOneBoardByNum(String strNews) {
//		NewsupHit(strNews);
//		String sql = "select * from news_board where news_num = ?";
//		NewsBoardVO newsVo = null;
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		try {
//			conn = DBManager_vet.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, Integer.parseInt(strNews));
//			rs = pstmt.executeQuery();
//			if (rs.next()) {
//				newsVo = new NewsBoardVO();
//				newsVo.setNews_num(rs.getInt("news_num"));
//				newsVo.setNews_title(rs.getString("news_title"));
//				newsVo.setNews_date(rs.getTimestamp("news_date"));
//				newsVo.setNews_name(rs.getString("news_name"));
//				newsVo.setNews_hit(rs.getInt("news_hit"));
//				newsVo.setNews_content(rs.getString("news_content"));
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DBManager_vet.close(conn, pstmt, rs);
//		}
//		return newsVo;
//	}
//	public void NewsupdateBoard(NewsBoardVO bVo) {
//		String sql = "update news_board set news_name=?, news_title=?, news_content=?, "
//				+ " news_date=sysdate where news_num=?";
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		try {
//			conn = DBManager_vet.getConnection();
//			pstmt = conn.prepareStatement(sql);
//
//			pstmt.setString(1, bVo.getNews_name());
//			pstmt.setString(2, bVo.getNews_title());
//			pstmt.setString(3, bVo.getNews_content());
//			pstmt.setInt(4, bVo.getNews_num());
//
//			pstmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DBManager_vet.close(conn, pstmt);
//		}
//	}
//	public void NewsdeleteBoard(String news_num) {
//		String sql = "delete from news_board where news_num=?";
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		try {
//			conn = DBManager_vet.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, Integer.parseInt(news_num));
//			pstmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//}
