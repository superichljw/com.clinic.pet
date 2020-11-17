package com.clinic.pet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartRequest;

import com.clinic.pet.dao.PetDao;
import com.clinic.pet.dto.BookingVO;
import com.clinic.pet.dto.FaqBoardVO;
import com.clinic.pet.dto.QnaBoardVO;
import com.clinic.pet.dto.SearchDTO;
import com.clinic.pet.dto.VetClinicBoardVO;
import com.clinic.pet.dto.VetClinicVO;
import com.clinic.pet.dto.noticePageDTO;
import com.clinic.pet.dto.vetboardCommentVO;

/**
 * Handles requests for the application home page.
 */
@Repository
@Controller
public class HomeController {

	@Autowired // spring�꽕�젙�뙆�씪�뿉�꽌 留뚮뱾�뼱 �넃�� bean 媛앹껜瑜� 二쇱엯諛쏆쓬
	@Resource(name = "sqlSession")
	private SqlSession sqlSession;

	@RequestMapping(value = "/")
	public String home() {
		return "redirect:main";
	}

	@RequestMapping(value = "/main")
	public String main(Model model) {
//		VetClinicBoardDAO bDao = VetClinicBoardDAO.getInstance();
//		List<VetClinicBoardVO> boardList = bDao.select5Boards();
//		model.addAttribute("boardList", boardList);

		PetDao petdao = sqlSession.getMapper(PetDao.class);
		model.addAttribute("boardList", petdao.select5Boards());
		return "project_hp/main";
	}

	@RequestMapping(value = "/board_list", method = { RequestMethod.GET, RequestMethod.POST })
	public String petboardlist(Model model) {

//		VetClinicBoardDAO bDao = VetClinicBoardDAO.getInstance();
//		List<VetClinicBoardVO> boardList = bDao.selectAllBoards();
//		model.addAttribute("boardList", boardList);

		PetDao petdao = sqlSession.getMapper(PetDao.class);
		model.addAttribute("boardList", petdao.selectAllBoards());
		return "project_hp/Pet_Doctor_query/vetboard";
	}

	@RequestMapping(value = "/board_write_form", method = { RequestMethod.GET, RequestMethod.POST })
	public String boardwriteform() {
		return "project_hp/Pet_Doctor_query/boardWrite";
	}

	@RequestMapping(value = "/board_write", method = { RequestMethod.GET, RequestMethod.POST })
	public String boardwrite(HttpServletRequest request, Model model, MultipartRequest multipartRequest)
			throws IOException {
//		VetClinicBoardVO bVo = new VetClinicBoardVO();
//		bVo.setName(request.getParameter("name"));
//		bVo.setPass(request.getParameter("pass"));
//		bVo.setEmail(request.getParameter("email"));
//		bVo.setTitle(request.getParameter("title"));
//		bVo.setContent(request.getParameter("content"));
//
//		VetClinicBoardDAO bDao = VetClinicBoardDAO.getInstance();
//		bDao.insertBoard(bVo);
//
//		List<VetClinicBoardVO> boardList = bDao.selectAllBoards();
//		model.addAttribute("boardList", boardList);

		PetDao petdao = sqlSession.getMapper(PetDao.class);
		VetClinicBoardVO bVo = new VetClinicBoardVO();
		bVo.setName(request.getParameter("name"));
		bVo.setPass(request.getParameter("pass"));
		bVo.setEmail(request.getParameter("email"));
		bVo.setTitle(request.getParameter("title"));
		bVo.setContent(request.getParameter("content"));
		petdao.insertvetBoard(bVo);
		model.addAttribute("boardList", petdao.selectAllBoards());

		return "project_hp/Pet_Doctor_query/vetboard";
	}

	@RequestMapping(value = "/board_view", method = { RequestMethod.GET, RequestMethod.POST })
	public String boardview(HttpServletRequest request, Model model) {

//		String num = request.getParameter("num");
//		VetClinicBoardDAO bDao = VetClinicBoardDAO.getInstance();
//		bDao.updateReadCount(num);
//		VetClinicBoardVO bVo = bDao.selectOneBoardByNum(num);
//		model.addAttribute("board", bVo);
//
//		VetBoardCommentDAO vbcDao = VetBoardCommentDAO.getInstance();
//		List<vetboardCommentVO> vbcList = vbcDao.selectOneBoardByNum(num);
//		System.out.println(vbcList);
//		model.addAttribute("vbcList", vbcList);

		PetDao petdao = sqlSession.getMapper(PetDao.class);
		String num = request.getParameter("num");
		petdao.updateReadCount(num);
		model.addAttribute("board", petdao.vetselectOneBoardByNum(num));
		model.addAttribute("vbcList", petdao.CommentselectOneBoardByNum(num));

		return "project_hp/Pet_Doctor_query/vetboardView";
	}

	@RequestMapping("/board_check_pass_form")
	public String boardcheckpassform() {
		return "project_hp/VetBoardPassCheck";
	}

	@RequestMapping("/board_check_pass")
	public String boardcheckpass(HttpServletRequest request, Model model) {
//		String url = null;
//		String num = request.getParameter("num");
//		String pass = request.getParameter("pass");
//		VetClinicBoardDAO bDao = VetClinicBoardDAO.getInstance();
//		VetClinicBoardVO bVo = bDao.selectOneBoardByNum(num);
//		if (bVo.getPass().equals(pass)) { // �꽦怨�
//			url = "project_hp/checkSuccess";
//		} else {// �떎�뙣
//			url = "project_hp/VetBoardCheckPass";
//			model.addAttribute("message", "鍮꾨�踰덊샇媛� ���졇�뒿�땲�떎.");
//		}
		String url = null;
		String num = request.getParameter("num");
		String pass = request.getParameter("pass");
		PetDao petdao = sqlSession.getMapper(PetDao.class);
		VetClinicBoardVO bVo = petdao.vetselectOneBoardByNum(num);
		if (bVo.getPass().equals(pass)) { // �꽦怨�
			url = "project_hp/checkSuccess";
		} else {// �떎�뙣
			url = "project_hp/VetBoardCheckPass";
			model.addAttribute("message", "鍮꾨�踰덊샇媛� ���졇�뒿�땲�떎.");
		}
		return url;
	}

	@RequestMapping("/board_update_form")
	public String boardupdateform(HttpServletRequest request, Model model) {
//		String url = "project_hp/Pet_Doctor_query/NoticeboardUpdate";
//		String num = request.getParameter("num");
//		VetClinicBoardDAO bDao = VetClinicBoardDAO.getInstance();
//		bDao.updateReadCount(num);
//		VetClinicBoardVO bVo = bDao.selectOneBoardByNum(num);
//		model.addAttribute("board", bVo);

		String url = "project_hp/Pet_Doctor_query/NoticeboardUpdate";
		String num = request.getParameter("num");
		PetDao petdao = sqlSession.getMapper(PetDao.class);
		petdao.updateReadCount(num);
		VetClinicBoardVO bVo = petdao.vetselectOneBoardByNum(num);
		model.addAttribute("board", bVo);

		return url;
	}

