package com.scit.oracleTest.DAO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
			return 0;
		}
		return result;
	}
}
