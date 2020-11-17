package com.clinic.pet.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.clinic.pet.dto.BookingVO;
import com.clinic.pet.dto.FaqBoardVO;
import com.clinic.pet.dto.NewsBoardVO;
import com.clinic.pet.dto.NoticeVO;
import com.clinic.pet.dto.PetClinicSearchVO;
import com.clinic.pet.dto.QnaBoardVO;
import com.clinic.pet.dto.VetClinicBoardVO;
import com.clinic.pet.dto.VetClinicVO;
import com.clinic.pet.dto.vetboardCommentVO;

@Repository
public interface PetDao {
	// notice怨듭��궗�빆
	public ArrayList<NoticeVO> select(String page, String pageDataCount);
	public int dataCount();
	public void insertBoard(String notice_title, String notice_name, String notice_content);
	public void deleteBoard(String notice_num);
	public NoticeVO selectOneBoardByNum(String Nnum);
	public void updateBoard(String notice_name, String notice_title, String notice_content, int notice_num);
	public void upHit(String notice_num);

	// �돱�뒪 �럹�씠吏�
	public ArrayList<NewsBoardVO> Newsselect(String page, String pageDataCount);
	public int NewsdataCount();
	public void NewsinsertBoard(String news_title, String news_name, String news_content);
	public void NewsdeleBoard(String news_num);
	public NewsBoardVO NewsselectOneBoardByNum(String news_num);
	public void NewsupdateBoard(String news_name, String news_title, String news_content, int news_num);
	public void NewsupHit(String news_num);

	// faq寃뚯떆�뙋
	public ArrayList<FaqBoardVO> FaqSelect(String page, String pageDataCount);
	public int FaqdataCount();
	public void FaqinsertBoard(FaqBoardVO fVo);
	public void FaqdeleteBoard(String faq_num);
	public FaqBoardVO FaqselectOneBoardByNum(String faq_num);
	public void FaqupdateBoard(FaqBoardVO bVo);
	public void FaqupHit(String faq_num);

	// qna 寃뚯떆�뙋
	public ArrayList<QnaBoardVO> Qnaselect(String page, String pageDataCount);
	public int QnadataCount();
	public void QnainsertBoard(QnaBoardVO qVo);
	public void QnadeleteBoard(String qna_num);
	public QnaBoardVO QnaselectOneBoardByNum(String qna_num);
	public void QnaupdateBoard(QnaBoardVO qVo);
	public void QnaupHit(String qna_num);
	
	//蹂묒썝寃��깋怨� �삁�빟
	public ArrayList<PetClinicSearchVO> petclinicSearchselect(String page, String pageDataCount, String searchCol, String searchVal);
	public int petclnicdataCount(String searchCol, String searchVal);
	public void insertBooking(BookingVO bookingVO);
	public PetClinicSearchVO bookingselectOneBoardByNum(String AHLnum);
	public ArrayList<BookingVO> bookingselectOneBoardById(String bookingid);	
	public ArrayList<BookingVO> bookingselect(String page,String pageDataCount);
	public int bookingdataCount();
	public int mypagedatacount(String searchCol, String searchVal);
	public ArrayList<VetClinicVO> mypagesearchSelect(String page, String pageDataCount, String searchCol, String searchVal);
	public VetClinicVO getMember(String userid);
	public int userCheck(String userid, String pwd);
	public int confirmID(String userid);
	public int signup(VetClinicVO mVo);
	public int updateMember(VetClinicVO mVo);
	
	//boardDAO
	
	public ArrayList<VetClinicBoardVO> select5Boards();
	public ArrayList<VetClinicBoardVO> selectAllBoards();
	public void insertvetBoard(VetClinicBoardVO bVo);
	public void updateReadCount(String num);
	public VetClinicBoardVO vetselectOneBoardByNum(String num);
	public void vetupdateBoard(VetClinicBoardVO bVo);
	public void vetdeleteBoard(String num);
	
	//comment
	public void insertComment(vetboardCommentVO bVo);
	public List<vetboardCommentVO> CommentselectOneBoardByNum(String commentnum);
	
}