	@RequestMapping("/board_update")
	public String boardupdate(HttpServletRequest request) {
//		VetClinicBoardVO bVo = new VetClinicBoardVO();
//		bVo.setNum(Integer.parseInt(request.getParameter("num")));
//		bVo.setName(request.getParameter("name"));
//		bVo.setPass(request.getParameter("pass"));
//		bVo.setEmail(request.getParameter("email"));
//		bVo.setTitle(request.getParameter("title"));
//		bVo.setContent(request.getParameter("content"));
//		VetClinicBoardDAO bDao = VetClinicBoardDAO.getInstance();
//		bDao.updateBoard(bVo);

		VetClinicBoardVO bVo = new VetClinicBoardVO();
		bVo.setNum(Integer.parseInt(request.getParameter("num")));
		bVo.setName(request.getParameter("name"));
		bVo.setPass(request.getParameter("pass"));
		bVo.setEmail(request.getParameter("email"));
		bVo.setTitle(request.getParameter("title"));
		bVo.setContent(request.getParameter("content"));

		PetDao petdao = sqlSession.getMapper(PetDao.class);
		petdao.vetupdateBoard(bVo);
		return "redirect:board_list";
	}

	@RequestMapping("/board_delete")
	public String boarddelete(HttpServletRequest request) {
//		String num = request.getParameter("num");
//		VetClinicBoardDAO bDao = VetClinicBoardDAO.getInstance();
//		bDao.deleteBoard(num);
		PetDao petdao = sqlSession.getMapper(PetDao.class);
		String num = request.getParameter("num");
		petdao.vetdeleteBoard(num);
		return "redirect:board_list";
	}

	@RequestMapping("/board_comment")
	public String boardcomment(HttpServletRequest request, Model model) {
//		vetboardCommentVO vbcVo = new vetboardCommentVO();
//		vbcVo.setComment_id(request.getParameter("comment_id"));
//		vbcVo.setComment_board(Integer.parseInt(request.getParameter("comment_board")));
//		vbcVo.setComment_content(request.getParameter("comment_content"));
//		VetBoardCommentDAO vbcDao = VetBoardCommentDAO.getInstance();
//		vbcDao.insertBoard(vbcVo);
//
//		String commentnum = request.getParameter("comment_board");
//		List<vetboardCommentVO> vbcList = vbcDao.selectOneBoardByNum(commentnum);
//
//		model.addAttribute("vbcList", vbcList);

		PetDao petdao = sqlSession.getMapper(PetDao.class);
		vetboardCommentVO vbcVo = new vetboardCommentVO();
		vbcVo.setComment_id(request.getParameter("comment_id"));
		vbcVo.setComment_board(Integer.parseInt(request.getParameter("comment_board")));
		vbcVo.setComment_content(request.getParameter("comment_content"));
		petdao.insertComment(vbcVo);

		String commentnum = request.getParameter("comment_board");
		model.addAttribute("vbcList", petdao.CommentselectOneBoardByNum(commentnum));
		return "redirect:board_view?num=" + commentnum;
	}

	@RequestMapping("/notice_write_view")
	public String noticewriteview() {
		return "project_hp/Pet_Board_notice/noticeWrite";
	}

	@RequestMapping("/notice_list")
	public String noticelist(HttpServletRequest request, Model model) {

		PetDao petdao = sqlSession.getMapper(PetDao.class);
		String page = request.getParameter("page");
		String pageDataCount = request.getParameter("pageDataCount");
		if (page == null) {
			page = "1";// 媛믪씠 �꽆�뼱�삤吏� �븡�븯�쓣�븣 �삁�쇅泥섎━
		}
		if (pageDataCount == null) {
			pageDataCount = "5";// 媛믪씠 �꽆�뼱�삤吏� �븡�븯�쓣�븣 �삁�쇅泥섎━
		}
		model.addAttribute("dtos", petdao.select(page, pageDataCount));

		int totalDataCount = petdao.dataCount();
		noticePageDTO bPageDto = new noticePageDTO();
		bPageDto.makePage(Integer.parseInt(page), Integer.parseInt(pageDataCount), totalDataCount);
		model.addAttribute("bPageDto", bPageDto);

//		String page = request.getParameter("page");
//		String pageDataCount = request.getParameter("pageDataCount");
//		if (page == null) {
//			page = "1";// 媛믪씠 �꽆�뼱�삤吏� �븡�븯�쓣�븣 �삁�쇅泥섎━
//		}
//		if (pageDataCount == null) {
//			pageDataCount = "5";// 媛믪씠 �꽆�뼱�삤吏� �븡�븯�쓣�븣 �삁�쇅泥섎━
//		}
//		NoticeDAO dao = NoticeDAO.getInstance();
//		ArrayList<NoticeVO> dtos = dao.select(page, pageDataCount);
//		model.addAttribute("dtos", dtos);
//
//		int totalDataCount = dao.dataCount();
//		noticePageDTO bPageDto = new noticePageDTO();
//		bPageDto.makePage(Integer.parseInt(page), Integer.parseInt(pageDataCount), totalDataCount);
//		model.addAttribute("bPageDto", bPageDto);
		return "project_hp/Pet_Board_notice/noticeBoard";

	}

	@RequestMapping("/notice_write")
	public String noticewrite(HttpServletRequest request) {
//		NoticeVO bVo = new NoticeVO();
//
//		bVo.setNotice_title(request.getParameter("notice_title"));
//		bVo.setNotice_name(request.getParameter("notice_name"));
//		bVo.setNotice_content(request.getParameter("notice_content"));
//
//		NoticeDAO Ndao = new NoticeDAO();
//		Ndao.insertBoard(bVo);
//		NoticeVO bVo = new NoticeVO();
//		bVo.setNotice_title(request.getParameter("notice_title"));
//		bVo.setNotice_name(request.getParameter("notice_name"));
//		bVo.setNotice_content(request.getParameter("notice_content"));

		PetDao petdao = sqlSession.getMapper(PetDao.class);
		petdao.insertBoard(request.getParameter("notice_title"), request.getParameter("notice_name"),
				request.getParameter("notice_content"));

		return "redirect:notice_list";
	}

	@RequestMapping("/notice_delete")
	public String noticedelete(HttpServletRequest request) {
//		String notice_num = request.getParameter("notice_num");
//		NoticeDAO Ndao = new NoticeDAO();
//		Ndao.deleteBoard(notice_num);

		PetDao petdao = sqlSession.getMapper(PetDao.class);
		petdao.deleteBoard(request.getParameter("notice_num"));

		return "redirect:notice_list";
	}

	@RequestMapping("/notice_content_view")
	public String noticecontentview(HttpServletRequest request, Model model) {
//		String Nnum = request.getParameter("notice_num");
//		NoticeDAO Ndao = new NoticeDAO();
//		NoticeVO bVo = Ndao.selectOneBoardByNum(Nnum);
//		model.addAttribute("bVo", bVo);

		PetDao petdao = sqlSession.getMapper(PetDao.class);
		petdao.upHit(request.getParameter("notice_num"));
		model.addAttribute("bVo", petdao.selectOneBoardByNum(request.getParameter("notice_num")));
		return "project_hp/Pet_Board_notice/NoticeContentView";
	}

