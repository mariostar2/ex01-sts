package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.bean.Member;
import com.example.demo.bean.PrinterB;
import com.example.demo.dto.MyUserDto;
import com.example.demo.service.MyUserService;

import jakarta.annotation.Resource;



//1.Spring 컨테이너에 Bean 으로 등록한다.
//2. 서블릿 역활을 하는 클래스로 만든다.
@Controller 

public class MyController {
	
	@Autowired
	private MyUserService service;
	
	@RequestMapping("/")
	public String root() {
		return "index"; // --> view 이름 ,  --> jsp 타임리프 머스타치 (index html)
	
	}
		
	@RequestMapping("/b")
	public @ResponseBody String root1() {
		System.out.println("root............");
		return "index"; // ------------> 순수 텍스트 - 데이터 
	}
	
	@RequestMapping("/test1")
	public String test1() {
		System.out.println("test1.......");
		return "memu1/test1";
	}
	
	@Autowired
	@Qualifier("member1")
	private Member member;
	
	@RequestMapping("/bean")
	public  @ResponseBody String  beanTest() {
		
		member.print();
		return "Bean을 생성하고 사용하는 test 중입니다";
	}
	
	@Bean(name="hello")
	//@Primary
	public Member member2() {
		return new Member("임꺽정", "도적", new PrinterB());
	}
	
	@RequestMapping("/user")
	public String searchUser(Model model ,@RequestParam("userid")String userid) {
		MyUserDto dto = service.getUser(userid);
		
		//서비스를 통해 리포지토리에서 받은 user 데이터를 뷰(jsp)에 전달한다.
		model.addAttribute("user",dto);
		return "user";
	}
	
	@RequestMapping("/userlist")
	public String searchAllUser(Model model) {
		List<MyUserDto> userList = service.getUsers();
		model.addAttribute("userList", userList);	
		return "userList";
	}
		
	@GetMapping("/s/users")
	@ResponseBody
	public List<MyUserDto>getUser(){
		return service.getUsers();
	}

	//조회용 AJAX
	@GetMapping("/updateform")
	public String updateForm(Model model, @RequestParam("userid")String userid) {
		model.addAttribute("user",service.getUser(userid));
		return "update";
	}

	@PostMapping("/update")
	public String userUpdate(@RequestParam("userid")String userid, @RequestParam("username")String username) {
		service.updateUser(userid, username);
		return "redirect:/userlist?userid=" + userid;
	}
	
	//수정용 AJAX
	@GetMapping("s/update")
	@ResponseBody
	public String userUpdateTool(@RequestParam("userid") String userid,@RequestParam("username")String username) {
		service.updateUser(userid, username);
		return "수정 성공";
	}
	
	
	@PostMapping("/delete")
	public String delete(@RequestParam("userid")String userid) {
		service.deleteUser(userid);
		return "redirect:/userList?userid" + userid;
	}
	
	//삭제용 AJAX
	@PostMapping("/s/delete")
	@ResponseBody
	public String deleteUser(@RequestParam("userid")String userid) {
		service.deleteUser(userid);
		return "삭제 성공";
	}
	
	//USER2 이동용
	@GetMapping("/user2")
	public String user2Page() {
	    return "user2";   
	}

}
