package com.scit.oracleTest;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scit.oracleTest.DAO.boardDAO;
import com.scit.oracleTest.VO.Board;

@Controller
public class boardController {

	@Autowired
	boardDAO dao;
	
	@RequestMapping(value="/goBoard",method=RequestMethod.POST)
	public String goBoard() {
		return "board";
	}
	
	@RequestMapping(value="/goBoardWrite",method=RequestMethod.POST)
	public String goBoardWrite() {
		return "boardWrite";
	}
	
	@RequestMapping(value="/insertBoard",method=RequestMethod.POST)
	public String insertBoard(Board board, Model model, HttpSession session) {
		String id = (String) session.getAttribute("id");//String 들어가는건 ""를 적어준다.
		board.setId(id);//board에 id가 들어있지 않기때문에 set을 써서 담아 넣어준다. 
		int result = dao.inseretBoard(board);
		if (result==1) {
			model.addAttribute("Message", "게시물 등록에 성공하였습니다.");
		}
			model.addAttribute("Message", "게시물 등록에 실패하였습니다.");
			return "board";
	}
}