	@RequestMapping("/notice_update")
	public String noticeupdate(HttpServletRequest request) {
//		NoticeDAO Ndao = new NoticeDAO();
//		NoticeVO bVo = new NoticeVO();
//		bVo.setNotice_num(Integer.parseInt(request.getParameter("notice_num")));
//		bVo.setNotice_name(request.getParameter("notice_name"));
//		bVo.setNotice_title(request.getParameter("notice_title"));
//		bVo.setNotice_content(request.getParameter("notice_content"));
//		Ndao.updateBoard(bVo);

		PetDao petdao = sqlSession.getMapper(PetDao.class);
		petdao.updateBoard(request.getParameter("notice_name"), request.getParameter("notice_title"),
				request.getParameter("notice_content"), Integer.parseInt(request.getParameter("notice_num")));
		return "redirect:notice_list";

	}

	@RequestMapping("/notice_update_form")
	public String noticeupdateform(HttpServletRequest request, Model model) {
//		String Nnum = request.getParameter("notice_num");
//		NoticeDAO Ndao = new NoticeDAO();
//		NoticeVO bVo = Ndao.selectOneBoardByNum(Nnum);
//		model.addAttribute("bVo", bVo);

		PetDao petdao = sqlSession.getMapper(PetDao.class);
		model.addAttribute("bVo", petdao.selectOneBoardByNum(request.getParameter("notice_num")));

		return "project_hp/Pet_Board_notice/noticeUpdate";
	}

	@RequestMapping("/news_list")
	public String newslist(HttpServletRequest request, Model model) {
//		String page = (String) request.getParameter("page");
//		String pageDataCount = (String) request.getParameter("pageDataCount");
//		if (page == null) {
//			page = "1";// 媛믪씠 �꽆�뼱�삤吏� �븡�븯�쓣�븣 �삁�쇅泥섎━
//		}
//		if (pageDataCount == null) {
//			pageDataCount = "5";// 媛믪씠 �꽆�뼱�삤吏� �븡�븯�쓣�븣 �삁�쇅泥섎━
//		}
//		System.out.println(page);
//		System.out.println(pageDataCount);
//		NoticeDAO Ndao = new NoticeDAO();
//		ArrayList<NewsBoardVO> newsdtos = Ndao.Newsselect(page, pageDataCount);
//		request.setAttribute("newsdtos", newsdtos);
//		int totalDataCount = Ndao.NewsdataCount();
//
//		noticePageDTO newsDto = new noticePageDTO();
//		newsDto.makePage(Integer.parseInt(page), Integer.parseInt(pageDataCount), totalDataCount);
//		request.setAttribute("newsDto", newsDto);

		PetDao petdao = sqlSession.getMapper(PetDao.class);
		String page = (String) request.getParameter("page");
		String pageDataCount = (String) request.getParameter("pageDataCount");
		if (page == null) {
			page = "1";// 媛믪씠 �꽆�뼱�삤吏� �븡�븯�쓣�븣 �삁�쇅泥섎━
		}
		if (pageDataCount == null) {
			pageDataCount = "5";// 媛믪씠 �꽆�뼱�삤吏� �븡�븯�쓣�븣 �삁�쇅泥섎━
		}
		model.addAttribute("newsdtos", petdao.Newsselect(page, pageDataCount));
		int totalDataCount = petdao.NewsdataCount();

		noticePageDTO newsDto = new noticePageDTO();
		newsDto.makePage(Integer.parseInt(page), Integer.parseInt(pageDataCount), totalDataCount);
		model.addAttribute("newsDto", newsDto);

		return "project_hp/Pet_Board_news/newsBoard";
	}

	@RequestMapping("/news_write")
	public String newswrite(HttpServletRequest request) {
//		NewsBoardVO bVo = new NewsBoardVO();
//
//		bVo.setNews_title(request.getParameter("news_title"));
//		bVo.setNews_name(request.getParameter("news_name"));
//		bVo.setNews_content(request.getParameter("news_content"));
//		NoticeDAO Ndao = new NoticeDAO();
//		Ndao.NewsinsertBoard(bVo);

		PetDao petdao = sqlSession.getMapper(PetDao.class);
		petdao.NewsinsertBoard(request.getParameter("news_title"), request.getParameter("news_name"),
				request.getParameter("news_content"));
		return "redirect:news_list";
	}

	@RequestMapping("/news_write_form")
	public String newswriteform() {
		return "project_hp/Pet_Board_news/newsWrite";
	}

	@RequestMapping("/news_content_view")
	public String newscontentview(HttpServletRequest request, Model model) {
//		String Nnum = request.getParameter("news_num");
//		NoticeDAO Ndao = new NoticeDAO();
//		NewsBoardVO newsVo = Ndao.NewsselectOneBoardByNum(Nnum);
//		model.addAttribute("newsVo", newsVo);

		PetDao petdao = sqlSession.getMapper(PetDao.class);
		petdao.NewsupHit(request.getParameter("news_num"));
		model.addAttribute("newsVo", petdao.NewsselectOneBoardByNum(request.getParameter("news_num")));
		return "project_hp/Pet_Board_news/NewsContentView";
	}

	@RequestMapping("/news_update_form")
	public String newsupdateform(HttpServletRequest request, Model model) {
//		String Nnum = request.getParameter("news_num");
//		NoticeDAO Ndao = new NoticeDAO();
//		NewsBoardVO newsVo = Ndao.NewsselectOneBoardByNum(Nnum);
//		model.addAttribute("newsVo", newsVo);

		PetDao petdao = sqlSession.getMapper(PetDao.class);
		model.addAttribute("newsVo", petdao.NewsselectOneBoardByNum(request.getParameter("news_num")));
		return "project_hp/Pet_Board_news/newsUpdate";
	}

	@RequestMapping("/news_update")
	public String newsupdate(HttpServletRequest request) {
//		NoticeDAO Ndao = new NoticeDAO();
//		NewsBoardVO bVo = new NewsBoardVO();
//		bVo.setNews_num(Integer.parseInt(request.getParameter("news_num")));
//		bVo.setNews_name(request.getParameter("news_name"));
//		bVo.setNews_title(request.getParameter("news_title"));
//		bVo.setNews_content(request.getParameter("news_content"));
//		Ndao.NewsupdateBoard(bVo);

		PetDao petdao = sqlSession.getMapper(PetDao.class);
		petdao.NewsupdateBoard(request.getParameter("news_name"), request.getParameter("news_title"),
				request.getParameter("news_content"), Integer.parseInt(request.getParameter("news_num")));

		return "redirect:news_list";
	}

	@RequestMapping("/news_delete")
	public String newsdelete(HttpServletRequest request) {
//		String news_num = request.getParameter("news_num");
//		NoticeDAO Ndao = new NoticeDAO();
//		Ndao.NewsdeleteBoard(news_num);

		PetDao petdao = sqlSession.getMapper(PetDao.class);
		petdao.NewsdeleBoard(request.getParameter("news_num"));
		return "redirect:news_list";
	}

