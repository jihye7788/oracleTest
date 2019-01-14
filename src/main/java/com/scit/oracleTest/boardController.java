package com.scit.oracleTest;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scit.oracleTest.DAO.boardDAO;
import com.scit.oracleTest.DAO.commentDAO;
import com.scit.oracleTest.VO.Board;
import com.scit.oracleTest.VO.Comment;
import com.scit.oracleTest.VO.User;

@Controller
public class boardController {

	@Autowired
	boardDAO dao;
	@Autowired
	commentDAO cdao;
	
	@RequestMapping(value="/goBoard",method=RequestMethod.POST)
	public String goBoard() {
		return "redirect:/selectBoardList";
	}
	
	@RequestMapping(value="/goBoardWrite",method=RequestMethod.POST)
	public String goBoardWrite() {
		return "boardWrite";
	}
	
	@RequestMapping(value="/insertBoard",method=RequestMethod.POST)
	public String insertBoard(Board board, Model model, HttpSession session) {
		String id = (String) session.getAttribute("logiId");//String 들어가는건 ""를 적어준다.
		board.setId(id);//board에 id가 들어있지 않기때문에 set을 써서 담아 넣어준다. 
		int result = dao.inseretBoard(board);
		if (result==1) {
			model.addAttribute("Message", "게시물 등록에 성공하였습니다.");
			return "redirect:/selectBoardList";
		}
			model.addAttribute("Message", "게시물 등록에 실패하였습니다.");
			return "redirect:/selectBoardList";
	}
	@RequestMapping(value="/selectBoardList",method=RequestMethod.GET)
	public String selectBoardList(Model model) {
		ArrayList<Board> bList = dao.selectBoardList();
		model.addAttribute("bList", bList);
		System.out.println(bList.size());
		return "board";
				
	}
	
	@RequestMapping(value = "/boardDetail", method = RequestMethod.GET)
	public String boardDetail(Model model, String boardseq) {
		
		try {// 사용자가 파라미터에 글자를 넣은 경우
			Integer.parseInt(boardseq);
		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/selectBoardList";
		}
		Board board = dao.selectBoard(boardseq);
		
		if (board == null) {//게시글이 조회되지 않는경우
			return "redirect:/selectBoardList";
		}
		dao.increaseHit(boardseq);
		model.addAttribute("board", board);
		ArrayList<Comment> cList = new ArrayList<Comment>();
		cList = cdao.selectCommentList(boardseq);
		model.addAttribute("cList", cList);				
		return "boardDetail";
	}
	
	@RequestMapping(value="/deleteBoard",method=RequestMethod.POST)
	public String deleteBoard(String boardSeq, HttpSession session, Model model) {		
		Board board = dao.selectBoard(boardSeq);
		if (session.getAttribute("loginId")==null) {
			return "login";
		}
		if (board.getId().equals((String)session.getId())){
			dao.deleteBoard(boardSeq);
		}
		return "redirect:/selectBoardList";				
	}
	
	@RequestMapping(value="/updateBoard",method=RequestMethod.POST)
	public String updateBoard(String boardSeq, HttpSession session, Model model) {		
		if (session.getAttribute("loginId")==null) {
			return "login";
		}
		Board board = dao.selectBoard(boardSeq);
		if (board.getId().equals((String)session.getId())){
			model.addAttribute("board", board);
			return "boardWrite";
		}
		return "redirect:/selectBoardList";				
	}
	
	
}
