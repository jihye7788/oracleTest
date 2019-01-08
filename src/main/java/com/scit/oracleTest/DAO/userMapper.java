package com.scit.oracleTest.DAO;

import com.scit.oracleTest.VO.User;

public interface userMapper {
	
	public int insertUser(User user);//회원등록 
	
	public User login(User user);//로그인
}