	@RequestMapping("/faq_list")
	public String faqlist(HttpServletRequest request, Model model) {
//		String page = (String) request.getParameter("page");
//		String pageDataCount = (String) request.getParameter("pageDataCount");
//		if (page == null) {
//			page = "1";// 媛믪씠 �꽆�뼱�삤吏� �븡�븯�쓣�븣 �삁�쇅泥섎━
//		}
//		if (pageDataCount == null) {
//			pageDataCount = "5";// 媛믪씠 �꽆�뼱�삤吏� �븡�븯�쓣�븣 �삁�쇅泥섎━
//		}
//		System.out.println(page);
//		System.out.println(pageDataCount);
//		FaqDAO Ndao = new FaqDAO();
//		ArrayList<FaqBoardVO> faqdtos = Ndao.select(page, pageDataCount);
//		model.addAttribute("faqdtos", faqdtos);
//		int totalDataCount = Ndao.dataCount();
//
//		noticePageDTO faqPage = new noticePageDTO();
//		faqPage.makePage(Integer.parseInt(page), Integer.parseInt(pageDataCount), totalDataCount);
//		model.addAttribute("faqPage", faqPage);

		PetDao petdao = sqlSession.getMapper(PetDao.class);
		String page = (String) request.getParameter("page");
		String pageDataCount = (String) request.getParameter("pageDataCount");
		if (page == null) {
			page = "1";// 媛믪씠 �꽆�뼱�삤吏� �븡�븯�쓣�븣 �삁�쇅泥섎━
		}
		if (pageDataCount == null) {
			pageDataCount = "5";// 媛믪씠 �꽆�뼱�삤吏� �븡�븯�쓣�븣 �삁�쇅泥섎━
		}
		model.addAttribute("faqdtos", petdao.FaqSelect(page, pageDataCount));
		int totalDataCount = petdao.dataCount();
		noticePageDTO faqPage = new noticePageDTO();
		faqPage.makePage(Integer.parseInt(page), Integer.parseInt(pageDataCount), totalDataCount);
		model.addAttribute("faqPage", faqPage);

		return "project_hp/Pet_Board_faq/faqBoard";
	}

	@RequestMapping("/faq_content_view")
	public String faqcontentview(HttpServletRequest request, Model model) {
//		String Nnum = request.getParameter("faq_num");
//		FaqDAO Ndao = new FaqDAO();
//		FaqBoardVO faqVo = Ndao.selectOneBoardByNum(Nnum);
//		model.addAttribute("faqVo", faqVo);

		PetDao petdao = sqlSession.getMapper(PetDao.class);
		petdao.FaqupHit(request.getParameter("faq_num"));
		model.addAttribute("faqVo", petdao.FaqselectOneBoardByNum(request.getParameter("faq_num")));
		return "project_hp/Pet_Board_faq/FaqContentView";
	}

	@RequestMapping("/faq_delete")
	public String faqdelete(HttpServletRequest request) {
//		String faq_num = request.getParameter("faq_num");
//		FaqDAO Ndao = new FaqDAO();
//		Ndao.deleteBoard(faq_num);

		PetDao petdao = sqlSession.getMapper(PetDao.class);
		petdao.FaqdeleteBoard(request.getParameter("faq_num"));
		return "redirect:faq_list";
	}

	@RequestMapping("/faq_update")
	public String faqupdate(HttpServletRequest request) {
//		FaqDAO Ndao = new FaqDAO();
//		FaqBoardVO bVo = new FaqBoardVO();
//
//		bVo.setFaq_num(Integer.parseInt(request.getParameter("faq_num")));
//		bVo.setFaq_name(request.getParameter("faq_name"));
//		bVo.setFaq_title(request.getParameter("faq_title"));
//		bVo.setFaq_content(request.getParameter("faq_content"));
//		Ndao.updateBoard(bVo);

		PetDao petdao = sqlSession.getMapper(PetDao.class);
		FaqBoardVO bVo = new FaqBoardVO();
		bVo.setFaq_num(Integer.parseInt(request.getParameter("faq_num")));
		bVo.setFaq_name(request.getParameter("faq_name"));
		bVo.setFaq_title(request.getParameter("faq_title"));
		bVo.setFaq_content(request.getParameter("faq_content"));
		petdao.FaqupdateBoard(bVo);
		return "redirect:faq_list";
	}

	@RequestMapping("/faq_update_form")
	public String faqupdateform(HttpServletRequest request, Model model) {
//		String Nnum = request.getParameter("faq_num");
//		FaqDAO Ndao = new FaqDAO();
//		FaqBoardVO faqVo = Ndao.selectOneBoardByNum(Nnum);
//		model.addAttribute("faqVo", faqVo);

		PetDao petdao = sqlSession.getMapper(PetDao.class);
		model.addAttribute("faqVo", petdao.FaqselectOneBoardByNum(request.getParameter("faq_num")));
		return "project_hp/Pet_Board_faq/FaqUpdate";
	}

	@RequestMapping("/faq_write")
	public String faqwrite(HttpServletRequest request) {
//		FaqBoardVO bVo = new FaqBoardVO();
//		bVo.setFaq_title(request.getParameter("faq_title"));
//		bVo.setFaq_name(request.getParameter("faq_name"));
//		bVo.setFaq_content(request.getParameter("faq_content"));
//		FaqDAO Ndao = new FaqDAO();
//		Ndao.insertBoard(bVo);

		PetDao petdao = sqlSession.getMapper(PetDao.class);
		FaqBoardVO fVo = new FaqBoardVO();
		fVo.setFaq_title(request.getParameter("faq_title"));
		fVo.setFaq_name(request.getParameter("faq_name"));
		fVo.setFaq_content(request.getParameter("faq_content"));
		petdao.FaqinsertBoard(fVo);
		return "redirect:faq_list";
	}

	@RequestMapping("/faq_write_form")
	public String faqwriteform() {
		return "project_hp/Pet_Board_faq/FaqWrite";
	}

	@RequestMapping("/qna_list")
	public String qnalist(HttpServletRequest request, Model model) {
//		String page = (String) request.getParameter("page");
//		String pageDataCount = (String) request.getParameter("pageDataCount");
//		if (page == null) {
//			page = "1";// 媛믪씠 �꽆�뼱�삤吏� �븡�븯�쓣�븣 �삁�쇅泥섎━
//		}
//		if (pageDataCount == null) {
//			pageDataCount = "5";// 媛믪씠 �꽆�뼱�삤吏� �븡�븯�쓣�븣 �삁�쇅泥섎━
//		}
//		System.out.println(page);
//		System.out.println(pageDataCount);
//		QnaDAO qdao = new QnaDAO();
//		ArrayList<QnaBoardVO> qnadtos = qdao.select(page, pageDataCount);
//		model.addAttribute("qnadtos", qnadtos);
//		int totalDataCount = qdao.dataCount();
//
//		noticePageDTO qnaPage = new noticePageDTO();
//		qnaPage.makePage(Integer.parseInt(page), Integer.parseInt(pageDataCount), totalDataCount);
//		model.addAttribute("qnaPage", qnaPage);

		PetDao petdao = sqlSession.getMapper(PetDao.class);

		String page = (String) request.getParameter("page");
		String pageDataCount = (String) request.getParameter("pageDataCount");
		if (page == null) {
			page = "1";// 媛믪씠 �꽆�뼱�삤吏� �븡�븯�쓣�븣 �삁�쇅泥섎━
		}
		if (pageDataCount == null) {
			pageDataCount = "5";// 媛믪씠 �꽆�뼱�삤吏� �븡�븯�쓣�븣 �삁�쇅泥섎━
		}
		model.addAttribute("qnadtos", petdao.Qnaselect(page, pageDataCount));
		int totalDataCount = petdao.QnadataCount();
		noticePageDTO qnaPage = new noticePageDTO();
		qnaPage.makePage(Integer.parseInt(page), Integer.parseInt(pageDataCount), totalDataCount);
		model.addAttribute("qnaPage", qnaPage);

		return "project_hp/Pet_Board_qna/qnaBoard";
	}

