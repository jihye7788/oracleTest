package com.scit.oracleTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scit.oracleTest.DAO.userDAO;
import com.scit.oracleTest.VO.User;

@Controller
public class UserController {

	@Autowired
	userDAO dao; //@Repository를 통해 빈등록을 한 객체, Autowired는 빈객체 어노테이션을 쓴 객체 안에만 주입이 된다. 
	@RequestMapping(value="/insertUser",method=RequestMethod.POST)
	public String insertUser(User user) {
		dao.insertUser(user);
		return "home";
	}
	
}
