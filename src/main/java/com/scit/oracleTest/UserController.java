package com.scit.oracleTest;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scit.oracleTest.DAO.userDAO;
import com.scit.oracleTest.VO.User;

@Controller
public class UserController {

	@Autowired
	userDAO dao; //@Repository를 통해 빈등록을 한 객체, Autowired는 빈객체 어노테이션을 쓴 객체 안에만 주입이 된다. 
	@RequestMapping(value="/insertUser",method=RequestMethod.POST)
	public String insertUser(User user, Model model) {
		int result = dao.insertUser(user);
		if(result==0) {
			model.addAttribute("User", user);
			model.addAttribute("warning", "중복된 ID가 존재합니다.");
			return "join";
		}
		return "home";
	}
	@RequestMapping(value="/goJoin", method=RequestMethod.POST)
	public String goJoin() {
		return "join";
	}
	
	@RequestMapping(value="/goLogin", method=RequestMethod.POST)
	public String goLogin() {
		return "login";
	}
	
	@RequestMapping(value="/goHome",method=RequestMethod.POST)
	public String goHome() {
		return "home";
	}

	@RequestMapping(value="/loginUser",method=RequestMethod.POST)
	public String login(User user, HttpSession session, Model model) {
		User result = dao.loginUser(user);
		if (result==null) {
			model.addAttribute("warning", "ID, PW를 다시한번 체크해주세요");
			model.addAttribute("User", user);
		
			return "login"; 
		}
		session.setAttribute("loginId", result.getId());
		return "home";
	}
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session){
		session.invalidate();//새로 session을 만든다. 
		//session.setAttribute("loginId", null);이것도 가능
		return "home";
	}
}