	@RequestMapping("/qna_content_view")
	public String qnacontentview(HttpServletRequest request, Model model) {
//		String Nnum = request.getParameter("qna_num");
//		QnaDAO qdao = new QnaDAO();
//		QnaBoardVO qnaVo = qdao.selectOneBoardByNum(Nnum);
//		model.addAttribute("qnaVo", qnaVo);
		PetDao petdao = sqlSession.getMapper(PetDao.class);
		petdao.QnaupHit(request.getParameter("qna_num"));
		model.addAttribute("qnaVo", petdao.QnaselectOneBoardByNum(request.getParameter("qna_num")));
		return "project_hp/Pet_Board_qna/QnaContentView";
	}

	@RequestMapping("/qna_delete")
	public String qnadelete(HttpServletRequest request) {
//		String qna_num = request.getParameter("qna_num");
//		QnaDAO Ndao = new QnaDAO();
//		Ndao.deleteBoard(qna_num);

		PetDao petdao = sqlSession.getMapper(PetDao.class);
		petdao.QnadeleteBoard(request.getParameter("qna_num"));

		return "redirect:qna_list";
	}

	@RequestMapping("/qna_update")
	public String qnaupdate(HttpServletRequest request) {
//		QnaDAO Ndao = new QnaDAO();
//		QnaBoardVO bVo = new QnaBoardVO();
//
//		bVo.setQna_num(Integer.parseInt(request.getParameter("qna_num")));
//		bVo.setQna_name(request.getParameter("qna_name"));
//		bVo.setQna_title(request.getParameter("qna_title"));
//		bVo.setQna_content(request.getParameter("qna_content"));
//		Ndao.updateBoard(bVo);

		PetDao petdao = sqlSession.getMapper(PetDao.class);
		QnaBoardVO qVo = new QnaBoardVO();

		qVo.setQna_num(Integer.parseInt(request.getParameter("qna_num")));
		qVo.setQna_name(request.getParameter("qna_name"));
		qVo.setQna_title(request.getParameter("qna_title"));
		qVo.setQna_content(request.getParameter("qna_content"));
		petdao.QnaupdateBoard(qVo);

		return "redirect:qna_list";
	}

	@RequestMapping("/qna_update_form")
	public String qnaupdateform(HttpServletRequest request, Model model) {
//		String Nnum = request.getParameter("qna_num");
//		QnaDAO Ndao = new QnaDAO();
//		QnaBoardVO qnaVo = Ndao.selectOneBoardByNum(Nnum);
//		model.addAttribute("qnaVo", qnaVo);

		PetDao petdao = sqlSession.getMapper(PetDao.class);
		model.addAttribute("qnaVo", petdao.QnaselectOneBoardByNum(request.getParameter("qna_num")));

		return "project_hp/Pet_Board_qna/QnaUpdate";
	}

	@RequestMapping("/qna_write")
	public String qnawrite(HttpServletRequest request) {
//		QnaBoardVO bVo = new QnaBoardVO();
//
//		bVo.setQna_title(request.getParameter("qna_title"));
//		bVo.setQna_name(request.getParameter("qna_name"));
//		bVo.setQna_content(request.getParameter("qna_content"));
//
//		QnaDAO Ndao = new QnaDAO();
//		Ndao.insertBoard(bVo);
		PetDao petdao = sqlSession.getMapper(PetDao.class);
		QnaBoardVO qVo = new QnaBoardVO();

		qVo.setQna_title(request.getParameter("qna_title"));
		qVo.setQna_name(request.getParameter("qna_name"));
		qVo.setQna_content(request.getParameter("qna_content"));
		petdao.QnainsertBoard(qVo);
		return "redirect:qna_list";
	}

	@RequestMapping("/qna_write_form")
	public String qnawriteform() {
		return "project_hp/Pet_Board_qna/QnaWrite";
	}

	@RequestMapping("/search_list")
	public String searchlist(HttpServletRequest request, Model model) {
//		String page = request.getParameter("page");
//		String pageDataCount = request.getParameter("pageDataCount");
//		if (page == null) {
//			page = "1";
//		}
//		if (pageDataCount == null) {
//			pageDataCount = "10";
//		}
//
//		String searchCol = (String) request.getParameter("searchCol");
//		String searchVal = (String) request.getParameter("searchVal");
//		if (searchCol == null || searchVal == null) {
//			searchCol = "AHLname";
//			searchVal = "";
//		}
//		if (searchCol.equals("") || searchVal.equals("")) {
//			searchCol = "AHLname";
//			searchVal = "";
//		}
//
//		SearchDAO sDao = new SearchDAO();
//		ArrayList<PetClinicSearchVO> dtos = sDao.searchSelect(page, pageDataCount, searchCol, searchVal);
//		model.addAttribute("searchdtos", dtos);
//
//		int totalDataCount = sDao.dataCount(searchCol, searchVal);
//		SearchDTO searchPage1 = new SearchDTO();
//		searchPage1.makePage(Integer.parseInt(page), Integer.parseInt(pageDataCount), totalDataCount, searchCol,
//				searchVal);
//		model.addAttribute("searchPage", searchPage1);

		PetDao petdao = sqlSession.getMapper(PetDao.class);

		String page = request.getParameter("page");
		String pageDataCount = request.getParameter("pageDataCount");
		String searchCol = request.getParameter("searchCol");
		String searchVal = request.getParameter("searchVal");
		if (page == null) {
			page = "1";
		}
		if (pageDataCount == null) {
			pageDataCount = "10";
		}

		if (searchCol == null || searchVal == null) {
			searchCol = "AHLname";
			searchVal = "";
		}
		if (searchCol.equals("") || searchVal.equals("")) {
			searchCol = "AHLname";
			searchVal = "";
		}
		model.addAttribute("searchdtos", petdao.petclinicSearchselect(page, pageDataCount, searchCol, searchVal));

		int totalDataCount = petdao.petclnicdataCount(searchCol, searchVal);
		SearchDTO searchPage1 = new SearchDTO();
		searchPage1.makePage(Integer.parseInt(page), Integer.parseInt(pageDataCount), totalDataCount, searchCol,
				searchVal);
		model.addAttribute("searchPage", searchPage1);
		System.out.println(totalDataCount);
		System.out.println(searchVal);
		return "project_hp/Pet_ClinicSearch/clinic";
	}

