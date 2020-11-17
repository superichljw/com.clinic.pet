package com.clinic.pet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.clinic.pet.dto.SlideVO;
import com.clinic.pet.util.DBManager_vet;

public class SlideDAO {
	private SlideDAO() {
	}
	private static SlideDAO instance = new SlideDAO();
	
	public static SlideDAO getInstance() {
		return instance;
	}
	public int insertSlide(SlideVO slideVO) {
	    int result = 0;

	    String sql = "insert into slide(slideno, pic) values(slideno_seq.nextval, ?)";

	    Connection con = null;
	    PreparedStatement pstmt = null;
	    
	    try {
	      con = DBManager_vet.getConnection();
	      pstmt = con.prepareStatement(sql);
	      pstmt.setString(1, slideVO.getPic());      
	      
	      result = pstmt.executeUpdate();
	    } catch (Exception e) {
	      System.out.println("추가 실패");
	      e.printStackTrace();
	    } finally {
	    	DBManager_vet.close(con, pstmt);
	    }
	    return result;
	  }
	
	public List<SlideVO> select3Slides() {
		String sql = "select pic from (select *from slide order by rownum desc)where rownum < 5 order by rownum desc";
		List<SlideVO> list = new ArrayList<SlideVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager_vet.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				SlideVO sVo = new SlideVO();
				
				sVo.setPic(rs.getString("pic"));
				list.add(sVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager_vet.close(conn, stmt, rs);
		}
		return list;
	}
}
