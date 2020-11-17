//package com.clinic.pet.dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//import com.clinic.pet.dto.VetClinicBoardVO;
//import com.clinic.pet.util.DBManager_vet;
//
//public class VetClinicBoardDAO {
//	private VetClinicBoardDAO() {
//	}
//
//	private static VetClinicBoardDAO instance = new VetClinicBoardDAO();
//
//	public static VetClinicBoardDAO getInstance() {
//		return instance;
//	}
//
//	public List<VetClinicBoardVO> selectAllBoards() {
//		String sql = "select * from board order by num desc";
//		List<VetClinicBoardVO> list = new ArrayList<VetClinicBoardVO>();
//		Connection conn = null;
//		Statement stmt = null;
//		ResultSet rs = null;
//		try {
//			conn = DBManager_vet.getConnection();
//			stmt = conn.createStatement();
//			rs = stmt.executeQuery(sql);
//			while (rs.next()) {
//				VetClinicBoardVO bVo = new VetClinicBoardVO();
//				bVo.setNum(rs.getInt("num"));
//				bVo.setName(rs.getString("name"));
//				bVo.setEmail(rs.getString("email"));
//				bVo.setPass(rs.getString("pass"));
//				bVo.setTitle(rs.getString("title"));
//				bVo.setContent(rs.getString("content"));
//				bVo.setReadcount(rs.getInt("readcount"));
//				bVo.setWritedate(rs.getTimestamp("writedate"));
//				list.add(bVo);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DBManager_vet.close(conn, stmt, rs);
//		}
//		return list;
//	}
//
//	public List<VetClinicBoardVO> select5Boards() {
//		String sql = "select * from (select *from board order by rownum desc)where rownum < 6 order by rownum desc";
//		List<VetClinicBoardVO> list = new ArrayList<VetClinicBoardVO>();
//		Connection conn = null;
//		Statement stmt = null;
//		ResultSet rs = null;
//		try {
//			conn = DBManager_vet.getConnection();
//			stmt = conn.createStatement();
//			rs = stmt.executeQuery(sql);
//			while (rs.next()) {
//				VetClinicBoardVO bVo = new VetClinicBoardVO();
//				bVo.setNum(rs.getInt("num"));
//				bVo.setName(rs.getString("name"));
//				bVo.setEmail(rs.getString("email"));
//				bVo.setPass(rs.getString("pass"));
//				bVo.setTitle(rs.getString("title"));
//				bVo.setContent(rs.getString("content"));
//				bVo.setReadcount(rs.getInt("readcount"));
//				bVo.setWritedate(rs.getTimestamp("writedate"));
//				list.add(bVo);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DBManager_vet.close(conn, stmt, rs);
//		}
//		return list;
//	}
//	
//	
//	public void insertBoard(VetClinicBoardVO bVo) {
//		String sql = "insert into board(" + "num, name, email, pass, title, content) "
//				+ "values(board_seq.nextval, ?, ?, ?, ?, ?)";
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		try {
//			conn = DBManager_vet.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, bVo.getName());
//			pstmt.setString(2, bVo.getEmail());
//			pstmt.setString(3, bVo.getPass());
//			pstmt.setString(4, bVo.getTitle());
//			pstmt.setString(5, bVo.getContent());
//			pstmt.executeUpdate();
//			System.out.println(bVo.getContent());
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DBManager_vet.close(conn, pstmt);
//		}
//	}
//
//	public void updateReadCount(String num) {
//		String sql = "update board set readcount=readcount+1 where num=?";
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		try {
//			conn = DBManager_vet.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, num);
//			pstmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DBManager_vet.close(conn, pstmt);
//		}
//	}
//
//	// 게시판 글 상세 내용 보기 :글번호로 찾아온다. : 실패 null,
//	public VetClinicBoardVO selectOneBoardByNum(String num) {
//		String sql = "select * from board where num = ?";
//		VetClinicBoardVO bVo = null;
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		try {
//			conn = DBManager_vet.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, num);
//			rs = pstmt.executeQuery();
//			if (rs.next()) {
//				bVo = new VetClinicBoardVO();
//				bVo.setNum(rs.getInt("num"));
//				bVo.setName(rs.getString("name"));
//				bVo.setPass(rs.getString("pass"));
//				bVo.setEmail(rs.getString("email"));
//				bVo.setTitle(rs.getString("title"));
//				bVo.setContent(rs.getString("content"));
//				bVo.setWritedate(rs.getTimestamp("writedate"));
//				bVo.setReadcount(rs.getInt("readcount"));
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DBManager_vet.close(conn, pstmt, rs);
//		}
//		return bVo;
//	}
//
//	public void updateBoard(VetClinicBoardVO bVo) {
//		String sql = "update board set name=?, email=?, pass=?, " + "title=?, content=? where num=?";
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		try {
//			conn = DBManager_vet.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, bVo.getName());
//			pstmt.setString(2, bVo.getEmail());
//			pstmt.setString(3, bVo.getPass());
//			pstmt.setString(4, bVo.getTitle());
//			pstmt.setString(5, bVo.getContent());
//			pstmt.setInt(6, bVo.getNum());
//			pstmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DBManager_vet.close(conn, pstmt);
//		}
//	}
//
//	public VetClinicBoardVO checkPassWord(String pass, String num) {
//		String sql = "select * from board where pass=? and num=?";
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		VetClinicBoardVO bVo = null;
//		try {
//			conn = DBManager_vet.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, pass);
//			pstmt.setString(2, num);
//			rs = pstmt.executeQuery();
//			if (rs.next()) {
//				bVo = new VetClinicBoardVO();
//				bVo.setNum(rs.getInt("num"));
//				bVo.setName(rs.getString("name"));
//				bVo.setEmail(rs.getString("email"));
//				bVo.setPass(rs.getString("pass"));
//				bVo.setTitle(rs.getString("title"));
//				bVo.setContent(rs.getString("content"));
//				bVo.setReadcount(rs.getInt("readcount"));
//				bVo.setWritedate(rs.getTimestamp("writedate"));
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return bVo;
//	}
//
//	public void deleteBoard(String num) {
//		String sql = "delete board where num=?";
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		try {
//			conn = DBManager_vet.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, num);
//			pstmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	// 리스트 페이지에 보여줄 로직(페이징 처리)
//		public List<VetClinicBoardVO> getList(int startRow, int endRow) {
//			// 페이징 처리를 위한 sql / 인라인뷰, rownum 사용
//			String sql = "select * from"
//					+ "(select rownum as rn, num, name, title, readcount, writedate from"
//					+ "(select * from board order by num desc)) where rn between ? and ?";
//
//			List<VetClinicBoardVO> list = null;
//			Connection conn = null;
//			PreparedStatement pstmt = null;
//			ResultSet rs = null;
//			try {
//				conn = DBManager_vet.getConnection(); // 커넥션을 얻어옴
//				pstmt = conn.prepareStatement(sql); // sql 정의
//				pstmt.setInt(1, startRow); // sql 물음표에 값 매핑
//				pstmt.setInt(2, endRow);
//				rs = pstmt.executeQuery(); // sql 실행
//				if (rs.next()) { // 데이터베이스에 데이터가 있으면 실행
//					list = new ArrayList<VetClinicBoardVO>(); // list 객체 생성
//					do {
//						// 반복할 때마다 ExboardDTO 객체를 생성 및 데이터 저장
//						VetClinicBoardVO board = new VetClinicBoardVO();
//						board.setNum(rs.getInt("num"));
//						board.setName(rs.getString("name"));
////						board.setPass(rs.getString("pass"));
//						board.setTitle(rs.getString("title"));
////						board.setContent(rs.getString("content"));
//						board.setWritedate(rs.getTimestamp("writedate"));
//						board.setReadcount(rs.getInt("readcount"));
//
//						list.add(board); // list에 0번 인덱스부터 board 객체의 참조값을 저장
//					} while (rs.next());
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			} finally {
//				DBManager_vet.close(conn, pstmt, rs); // DB 연결 종료 / Connection 반환
//			}
//			return list; // list 반환
//		}
//		
//		public int getCount(){
//			int count = 0;
//			String sql = "select count(*) from board";
//			Connection conn = null;
//			PreparedStatement pstmt = null;
//			ResultSet rs = null;
//			try {
//				conn = DBManager_vet.getConnection();
//				pstmt = conn.prepareStatement(sql);
//				rs = pstmt.executeQuery();
//				if(rs.next()){
//					count = rs.getInt(1);
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			} finally {
//				DBManager_vet.close(conn, pstmt, rs);
//			}
//			return count; // 총 레코드 수 리턴
//		}
//		
//	
//
//	
//}