	@RequestMapping("/booking_insert")
	public String bookinginsert(HttpServletRequest request, Model model) {
//		BookingVO bookingVO = new BookingVO();
//		HttpSession session = request.getSession();
//		VetClinicVO loginUser = (VetClinicVO) session.getAttribute("loginUser");
//
//		bookingVO.setBooking_Name(request.getParameter("booking_name"));
//		bookingVO.setBooking_id(loginUser.getUserid());
//		bookingVO.setBooking_Add(request.getParameter("booking_add"));
//		bookingVO.setBooking_Date(request.getParameter("booking_date"));
//		bookingVO.setBooking_Tel(request.getParameter("booking_tel"));
//
//		BookingDAO bookDAO = new BookingDAO();
//		bookDAO.insertBooking(bookingVO);
//
//		model.addAttribute("bookingVO", bookingVO);

		PetDao petdao = sqlSession.getMapper(PetDao.class);
		BookingVO bookingVO = new BookingVO();
		HttpSession session = request.getSession();
		VetClinicVO loginUser = (VetClinicVO) session.getAttribute("loginUser");

		bookingVO.setBooking_Name(request.getParameter("booking_name"));
		bookingVO.setBooking_id(loginUser.getUserid());
		bookingVO.setBooking_Add(request.getParameter("booking_add"));
		bookingVO.setBooking_Date(request.getParameter("booking_date"));
		bookingVO.setBooking_Tel(request.getParameter("booking_tel"));

		petdao.insertBooking(bookingVO);

		return "redirect:search_list";
	}

	@RequestMapping("/booking_content_view")
	public String bookingcontentview(HttpServletRequest request, Model model) {
//		String Nnum = request.getParameter("AHLnum");
//		SearchDAO sdao = new SearchDAO();
//		PetClinicSearchVO searchVO = sdao.selectOneBoardByNum(Nnum);
//		model.addAttribute("searchVO", searchVO);

		PetDao petdao = sqlSession.getMapper(PetDao.class);
		model.addAttribute("searchVO", petdao.bookingselectOneBoardByNum(request.getParameter("AHLnum")));

		return "project_hp/Pet_ClinicSearch/booking_contentView";
	}

	@RequestMapping("/booking_mypage")
	public String bookingmypage(HttpServletRequest request, Model model) {
//		HttpSession session = request.getSession();
//		VetClinicVO loginUser = (VetClinicVO) session.getAttribute("loginUser");
//
//		String bookingid = loginUser.getUserid();
//
//		System.out.println("id : " + bookingid);
//		BookingDAO bdao = new BookingDAO();
//		List<BookingVO> bookingidList = bdao.selectOneBoardById(bookingid);
//
//		model.addAttribute("bookingidList", bookingidList);

		HttpSession session = request.getSession();
		VetClinicVO loginUser = (VetClinicVO) session.getAttribute("loginUser");
		String bookingid = loginUser.getUserid();

		PetDao petdao = sqlSession.getMapper(PetDao.class);
		model.addAttribute("bookingidList", petdao.bookingselectOneBoardById(bookingid));

		return "project_hp/Pet_Mypage/mypageIndex";
	}

	@RequestMapping("/booking_list")
	public String booking_list(HttpServletRequest request, Model model) {
//		String page = (String) request.getParameter("page");
//		String pageDataCount = (String) request.getParameter("pageDataCount");
//		if (page == null) {
//			page = "1";// 媛믪씠 �꽆�뼱�삤吏� �븡�븯�쓣�븣 �삁�쇅泥섎━
//		}
//		if (pageDataCount == null) {
//			pageDataCount = "5";// 媛믪씠 �꽆�뼱�삤吏� �븡�븯�쓣�븣 �삁�쇅泥섎━
//		}
//		System.out.println(page);
//		System.out.println(pageDataCount);
//
//		BookingDAO bookingdao = new BookingDAO();
//		ArrayList<BookingVO> bookingdtos = bookingdao.select(page, pageDataCount);
//		model.addAttribute("bookingdtos", bookingdtos);
//		int totalDataCount = bookingdao.dataCount();
//
//		noticePageDTO bookingPage = new noticePageDTO();
//		bookingPage.makePage(Integer.parseInt(page), Integer.parseInt(pageDataCount), totalDataCount);
//		model.addAttribute("bookingPage", bookingPage);

		PetDao petdao = sqlSession.getMapper(PetDao.class);
		String page = (String) request.getParameter("page");
		String pageDataCount = (String) request.getParameter("pageDataCount");
		if (page == null) {
			page = "1";// 媛믪씠 �꽆�뼱�삤吏� �븡�븯�쓣�븣 �삁�쇅泥섎━
		}
		if (pageDataCount == null) {
			pageDataCount = "5";// 媛믪씠 �꽆�뼱�삤吏� �븡�븯�쓣�븣 �삁�쇅泥섎━
		}
		model.addAttribute("bookingdtos", petdao.bookingselect(page, pageDataCount));
		noticePageDTO bookingPage = new noticePageDTO();
		int totalDataCount = petdao.bookingdataCount();
		bookingPage.makePage(Integer.parseInt(page), Integer.parseInt(pageDataCount), totalDataCount);
		model.addAttribute("bookingPage", bookingPage);
		return "project_hp/Pet_Booking/booking";
	}

	@RequestMapping("/mypage_mod_byadmin")
	public String mypagemodbyadmin(HttpServletRequest request, Model model) {
//		String page = (String) request.getParameter("page");
//		String pageDataCount = (String) request.getParameter("pageDataCount");
//		if (page == null) {
//			page = "1";
//		}
//		if (pageDataCount == null) {
//			pageDataCount = "10";
//		}
//
//		String searchCol = (String) request.getParameter("searchCol");
//		String searchVal = (String) request.getParameter("searchVal");
//		if (searchCol == null || searchVal == null) {
//			searchCol = "userid";
//			searchVal = "";
//		}
//		if (searchCol.equals("") || searchVal.equals("")) {
//			searchCol = "userid";
//			searchVal = "";
//		}
//
//		VetClinicDAO sDao = new VetClinicDAO();
//		ArrayList<VetClinicVO> dtos = sDao.searchSelect(page, pageDataCount, searchCol, searchVal);
//		model.addAttribute("searchdtos", dtos);
//
//		int totalDataCount = sDao.dataCount(searchCol, searchVal);
//		SearchDTO searchPage1 = new SearchDTO();
//		searchPage1.makePage(Integer.parseInt(page), Integer.parseInt(pageDataCount), totalDataCount, searchCol,
//				searchVal);
//		model.addAttribute("searchPage", searchPage1);

		PetDao petdao = sqlSession.getMapper(PetDao.class);
		String page = (String) request.getParameter("page");
		String pageDataCount = (String) request.getParameter("pageDataCount");
		String searchCol = (String) request.getParameter("searchCol");
		String searchVal = (String) request.getParameter("searchVal");
		if (page == null) {
			page = "1";
		}
		if (pageDataCount == null) {
			pageDataCount = "10";
		}
		if (searchCol == null || searchVal == null) {
			searchCol = "userid";
			searchVal = "";
		}
		if (searchCol.equals("") || searchVal.equals("")) {
			searchCol = "userid";
			searchVal = "";
		}
		model.addAttribute("searchdtos", petdao.mypagesearchSelect(page, pageDataCount, searchCol, searchVal));
		int totalDataCount = petdao.mypagedatacount(searchCol, searchVal);
		SearchDTO searchPage1 = new SearchDTO();
		searchPage1.makePage(Integer.parseInt(page), Integer.parseInt(pageDataCount), totalDataCount, searchCol,
				searchVal);
		model.addAttribute("searchPage", searchPage1);

		return "project_hp/Pet_Mypage/mypagebyAdmin";
	}

