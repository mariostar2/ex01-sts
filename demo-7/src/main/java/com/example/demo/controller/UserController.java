package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dao.UserDao;
import com.example.demo.dto.UserDto;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	@Autowired
	private UserDao userDao;
	
	
	//로그인 화면
	@RequestMapping("/user/login")
	public String loginForm() {
		return "user/login";
	}
	
	//로그인 처리
	@RequestMapping("/login")
	public String login(Model model, @RequestParam("id") String id, @RequestParam("pw") String pw , HttpSession session) {
		UserDto user = userDao.Login(id, pw);
		if(user == null) {
			model.addAttribute("msg","아이디와 비밀번호가 다릅니다");
			return "user/login";
		}	
		session.setAttribute("userid", user.getId());
		session.setAttribute("username", user.getName());
		return "redirect:/board/list";

	}	
	
	//회원가입 폼
	@RequestMapping("user/signUpForm")
	public String signUpForm() {
		return "user/signUp";
	}
	
	//회원 가입 처리
	@RequestMapping("user/signUp")
	public String signUp(Model model ,@RequestParam("id") String id,  @RequestParam("pw")String pw , @RequestParam("name")String name) {
		userDao.signUp(id, pw, name);
		return "redirect:/user/login";
	}
	//로그아웃
	@RequestMapping("/user/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/board/list";			
	}
	
	
	
}