//package com.clinic.pet.dao;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//import com.clinic.pet.dto.VetClinicVO;
//import com.clinic.pet.util.DBManager_vet;
//
//public class VetClinicDAO {
//	
//	private static VetClinicDAO instance = new VetClinicDAO();
//
//	public static VetClinicDAO getInstance() {
//		return instance;
//	}
//	
//	public VetClinicDAO() {
//		
//	}
//	
//
//	public int insertMember(VetClinicVO mVo) {
//		int result = -1;
//		String sql = "insert into vetmember(usertype,userid,pwd,email,addr,name,phone,personal,emailok,pettype,petname,petnum,hospital_name,hospital_num,hospital_li,auth) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		try {
//			conn = DBManager_vet.getConnection();
//			pstmt = conn.prepareStatement(sql);
//
//			pstmt.setString(1, mVo.getUsertype());
//			pstmt.setString(2, mVo.getUserid());
//			pstmt.setString(3, mVo.getPwd());
//			pstmt.setString(4, mVo.getEmail());
//			pstmt.setString(5, mVo.getAddr());
//			pstmt.setString(6, mVo.getName());
//			pstmt.setString(7, mVo.getPhone());
//			pstmt.setInt(8, mVo.getPersonal());
//			pstmt.setInt(9, mVo.getEmailok());
//			pstmt.setString(10, mVo.getPettype());
//			pstmt.setString(11, mVo.getPetname());
//			pstmt.setString(12, mVo.getPetnum());
//			pstmt.setString(13, mVo.getHospital_name());
//			pstmt.setString(14, mVo.getHospital_num());
//			pstmt.setString(15, mVo.getHospital_li());
//			pstmt.setInt(16, mVo.getAuth());
//
//			result = pstmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (pstmt != null)
//					pstmt.close();
//				if (conn != null)
//					conn.close();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//
//		}
//		return result;
//	}
//
//	public int userCheck(String userid, String pwd) {
//		int result = -1;
//		String sql = "select pwd from vetmember where userid=?";
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//
//		try {
//			conn = DBManager_vet.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, userid);
//			rs = pstmt.executeQuery();
//			if (rs.next()) {
//				if (rs.getString("pwd") != null && rs.getString("pwd").equals(pwd)) {
//					result = 1;
//
//				} else {
//					result = 0;
//				}
//			} else {
//				result = -1;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (rs != null)
//					rs.close();
//				if (pstmt != null)
//					pstmt.close();
//				if (conn != null)
//					conn.close();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		return result;
//	}
//
//	public VetClinicVO getMember(String userid) {
//		VetClinicVO mVo = null;
//		String sql = "select * from vetmember where userid=?";
//
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		try {
//			conn = DBManager_vet.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, userid);
//			rs = pstmt.executeQuery();
//			if (rs.next()) {
//				mVo = new VetClinicVO();
//
//				mVo.setUserid(rs.getString("userid"));
//				mVo.setPwd(rs.getString("pwd"));
//				mVo.setEmail(rs.getString("email"));
//				mVo.setAddr(rs.getString("addr"));
//				mVo.setName(rs.getString("name"));
//				mVo.setPhone(rs.getString("phone"));
//				mVo.setPersonal(rs.getInt("personal"));
//				mVo.setEmailok(rs.getInt("emailok"));
//				mVo.setPettype(rs.getString("pettype"));
//				mVo.setPetname(rs.getString("petname"));
//				mVo.setPetnum(rs.getString("petnum"));
//
//				mVo.setUsertype(rs.getString("usertype"));
//				mVo.setHospital_name(rs.getString("hospital_name"));
//				mVo.setHospital_num(rs.getString("hospital_num"));
//				mVo.setHospital_li(rs.getString("hospital_li"));
//				mVo.setJoindate(rs.getTimestamp("joindate"));
//				mVo.setAuth(rs.getInt("auth"));
//
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (rs != null)
//					rs.close();
//				if (pstmt != null)
//					pstmt.close();
//				if (conn != null)
//					conn.close();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		return mVo;
//
//	}
//
//	// 아이디로 회원 정보 가져오는 메소드
//
//	public VetClinicVO getMemberByNum(int useridnum) {
//		VetClinicVO mVo = null;
////		String sql = "select * from vetmember where userid=?";
//		String sql = "select rownum as m , vetmember.* from vetmember where rownum=?";
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		try {
//			conn = DBManager_vet.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, useridnum);
//			rs = pstmt.executeQuery();
//			if (rs.next()) {
//				mVo = new VetClinicVO();
//
//				mVo.setUserid(rs.getString("userid"));
//				mVo.setPwd(rs.getString("pwd"));
//				mVo.setEmail(rs.getString("email"));
//				mVo.setAddr(rs.getString("addr"));
//				mVo.setName(rs.getString("name"));
//				mVo.setPhone(rs.getString("phone"));
//				mVo.setPersonal(rs.getInt("personal"));
//				mVo.setEmailok(rs.getInt("emailok"));
//				mVo.setPettype(rs.getString("pettype"));
//				mVo.setPetname(rs.getString("petname"));
//				mVo.setPetnum(rs.getString("petnum"));
//
//				mVo.setUsertype(rs.getString("usertype"));
//				mVo.setHospital_name(rs.getString("hospital_name"));
//				mVo.setHospital_num(rs.getString("hospital_num"));
//				mVo.setHospital_li(rs.getString("hospital_li"));
//				mVo.setJoindate(rs.getTimestamp("joindate"));
//				mVo.setAuth(rs.getInt("auth"));
//
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (rs != null)
//					rs.close();
//				if (pstmt != null)
//					pstmt.close();
//				if (conn != null)
//					conn.close();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		return mVo;
//
//	}
//
//	public int confirmID(String userid) {
//
//		int result = -1;
//		String sql = "select userid from vetmember where userid=?";
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//
//		try {
//			conn = DBManager_vet.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, userid);
//			rs = pstmt.executeQuery();
//			if (rs.next()) {
//				result = 1;
//			} else {
//				result = -1;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (rs != null)
//					rs.close();
//				if (pstmt != null)
//					pstmt.close();
//				if (conn != null)
//					conn.close();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//		return result;
//	}
//
//	public int updateMember(VetClinicVO mVo) {
//		int result = -1;
//		String sql = "update vetmember set pwd=?, email=?, "
//				+ "addr=?, name=?, phone=?, emailok=?, pettype=?, petname=?, petnum=?,"
//				+ "usertype=?, hospital_name=?,hospital_num=?,hospital_li=?,auth=? where userid=?";
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		try {
//			conn = DBManager_vet.getConnection();
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, mVo.getPwd());
//			pstmt.setString(2, mVo.getEmail());
//			pstmt.setString(3, mVo.getAddr());
//			pstmt.setString(4, mVo.getName());
//			pstmt.setString(5, mVo.getPhone());
//			pstmt.setInt(6, mVo.getEmailok());
//			pstmt.setString(7, mVo.getPettype());
//			pstmt.setString(8, mVo.getPetname());
//			pstmt.setString(9, mVo.getPetnum());
//			pstmt.setString(10, mVo.getUsertype());
//			pstmt.setString(11, mVo.getHospital_name());
//			pstmt.setString(12, mVo.getHospital_num());
//			pstmt.setString(13, mVo.getHospital_li());
//			pstmt.setInt(14, mVo.getAuth());
//			pstmt.setString(15, mVo.getUserid());
//			result = pstmt.executeUpdate();
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (pstmt != null)
//					pstmt.close();
//				if (conn != null)
//					conn.close();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//
//		}
//		return result;
//	}
//
//	public List<VetClinicVO> selectAllBoards() {
//		String sql = "select rownum as m, vetmember.* from vetmember order by rownum desc";
//		List<VetClinicVO> list = new ArrayList<VetClinicVO>();
//		Connection conn = null;
//		Statement stmt = null;
//		ResultSet rs = null;
//		try {
//			conn = DBManager_vet.getConnection();
//			stmt = conn.createStatement();
//			rs = stmt.executeQuery(sql);
//			while (rs.next()) {
//				VetClinicVO bVo = new VetClinicVO();
//				bVo.setUsertype(rs.getString("usertype"));
//				bVo.setUserid(rs.getString("userid"));
//				bVo.setPwd(rs.getString("pwd"));
//				bVo.setName(rs.getString("name"));
//				bVo.setJoindate(rs.getTimestamp("joindate"));
//				bVo.setPhone(rs.getString("phone"));
//				bVo.setEmail(rs.getString("email"));
//				bVo.setAddr(rs.getString("addr"));
//				bVo.setPersonal(rs.getInt("personal"));
//				bVo.setEmailok(rs.getInt("emailok"));
//				bVo.setPettype(rs.getString("pettype"));
//				bVo.setPetname(rs.getString("petname"));
//				bVo.setPetnum(rs.getString("petnum"));
//				bVo.setHospital_name(rs.getString("hospital_name"));
//				bVo.setHospital_num(rs.getString("hospital_num"));
//				bVo.setHospital_li(rs.getString("hospital_li"));
//				bVo.setAuth(rs.getInt("auth"));
//
//				list.add(bVo);
//
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			DBManager_vet.close(conn, stmt, rs);
//		}
//		return list;
//	}
//
//	public ArrayList<VetClinicVO> searchSelect(String page, String pageDataCount, String searchCol, String searchVal) {
//		ArrayList<VetClinicVO> dtos = new ArrayList<VetClinicVO>();
//
////	
//		String sql = String.format("select * from(" + "select rownum m, sub.* " + "from (select * " + "from vetmember "
//				+ "order by rownum desc) sub " + "where rownum <= %s*%s and %s like '%%%s%%') "
//				+ "where m>=(%s-1)*%s+1", page, pageDataCount, searchCol, searchVal, page, pageDataCount);
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
//
//			while (rs.next()) {
//				dtos.add(new VetClinicVO(rs.getString("usertype"), rs.getString("userid"), rs.getString("pwd"),
//						rs.getString("email"), rs.getTimestamp("joindate"), rs.getString("addr"), rs.getString("name"),
//						rs.getString("phone"), rs.getString("pettype"), rs.getString("petname"), rs.getString("petnum"),
//						rs.getInt("personal"), rs.getInt("emailok"), rs.getString("hospital_name"),
//						rs.getString("hospital_num"), rs.getString("hospital_li"), rs.getInt("auth")));
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
//		String query = String.format("select count(userid) count from vetmember");
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
//		sql = String.format("select  count(userid) as bCount from vetmember " + "where %s like '%%%s%%' ", searchCol,
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
//}