	@RequestMapping("/mem_update_byadmin")
	public String memupdatebyadmin(HttpServletRequest request, Model model) {
//		String userid = request.getParameter("userid");
//		VetClinicDAO sdao = new VetClinicDAO();
//		VetClinicVO vetVo = sdao.getMember(userid);
//
//		model.addAttribute("vetVo", vetVo);

		PetDao petdao = sqlSession.getMapper(PetDao.class);
		model.addAttribute("vetVo", petdao.getMember(request.getParameter("userid")));

		return "project_hp/Pet_Mypage/mypageModbyadmin";
	}

	@RequestMapping("/login_form")
	public String loginform() {
		return "project_hp/Pet_Login/login";
	}

	@RequestMapping("/login")
	public void login(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {
//		String userid = request.getParameter("userid");
//		String pwd = request.getParameter("pwd");
//
//		VetClinicDAO mDao = VetClinicDAO.getInstance();
//		int result = mDao.userCheck(userid, pwd);
//
//		HttpSession session = request.getSession();
//
//		if (result == 1) {
//			VetClinicVO mVo = mDao.getMember(userid);
//			session.setAttribute("loginUser", mVo);
//			model.addAttribute("message", "濡쒓렇�씤 �븯���뒿�땲�떎.");
//		} else if (result == 0) {
//			model.addAttribute("message", "鍮꾨�踰덊샇媛� 留욎� �븡�뒿�땲�떎.");
//		} else if (result == -1) {
//			model.addAttribute("message", "議댁옱�븯吏� �븡�뒗 �쉶�썝�엯�땲�떎.");
//		}
//
//		response.setContentType("text/html; charset=UTF-8");
//		PrintWriter out = response.getWriter();
//		out.println("<script>alert('濡쒓렇�씤 �븯���뒿�땲�떎'); opener.location.reload(); window.close();</script>");
//		out.flush();

		PetDao petdao = sqlSession.getMapper(PetDao.class);
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");

		int result = petdao.userCheck(userid, pwd);
		if (userid == null) {
			result = -1;
		}
		HttpSession session = request.getSession();

		if (result == 1) {
			VetClinicVO mVo = petdao.getMember(userid);
			session.setAttribute("loginUser", mVo);
			model.addAttribute("message", "濡쒓렇�씤 �븯���뒿�땲�떎.");
		} else if (result == 0) {
			model.addAttribute("message", "鍮꾨�踰덊샇媛� 留욎� �븡�뒿�땲�떎.");
		} else if (result == -1) {
			model.addAttribute("message", "議댁옱�븯吏� �븡�뒗 �쉶�썝�엯�땲�떎.");
		}

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<script>alert('濡쒓렇�씤 �븯���뒿�땲�떎'); opener.location.reload(); window.close();</script>");
		out.flush();
	}

	@RequestMapping("/login_check")
	public String logincheck(HttpServletRequest request, Model model) {
//		String userid = request.getParameter("userid");
//
//		VetClinicDAO mDao = VetClinicDAO.getInstance();
//
//		int result = mDao.confirmID(userid);
//		model.addAttribute("userid", userid);
//		model.addAttribute("result", result);

		PetDao petdao = sqlSession.getMapper(PetDao.class);
		String userid = request.getParameter("userid");
		int result = petdao.confirmID(userid);

		model.addAttribute("userid", userid);
		model.addAttribute("result", result);
		return "project_hp/Pet_Login/idcheck";
	}

	@RequestMapping("/signup_form")
	public String signupform() {
		return "project_hp/Pet_Signup/signup";
	}

	@RequestMapping("/signup_type_form")
	public String signuptypeform() {
		return "project_hp/Pet_Signup/signupType";
	}

	@RequestMapping("/docsignup")
	public String docsignup() {
		return "project_hp/Pet_Signup/docsignup";
	}

	@RequestMapping("/selfinspection_popup")
	public String selfinspectionpopup() {
		return "project_hp/Pet_Inspection/selfinspection_popup";
	}

	@RequestMapping("/signup")
	public void signup(HttpServletRequest request, HttpServletResponse response, Model model)
			throws ServletException, IOException {

//		String usertype = request.getParameter("usertype");
//		String hospital_name = request.getParameter("hospital_name");
//		String hospital_num = request.getParameter("hospital_num");
//		String hospital_li = request.getParameter("hospital_li");
//		String userid = request.getParameter("userid");
//		String pwd = request.getParameter("pwd");
//		String email = request.getParameter("email");
//		String phone = request.getParameter("phone");
//		String name = request.getParameter("name");
//		String addr = request.getParameter("postcode") + request.getParameter("address")
//				+ request.getParameter("referAdd") + request.getParameter("detailAdd");
//		String pettype = request.getParameter("pettype");
//		String petname = request.getParameter("petname");
//		String petnum = request.getParameter("petnum");
//		String personal = request.getParameter("personal");
//		String emailok = request.getParameter("emailok");
//		String auth = request.getParameter("auth");
//
//		VetClinicVO mVo = new VetClinicVO();
//
//		mVo.setUsertype(usertype);
//		mVo.setHospital_name(hospital_name);
//		mVo.setHospital_num(hospital_num);
//		mVo.setHospital_li(hospital_li);
//		mVo.setAuth(Integer.parseInt(auth));
//		mVo.setUserid(userid);
//		mVo.setPwd(pwd);
//		mVo.setEmail(email);
//		mVo.setPhone(phone);
//		mVo.setAddr(addr);
//		mVo.setName(name);
//		mVo.setPersonal(Integer.parseInt(personal));
//		mVo.setEmailok(Integer.parseInt(emailok));
//		mVo.setPetname(petname);
//		mVo.setPettype(pettype);
//		mVo.setPetnum(petnum);
//
//		VetClinicDAO mDao = VetClinicDAO.getInstance();
//
//		int result = mDao.insertMember(mVo);
//
//		HttpSession session = request.getSession();
//
//		if (result == 1) {
//			session.setAttribute("userid", mVo.getUserid());
//			model.addAttribute("message", "�쉶�썝 媛��엯�뿉 �꽦怨듯뻽�뒿�땲�떎.");
//		} else {
//			model.addAttribute("message", "�쉶�썝 媛��엯�뿉 �떎�뙣�뻽�뒿�땲�떎.");
//		}
//
//		response.setContentType("text/html; charset=UTF-8");
//
//		PrintWriter out = response.getWriter();
//
//		out.println("<script>alert('�쉶�썝媛��엯�씠 �셿猷� �릺�뿀�뒿�땲�떎'); window.close();</script>");
//
//		out.flush();

		String usertype = request.getParameter("usertype");
		String hospital_name = request.getParameter("hospital_name");
		String hospital_num = request.getParameter("hospital_num");
		String hospital_li = request.getParameter("hospital_li");
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String name = request.getParameter("name");
		String addr = request.getParameter("postcode") + request.getParameter("address")
				+ request.getParameter("referAdd") + request.getParameter("detailAdd");
		String pettype = request.getParameter("pettype");
		String petname = request.getParameter("petname");
		String petnum = request.getParameter("petnum");
		String personal = request.getParameter("personal");
		String emailok = request.getParameter("emailok");
		String auth = request.getParameter("auth");

		VetClinicVO mVo = new VetClinicVO();

		mVo.setUsertype(usertype);
		mVo.setHospital_name(hospital_name);
		mVo.setHospital_num(hospital_num);
		mVo.setHospital_li(hospital_li);
		mVo.setAuth(Integer.parseInt(auth));
		mVo.setUserid(userid);
		mVo.setPwd(pwd);
		mVo.setEmail(email);
		mVo.setPhone(phone);
		mVo.setAddr(addr);
		mVo.setName(name);
		mVo.setPersonal(Integer.parseInt(personal));
		mVo.setEmailok(Integer.parseInt(emailok));
		mVo.setPetname(petname);
		mVo.setPettype(pettype);
		mVo.setPetnum(petnum);

		PetDao petdao = sqlSession.getMapper(PetDao.class);

		int result = petdao.signup(mVo);

		HttpSession session = request.getSession();

		if (result == 1) {
			session.setAttribute("userid", mVo.getUserid());
			model.addAttribute("message", "�쉶�썝 媛��엯�뿉 �꽦怨듯뻽�뒿�땲�떎.");
		} else {
			model.addAttribute("message", "�쉶�썝 媛��엯�뿉 �떎�뙣�뻽�뒿�땲�떎.");
		}

		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();

		out.println("<script>alert('�쉶�썝媛��엯�씠 �셿猷� �릺�뿀�뒿�땲�떎'); window.close();</script>");

		out.flush();

	}

	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "redirect:main";
	}

