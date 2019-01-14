package com.scit.oracleTest.DAO;

import java.util.ArrayList;

import com.scit.oracleTest.VO.Board;

public interface boardMapper {
	
	public int insertBoard(Board board);
	public ArrayList<Board> selectBoardList();//출력
	public Board selectBoard(String boardSeq);// 
	public void increseHit(String boardSeq);
	public void deleteBoard(String boardSeq);
	public void updateBoard(Board board);
}	
