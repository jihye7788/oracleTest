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
public class commentController {
	
	@Autowired
	commentDAO dao;
	
	@Autowired
	boardDAO bdao;
	
	@RequestMapping(value="/insertComment" ,method=RequestMethod.POST)
	public String insertComment(Comment comment, HttpSession session, Model model, User user) {
		if(session.getAttribute("logiId")==null) {
			return "login";
		}
		String loginId=(String)session.getAttribute("logiId");
		comment.setId(loginId);
		int result=dao.insertComment(comment);
		System.out.println();
		if (result==0) {
			model.addAttribute("fail", "댓글등록에 실패하였습니다.");
			return "board";
		}else if (result==1){
			//model.addAttribute("Comment", comment);
			model.addAttribute("board", bdao.selectBoard(comment.getBoardseq()));
			selectCommentList1(model,comment.getBoardseq());
			return "boardDetail";
		}
		return "board";
	}
	
	public Model selectCommentList1(Model model, String boardseq){
		ArrayList<Comment> cList = new ArrayList<Comment>();
		cList = dao.selectCommentList(boardseq);
		model.addAttribute("cList", cList);				
		return model;
	}
}
