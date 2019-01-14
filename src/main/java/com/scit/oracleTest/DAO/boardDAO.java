package com.scit.oracleTest.DAO;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import com.scit.oracleTest.VO.Board;

@Repository
public class boardDAO {
	@Autowired
	SqlSession session;
	
	public int inseretBoard(Board board) {
		int result = 0;
		boardMapper mapper = session.getMapper(boardMapper.class);
		try {
			result = mapper.insertBoard(board);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return 0;
		}
		return result;
	}
	
	public ArrayList<Board> selectBoardList(){
			ArrayList<Board> result =null;
			boardMapper mapper = session.getMapper(boardMapper.class);
			try {
				result=mapper.selectBoardList();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return result;
			}
			return result;
	}
	

	public Board selectBoard(String boardSeq) {
		Board result = null;

		boardMapper mapper = session.getMapper(boardMapper.class);
		try {
			result = mapper.selectBoard(boardSeq);
		} catch (Exception e) {
			return result;
		}
		return result;
	}
	
	public void increaseHit(String boardSeq) {
		boardMapper mapper =session.getMapper(boardMapper.class);
		try {
			mapper.increseHit(boardSeq);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}		
	}
	
	public void deleteBoard(String boardSeq) {
		boardMapper mapper = session.getMapper(boardMapper.class);
		try {
			mapper.deleteBoard(boardSeq);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void updateBoard(Board board) {
		boardMapper mapper = session.getMapper(boardMapper.class);
		try {
			mapper.updateBoard(board);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
