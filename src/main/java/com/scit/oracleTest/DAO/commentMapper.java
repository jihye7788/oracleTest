package com.scit.oracleTest.DAO;

import java.util.ArrayList;

import com.scit.oracleTest.VO.Comment;

public interface commentMapper {
	
	public int insertComment(Comment comment);
	public ArrayList<Comment> selectCommentList(String boardseq);
}
