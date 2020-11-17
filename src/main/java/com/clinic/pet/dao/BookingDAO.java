//package com.clinic.pet.dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//import com.clinic.pet.dto.BookingVO;
//import com.clinic.pet.util.DBManager_vet;
//
//public class BookingDAO {
//	
//
//	public BookingDAO() {
//		
//	}
//
//	private static BookingDAO instance = new BookingDAO();
//
//	public static BookingDAO getInstance() {
//		return instance;
//	}
//
//	public void insertBooking(BookingVO BookingVO) {
//		String sql = "insert into booking(booking_num,booking_id,booking_Add,booking_Tel,booking_Date,booking_Name)"
//				+ " values(booking_seq.nextval,?, ?, ?, ?,?)";
//
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//
//		try {
//			conn = DBManager_vet.getConnection();
//			pstmt = conn.prepareStatement(sql);
////	      pstmt.setInt(1, BookingVO.getBooking_num());
//			pstmt.setString(1, BookingVO.getBooking_id());
//			pstmt.setString(2, BookingVO.getBooking_Add());
//			pstmt.setString(3, BookingVO.getBooking_Tel());
//			pstmt.setString(4, BookingVO.getBooking_Date());
//			pstmt.setString(5, BookingVO.getBooking_Name());
//
//			pstmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DBManager_vet.close(conn, pstmt);
//		}
//	}
//
//	public ArrayList<BookingVO> selectAllBoard() {
//		String sql = "select * from booking order by booking_num desc";
//
//		ArrayList<BookingVO> list = new ArrayList<BookingVO>();
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//
//		try {
//			conn = DBManager_vet.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//			while (rs.next()) {
//				BookingVO bVo = new BookingVO();
//				bVo.setBooking_num(rs.getInt("booking_num"));
//				bVo.setBooking_Name(rs.getString("booking_name"));
//				bVo.setBooking_Add(rs.getString("booking_Add"));
//				bVo.setBooking_Tel(rs.getString("booking_Tel"));
//				bVo.setBooking_id(rs.getString("booking_id"));
//				bVo.setBooking_Date(rs.getString("booking_date"));
//				bVo.setOrderDate(rs.getTimestamp("orderdate"));
//
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
//	public BookingVO selectOneBoardByNum(String strID) {
//
//		String sql = "select * from booking where booking_num = ?";
//		BookingVO bVo = null;
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		try {
//			conn = DBManager_vet.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, Integer.parseInt(strID));
//			rs = pstmt.executeQuery();
//			if (rs.next()) {
//				bVo = new BookingVO();
//				bVo.setBooking_num(rs.getInt("booking_num"));
//				bVo.setBooking_Name(rs.getString("booking_Name"));
//				bVo.setBooking_Date(rs.getString("booking_Date"));
//				bVo.setBooking_Add(rs.getString("booking_Add"));
//				bVo.setBooking_Tel(rs.getString("booking_Tel"));
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DBManager_vet.close(conn, pstmt, rs);
//		}
//		return bVo;
//	}
//
//	public ArrayList<BookingVO> select(String page, String pageDataCount) {
//		ArrayList<BookingVO> dtos = new ArrayList<BookingVO>();
//		BookingVO bdto = null;
//		Connection conn = null;
//		Statement stmt = null;
//		ResultSet rs = null;
//		try {
//			conn = DBManager_vet.getConnection();
//			String query = String.format("select * from "
//					+ "(select rownum as m,booking_num,booking_id,booking_name,  booking_add,booking_tel, booking_Date,orderDate "
//					+ " from (select booking_num, booking_id,booking_name, booking_add,booking_tel, booking_Date,orderDate "
//					+ " from booking order by booking_num desc)sub where rownum <= %s*%s "
//					+ " order by booking_num desc) where m>=(%s-1)*%s+1", page, pageDataCount, page, pageDataCount);
//			System.out.println(query);
//			stmt = conn.createStatement();
//			rs = stmt.executeQuery(query);
//			
//			while (rs.next()) {
//				bdto = new BookingVO(
//						rs.getInt("booking_num"), 
//						rs.getString("booking_id"), 
//						rs.getString("booking_Name"),
//						rs.getString("booking_Add"), 
//						rs.getString("booking_Tel"), 
//						rs.getString("booking_Date"),
//						rs.getTimestamp("orderDate"));
//				dtos.add(bdto);
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
//		String query = String.format("select count(booking_num) Bcount from booking");
//		System.out.println(query);
//		try {
//			conn = DBManager_vet.getConnection();
//			stmt = conn.createStatement();
//			rs = stmt.executeQuery(query);
//			while (rs.next()) {
//				returnValue = rs.getInt("Bcount");
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
//public List<BookingVO> selectOneBoardById(String bookingid) {
//		
//		String sql = "select * from booking where booking_id=? order by booking_num desc";
//		System.out.println(sql);
//		List<BookingVO> list = new ArrayList<BookingVO>();
//		BookingVO bVo = null;
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		try {
//			conn = DBManager_vet.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			
//			pstmt.setString(1, bookingid);
//			System.out.println(bookingid);
//			rs = pstmt.executeQuery();
//			
//			while (rs.next()) {
//				bVo = new BookingVO();
//
//				bVo.setBooking_num(rs.getInt("booking_num"));
//
//				bVo.setBooking_Name(rs.getString("booking_Name"));
//				bVo.setBooking_Add(rs.getString("booking_Add"));
//				bVo.setBooking_Tel(rs.getString("booking_Tel"));
//				bVo.setBooking_Date(rs.getString("booking_Date"));
//				bVo.setOrderDate(rs.getTimestamp("orderdate"));
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