	@RequestMapping("/member_info")
	public String memberinfo(HttpServletRequest request, Model model) {

//		HttpSession session = request.getSession();
//		VetClinicVO loginUser = (VetClinicVO) session.getAttribute("loginUser");
//
//		String bookingid = loginUser.getUserid();
//
//		VetClinicDAO mDao = VetClinicDAO.getInstance();
//		VetClinicVO mVo = mDao.getMember(bookingid);
//		model.addAttribute("mVo", mVo);

		PetDao petdao = sqlSession.getMapper(PetDao.class);
		HttpSession session = request.getSession();
		VetClinicVO loginUser = (VetClinicVO) session.getAttribute("loginUser");
		String bookingid = loginUser.getUserid();
		VetClinicVO mVo = petdao.getMember(bookingid);
		model.addAttribute("mVo", mVo);
		return "project_hp/Pet_Mypage/mypage";
	}

	@RequestMapping("/member_info_update")
	public String memberinfoupdate(HttpServletRequest request) {
//		String userid = request.getParameter("userid");
//		String pwd = request.getParameter("pwd");
//		String email = request.getParameter("email");
//		String phone = request.getParameter("phone");
//		String name = request.getParameter("name");
////		String addr = request.getParameter("addr");
//		String addr = request.getParameter("postcode") + request.getParameter("address")
//				+ request.getParameter("referAdd") + request.getParameter("detailAdd");
//		String pettype = request.getParameter("pettype");
//		String petname = request.getParameter("petname");
//		String petnum = request.getParameter("petnum");
//		String personal = request.getParameter("personal");
//		String emailok = request.getParameter("emailok");
//
//		String usertype = request.getParameter("usertype");
//		String hospital_name = request.getParameter("hospital_name");
//		String hospital_num = request.getParameter("hospital_num");
//		String hospital_li = request.getParameter("hospital_li");
//		String auth = request.getParameter("auth");
//
//		VetClinicVO mVo = new VetClinicVO();
//
//		mVo.setUserid(userid);
//		mVo.setPwd(pwd);
//		mVo.setEmail(email);
//		mVo.setPhone(phone);
//		mVo.setAddr(addr);
//		mVo.setName(name);
//		mVo.setPersonal(Integer.parseInt(personal));
//		mVo.setEmailok(Integer.parseInt(emailok));
//		mVo.setPetname(petname);
//		mVo.setPettype(pettype);
//		mVo.setPetnum(petnum);
//
//		mVo.setUsertype(usertype);
//		mVo.setHospital_name(hospital_name);
//		mVo.setHospital_num(hospital_num);
//		mVo.setHospital_li(hospital_li);
//		mVo.setAuth(Integer.parseInt(auth));
//
//		VetClinicDAO mDao = VetClinicDAO.getInstance();
//
//		mDao.updateMember(mVo);

		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String name = request.getParameter("name");
//		String addr = request.getParameter("addr");
		String addr = request.getParameter("postcode") + request.getParameter("address")
				+ request.getParameter("referAdd") + request.getParameter("detailAdd");
		String pettype = request.getParameter("pettype");
		String petname = request.getParameter("petname");
		String petnum = request.getParameter("petnum");
		String personal = request.getParameter("personal");
		String emailok = request.getParameter("emailok");

		String usertype = request.getParameter("usertype");
		String hospital_name = request.getParameter("hospital_name");
		String hospital_num = request.getParameter("hospital_num");
		String hospital_li = request.getParameter("hospital_li");
		String auth = request.getParameter("auth");

		VetClinicVO mVo = new VetClinicVO();

		mVo.setUserid(userid);
		mVo.setPwd(pwd);
		mVo.setEmail(email);
		mVo.setPhone(phone);
		mVo.setAddr(addr);
		mVo.setName(name);
		mVo.setPersonal(Integer.parseInt(personal));
		mVo.setEmailok(Integer.parseInt(emailok));
		mVo.setPetname(petname);
		mVo.setPettype(pettype);
		mVo.setPetnum(petnum);

		mVo.setUsertype(usertype);
		mVo.setHospital_name(hospital_name);
		mVo.setHospital_num(hospital_num);
		mVo.setHospital_li(hospital_li);
		mVo.setAuth(Integer.parseInt(auth));

		PetDao petdao = sqlSession.getMapper(PetDao.class);

		petdao.updateMember(mVo);

		return "redirect:booking_mypage";
	}

	@RequestMapping("/selfinspection")
	public String selfinspection() {
		return "project_hp/Pet_Inspection/selfinspection";
	}

	@RequestMapping("/signup_id_check")
	public String singupidcheck(HttpServletRequest request, Model model) {
//		String userid = request.getParameter("userid");
//
//		VetClinicDAO mDao = VetClinicDAO.getInstance();
//
//		int result = mDao.confirmID(userid);
//		model.addAttribute("userid", userid);
//		model.addAttribute("result", result);

		PetDao petdao = sqlSession.getMapper(PetDao.class);
		String userid = request.getParameter("userid");
		int result = petdao.confirmID(userid);
		if (result==0) {
			result = -1;
		}
		model.addAttribute("userid", userid);
		model.addAttribute("result", result);

		return "project_hp/Pet_Login/idcheck";

	}

}
