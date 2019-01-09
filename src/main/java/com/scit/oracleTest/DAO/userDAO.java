package com.scit.oracleTest.DAO;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.scit.oracleTest.VO.User;

@Repository//빈 등록 어노테이션, @Component의 메타 어노테이션으로 dao에 특화 되어있다. 
public class userDAO {
	@Autowired//root-context.xml 이나 Bean 등록 어노테이션을 적은 객체를 주입시킨다.
	SqlSession sqlSession;//변수명을 맞춰주지 않으면 중복된게 있을경우 문제가 생길 수 있으니 맞춰준다. 
	
	public int insertUser(User user) {
		int result = 0;
		userMapper mapper = sqlSession.getMapper(userMapper.class);
		
		//spring에선 commit같은걸 따로 해줄 필요는 없지만 문제가 발생할 수 도 있기 때문에 try-catch해준다
		try {
			result = mapper.insertUser(user);	
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
		return result;
	}
	
	public User loginUser(User user) {
		User result =null;
		userMapper mapper = sqlSession.getMapper(userMapper.class);
		try {
			result = mapper.loginUser(user);
		} catch (Exception e) {
			// TODO: handle exception
			result = null;
		}
		return result;
	}
	
}
