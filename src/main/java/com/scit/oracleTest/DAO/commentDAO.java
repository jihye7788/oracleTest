package com.scit.oracleTest.DAO;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.scit.oracleTest.VO.Comment;

@Repository
public class commentDAO {
	
	@Autowired
	SqlSession session;
	
	public int insertComment(Comment comment) {
		commentMapper mapper = session.getMapper(commentMapper.class);
		int result = 0;
		try {
			result = mapper.insertComment(comment);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return result;
		}
		return result;
	}
	public ArrayList<Comment> selectCommentList(String boardseq){
		commentMapper mapper = session.getMapper(commentMapper.class);
		ArrayList<Comment> cList = new ArrayList<Comment>();
		try {
			cList = mapper.selectCommentList(boardseq);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return cList;
	}
}
